/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Nadhem
 */
public class PotionSoin extends Objet {
    /**
     * représente les points de vie gagnés lors d'utilisation
     */
    private int ptVie;
    
    /**
     *
     */
    public PotionSoin(){
        super();
        this.ptVie = 25;

    }
    
    /**
     *
     * @param ptVie
     * @param p
     */
    public PotionSoin(int ptVie, Point2D p){
        super();
        this.ptVie = ptVie;
    }

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    
}
