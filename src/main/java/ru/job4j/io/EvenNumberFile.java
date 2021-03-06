package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder sb = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                    sb.append((char) read);
            }
            String[] lines = sb.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (Integer.parseInt(line) % 2 == 0) {
                    System.out.println(line + " even");
                } else {
                    System.out.println(line + " not even.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}