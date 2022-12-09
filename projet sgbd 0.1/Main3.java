package affichage;

import bdd.*;
import verification.*;

public class Main3 {
    public static void main(String[] args){
        //System.out.println("Hello");
        // String insert="Insert in CEN /Algo,200,A/";
        Relation cjh=new Relation("CJH");
        Relation ena=new Relation("ENA");
        Relation cen=new Relation("CEN");
        String [] colonnes=new String[1];
        String [] colonnes2=new String[1];
        String [] colonnes3=new String[2];
        String [] colonnes9=new String[1];

        Relation r1=new Relation("r1");
        Relation r2=new Relation("r2");
        Relation r3=new Relation("r3");
        Relation r7=new Relation("r7");
        Relation r8=new Relation("r8");
        Relation r9=new Relation("r9");
        Relation r13=new Relation("r13");

        colonnes[0]="IdCours";
        colonnes2[0]="IdEtudiant";

        colonnes3[0]="IdEtudiant";
        colonnes3[1]="IdCours";

        colonnes9[0]="IdEtudiant";
        try{
            cjh.toRelation("CJH");
            ena.toRelation("ENA");
            cen.toRelation("CEN");

            r1=cjh.getProjection(cjh,colonnes,"R1");
            r2=ena.getProjection(ena, colonnes2, "R2");
            r3=cen.getProjection(cen, colonnes3, "R3");
            r7=r7.getProduitCartesien(r1, r2, "r7");
            r8=r8.getDifference(r7, r3, "r8");
            r9=r9.getProjection(r3, colonnes9,"r9");
            r13=r13.getDivision(r3, r2, "r13");

        }catch (Exception e){
            // System.out.print(e.getMessage());
            e.printStackTrace();
        }

        // for(int i=0;i<r9.getLignes().size();i++){
        //     // System.out.println(r9.getAttribut(i));
        //     for(int j=0;j<r9.getAttributs().size();j++){
        //         System.out.println(r9.getLignes().get(i).get(j));
        //     }
        // }
        System.out.println(r13.getAttributs().size());
        for(int l=0;l<r13.getAttributs().size();l++){
            System.out.println(r13.getAttribut(l));
        }
    }
}
