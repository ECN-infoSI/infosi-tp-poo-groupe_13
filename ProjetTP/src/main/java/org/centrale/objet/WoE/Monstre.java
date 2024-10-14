/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;




/**
 *
 * @author samer
 */
public class Monstre extends Creature{


    /**
     *
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param pos
     */
    public Monstre(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos);
    }
    
    /**
     *
     * @param m
     */
    public Monstre(Monstre m){
        super((Creature)m);
        //il faut modifier ce constructeur pour gere le clonage
    }
    
    /**
     *
     */
    public Monstre(){
        super();
    }
    





    
}

