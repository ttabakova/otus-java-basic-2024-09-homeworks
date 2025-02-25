package ru.otus.java.basic.homeworks.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileManager {
    private Path root;

    public FileManager(String root) {
        this.root = Paths.get(root).toAbsolutePath();
    }

    /**
     * Выводит список файлов в указанной директории с указанной детализацией списка
     *
     * @param path    директория
     * @param details опция вывода, true - вывод детальной информации, false - вывод простого списка
     */
    public void listFiles(String path, boolean details) {
        File homeDir = new File(path);
        String[] fileList = homeDir.list();
        if (fileList == null) {
            System.out.println("Директория " + path + " пуста");
            return;
        }
        System.out.println("Файлы в директории " + path + ":");
        for (String s : fileList) {
            if (details) finfo(s);
            else System.out.println(s);
        }
    }

    /**
     * Переустанавливает корневую директорию файлового менеджера
     *
     * @param root директория, на которую нужно переустановить корневую директорию. ".." - переход в родительскую к текущему корню директорию
     */
    public void setRoot(String root) {
        Path path;
        if (root.equalsIgnoreCase("..")) {
            path = this.root.getParent();
        } else path = this.root.resolve(root);
        this.root = path.toAbsolutePath();
    }

    /**
     * Создает директорию с указанным именем, без создания вложенных директорий
     *
     * @param name имя новой директории
     */
    public void createDir(String name) {
        Path path = root.resolve(name);
        if (!path.toFile().mkdir()) {
            System.out.println("Директория " + path + " уже существует");
        } else {
            System.out.println("Директория " + path + " успешно создана");
        }
    }

    /**
     * Удаляет файл или директорию по указанному пути. При попытке удалить непустую директорию спрашивает, удалить ли вложенные файлы
     * (y - удалить, n - выйти без удаления)
     *
     * @param name имя удаляемого файла или директории
     */
    public void deleteFile(String name) {
        Path path = root.resolve(name);
        File toDelete = path.toFile();
        if (!toDelete.exists()) {
            System.out.println("Файл " + path + " не существует");
        } else if (toDelete.isDirectory() & toDelete.list() != null) {
            System.out.println("Директория " + path + " не пуста.");
            listFiles(path.toString(), false);
            System.out.println("Удалить вложенные файлы? y|n");
            String input;
            while (true) {
                Scanner in = new Scanner(System.in);
                input = in.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("Удаляем вложенные файлы...");
                    deleteAll(toDelete);
                    break;
                } else if (input.equalsIgnoreCase("n")) {
                    return;
                } else System.out.println("Неверный формат. Введите y или n");
            }
        } else {
            if (toDelete.delete()) System.out.println("Файл " + path + " успешно удален");
            else System.out.println("Не смогли удалить файл " + path);
        }
    }

    /**
     * Переместить (переименовать) файл или директорию по указанному пути в новый указанный путь
     *
     * @param source перемещаемый файл или директория
     * @param dest   путь назначения
     * @param force  принудительная перезапись, в случае, если в файл по целевому пути уже существует
     */
    public void moveFile(String source, String dest, boolean force) {
        Path sourcePath = root.resolve(source);
        if (!sourcePath.toFile().exists()) System.out.println("Исходный файл не найден: " + sourcePath);
        else {
            Path destPath = root.resolve(dest);
            if (!destPath.toFile().exists() || force) {
                File[] files = destPath.toFile().listFiles();
                if (files != null) {
                    for (File file : files) {
                        String fileName = file.getName();
                        System.out.println("Перемещаем файл " + fileName + " в " + destPath.resolve(fileName));
                        moveFile(fileName, destPath.resolve(fileName).toString(), force);
                    }
                }
                try {
                    Files.move(sourcePath, destPath, REPLACE_EXISTING);
                    System.out.println("Файлы успешно перемещены");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else System.out.println("Файл " + destPath + " уже существует. mv -f для перезаписи");
        }
    }

    /**
     * Скопировать файл или директорию по указанному пути в новый указанный путь
     *
     * @param source перемещаемый файл или директория
     * @param dest   путь назначения
     * @param force  принудительная перезапись, в случае, если в файл по целевому пути уже существует
     */
    public void copyFile(String source, String dest, boolean force) {
        Path sourcePath = root.resolve(source);
        if (!sourcePath.toFile().exists()) System.out.println("Исходный файл не найден: " + sourcePath);
        else {
            Path destPath = root.resolve(dest);
            if (!destPath.toFile().exists() || force) {
                try {
                    Files.copy(sourcePath, destPath, REPLACE_EXISTING);
                    System.out.println("Файлы успешно скопированы");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                File[] files = destPath.toFile().listFiles();
                if (files != null) {
                    for (File file : files) {
                        String fileName = file.getName();
                        copyFile(fileName, destPath.resolve(fileName).toString(), force);
                    }
                }
            } else System.out.println("Файл " + destPath + " уже существует. mv -f для перезаписи");
        }
    }

    /**
     * Выводит детальную информацию о файле: название, размер, дата последнего изменения
     *
     * @param name имя файла для вывода детальной информации
     */
    public void finfo(String name) {
        File file = new File(name);
        if (!file.exists()) System.out.println("Файл не найден: " + name);
        else {
            System.out.printf("%s, %dКб, изменен %s", file.getName(), file.length() / 1024, Instant.ofEpochMilli(file.lastModified()));
            System.out.println();
        }
    }

    /**
     * Найти файл с указанным именем в текущей директории и/или вложенных директориях. Путь к найденным файлам выводится в консоль
     *
     * @param name имя файла
     */
    public void findFile(String name) {
        ArrayList<Path> found = new ArrayList<>();
        listFoundFiles(name, root, found);
        if (!found.isEmpty()) {
            System.out.println("Найдено файлов: " + found.size());
            for (Path path : found) {
                System.out.println(path.toAbsolutePath());
            }
        } else System.out.println("Ничего не найдено");
    }

    public Path getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    /**
     * Рекурсивное удаление вложенных структур директорий и файлов
     *
     * @param toDelete файл или директория, который нужно удалить вместе со всеми дочерними
     */
    private void deleteAll(File toDelete) {
        File[] files = toDelete.listFiles();
        if (files != null) {
            for (File value : files) {
                deleteAll(value);
            }
        }
        if (toDelete.delete()) {
            System.out.println("Файл успешно удален: " + toDelete.getName());
        } else {
            System.out.println("Не смогли удалить файл: " + toDelete.getName());
        }
    }

    /**
     * Ищет файл с указанными именем по указанному пути и внутри дочерних директорий. пути к найденным файлам добавляются в список
     *
     * @param name  название искомого файла
     * @param path  путь поиска
     * @param found список найденных файлов
     */
    private void listFoundFiles(String name, Path path, ArrayList<Path> found) {
        File file = path.toFile();
        if (file.getName().equalsIgnoreCase(name)) {
            found.add(path.toAbsolutePath());
        }
        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (File filei : fileList) {
                listFoundFiles(name, path.resolve(filei.getName()), found);
            }
        }
    }
}
