import java.net.Socket;
import java.io.*;
import java.util.Scanner;

class Client
{
    public static void main(String arg[]) throws Exception
    {
        Socket s = new Socket("localhost", 8888);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a String:");
        String str = br.readLine();
        dout.writeUTF(str);
        String str2 = din.readUTF();
        System.out.println("Reversed String from server: " + str2);
        dout.flush();
        dout.close();
        s.close();
    }
}








