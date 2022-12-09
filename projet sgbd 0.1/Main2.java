package affichage;
import syntaxe.*;
import verification.*;
public class Main2 {
    public static void main(String[] args){
        //System.out.println("hello");
        // String test="Insert in etudiant /Lucie,Rasoa/";
        // String test2="Insert in etudiant /Lucas,Rabe/";
        // String test3="Insert in etudiant /Jean,Jean/";
        // String test4="Insert in etudiant /Jeanne,Layah/";
        String select="Select in CJH i IdCours";
        try{
            try{
                Traitement.getTraitement(select);
                // Traitement.getTraitement(test2);
                // Traitement.getTraitement(test3);
                // Traitement.getTraitement(test4);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        } catch(Exception e){e.printStackTrace();}
    }
}
