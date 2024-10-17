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

    public Nourriture(String nom, int modificationCarac, int dureeEffet, String typeCaracteristique) {
        this.nom = nom;
        this.modificationCarac = modificationCarac;
        this.dureeEffet = dureeEffet;
        this.typeCaracteristique = typeCaracteristique;
    }

    @Override
    public void utiliser(Personnage perso) {
        System.out.println(perso.getNom()+" utilise "+this.getNom());
        perso.ajouterEffetActif(this);
        this.appliquerEffet(perso);
    }

    public void appliquerEffet(Personnage perso) {
        switch (typeCaracteristique) {
            case "force" ->
                perso.setDegAtt(perso.getDegAtt() + modificationCarac);
            case "portée" ->
                perso.setDistAttMax(perso.getDistAttMax() + modificationCarac);
        }
    }
    
    public void retablirEffet(Personnage perso){
    }

    public boolean estExpiree() {
        return dureeEffet <= 0;
    }

    public String getNom() {
        return nom;
    }
    
    public int getDureeEffet(){
        return dureeEffet;
    }
    
    public void setDureeEffet(int dureeEffet){
        this.dureeEffet = dureeEffet;
    }
    
    public int getModificationCarac(){
        return modificationCarac;
    }

}
