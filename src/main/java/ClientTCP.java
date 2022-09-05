import utility.InputUtil;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientTCP {
    public static void main(String[] args) throws IOException {

        System.out.println(InputUtil.askString("Your name and surname please!"));
        String URIString = InputUtil.askString("Please enter the URI that u want to write to file! Ex: /Users/sevanaahmadzada/Downloads/Unknown-pic.png");
//        System.out.println("Ex: /Users/sevanaahmadzada/Downloads/Unknown-pic.png");
        String ipPort = InputUtil.askString("Please enter ip address and port number! Ex: localhost:1224");
        String splittedArr[] = ipPort.split(":"); //array of strings  [{localhost},{1234}]
        String ipAddress = splittedArr[0];
        String port =splittedArr[1];
        int intPort = Integer.parseInt(port);

        Socket s = new Socket(ipAddress, intPort);
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        byte bytes[] = Files.readAllBytes(Paths.get(URIString));
        out.writeInt(bytes.length);
        out.write(bytes);
        System.out.println("File was successfully sent!");
        s.close();
    }
}
