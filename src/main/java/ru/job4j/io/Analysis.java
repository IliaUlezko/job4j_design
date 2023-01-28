package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {

        try (BufferedReader in = new BufferedReader(
                new FileReader(source));
        PrintWriter out = new PrintWriter(
                new FileOutputStream(target))) {
            boolean b = true;
            while (in.ready()) {
                String[] str = in.readLine().split(" ");
                if (("400".contains(str[0]) || "500".contains(str[0])) && b) {
                    out.print(str[1] + ";");
                    b = false;
                }
                if (("200".contains(str[0]) || "300".contains(str[0])) && !b) {
                    out.println(str[1] + ";");
                    b = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log",
                "./data/unavailableServer.csv");
    }
}
