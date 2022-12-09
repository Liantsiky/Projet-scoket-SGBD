package verification;
import syntaxe.*;
import bdd.*;

public class Operation{
    public String executeQuery(String requete) throws Exception{
        //donnees a rendre 
        String res="Vita";
        Relation rel=new Relation("Resultat");

        //prend le nom de l'operation
        String[] req=requete.split(" ");
        String operation=req[1];
        if(operation.equalsIgnoreCase("Projection")==true){
            Relation temp=Relation.toRelation(req[2]);
            rel=Relation.getProjection(temp,req[3], req[5]);
        }
        return res;

        //Excecuter la requete
        // Object req=izy.getConstructor().newInstance();
        // Method execution= izy.getMethod("executeQuery",String.class);
        // execution.invoke(req,requete);
    }
    
}