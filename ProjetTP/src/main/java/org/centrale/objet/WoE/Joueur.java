/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leovdb
 */
public class Joueur {

    private Personnage perso;
    private Scanner scanner;
    private World world;
    ElementDeJeu[][] grille;

    /**
     *
     * @param world
     */
    public Joueur(World world) {
        scanner = new Scanner(System.in);
        this.grille = world.getGrille();
        this.world = world;
    }

    /**
     *
     */
    public void creationJoueur() {
        System.out.println("Choisissez votre classe (Guerrier : 'G', Archer : 'A') : ");
        String classe = scanner.nextLine();
        System.out.println("Choisissez le nom de votre personnage : ");
        String nom = scanner.nextLine();

        switch (classe.toLowerCase()) {
            case "g" ->
                perso = new Guerrier(nom);
            case "a" ->
                perso = new Archer(nom);
            default -> {
                System.out.println("Classe non valide. Par défaut, un Guerrier sera créé.");
                perso = new Guerrier(nom);
            }
        }
    }

    /**
     *
     */
    public void actionJoueur() {
        boolean choixValide = false;

        while (!choixValide) {
            System.out.println("\n---------------- C'est votre tour");
            System.out.println("Que voulez-vous faire ?");
            System.out.println("(1) Se déplacer");
            System.out.println("(2) Combattre");
            System.out.println("(3) Utiliser un objet de l'inventaire");
            System.out.println("(4) Sauvegarder");

            int choix = 0;
            try {
                choix = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {

                scanner.next(); // Clear the invalid input
            }

            int utilisableIndex = -1;
            Creature cible = null;
            boolean deplacementValide = false;
            switch (choix) {
                case 1 -> {

                    while (!deplacementValide) {
                        System.out.println("Choisissez une direction pour vous déplacer :");
                        System.out.println("(7) Haut-gauche, (8) Haut, (9) Haut-droite");
                        System.out.println("(4) Gauche, (6) Droite");
                        System.out.println("(1) Bas-gauche, (2) Bas, (3) Bas-droite");

                        int direction = 0;
                        try {
                            direction = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            scanner.next();

                        }
                        Point2D nouvellePos = World.calculerNouvellePosition(perso.getPos(), direction);

                        if (nouvellePos != null && World.estDeplacementValide(nouvellePos)) {
                            ElementDeJeu elementSurCase = grille[nouvellePos.getX()][nouvellePos.getY()];

                            if (elementSurCase instanceof Utilisable utilisable) {
                                ramasserUtilisable(utilisable);
                            }

                            grille[perso.getPos().getX()][perso.getPos().getY()] = null;
                            perso.setPos(nouvellePos);
                            grille[nouvellePos.getX()][nouvellePos.getY()] = perso;
                            System.out.println("Vous vous êtes déplacé en " + nouvellePos.getX() + "," + nouvellePos.getY() + ".");
                            deplacementValide = true;
                        } else {
                            System.out.println("Déplacement impossible.");
                            break;
                        }
                    }
                }

                case 2 -> {
                    List<Creature> ciblesPotentielles = World.selectCibles(perso.getPos(), perso.getDistAttMax());
                    cible = this.selectCible(ciblesPotentielles);
                    if (cible == null) {
                        System.out.println("Pas de cible à portée ou choix invalide. Vous ne pouvez pas attaquer.");
                    } else {
                        System.out.println("Vous engagez le combat avec " + cible.toString() + " !");
                        ((Combattant) perso).combattre(cible);
                        if (cible.estMorte()) {
                            grille[cible.getPos().getX()][cible.getPos().getY()] = null;
                            System.out.println("RIP " + cible.toString());
                        }
                    }
                }

                case 3 -> {
                    utilisableIndex = this.selectUtilisableFromInventaire();

                    if (utilisableIndex == -1) {
                        System.out.println("Veuillez choisir une autre action.");
                    } else {
                        perso.utiliserUtilisable(utilisableIndex);
                    }
                }

                case 4 -> {
                    String filePath;
                    System.out.println("Souhaitez-vous sauvegarder la partie ? (oui(o)/non(n))");

                    String saveResponse = scanner.nextLine();
                    if (saveResponse.trim().toLowerCase().equals("oui") || saveResponse.trim().toLowerCase().equals("o")) {
                        System.out.println("Entrez le nom de la sauvegarde :");
                        String saveName = scanner.nextLine().trim();
                        filePath = "sauvegardes/sauvegarde-" + saveName + ".txt";

                        Sauvegarder sauvegarde = new Sauvegarder();
                        sauvegarde.sauvegarde(world, filePath);
                        System.out.println("Partie sauvegardée avec succès dans le fichier : " + filePath);
                    }

                }

                default -> {
                    System.out.println("Action non reconnue. Veuillez réessayer.");
                }
            }

            if ((choix == 1 && deplacementValide) || (choix == 2 && cible != null) || (choix == 3 && utilisableIndex != -1)) {
                choixValide = true;
            }
        }
    }

    /**
     *
     * @param utilisable
     */
    public void ramasserUtilisable(Utilisable utilisable) {
        perso.ajouterUtilisable(utilisable);
        System.out.println("Vous avez ramassé : " + utilisable);
        grille[((Objet) utilisable).getPos().getX()][((Objet) utilisable).getPos().getY()] = null;
    }

    /**
     *
     * @return
     */
    public int selectUtilisableFromInventaire() {
        perso.afficherInventaire();
        List<Utilisable> inventaire = perso.getInventaire();

        if (inventaire.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
            return -1;
        }

        System.out.println("Choisissez l'objet à utiliser (entrez le numéro) ou -1 pour annuler :");
        int choix = -2;
        try {
            choix = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
        }

        if (choix >= 0 && choix < inventaire.size()) {
            return choix;
        } else if (choix == -1) {
            System.out.println("Annulation de la sélection.");
            return -1;
        } else {
            System.out.println("Choix invalide.");
            return -1;
        }
    }

    /**
     *
     * @param ciblesPotentielles
     * @return
     */
    public Creature selectCible(List<Creature> ciblesPotentielles) {
        if (ciblesPotentielles.isEmpty()) {
            return null;
        }

        System.out.println("Cibles disponibles :");
        for (int index = 0; index < ciblesPotentielles.size(); index++) {
            Creature cible = ciblesPotentielles.get(index);
            System.out.println((index) + ". " + cible.toString() + " à la position (" + ((ElementDeJeu) cible).getPos().getX() + ", " + ((ElementDeJeu) cible).getPos().getY() + ") vie : " + cible.getPtVie());
        }

        System.out.println("Choisissez une cible :");
        int choix = -1;
        try {
            choix = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
        }

        if (choix >= 0 && choix < ciblesPotentielles.size()) {
            Creature cibleChoisie = ciblesPotentielles.get(choix);
            System.out.println("Vous avez choisi de combattre " + cibleChoisie.toString());
            return cibleChoisie;
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    public boolean joueurIsAlone() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                if (!((i == this.getPersonnage().getPos().getX()) && (j == this.getPersonnage().getPos().getY()))) {
                    ElementDeJeu element = grille[i][j];
                    if (element instanceof Creature) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     *
     * @return
     */
    public Personnage getPersonnage() {
        return perso;
    }

    /**
     *
     * @param perso
     */
    public void setPersonnage(Personnage perso) {
        this.perso = perso;
    }

    /**
     *
     */
    public void afficherPosition() {
        perso.getPos().affiche();
    }
}
