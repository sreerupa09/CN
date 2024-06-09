import java.net.*;  
import java.io.*;  

class MyClient {  
    public static void main(String args[]) throws Exception {  
        Socket s = new Socket("localhost", 3333);  
        DataInputStream din = new DataInputStream(s.getInputStream());  
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int op;

        do {
            System.out.println("1-Reverse");
            System.out.println("2-Concat");
            System.out.println("3-Uppercase");
            System.out.println("4-Sentence");
            System.out.println("5-exit");
            System.out.println("Enter Your Option");
            String sop = br.readLine();
            op = Integer.parseInt(sop);
            dout.writeUTF(sop);

            String str1 = "", str2 = "", str3 = "";
            switch(op) {
                case 1:
                    System.out.println("Enter a string");
                    str1 = br.readLine();
                    dout.writeUTF(str1);
                    str2 = din.readUTF();
                    System.out.println("Reverse : " + str2);
                    dout.flush();
                    break;

                case 2:
                    System.out.println("Enter a String");
                    str1 = br.readLine();
                    System.out.println("Enter a String");
                    str2 = br.readLine();
                    dout.writeUTF(str1); 
                    dout.writeUTF(str2);
                    dout.flush();
                    str3 = din.readUTF();
                    System.out.println("Concatenate: " + str3);
                    break;

                case 3:
                    System.out.println("Enter a String : ");
                    str1 = br.readLine();
                    dout.writeUTF(str1);
                    dout.flush();
                    str2 = din.readUTF();
                    System.out.println("Uppercase: " + str2);
                    break;

                case 4:
                    System.out.println("Enter a string : ");
                    str1 = br.readLine();
                    dout.writeUTF(str1);
                    dout.flush();
                    str2 = din.readUTF();
                    System.out.println("Sentence: " + str2);
                    break;

                case 5:
                    break;

                default:
                    System.out.println("WRONG INPUT");
                    break;
            }

        } while (op != 5);

        din.close();
        dout.close();
        br.close();
        s.close();
    }
}
