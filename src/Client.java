import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Rob on 22/02/2017.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.run();
    }

    public void run() throws Exception {
//        Probably best to do try and catch but for now we'll leave it generic'
        Socket clientSocket = new Socket("localhost", 444);
        PrintStream PS = new PrintStream(clientSocket.getOutputStream());
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        InputStreamReader IR = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader BR = new BufferedReader(IR);

        String userInput;
        String serverMessage;
        while ((serverMessage = BR.readLine()) != null) {
            System.out.println(serverMessage);
            userInput = stdIn.readLine();
            if (userInput != null) {
//        This is what will be sent from the client to the server
                PS.println(userInput);
//            Now we'll get something from the server
//            We'll listen for something coming back from the server
//            This is what we received from the server
            }
        }

    }
}
