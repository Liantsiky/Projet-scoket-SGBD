package affichage;

import syntaxe.*;
import verification.*;

import java.net.*;
import java.io.*;
public class Serveur{
    public static void main(String[] args)throws IOException{
        ServerSocket serv=new ServerSocket(5661);

        Socket test=serv.accept();
        DataInputStream donnee= new DataInputStream(test.getInputStream());
        String resultat=donnee.readUTF();
        System.out.println("Votre requete : "+resultat);
        // Socket test2=new Socket("localhost",5661);
        //traitement
        String trait="";
        try {
            
             trait=Traitement.getTraitement(resultat);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        DataOutputStream sendres=new DataOutputStream(test.getOutputStream());
        sendres.writeUTF(trait);
        sendres.flush();
        donnee.close();
        sendres.close();
        serv.close();
        // test2.close();
    }
}