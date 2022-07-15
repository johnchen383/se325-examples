package se325.example01.basictcp;

import se325.util.Keyboard;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {

            //try retrieve input. Server addy can be "localhost"
            InetAddress serverAddress = InetAddress.getByName(Keyboard.prompt("Server address:"));
            int serverPort = Integer.parseInt(Keyboard.prompt("Server port:"));
            int num1 = Integer.parseInt(Keyboard.prompt("Enter first number:"));
            int num2 = Integer.parseInt(Keyboard.prompt("Enter second number:"));

            //try with resources handles the proper closing of sockets in all cases
            try (Socket socket = new Socket(serverAddress, serverPort)) {

                //wrap raw byte stream to data streams to allow for the sending of primitive types
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                out.writeInt(num1);
                out.writeInt(num2);

                int product = in.readInt();
                System.out.println("Received: " + product);

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
