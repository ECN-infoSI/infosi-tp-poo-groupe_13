/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
public class PotionSoin extends Objet implements Utilisable {

    private int ptVie;

    public PotionSoin() {
        super();
        this.ptVie = 25;
    }

    public PotionSoin(int ptVie, Point2D p) {
        super();
        this.ptVie = ptVie;
    }

    @Override
    public void utiliser(Personnage perso) {
        System.out.println(perso.getNom()+" utilise la potion gagne " + this.getPtVie() + " points de vie");
        perso.setPtVie(perso.getPtVie() + this.ptVie);
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

}
