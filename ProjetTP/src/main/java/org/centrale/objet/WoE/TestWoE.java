/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.centrale.objet.WoE;

import java.util.*;
import java.io.*;

/**
 *
 * @author leovdb
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String delimiter = "\n-------------------------------------------------";
        Scanner scanner = new Scanner(System.in);
        World world;
        int taille = 10;
        int nbPerso = 5;
        int nbMonstre = 5;
        int nbObjet = 5;
        if (nbObjet + nbMonstre + nbPerso + 1 > taille * taille) {
            System.out.println("Trop d'éléments de jeu pour la taille du monde fournie");
            return;
        }

        System.out.println("Bienvenue dans le monde de WoE !");

        System.out.println("Voulez-vous charger une partie existante ? (oui(o)/non(n))");
        String reponse = scanner.nextLine().trim().toLowerCase();

        if (reponse.equals("oui") || reponse.equals("o")) {

            File saveDirectory = new File("sauvegardes");
            if (!saveDirectory.exists() || saveDirectory.list().length == 0) {
                System.out.println("Aucune sauvegarde trouvée. Démarrage d'une nouvelle partie.");
                world = new World(taille, nbPerso, nbMonstre, nbObjet);
            } else {
                String[] sauvegardes = saveDirectory.list();
                System.out.println("Sauvegardes disponibles :");
                for (int i = 0; i < sauvegardes.length; i++) {
                    System.out.println(i + ": " + sauvegardes[i]);
                }

                System.out.println("Entrez l'index de la sauvegarde à charger :");
                int index = -1;
                try {
                    index = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {

                }
                if (index >= 0 && index < sauvegardes.length) {
                    String selectedSaveFile = "sauvegardes/" + sauvegardes[index];
                    System.out.println("Chargement de la sauvegarde : " + selectedSaveFile);
                    ChargementPartie chargement = new ChargementPartie();
                    world = chargement.chargement(selectedSaveFile);
                } else {
                    System.out.println("Index non valide. Démarrage d'une nouvelle partie.");
                    world = new World(taille, nbPerso, nbMonstre, nbObjet);
                }
            }
        } else {
            world = new World(taille, nbPerso, nbMonstre, nbObjet);
        }

        int i = 1;

        while ((world.getJoueur().getPersonnage().getPtVie() > 0) && (!(world.getJoueur().joueurIsAlone()))) {
            System.out.println(delimiter.repeat(3));
            System.out.println("\nTour de jeu n°" + i);

            world.tourDeJeu();
            System.out.println(delimiter.repeat(3));

            i++;
        }
        System.out.println("\nFIN DE LA PARTIE EN " + i + " TOURS !");
        if (world.getJoueur().getPersonnage().getPtVie() > 0) {
            System.out.println("GG ! " + world.getJoueur().getPersonnage().getNom() + " est le vainqueur !!!");
        } else {
            System.out.println("RIP " + world.getJoueur().getPersonnage().getNom());
        }

        World.afficherWorld();

        scanner.close();
    }
}
