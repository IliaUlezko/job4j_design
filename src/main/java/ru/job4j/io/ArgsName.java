package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    private void validate(String str) {
        String[] data = str.split("=", 2);

        if (!str.startsWith("-")) {
            throw new IllegalArgumentException("Wrong parameter.Parameter must start with \"-\".");
        }
        if (!str.contains("=")) {
            throw new IllegalArgumentException("Wrong parameter.Parameter must contain with \"=\".");
        }
        if (str.startsWith("-=")) {
            throw new IllegalArgumentException("Wrong parameter.Parameter cannot start with \"-=\".");
        }
        if (str.endsWith("=") && data[1].isEmpty()) {
            throw new IllegalArgumentException("Wrong parameter.");
        }
    }

    public String get(String key) {

        if (values.get(key) == null) {
            throw new IllegalArgumentException("Missing output! Edit program arguments!");
        }
        return values.get(key);
    }

    private void parse(String[] args) {

        String[] s;
        for (String str : args) {
            validate(str);
            s = str.split("=", 2);
            values.put(s[0].substring(1), s[1]);
        }
    }

    public static ArgsName of(String[] args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {

        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}