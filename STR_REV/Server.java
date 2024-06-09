import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

class Server
{
    public static void main(String arg[]) throws Exception
    {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        System.out.println("Connected Successfully");

        String str = din.readUTF();
        String str2 = "";
        System.out.println("String given by client: " + str);
        for (int i = 0; i < str.length(); i++) {
            str2 = str.charAt(i) + str2;
        }
        dout.writeUTF(str2);
        dout.flush();
        din.close();
        s.close();
        ss.close();
    }
}
