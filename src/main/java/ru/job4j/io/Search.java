package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validate(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null.");
        }

        File file = new File(args[0]);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Enter root folder!");
        }

        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Enter file extantion!");
        }
    }

    public static void main(String[] args) throws IOException {
        validate(args);
        Path path = Paths.get(args[0]);
        search(path, p -> p.toFile()
                .getName()
                .endsWith(args[1])).
                forEach(System.out::println);
    }
}
