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
public class PommeEnchantee extends Nourriture {

    public PommeEnchantee() {
        super("Pomme enchanté", randomBetween(20,40), randomBetween(1,3), "force");
    }
    
    @Override
    public void retablirEffet(Personnage perso){
        perso.setDegAtt(perso.getDegAtt() - this.getModificationCarac());
    }
    
    private static int randomBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
