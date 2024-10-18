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
public class Archer extends Personnage implements Combattant {

    private int nbFleches;

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
     * @param nbF
     */
    public Archer(String n, int pV, int dA, int ptPar, int paAtt, int paPar, int dMax, Point2D p, int nbF) {
        super(n, pV, dA, ptPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbF;
    }

    /**
     *
     * @param nom
     */
    public Archer(String nom) {
        super(nom,
                randomBetween(30, 80),
                randomBetween(15, 25),
                randomBetween(15, 25),
                randomBetween(50, 70),
                randomBetween(10, 30),
                randomBetween(2, 4),
                new Point2D(0, 0));
        this.nbFleches = randomBetween(5, 15);
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
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
        double distance = this.getPos().distance(c.getPos());
        if (distance < 2) {
            System.out.println("Combat au corps à corps sur " + c.toString());
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
                    System.out.println("L'adversaire parvient à parer, il subit " + degatsSubis + " degats.");
                }
            } else {
                System.out.println("Attaque ratee");
            }
        } else if (this.nbFleches > 0) {
            System.out.println("Combat a distance sur " + c.toString());
            Random rand = new Random();
            int randAtt = rand.nextInt(101);
            if (randAtt <= this.getPageAtt()) {
                System.out.println("Attaque reussie");
                c.setPtVie(c.getPtVie() - this.getDegAtt());
                System.out.println("L'adversaire subit " + this.getDegAtt() + " degats.");
            } else {
                System.out.println("Attaque ratee");
            }

            this.nbFleches--;
            System.out.println("L'attaquant perd une fleche, il lui reste " + this.nbFleches + " fleches.");
        } else {
            System.out.println("L'archer n'as plus de flêche, il ne peut pas attaquer à cette distance.");
        }
    }

    /**
     *
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }
}
