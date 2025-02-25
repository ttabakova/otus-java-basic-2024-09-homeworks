package ru.otus.java.basic.homeworks.filemanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    private FileManager fileManager;

    @BeforeEach
    void setUp() {
        fileManager = new FileManager(".");
    }

    @Test
    void setRootInternal() {
        String newRoot = "src";
        fileManager.setRoot(newRoot);
        Assertions.assertEquals(fileManager.getRoot().toString(), Paths.get("./src").toAbsolutePath().toString());
    }

    @Test
    void setRootExternal() {
        String newRoot = "D:\\Projects";
        fileManager.setRoot(newRoot);
        Assertions.assertEquals(fileManager.getRoot().toString(), Paths.get("D:\\Projects").toAbsolutePath().toString());
    }

    @Test
    void setRootParent() {
        String newRoot = "..";
        String parentRoot = fileManager.getRoot().getParent().toAbsolutePath().toString();
        fileManager.setRoot(newRoot);
        Assertions.assertEquals(fileManager.getRoot().toString(), parentRoot);
    }

    @Test
    void createDirSimple() {
        String newDir = "test";
        fileManager.createDir(newDir);
        List<String> fileList = Arrays.stream(fileManager.getRoot().toFile().list()).toList();
        Assertions.assertTrue(fileList.contains(newDir));
        fileManager.deleteFile(newDir,false);
    }

    @Test
    void deleteFileSimple() {
        String filename = "testDir";
        fileManager.createDir("src/test/resources/"+filename);
        fileManager.deleteFile("src/test/resources/"+filename,false);
        File deletedFile = fileManager.getRoot().resolve("src/test/resources/"+filename).toFile();
        assertFalse(deletedFile.exists());
    }

    @Test
    void deleteFileForce() {
        String filename = "testDir";
        fileManager.createDir("src/test/resources/"+filename);
        fileManager.findFile("src/test/resources/"+filename+"/"+filename);
        fileManager.deleteFile("src/test/resources/"+filename,true);
        File deletedFile = fileManager.getRoot().resolve("src/test/resources/"+filename).toFile();
        assertFalse(deletedFile.exists());
    }
}