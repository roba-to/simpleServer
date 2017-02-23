import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Rob on 22/02/2017.
 */
public class multiServerThread extends Thread {
    private Socket socket = null;
    private String[] messages = {"Keep going...",
            "Sing it baby...",
            "*clicks fingers*",
            "LaLaLaaaaaa", "What a voice!!",
            "Did you write this yourself?",
            "If I had a ukulele"};
    private Random r = new Random();

    public multiServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
                PrintStream output = new PrintStream(socket.getOutputStream());
                InputStreamReader IR = new InputStreamReader(socket.getInputStream());
                BufferedReader input = new BufferedReader(IR)
        ) {
            String message, serverMessage;

            output.println("Type me a song...");

            // This is what the Server would see

            while ((message = input.readLine()) != null) {
                System.out.println(socket.getLocalAddress() + ":" + socket.getLocalPort() + " => " + message);
                // This is what the client would see
                serverMessage = messages[r.nextInt(3)];
                output.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
