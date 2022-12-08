package syntaxe;
import java.io.*;
import java.util.*;
public class Select {
    public static String executeQuery(String requete)throws Exception{
        //donnes a rendre 
        String resultat=null;
        //prend le nom de la table
        String[] req=requete.split(" ");
        String table= req[2];
        //prend le nom de la colonne a prendre
        String colonne=req[4];
        String[] colonnes=req[4].split(",");
        //prend le fichier correspondant
        FileReader fichier=new FileReader(table+".txt");
        BufferedReader re=new BufferedReader(fichier);

        //extraction du fichier
        String ligne= re.readLine();
        String[] allLigne= ligne.split(";;");

        //Dans le cas oe izy rehetra 
        if(colonne.equals("all")){
            for(int i=0;i<allLigne.length;i++){
                String[] valeur=allLigne[i].split(",");
                for(int j=0;j<valeur.length;j++){
                    System.out.println(valeur[j]);
                    resultat=resultat+";;"+valeur[j];
                }
            }
        } else{
            
        //Dans le cas argument specifique
            //prends les arguments de la table
            String argument= getTableandArgument(table);
            String arguments[]=argument.split(",");

            //cherche quel est l'indice de l'argument qu'on cherche

            Vector <Integer> indices=new Vector <Integer>();
            int indice=0; //l'indice a rechercher
            for(int j=0;j<arguments.length;j++){
                String[] variable=arguments[j].split(" ");
                for(int l=0;l<colonnes.length;l++){
                    if(colonnes[l].equals(variable[1])==true){
                        indices.add(j);
                    }
                }
                
            }

            //extraction des colonnes
            for(int k=0;k<allLigne.length;k++){
                String []val=allLigne[k].split(",");
                for(int q=0;q<indices.size();q++){
                    System.out.println(val[indices.get(q)]);
                    resultat=resultat+";;"+val[indices.get(q)];
                }
                
            }
        }
        return resultat;
    }

    //fonction retourne la table et les arguments correspondants a la recherche
    public static String getTableandArgument(String seek)throws Exception{
        String result=null;
        // retire les tables existantes du fichier "tables.txt"
        FileReader fichier=new FileReader("tables.txt");
        BufferedReader re=new BufferedReader(fichier);
        String ligne= re.readLine();
        String[] allLigne= ligne.split(";;");

        //rechercher la table
        for(int i=0;i<allLigne.length;i++){
            String [] check=allLigne[i].split("/");
            if(check[0].equals(seek)==true){
                //retourne les valeurs et les varibles de la table correspondante
                result=check[1];
            }
        }
        if(result==null){
            new Exception("La table que vous cherchez n'existe pas");
        }
        return result;
    }
}
