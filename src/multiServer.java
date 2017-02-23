import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Rob on 22/02/2017.
 */
public class multiServer {
    public static void main(String[] args) throws Exception {
        multiServer mS = new multiServer();
        mS.run();
    }

    public void run() {
        int portNumber = 444;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new multiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Couldn't listen on port number: " + portNumber);
            System.exit(-1);
        }
    }
}
