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
public class NuageToxique extends Objet implements Combattant, Deplacable {

    private int degats;
    private int distAttMax;

    public NuageToxique() {
        super();
        this.degats = randomBetween(5, 15);
        this.distAttMax = randomBetween(1, 3);
    }

    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public void combattre(Creature c) {
        System.out.println("La creature " + c.toString() + " est sous le nuage");
        c.setPtVie(c.getPtVie() - this.getDegats());
        System.out.println("La creature a subit " + this.getDegats() + " degats.");
    }

    @Override

    public void deplace() {
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public int getDistAttMax() {
        return this.distAttMax;
    }

}
