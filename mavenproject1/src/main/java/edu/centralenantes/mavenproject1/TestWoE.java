/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.centralenantes.mavenproject1;

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
       System.out.println("peon:");
       w.peon.affiche();
       System.out.println("robin:");
       w.robin.affiche();
       System.out.println("bugs");
       w.bugs1.affiche();
       w.peon.deplace();
       w.robin.deplace();
       w.bugs1.deplace();
       System.out.println("peon:");
       w.peon.affiche();
       System.out.println("robin:");
       w.robin.affiche();
       System.out.println("bugs");
       w.bugs1.affiche();
       w.guillaumeT=new Archer(w.robin);
       w.robin.deplace();
       w.robin.affiche();
       w.guillaumeT.affiche();
    }
}
