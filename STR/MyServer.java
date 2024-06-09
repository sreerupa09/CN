import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

class Server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        System.out.println("Connected Successfully");
        int op;
        do {
            String sop = din.readUTF();
            op = Integer.parseInt(sop);
            System.out.println("Choose any from the below:");
            String str1 = "", str2 = "", str3 = "";
            switch (op) {
                case 1:
                    str1 = din.readUTF();
                    System.out.println("String Given as Per the Client");
                    for (int i = str1.length() - 1; i >= 0; i--) {
                        str2 += str1.charAt(i);
                    }
                    dout.writeUTF(str2);
                    dout.flush();
                    break;
                case 2:
                    str1 = din.readUTF();
                    System.out.println("String Given as Per the Client: " + str1);
                    str2 = din.readUTF();
                    System.out.println("String Given as Per the Client: " + str2);
                    str3 = str1 + "" + str2;
                    dout.writeUTF(str3);
                    dout.flush();
                    break;
                case 3:
                    str1 = din.readUTF();
                    System.out.println("String given by the client: " + str1);
                    str2 = str1.toUpperCase();
                    dout.writeUTF(str2);
                    dout.flush();
                    break;
                case 4:
                    str1 = din.readUTF();
                    System.out.println("String given by the Client: " + str1);
                    str1 = str1.toLowerCase();
                    char[] arr = str1.toCharArray();
                    arr[0] = Character.toUpperCase(arr[0]);
                    for (int i = 1; i < str1.length(); i++) {
                        if (arr[i] == ' ') {
                            i++;
                            arr[i] = Character.toUpperCase(arr[i]);
                        }
                    }
                    str2 = new String(arr);
                    dout.writeUTF(str2);
                    dout.flush();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("WRONG INPUT");
                    break;
            }
        } while (op != 5);
        din.close();
        s.close();
        ss.close();
    }
}
