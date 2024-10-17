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
public class Paysan extends Personnage {

    public Paysan(String n, int pV, int dA, int ptPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, ptPar, paAtt, paPar, dMax, p);
    }

    public Paysan(String nom) {
        super(nom,
                randomBetween(25, 75),
                0,
                0,
                0,
                0,
                0,
                new Point2D(0, 0));
    }
    
    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
