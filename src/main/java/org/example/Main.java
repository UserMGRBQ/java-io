package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\Users\\opah\\Desktop\\JAVA studies\\java-io\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}