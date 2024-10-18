/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author leovdb
 */
public final class World {

    private static int tailleGrille;
    private static ElementDeJeu[][] grille;
    private List<Personnage> personnages;
    private List<Monstre> monstres;
    private List<Objet> objets;
    private static Joueur joueur;
    private Scanner scanner;

    /**
     *
     * @param tailleGrille
     * @param nbPersonnages
     * @param nbMonstres
     * @param nbObjets
     */
    public World(int tailleGrille, int nbPersonnages, int nbMonstres, int nbObjets) {
        this.tailleGrille = tailleGrille;
        grille = new ElementDeJeu[tailleGrille][tailleGrille];
        personnages = new ArrayList<>();
        monstres = new ArrayList<>();
        objets = new ArrayList<>();
        scanner = new Scanner(System.in);
        creerMondeAlea(nbPersonnages, nbMonstres, nbObjets);
        joueur = new Joueur(this);
        joueur.creationJoueur();
        placerSurGrille(joueur.getPersonnage());
    }

    /**
     *
     * @param nom
     * @return
     */
    public static Personnage creerPersonnageAlea(String nom) {
        Random rand = new Random();
        return switch (rand.nextInt(3)) {
            case 0 ->
                new Archer(nom + "-Archer");
            case 1 ->
                new Guerrier(nom + "-Guerrier");
            case 2 ->
                new Paysan(nom + "-Paysan");
            default ->
                new Personnage();
        };
    }

    /**
     *
     * @return
     */
    public static Monstre creerMonstreAlea() {
        Random rand = new Random();
        return switch (rand.nextInt(2)) {
            case 0 ->
                new Loup();
            case 1 ->
                new Lapin();
            default ->
                new Monstre();
        };
    }

    /**
     *
     * @return
     */
    public static Objet creerObjetAlea() {
        Random rand = new Random();
        return switch (rand.nextInt(5)) {
            case 0 ->
                new PotionSoin();
            case 1 ->
                new Epee();
            case 2 ->
                new NuageToxique();
            case 3 ->
                new PommeEnchantee();
            case 4 ->
                new PommeDeLaDiscorde();
            default ->
                new Objet();
        };
    }

    /**
     *
     * @param nbPersonnages
     * @param nbMonstres
     * @param nbObjets
     */
    public void creerMondeAlea(int nbPersonnages, int nbMonstres, int nbObjets) {

        for (int i = 0; i < nbPersonnages; i++) {
            Personnage personnage = creerPersonnageAlea(Integer.toString(i));
            placerSurGrille(personnage);
            personnages.add(personnage);
        }

        for (int i = 0; i < nbMonstres; i++) {
            Monstre monstre = creerMonstreAlea();
            placerSurGrille(monstre);
            monstres.add(monstre);
        }

        for (int i = 0; i < nbObjets; i++) {
            Objet objet = creerObjetAlea();
            placerSurGrille(objet);
            objets.add(objet);
        }
    }

    /**
     *
     * @param element
     */
    public void placerSurGrille(ElementDeJeu element) {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(tailleGrille);
            y = rand.nextInt(tailleGrille);
        } while (grille[x][y] != null);
        grille[x][y] = element;
        element.setPos(new Point2D(x, y));
    }

    /**
     *
     * @param positionActuelle
     * @param direction
     * @return
     */
    public static Point2D calculerNouvellePosition(Point2D positionActuelle, int direction) {
        int x = positionActuelle.getX();
        int y = positionActuelle.getY();

        return switch (direction) {
            case 7 ->
                new Point2D(x - 1, y - 1);
            case 8 ->
                new Point2D(x, y - 1);
            case 9 ->
                new Point2D(x + 1, y - 1);
            case 4 ->
                new Point2D(x - 1, y);
            case 6 ->
                new Point2D(x + 1, y);
            case 1 ->
                new Point2D(x - 1, y + 1);
            case 2 ->
                new Point2D(x, y + 1);
            case 3 ->
                new Point2D(x + 1, y + 1);
            default -> {
                System.out.println("Direction invalide.");
                yield null;
            }
        };
    }

    /**
     *
     * @param positionCreature
     * @param porteeAttaque
     * @return
     */
    public static List<Creature> selectCibles(Point2D positionCreature, int porteeAttaque) {

        List<Creature> ciblesPotentielles = new ArrayList<>();

        for (int i = positionCreature.getX() - porteeAttaque; i <= positionCreature.getX() + porteeAttaque; i++) {
            for (int j = positionCreature.getY() - porteeAttaque; j <= positionCreature.getY() + porteeAttaque; j++) {
                if (i >= 0 && i < grille.length && j >= 0 && j < grille[0].length) {
                    if (!((i == positionCreature.getX()) && (j == positionCreature.getY()))) {
                        ElementDeJeu element = grille[i][j];
                        if (element instanceof Creature creature) {
                            ciblesPotentielles.add(creature);
                        }
                    }

                }
            }
        }

        return ciblesPotentielles;
    }

    /**
     *
     */
    public static void afficherWorld() {
        joueur.getPersonnage().affiche();
        System.out.println("\nVotre inventaire : ");
        joueur.getPersonnage().afficherInventaire();
        System.out.println("Vos effets : ");
        joueur.getPersonnage().afficherEffets();
        System.out.println("\nMonde : ");
        for (int j = 0; j < tailleGrille; j++) {
            for (int i = 0; i < tailleGrille; i++) {
                if (grille[i][j] != null) {
                    String name = grille[i][j].toString();
                    System.out.print(name + "  ");
                } else {
                    System.out.print(".....  ");
                }
            }
            System.out.println();
        }
        System.out.println("Votre position : ");
        joueur.afficherPosition();
    }

    /**
     *
     * @param nouvellePos
     * @return
     */
    public static boolean estDeplacementValide(Point2D nouvellePos) {
        int x = nouvellePos.getX();
        int y = nouvellePos.getY();

        if (x >= 0 && x < tailleGrille && y >= 0 && y < tailleGrille) {
            ElementDeJeu element = grille[x][y];

            if (element != null && !(element instanceof Utilisable)) {
                //System.out.println("Case occupée par un personnage ou un objet non utilisable.");
                return false;
            }

            return true;
        }
        return false;
    }

    /**
     *
     * @param element
     */
    public void actionElement(ElementDeJeu element) {
        Random rand = new Random();
        List<Integer> choix = new ArrayList<>();
        List<Creature> ciblesPotentielles =  new ArrayList<>();
        if (element instanceof Deplacable) {
            choix.add(0);
        }
        if (element instanceof Combattant combattant) {
            ciblesPotentielles = selectCibles(element.getPos(), combattant.getDistAttMax());
            if (!ciblesPotentielles.isEmpty()){
                choix.add(2);
            }
        }

        if (element instanceof Personnage personnage && !personnage.getInventaire().isEmpty()) {
            choix.add(1);
        }
        if (choix.size() <= 0) {
            return;
        }

        int randomIndexChoix = rand.nextInt(choix.size());

        switch (choix.get(randomIndexChoix)) {
            case 0 -> {
                if (element instanceof NuageToxique nuageToxique) {
                    if (!ciblesPotentielles.isEmpty()) {
                        for (Creature cible : ciblesPotentielles) {
                            nuageToxique.combattre(cible);
                            if (cible.estMorte()) {
                                grille[cible.getPos().getX()][cible.getPos().getY()] = null;
                                System.out.println("RIP " + cible.toString());
                            }
                        }
                    }
                }

                System.out.println("\nAction : deplacement d'un element");
                System.out.println(element);
                boolean deplacementValide = false;
                

                while (!deplacementValide) {
                    
                    int randomInt;
                    do {
                        randomInt = rand.nextInt(9) + 1;
                    } while (randomInt == 5);

                    Point2D nouvellePos = calculerNouvellePosition(element.getPos(), randomInt);
                    List<Integer> uniqueNumbers = new ArrayList<>();
                    int maxSize = 8; // List can hold up to 8 unique numbers (excluding 5)
                    
                    while (nouvellePos == null || !World.estDeplacementValide(nouvellePos)) {
                        do {
                            randomInt = rand.nextInt(9) + 1;
                        } while (randomInt == 5);
                        
                        if (!uniqueNumbers.contains(randomInt)){
                        uniqueNumbers.add(randomInt);
                        }
                        else if (uniqueNumbers.size() == maxSize){
                        nouvellePos = element.getPos();
                        System.out.println("deplacement impossible");
                        break;                                              
                    }
                        nouvellePos = calculerNouvellePosition(element.getPos(), randomInt);
                    }// potentiellement une boucle infinie si le personnage est bloqué
                    deplacementValide = true;
                    grille[element.getPos().getX()][element.getPos().getY()] = null;
                    element.setPos(nouvellePos);
                    grille[nouvellePos.getX()][nouvellePos.getY()] = element;
                }
            }

            case 1 -> {
                int randomIndexInventaire = rand.nextInt(((Personnage) element).getInventaire().size());
                System.out.println("\nAction : personnage utilise objet --> " + ((Personnage) element).getInventaire().get(randomIndexInventaire).toString());
                System.out.println(((Personnage) element));
                ((Personnage) element).utiliserUtilisable(randomIndexInventaire);
            }

            case 2 -> {
                System.out.println("\nAction : combat");
                System.out.println(element);
                if (element instanceof NuageToxique nuageToxique) {
                    for (Creature cible : ciblesPotentielles) {
                        nuageToxique.combattre(cible);
                        if (cible.estMorte()) {
                            grille[cible.getPos().getX()][cible.getPos().getY()] = null;
                            System.out.println("RIP " + cible.toString());
                        }
                    }
                } else {
                    int randomIndex = rand.nextInt(ciblesPotentielles.size());
                    Creature cible = ciblesPotentielles.get(randomIndex);
                    ((Combattant) element).combattre(cible);
                    if (cible.estMorte()) {
                        grille[cible.getPos().getX()][cible.getPos().getY()] = null;
                        System.out.println("RIP " + cible.toString());
                    }
                }
                
            }
        }
    }

    /**
     *
     */
    public void tourDeJeu() {
        afficherWorld();
        joueur.actionJoueur();
        joueur.getPersonnage().majEffets();

        List<ElementDeJeu> elementsTraites = new ArrayList<>();

        System.out.println("\n---------------- Actions des autres créatures");

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {

                if (!(i == joueur.getPersonnage().getPos().getX() && j == joueur.getPersonnage().getPos().getY())) {
                    ElementDeJeu element = grille[i][j];

                    if (element != null && !elementsTraites.contains(element)) {
                        elementsTraites.add(element);
                        actionElement(element);
                        if(element instanceof Personnage personnage){
                            personnage.majEffets();
                        }
                    }
                }
            }
        }
    }
            
    /**
     *
     * @return
     */
    public ElementDeJeu[][] getGrille() {
        return grille;
    }

    /**
     *
     * @return
     */
    public Joueur getJoueur() {
        return joueur;
    }

}
