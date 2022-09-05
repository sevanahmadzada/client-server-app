import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerTCP {
    public static void main(String[] args) throws IOException {

        ServerSocket sc = new ServerSocket(1224);
        while (true) {
            Socket connection = sc.accept();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            int messageLngt = in.readInt();
            byte arr[] = new byte[messageLngt];
            in.readFully(arr);
            Files.write(Paths.get("myFile.png"),arr);
        }

    }
}
