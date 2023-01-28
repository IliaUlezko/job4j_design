package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }
    public void load() {
        try (BufferedReader in = new BufferedReader(
                new FileReader(path)
        )) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.startsWith("#")
                        || line.length() == 0) {
                    continue;
                }
                String[] s = line.split("=", 2);
                values.put(s[0], s[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {

        Set<String> keys = values.keySet();
        String result = "";
        for (String k : keys) {
            if (k.equals(key)) {
                result = k;
                break;
            }
        }
        return result.equals(key) ? values.get(key) : "Value not found!";
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("app.properties");
        config.load();
        String s = config.value("hibernate.connection.password");
        System.out.println(s);
    }
}