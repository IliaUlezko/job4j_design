package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(
                new FileReader(file)
        )) {
            list = in.lines()
                    .filter(line -> line.contains(" 404 "))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Метод работает не корректно,
     * перезаписывает в файл последнюю
     * итеррируемую строку.
     * Подскажите, как исправить.
     */
    public static void save(List<String> log, String file) {
        Iterator<String> iterator = log.iterator();
        while (iterator.hasNext()) {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    ))) {
                out.printf("%s%n", iterator.next());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        log.forEach(System.out::println);
        System.out.println("--------------");
        LogFilter logFilter1 = new LogFilter();
        List<String> log1 = logFilter1.filter("log.txt");
        save(log1, "404.txt");
    }
}