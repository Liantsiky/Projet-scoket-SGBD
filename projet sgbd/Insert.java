package syntaxe;
import java.io.*;

public class Insert{
    
    public static String executeQuery(String requete)throws Exception{
        //prend le nom de la table
        String[] phrase=requete.split(" ");
        String table=phrase[2];

        //creer un fichier pour sauvegarder au nom de la table
        FileOutputStream save=new FileOutputStream(table+".txt",true);

        //prend les valeurs à inserer
        String valeurs=phrase[3];
        String[] v1=valeurs.split("/");
        String sauvegarder= v1[1]+";;"; //;; distingue chaque insertion de valeur
        
        //sauvergarde
        save.write(sauvegarder.getBytes());
        return "Insert effectuer";
    }
}
//SYNTAXE : Insert in *nom de la table* /*les valeurs */