package ru.job4j.attestation;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    private void validate(String str) {
        if (!str.startsWith("-")) {
            throw new IllegalArgumentException(
                    "Wrong parameter.Parameter must start with \"-\"."
            );
        }

        if (!str.contains("=")) {
            throw new IllegalArgumentException(
                    "Wrong parameter.Parameter must contain \"=\"."
            );
        }

        if (str.startsWith("-=")) {
            throw new IllegalArgumentException(
                    "Wrong parameter.Parameter must contain key!"
            );
        }
    }

    public String get(String key) {

        if (values.get(key) == null) {
            throw new IllegalArgumentException(
                    String.format("Missing program argument - %s", key));
        }
        return values.get(key);
    }

    public void parse(String[] args) {
        String[] s;
        for (String str : args) {
            validate(str);
            s = str.split("=", 2);
            values.put(s[0].substring(1), s[1]);
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Missing program argument!");
        }

        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
