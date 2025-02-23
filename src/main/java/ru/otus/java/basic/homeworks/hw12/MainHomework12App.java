package ru.otus.java.basic.homeworks.hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class MainHomework12App {
    public static void main(String[] args) {
        File homeDir = new File(".");
        System.out.println("Файлы в директории:");
        System.out.println(Arrays.toString(homeDir.listFiles()));
        File file = chooseFile();
        System.out.println("Выбранный файл: "+file.getName());
        printFile(file);
        writeToFile(file);
    }

    public static File chooseFile() {
        while (true) {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите название файла для работы:");
            String fileName = console.nextLine();
            File file = new File(fileName);
            if (!file.exists()) {
                try {
                    if (createFile(file)) return file;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (file.isDirectory()) {
                    System.out.println(Arrays.toString(file.listFiles()));
                    return chooseFile();
                } else return file;
            }
        }
    }

    public static boolean createFile(File file) throws IOException {
        System.out.println("Файл с указанным именем не существует. Создать? y|n");
        Scanner console = new Scanner(System.in);
        while (true) {
            String answer = console.next();
            if (answer.equals("y")) {
                file.createNewFile();
                return true;
            } else if (answer.equals("n")) return false;
            else System.out.println("Некорректный ответ. Попробуйте еще раз.");
        }
    }

    public static void writeToFile(File file){
        String in;
        byte[] buffer;
        Scanner console = new Scanner(System.in);
        while (true){
            System.out.println("Введите текст. Для окончания работы введите 'exit'");
            in = console.nextLine();
            if (in.equals("exit")) return;
            buffer = in.getBytes(StandardCharsets.UTF_8);
            System.out.println("Пишем в файл: " + in);
            try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file,true))) {
                out.write(buffer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printFile(File file){
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file))){
            char[] buffer = new char[64];
            int n = in.read(buffer);
            while (n>0){
                System.out.print(new String(buffer,0,n));
                n = in.read(buffer);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
