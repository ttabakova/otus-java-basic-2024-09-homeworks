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
    private Path dir;

    public FileManager(String dir) {
        this.dir = Paths.get(dir).toAbsolutePath();
    }

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

    public void setDir(String dir) {
        Path path;
        if (dir.equalsIgnoreCase("..")) {
            path = this.dir.getParent();
        } else path = this.dir.resolve(dir);
        this.dir = path.toAbsolutePath();
    }

    public void createDir(String name) {
        Path path = dir.resolve(name);
        if (!path.toFile().mkdir()) {
            System.out.println("Директория " + path + " уже существует");
        } else {
            System.out.println("Директория " + path + " успешно создана");
        }
    }

    public void deleteFile(String name) {
        Path path = dir.resolve(name);
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

    public void moveFile(String source, String dest, boolean force) {
        Path sourcePath = dir.resolve(source);
        if (!sourcePath.toFile().exists()) System.out.println("Исходный файл не найден: " + sourcePath);
        Path destPath = dir.resolve(dest);
        if (destPath.toFile().exists()) {
            if (force) try {
                Files.move(sourcePath, destPath, REPLACE_EXISTING);
                System.out.println("Файлы успешно перемещены");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            else System.out.println("Файл " + destPath + " уже существует. mv -f для перезаписи");
        }
        try {
            Files.move(sourcePath, destPath);
            System.out.println("Файлы успешно перемещены");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void copyFile(String source, String dest, boolean force) {
        Path sourcePath = dir.resolve(source);
        if (!sourcePath.toFile().exists()) System.out.println("Исходный файл не найден: " + sourcePath);
        Path destPath = dir.resolve(dest);
        if (destPath.toFile().exists()) {
            if (force) try {
                Files.copy(sourcePath, destPath, REPLACE_EXISTING);
                System.out.println("Файлы успешно скопированы");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            else System.out.println("Файл " + destPath + " уже существует. mv -f для перезаписи");
        }
        try {
            Files.copy(sourcePath, destPath);
            System.out.println("Файлы успешно скопированы");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void finfo(String name) {
        File file = new File(name);
        if (!file.exists()) System.out.println("Файл не найден: " + name);
        else
            System.out.println(file.getName() + ", " + file.length() / 1024 + "кб, " + Instant.ofEpochMilli(file.lastModified()));
    }

    public void findFile(String name) {
        ArrayList<Path> found = new ArrayList<>();
        addFiles(name, dir, found);
        if (!found.isEmpty()) {
            System.out.println("Найдено файлов: "+found.size());
            for (Path path : found) {
                System.out.println(path.toAbsolutePath());
            }
        } else System.out.println("Ничего не найдено");
    }

    public Path getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return dir.toString();
    }

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

    private void addFiles(String name, Path path, ArrayList<Path> found) {
        File file = path.toFile();
        if (file.getName().equalsIgnoreCase(name)){
            found.add(path.toAbsolutePath());
        }
        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (File filei : fileList) {
                addFiles(name, path.resolve(filei.getName()), found);
            }
        }
    }
}
