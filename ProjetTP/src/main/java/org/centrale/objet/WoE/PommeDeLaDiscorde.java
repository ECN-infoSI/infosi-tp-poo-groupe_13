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
public class PommeDeLaDiscorde extends Nourriture {

    /**
     *
     */
    public PommeDeLaDiscorde() {
        super("Pomme-de-la-discorde", -1 * randomBetween(1, 3), randomBetween(2, 4), "portée");
    }

    /**
     *
     * @param p
     * @param nom
     * @param modificationCarac
     * @param dureeEffet
     * @param typeCaracteristique
     */
    public PommeDeLaDiscorde(Point2D p, String nom, int modificationCarac, int dureeEffet, String typeCaracteristique) {
        super(p, nom, modificationCarac, dureeEffet, typeCaracteristique);
    }

    /**
     *
     * @param perso
     */
    @Override
    public void retablirEffet(Personnage perso) {
        perso.setDistAttMax(perso.getDistAttMax() - this.getModificationCarac());
    }

    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
