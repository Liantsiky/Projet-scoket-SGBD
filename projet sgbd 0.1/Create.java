package syntaxe;

import java.io.*;

public class Create {
    public static String executeQuery(String requete)throws Exception{
        //creation du fichier stockage liste de toutes les tables
        FileOutputStream saving=new FileOutputStream("tables.txt",true);
        
        //prendre le nom de la table
        String [] req= requete.split(" ");
        //prendre les valeurs
        String [] values=requete.split("/");
        String table=req[2]+"/"+values[1]+"/"+";;";
        saving.write(table.getBytes());
        saving.close();
        return "Create effectuer";
    }
}

//SYNTAXE : CREATE TABLE *nom de la table* /*les types puis les variables */