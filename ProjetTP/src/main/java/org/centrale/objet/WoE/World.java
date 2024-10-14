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
    public void creerMondeAlea(){
        LinkedList<Point2D> positionsUtilisees = new LinkedList<>();
        Random rand = new Random();
        for (Personnage perso:this.personnages)  {
        perso.setPos(new Point2D(rand.nextInt(this.carre),rand.nextInt(this.carre)));
        positionsUtilisees.add(perso.getPos());
        }
        for (Monstre mo:this.monstres)  {
        mo.setPos(new Point2D(rand.nextInt(this.carre),rand.nextInt(this.carre)));
        positionsUtilisees.add(mo.getPos());
        }
        for (Objet ob:this.objets)  {
        ob.setPos(new Point2D(rand.nextInt(this.carre),rand.nextInt(this.carre)));
        positionsUtilisees.add(ob.getPos());
        }
        boolean hasDuplicate = hasDuplicates(positionsUtilisees);
        if (hasDuplicate) {
            System.out.println("La liste contient des doublons.");
        } else {
            System.out.println("La liste ne contient pas de doublons.");
        }
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

    