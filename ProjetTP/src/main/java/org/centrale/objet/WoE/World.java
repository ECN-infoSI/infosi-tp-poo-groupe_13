/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Nadhem
 */
public class World {
    /**
     * représente la liste des personnages présents dans le monde
     */
    private LinkedList<Personnage> personnages;
    /**
     * représente la liste des monstres présents dans le monde
     */
    private LinkedList<Monstre> monstres;
    /**
     * représente la liste des objets présents dans le monde
     */
    private LinkedList<Objet> objets;
    /**
     * représente la taille du monde
     */
    private int carre;
    
    /**
     *
     */
    public World(){
        this.personnages = new LinkedList<>();
        this.monstres = new LinkedList<>();
        this.objets = new LinkedList<>();
        this.carre=50;
    }

    /**
     * Permet d'ajouter un personnage à la liste
     * @param p
     */
    public void ajouterPersonnage(Personnage p) {
        personnages.add(p);
    }

    /**
     * Permet d'ajouter un monstre à la liste
     * @param m
     */
    public void ajouterMonstre(Monstre m) {
        monstres.add(m);
    }

    /**
     * Permet d'ajouter un objet à la liste
     * @param o
     */
    public void ajouterObjet(Objet o) {
        objets.add(o);
    }

    /**
     * Permet de supprimer un personnage de la liste
     * @param p
     */
    public void supprimerPersonnage(Personnage p) {
        personnages.remove(p);
    }

    /**
     * Permet de supprimer un monstre de la liste
     * @param m
     */
    public void supprimerMonstre(Monstre m) {
        monstres.remove(m);
    }

    /**
     * Permet de supprimer un objet de la liste
     * @param o
     */
    public void supprimerObjet(Objet o) {
        objets.remove(o);
    }

    /**
     *
     * @param carre
     */
    public void setCarre(int carre) {
        this.carre = carre;
    }

    /**
     *
     * @return
     */
    public int getCarre() {
        return carre;
    }

    public LinkedList<Personnage> getPersonnages() {
        return personnages;
    }

    public LinkedList<Monstre> getMonstres() {
        return monstres;
    }
    
    /**
     * Cette méthode permet de créer un monde et de placer les créatures aléatoirement
     */
   public void creerMondeAlea() {
        Random rand = new Random();
        Set<Point2D> positionsUtilisees = new HashSet<>(); // Set pour garantir l'unicité des positions

        // Générer 50 personnages
        for (int i = 0; i < 50; i++) {
            Personnage perso = new Personnage();
            perso.setPos(genererPositionUnique(positionsUtilisees, rand));
            this.ajouterPersonnage(perso);
        }

        // Générer 50 monstres
        for (int i = 0; i < 50; i++) {
            Monstre monstre = new Monstre();
            monstre.setPos(genererPositionUnique(positionsUtilisees, rand));
            this.ajouterMonstre(monstre);
        }

        // Générer 50 objets
        for (int i = 0; i < 50; i++) {
            Objet objet = new Objet();
            objet.setPos(genererPositionUnique(positionsUtilisees, rand));
            this.ajouterObjet(objet);
        }

        System.out.println("Le monde a été généré avec 50 personnages, 50 monstres, et 50 objets.");
    }

    /**
     * Génère une position aléatoire unique qui n'a pas encore été utilisée.
     * @param positionsUtilisees Set des positions déjà utilisées
     * @param rand Instance de Random pour générer des positions aléatoires
     * @return Une position unique non utilisée
     */
    private Point2D genererPositionUnique(Set<Point2D> positionsUtilisees, Random rand) {
        Point2D pos;
        do {
            pos = new Point2D(rand.nextInt(this.carre), rand.nextInt(this.carre));
        } while (positionsUtilisees.contains(pos));  // Vérifie si la position est déjà utilisée
        positionsUtilisees.add(pos);  // Marque cette position comme utilisée
        return pos;
    }
    /**
     *Cette méthode permet de vérifier si la liste contient des doublons
     * @param list
     * @return
     */
    public static boolean hasDuplicates(List<?> list) {
    Set<Object> set = new HashSet<>(list);  // Conversion de la liste en Set
    return set.size() < list.size();  // Si la taille du Set est plus petite, il y a des doublons
    }

    /**
     * Elle permet  de calculer le total des points de vie des personnages
     * @return
     */
    public int calculerTotalPointsDeVie() {
        
        int totalPointsDeVie = 0;
        Iterator<Personnage> it = personnages.iterator();
        while (it.hasNext()) {
            totalPointsDeVie += it.next().getPtVie();
        }

        System.out.println(totalPointsDeVie);
        
        return totalPointsDeVie;
    }

    /**
     * Elle permet d'afficher le nom et la position des creatures
     */
    public void afficher(){
        for (Personnage perso:this.personnages)  {
            System.out.println(perso.getNom());
            perso.getPos().affiche();
        }
        for (Monstre m:this.monstres)  {
            m.getPos().affiche();
}
    }
    public boolean testerPositionsOccupees(int x, int y) {
        // Vérification parmi les personnages
        for (Personnage perso : this.personnages) {
            if (perso.getPos().getX() == x && perso.getPos().getY() == y) {
                return true; // La position est occupée par un personnage
            }
        }

        // Vérification parmi les monstres
        for (Monstre monstre : this.monstres) {
            if (monstre.getPos().getX() == x && monstre.getPos().getY() == y) {
                return true; // La position est occupée par un monstre
            }
        
        }
    return false;
    }

}

    