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
       w.creerMondeAlea();
       System.out.println(w.getMonstres());
       Joueur j=new Joueur(w);
       j.Jouer();
       
               
       
    }
}
