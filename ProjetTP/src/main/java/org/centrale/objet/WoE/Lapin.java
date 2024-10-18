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
public class Lapin extends Monstre {

    /**
     *
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param p
     */
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    /**
     *
     */
    public Lapin() {
        super(randomBetween(5, 15),
                0,
                0,
                0,
                0,
                new Point2D(0, 0));
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
}
