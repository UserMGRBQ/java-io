package org.example;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome! Please, write a folder path:");
        String strPath = sc.nextLine();
        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        File[] files = path.listFiles(File::isFile);

        // Listing folders from directory
        System.out.println("FOLDERS:");
        System.out.println();
        for (File folder : folders) {
            System.out.println(folder);
        }

        // Listing files from directory
        System.out.println();
        System.out.println("Files:");
        System.out.println();
        for (File file : files) {
            System.out.println(file);
        }

        // Creating a folder
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("FOLDERS:");
        System.out.println();
        for (File folder : folders) {
            System.out.println(folder);
        }
    }
}