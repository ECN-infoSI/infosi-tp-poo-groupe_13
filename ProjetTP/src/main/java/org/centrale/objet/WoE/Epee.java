/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author leovdb
 */
public class Epee extends Objet implements Utilisable {

    private int degAtt;

    /**
     *
     * @param degAtt
     * @param p
     */
    public Epee(int degAtt, Point2D p) {
        super(p);
        this.degAtt = degAtt;
    }

    /**
     *
     */
    public Epee() {
        super();
        this.degAtt = randomBetween(5, 50);
    }

    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /**
     *
     * @param perso
     */
    @Override
    public void utiliser(Personnage perso) {
        System.out.println(perso.getNom() + " utilise l'épée et gagne " + this.getDegAtt() + " d'attaque");
        perso.setDegAtt(perso.getDegAtt() + this.degAtt);
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
}
