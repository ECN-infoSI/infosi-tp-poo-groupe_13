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
public class Loup extends Monstre implements Combattant {

    private int distAttMax;

    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
        distAttMax = dMax;
    }

    public Loup() {
        super(randomBetween(20, 50),
                randomBetween(10, 30),
                randomBetween(10, 30),
                randomBetween(70, 90),
                randomBetween(10, 30),
                new Point2D(0, 0));
    }

    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public void combattre(Creature c) {
        System.out.println("Combat au corps à corps sur "+c.toString());
        Random rand = new Random();
        int randAtt = rand.nextInt(101);
        if (randAtt <= this.getPageAtt()) {
            System.out.println("Attaque reussie");

            int randDef = rand.nextInt(101);
            if (randDef > c.getPagePar()) {
                c.setPtVie(c.getPtVie() - this.getDegAtt());
                System.out.println("L'adversaire subit " + this.getDegAtt() + " degats.");
            } else {
                int degatsSubis = this.getDegAtt() - c.getPtPar();
                if (degatsSubis < 0) {
                    degatsSubis = 0;
                }
                c.setPtVie(c.getPtVie() - degatsSubis);
                System.out.println("L'adversaire parvient a parer, il subit " + degatsSubis + " degats.");
            }
        } else {
            System.out.println("Attaque ratee");
        }

    }
    
    @Override
    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

}
