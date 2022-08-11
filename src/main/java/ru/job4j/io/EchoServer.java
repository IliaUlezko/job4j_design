package ru.job4j.io;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());

                    String message = in.readLine();
                    System.out.println(message);

                    String[] messages = message.split(" ");

                    if ("/?msg=Exit".equals(messages[1])) {
                        server.close();
                    } else {

                        String[] value = messages[1].split("=");

                        if (value.length == 1) {
                            out.write("Message must have at least 1 character!\r\n\r\n".getBytes());
                        } else {
                            out.write(value[1].concat("\r\n\r\n").getBytes());
                        }
                    }
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}