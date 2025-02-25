package ru.otus.java.basic.homeworks.filemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CommandHandler {
    private final FileManager fileManager;

    /**
     * Конструктор и инициализатор консоли для работы с указанным файловым менеджером.
     * Выводит в консоль приветственное сообщение и путь к корневой директории, ожидает ввод пользователя.
     * В случае ввода команды выхода "exit" завершает работу. В случае иного ввода, пытается выполнить введенную команду.
     * @param fileManager экземпляр файлового менеджера для работы
     */
    public CommandHandler(FileManager fileManager) {
        this.fileManager = fileManager;
        System.out.println("""
                Добро пожаловать в файловый менеджер "На коленке"!
                Получить список доступных команд - введите help.""");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    
                    """ + fileManager + '>');
            String input = in.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Спасибо за использование нашего файлового менеджера!");
                break;
            }
            execute(input);
        }
    }

    /**
     * Обработка команды: проверяет, что команда находится в списке допустимых команд.
     * В случае успеха, проверяет необходимое количество атрибутов для исполнения и корректность ключевых слов
     * В случае успеха, исполняет команду.
     * Иначе, выводит сообщение об ошибке
     * @param input команда
     */
    public void execute(String input) {
        String[] command = input.split(" ");
        switch (command[0]) {
            case "help":
                sendHelp();
                return;
            case "ls":
                if (command.length == 1) fileManager.listFiles(fileManager.getRoot().toString(), false);
                else if (command.length == 2 && command[1].equalsIgnoreCase("-i"))
                    fileManager.listFiles(fileManager.getRoot().toString(), true);
                else wrongFormat();
                return;
            case "cd":
                if (command.length != 2) wrongFormat();
                else fileManager.setRoot(command[1]);
                return;
            case "mkdir":
                if (command.length != 2) wrongFormat();
                else fileManager.createDir(command[1]);
                return;
            case "rm":
                if (command.length == 2) fileManager.deleteFile(command[1],false);
                else if (command.length == 3 && command[2].equalsIgnoreCase("-f")) fileManager.deleteFile(command[1],true);
                else wrongFormat();
                return;
            case "mv":
                if (command.length == 3) fileManager.moveFile(command[1], command[2], false);
                else if (command.length == 4 && command[3].equalsIgnoreCase("-f"))
                    fileManager.moveFile(command[1], command[2], true);
                else wrongFormat();
                return;
            case "cp":
                if (command.length == 3) fileManager.copyFile(command[1], command[2], false);
                else if (command.length == 4 && command[3].equalsIgnoreCase("-f"))
                    fileManager.copyFile(command[1], command[2], true);
                else wrongFormat();
                return;
            case "find":
                if (command.length != 2) wrongFormat();
                else fileManager.findFile(command[1]);
                return;
            case "finfo":
                if (command.length != 2) wrongFormat();
                else fileManager.finfo(command[1]);
        }
    }

    /**
     * Вывод списка команд из текстового файла
     */
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

    /**
     * Вывод сообщения об ошибке в случае неверно введенной команды
     */
    private void wrongFormat() {
        System.out.println("Неверный формат команды. Получить список доступных команд - введите help.");
    }
}
