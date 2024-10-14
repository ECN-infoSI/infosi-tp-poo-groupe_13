/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

import java.util.Random;




/**
 *
 * @author Nadhem
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       World w=new World();
       w.setCarre(500000);
       Random rand = new Random();
       for (int i=0;i<w.getCarre()*2/5;i++){
           Archer a=new Archer();
           a.setNom("robin"+i);
           w.ajouterPersonnage(a);
       }
       for (int i=0;i<w.getCarre()*2/5;i++){
           Paysan p=new Paysan();
           p.setNom("peon"+i);
           w.ajouterPersonnage(p);
       }
       for (int i=0;i<w.getCarre()*2/5;i++){
           Lapin l=new Lapin();
           w.ajouterMonstre(l);
       }
       for (int i=0;i<w.getCarre()*2/5;i++){
           Guerrier g=new Guerrier();
           g.setNom("GrosBill"+i);
           w.ajouterPersonnage(g);
       }
       for (int i=0;i<w.getCarre()*2/5;i++){
           Loup lou=new Loup();
           w.ajouterMonstre(lou);
       }
       w.creerMondeAlea();
       long startTime = System.nanoTime();
       w.calculerTotalPointsDeVie();
        long endTime = System.nanoTime();
        long duration = endTime-startTime;
       System.out.println("duree : "+duration);
       
       
    }
}
