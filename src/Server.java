import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Rob on 22/02/2017.
 */
public class Server {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.run();
    }

    public void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(444);
        Socket clientSocket = serverSocket.accept();
        InputStreamReader IR = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader BR = new BufferedReader(IR);
        PrintWriter PS = new PrintWriter(clientSocket.getOutputStream(), true);
        String message;

        PS.println("Sing me a song...");

        // This is what the Server would see

        while ((message = BR.readLine()) != null) {
            System.out.println(message);
            // This is what the client would see
            PS.println("Keep going...");
        }
    }
}
