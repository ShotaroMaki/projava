package projava;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        try (var soc = new Socket("localhost", 1700);
            OutputStream output = soc.getOutputStream()) {
            System.out.println("サーバーは起動していません");
        }
    }
}
