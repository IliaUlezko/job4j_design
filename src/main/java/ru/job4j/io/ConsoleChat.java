package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> answers = readPhrases();
        boolean isWorking = true;
        boolean chat = true;
        Scanner scanner = new Scanner(System.in);
        while (isWorking) {
            String str = scanner.nextLine();
            log.add(str);
            if (!OUT.equals(str) && !STOP.equals(str) && chat) {
                Random random = new Random();
                int i = random.nextInt(answers.size());
                System.out.println(answers.get(i));
                log.add(answers.get(i));
            }

            if (STOP.equals(str) && chat) {
                chat = false;
            }

            if (CONTINUE.equals(str) && !chat) {
                chat = true;
            }

            if (OUT.equals(str)) {
                isWorking = false;
            }
        }
        saveLog(log);
    }


    private List<String> readPhrases() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            bufferedReader.lines().forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("chatLog.txt", "botAnswers.txt");
        cc.run();
    }
}