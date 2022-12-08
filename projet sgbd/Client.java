package affichage;

import syntaxe.*;
import verification.*;

import java.net.*;
import java.io.*;
public class Client{
    public static void main(String[] args)throws IOException{
        Socket test=new Socket("localhost",5661);
        DataOutputStream donnee= new DataOutputStream(test.getOutputStream());
        donnee.writeUTF("Select in CJH i IdCours");
        donnee.flush();
        DataInputStream res=new DataInputStream(test.getInputStream());
        String apoitra=res.readUTF();
        System.out.println(apoitra);
        test.close();
    }
}