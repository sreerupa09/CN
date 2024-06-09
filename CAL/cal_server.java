import java.net.*;  
import java.io.*;  
class MyServer{  
public static void main(String args[])throws Exception{  
ServerSocket ss=new ServerSocket(3333);  
Socket s=ss.accept();  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
int n=0,m=0;
boolean flag=true;
while(flag)
{
String ch=din.readUTF();  
String a=din.readUTF();  
String b=din.readUTF();  
switch(ch.charAt(0))
{
case '1':
n=Integer.parseInt(a);
m=Integer.parseInt(b);
System.out.println("Addition ="+ (n+m));
break;

case '2':
n=Integer.parseInt(a);
m=Integer.parseInt(b);
System.out.println("subtraction ="+ (n-m));
break;

case '3':
n=Integer.parseInt(a);
m=Integer.parseInt(b);
System.out.println("multiplication ="+ (n*m));
break;

case '4':
n=Integer.parseInt(a);
m=Integer.parseInt(b);
System.out.println("division ="+ (n/m));
break;

case '0':
flag=false;
break;

}

dout.writeUTF(ch);  
dout.flush();  
}  
din.close();  
s.close();  
ss.close();  
}}  
