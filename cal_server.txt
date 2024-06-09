import java.net.*;  
import java.io.*;  
class MyClient{  
public static void main(String args[])throws Exception{  
Socket s=new Socket("localhost",3333);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
boolean flag=true;
while(flag){
  System.out.println("Enter two nos ");
int a= Integer.parseInt(br.readLine());
int b= Integer.parseInt(br.readLine());
System.out.println("Enter 1 for add nos ");
System.out.println("Enter 2 for sub nos ");
System.out.println("Enter 3 for mult nos ");
System.out.println("Enter 4 for div nos ");
System.out.println("Enter 5 for exit ");

System.out.println("Enter ch");



int ch=Integer.parseInt(br.readLine());
if(ch>=0 && ch<=4)
{
if(ch==0)
{
 dout.writeUTF(Integer.toString(ch));
dout.writeUTF(Integer.toString(a));
dout.writeUTF(Integer.toString(b));

dout.flush(); 
flag=false;
}
else{
 dout.writeUTF(Integer.toString(ch));
dout.writeUTF(Integer.toString(a));
dout.writeUTF(Integer.toString(b));
dout.flush(); 
}}
else{
System.out.println("wrong");
}
ch=Integer.parseInt(din.readUTF());
}


dout.close();  
s.close();  
}}
