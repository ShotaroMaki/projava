package projava;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WeBClient {
     public static void main(String[] args) throws IOException {
         var domain = "www.google.com";
         SocketFactory factory = SSLSocketFactory.getDefault();
         try (Socket soc = factory.createSocket(domain, 443);
            var pw = new PrintWriter(soc.getOutputStream());
            var isr = new InputStreamReader(soc.getInputStream());
            var bur = new BufferedReader(isr))
         {
          pw.println("GET/index.html HTTP/1.1");
          pw.println("Host'" + domain);
          pw.println();
          pw.flush();
          bur.lines().limit(18).forEach(System.out::println);
         }
     }
}