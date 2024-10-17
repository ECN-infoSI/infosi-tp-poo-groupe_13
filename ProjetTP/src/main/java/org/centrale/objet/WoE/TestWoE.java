/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
public class TestWoE {

    public static void main(String[] args) {
        String delimiter = "\n-------------------------------------------------";
        System.out.println("Bienvenue dans le monde de WoE !");
        World world = new World(10, 1, 1, 1);
        int i = 1;
        while ((world.getJoueur().getPersonnage().getPtVie() > 0) && (!(world.getJoueur().joueurIsAlone()))) {
            System.out.println(world.getJoueur().joueurIsAlone());
            System.out.println(delimiter.repeat(3));
            System.out.println("\nTour de jeu n°" + i);
            
            world.tourDeJeu();
            System.out.println(delimiter.repeat(3));
            i++;
        }
        World.afficherWorld();
    }
}
