package projava;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) throws IOException {
        try (var server = new ServerSocket(8880)) {
            for (;;) {
                try (Socket soc = server.accept();
                        var isr = new InputStreamReader(soc.getInputStream());
                        var bur = new BufferedReader(isr);
                        var w = new PrintWriter(soc.getOutputStream())) {
                    System.out.println("connected from" + soc.getInetAddress());
                    bur.lines().takeWhile(line -> line.isEmpty()).forEach(System.out::println);
                    w.println("""
                            HTTP/1.1 200 OK
                            Content-Type: text/plain


                            <html><head><title>Hello</title></head>
                            <body><h1>Hello</h1>It works!</body>
                            </html>
                            """);
                }
            }
        }
    }
}
