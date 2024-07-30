package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String[] lines = new String[] {
                "Good morning",
                "Good afternoon",
                "Good evening",
                "Good night"
        };
        String path = "C:\\Users\\opah\\Desktop\\JAVA studies\\java-io\\greetings.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}