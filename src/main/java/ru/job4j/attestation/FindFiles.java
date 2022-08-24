package ru.job4j.attestation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class FindFiles {

    public static List<Path> search(ArgsName argsName) throws IOException {
        Path root = getPath(argsName);
        Predicate<Path> condition = getFileName(argsName);
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static Path getPath(ArgsName argsName) {
        Path path = Paths.get(argsName.get("d"));
        if (!path.toFile().exists()) {
            throw new IllegalArgumentException(String.format(
                    "Path %s does not exist!", path.toFile().getAbsolutePath()
            ));
        }
        if (!path.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format(
                    "%s is not directory!", path.toFile().getAbsolutePath()
            ));
        }
        return path;
    }

    private static Predicate<Path> getFileName(ArgsName argsName) {
        Predicate<Path> result = null;
        if ("mask".equals(argsName.get("t"))) {
            result = p -> p.toFile()
                    .getName()
                    .matches(argsName.get("n").replace(".", "[.]")
                            .replace("*", ".+")
                            .replace("?", "."));
        }
        if ("name".equals(argsName.get("t"))) {
            result = p -> p.toFile()
                    .getName()
                    .equals(argsName.get("n"));
        }
            return result;
    }


    public static void writeResult(ArgsName argsName) throws IOException {
        String target = argsName.get("o");
        List<Path> list = search(argsName);
        try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : list) {
                pw.write(path.toString());
                pw.write(System.lineSeparator());
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        writeResult(argsName);
    }
}