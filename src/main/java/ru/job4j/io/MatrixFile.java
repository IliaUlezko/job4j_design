package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MatrixFile {
    public static void matrix(int a) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 0; i < a; i++) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < a; j++) {
                    str.append((i + 1) * (j + 1)).append("\\t");
                }
                out.write(str.append(System.lineSeparator())
                        .toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
           matrix(5);
        }
}