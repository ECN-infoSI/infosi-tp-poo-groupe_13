/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author leovdb
 */
public class Personnage extends Creature {

    private String nom;

    private int distAttMax;

    private List<Nourriture> effetsActifs = new ArrayList<>();
    private List<Utilisable> inventaire = new ArrayList<>();

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
        nom = n;
        distAttMax = dMax;
    }
    
    /**
     *
     */
    public Personnage() {
        super();
        nom = "";
        distAttMax = 0;
    }

    /**
     *
     * @param effet
     */
    public void ajouterEffetActif(Nourriture effet) {
        effetsActifs.add(effet);
    }

    /**
     *
     * @param utilisable
     */
    public void ajouterUtilisable(Utilisable utilisable) {
        inventaire.add(utilisable);
    }

    /**
     *
     * @param index
     */
    public void utiliserUtilisable(int index) {
        if (index >= 0 && index < inventaire.size()) {
            Utilisable utilisable = inventaire.remove(index);
            utilisable.utiliser(this);
        } else {
            System.out.println("Utilisable non valide.");
        }
    }

    /**
     *
     */
    public void majEffets() {
        Iterator<Nourriture> it = effetsActifs.iterator();
        while (it.hasNext()) {
            Nourriture effet = it.next();
            effet.setDureeEffet(effet.getDureeEffet()-1);
            if (effet.estExpiree()) {
                System.out.println("Fin de l'effet "+effet.getNom()+" sur "+this.getNom());
                effet.retablirEffet(this);
                it.remove();
            }
        }
    }

    /**
     *
     */
    public void afficherInventaire() {
        for (int i = 0; i < inventaire.size(); i++) {
            System.out.println(i + ": " + inventaire.get(i));
        }
    }

    /**
     *
     */
    public void afficherEffets() {
        for (int i = 0; i < effetsActifs.size(); i++) {
            Nourriture nourriture = effetsActifs.get(i);
            System.out.println(i + ": " + nourriture.getNom() + "(durée : " + nourriture.getDureeEffet() + ")");
        }
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *
     * @return
     */
    public List<Utilisable> getInventaire() {
        return inventaire;
    }
}
