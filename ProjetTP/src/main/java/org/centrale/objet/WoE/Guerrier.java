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
public class Guerrier extends Personnage implements Combattant {

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param ptPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Guerrier(String n, int pV, int dA, int ptPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, ptPar, paAtt, paPar, dMax, p);

    }

    /**
     *
     * @param nom
     */
    public Guerrier(String nom) {
        super(nom,
                randomBetween(50, 100),
                randomBetween(25, 50),
                randomBetween(25, 50),
                randomBetween(70, 90),
                randomBetween(10, 30),
                1,
                new Point2D(0, 0));
    }

    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /**
     *
     * @param c
     */
    @Override
    public void combattre(Creature c) {
        System.out.println("Combat au corps a corps sur "+c.toString());
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
}
