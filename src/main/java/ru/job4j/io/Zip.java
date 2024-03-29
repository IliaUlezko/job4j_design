package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private void validate(String[] args) {
        ArgsName argsZip = ArgsName.of(args);
        args[0] = argsZip.get("d");
        args[1] = argsZip.get("e");
        args[2] = argsZip.get("o");
        File search = new File(args[0]);
        if (!search.exists()) {
            throw new IllegalArgumentException(String.format(
                    "Invalid path folder \"%s\"", args[0]));
        }
        if (!search.isDirectory()) {
            throw new IllegalArgumentException(String.format(
                    "File \"%s\" is not a directory", search.getName()));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(String.format(
                    "Invalid file extension \"%s\"", args[1]));
        }
    }

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(path)))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
        Zip zipPack = new Zip();
        zip.validate(args);
        List<Path> source = Search.search(Paths.get(args[0]),
                path -> !path.toFile().getName().endsWith(args[1]));
        zipPack.packFiles(source, new File(args[2]));
    }
}