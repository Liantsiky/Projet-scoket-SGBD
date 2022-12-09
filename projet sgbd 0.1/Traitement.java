package verification;
import java.lang.reflect.*;
public class Traitement{

    public static String [] getSyntaxe(){
        String[] syntaxe=new String [4];
        syntaxe[0]="Insert";
        syntaxe[1]="Create";
        syntaxe[2]="Select";
        syntaxe[3]="Operation";
        return syntaxe;
    }

    public static String getTraitement (String requete)throws Exception{
        //prendre le mot cle
        String[] cle= requete.split(" ");
        String[] syntaxes=getSyntaxe();
        String mot=null;

        //verification de la syntaxe
        for(int i=0;i<syntaxes.length;i++){
            if(cle[0].equalsIgnoreCase(syntaxes[i])==true){
                mot=cle[0];
            }
        }
        if(mot==null){
            new Exception("Incorrect syntax");
        }

        //rechercher la classe correspondante
        Class izy=Class.forName("syntaxe."+mot);

        //Excecuter la requete
        Object req=izy.getConstructor().newInstance();
        Method execution= izy.getMethod("executeQuery",String.class);
        String res=(String)execution.invoke(req,requete);
        return res;
    }
}