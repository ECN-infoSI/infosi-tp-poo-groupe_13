/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
public class Nourriture extends Objet implements Utilisable {

    private String nom;
    private int modificationCarac;
    private int dureeEffet;
    private String typeCaracteristique;

    /**
     *
     * @param nom
     * @param modificationCarac
     * @param dureeEffet
     * @param typeCaracteristique
     */
    public Nourriture(String nom, int modificationCarac, int dureeEffet, String typeCaracteristique) {
        super();
        this.nom = nom;
        this.modificationCarac = modificationCarac;
        this.dureeEffet = dureeEffet;
        this.typeCaracteristique = typeCaracteristique;
    }

    /**
     *
     * @param p
     * @param nom
     * @param modificationCarac
     * @param dureeEffet
     * @param typeCaracteristique
     */
    public Nourriture(Point2D p, String nom, int modificationCarac, int dureeEffet, String typeCaracteristique) {
        super(p);
        this.nom = nom;
        this.modificationCarac = modificationCarac;
        this.dureeEffet = dureeEffet;
        this.typeCaracteristique = typeCaracteristique;
    }

    /**
     *
     * @param perso
     */
    @Override
    public void utiliser(Personnage perso) {
        System.out.println(perso.getNom() + " utilise " + this.getNom());
        perso.ajouterEffetActif(this);
        this.appliquerEffet(perso);
    }

    /**
     *
     * @param perso
     */
    public void appliquerEffet(Personnage perso) {
        switch (typeCaracteristique) {
            case "force" ->
                perso.setDegAtt(perso.getDegAtt() + modificationCarac);
            case "portée" ->
                perso.setDistAttMax(perso.getDistAttMax() + modificationCarac);
        }
    }

    /**
     *
     * @param perso
     */
    public void retablirEffet(Personnage perso) {
    }

    /**
     *
     * @return
     */
    public boolean estExpiree() {
        return dureeEffet <= 0;
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
     * @return
     */
    public int getDureeEffet() {
        return dureeEffet;
    }

    /**
     *
     * @param dureeEffet
     */
    public void setDureeEffet(int dureeEffet) {
        this.dureeEffet = dureeEffet;
    }

    /**
     *
     * @return
     */
    public int getModificationCarac() {
        return modificationCarac;
    }

    /**
     *
     * @return
     */
    public String getTypeCarac() {
        return typeCaracteristique;
    }

}
