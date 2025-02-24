package ru.otus.java.basic.homeworks.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileManager {
    private Path dir;
    private final Scanner in;

    public FileManager(String dir) {
        this.dir = Paths.get(dir).toAbsolutePath();

        System.out.println("""
                Добро пожаловать в файловый менеджер "На коленке"!
                Получить список доступных команд - введите help.""");
        in = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    
                    """ + this.dir + '>');
            String input = in.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Спасибо за использование нашего файлового менеджера!");
                break;
            }
            execute(input);
        }
    }

    public void execute(String input) {
        String[] command = input.split(" ");
        switch (command[0]) {
            case "help":
                sendHelp();
                return;
            case "ls":
                if (command.length == 1) listFiles(dir.toString(), false);
                else if (command.length == 2 && command[1].equalsIgnoreCase("-i"))
                    listFiles(dir.toString(), true);
                else wrongFormat();
                return;
            case "cd":
                if (command.length != 2) wrongFormat();
                else setDir(command[1]);
                return;
            case "mkdir":
                if (command.length != 2) wrongFormat();
                else createDirectory(command[1]);
                return;
            case "rm":
                if (command.length != 2) wrongFormat();
                else delete(command[1]);
                return;
            case "mv":
                if (command.length == 3) moveFile(command[1], command[2], false);
                else if (command.length == 4 && command[3].equalsIgnoreCase("-f"))
                    moveFile(command[1], command[2], true);
                else wrongFormat();
                return;
            case "cp":
                if (command.length == 3) copyFile(command[1], command[2], false);
                else if (command.length == 4 && command[3].equalsIgnoreCase("-f"))
                    copyFile(command[1], command[2], true);
                else wrongFormat();
                return;
            case "finfo":
                if (command.length != 2) wrongFormat();
                else finfo(command[1]);
        }
    }

    public void sendHelp() {
        try (BufferedReader helpReader = new BufferedReader(new FileReader("src/main/resources/help.txt"))) {
            String line;
            while ((line = helpReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        System.out.println("Привели путь к " + path);
        this.dir = path.toAbsolutePath();
    }

    public void createDirectory(String name) {
        Path path = dir.resolve(name);
        if (!path.toFile().mkdir()) {
            System.out.println("Директория " + path + " уже существует");
        } else {
            System.out.println("Директория " + path + " успешно создана");
        }
    }

    public void delete(String name) {
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

    private void deleteAll(File toDelete) {
        File[] files = toDelete.listFiles();
        if (files != null) {
            File file;
            Iterator<File> fileIterator = Arrays.stream(files).iterator();
            while (fileIterator.hasNext()) {
                file = fileIterator.next();
                deleteAll(file);
            }
        }
        if (toDelete.delete()){
            System.out.println("Файл успешно удален: "+toDelete.getName());
        }else {
            System.out.println("не смогли удалить файл: "+toDelete.getName());
        }
    }

    private void wrongFormat() {
        System.out.println("Неверный формат команды. Получить список доступных команд - введите help.");
    }
}
