/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;


import java.util.Random;

/**
 *
 * @author Nadhem
 */
public class Creature extends ElementDeJeu implements Deplacable{
    /**
     * représente les points de vie de la créature
     */
    private int ptVie;
    /**
     * représente les dégats qu'elle cause lors  d'une attaque
     */
    private int degAtt;
    /**
     * représente les points des dégats atténués lors d'une parade d'une attaque 
     */
    private int ptPar;
    /**
     * représente le pourcentage de réussir une attaque
     */
    private int pageAtt;
    /**
     * représente le pourcentage de réussir une parade
     */
    private int pagePar;
    
    
    /**
     *
     * @param ptVie
     * @param degAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param pos
     */
    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(pos);
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
    }
    
    /**
     *
     * @param c
     */

    
    public Creature(Creature c){
        Point2D point = new Point2D(c.getPos());
        this(c.getPtVie(), c.getDegAtt() ,c.getPtPar() ,c.getPageAtt(), c.getPagePar(), point);
    }
    /**
     *
     */
    public Creature(){
        Point2D p = new Point2D();
        this(100,0,0,0,0,p);
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

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    
       
        private static final int[][] DIRECTIONS = {
        {0, -1},  // North
        {1, -1},  // Northeast
        {1, 0},   // East
        {1, 1},   // Southeast
        {0, 1},   // South
        {-1, 1},  // Southwest
        {-1, 0},  // West
        {-1, -1}  // Northwest
    };
    
    /**
     * la methode deplace permet de déplacer un personnage à une case adjacente aléatoire
     */
    @Override
    public void deplace(){
        Random randInt = new Random();
        int direction = randInt.nextInt(8); // Random int between 0 and 7

        // Get the dx and dy from the DIRECTIONS array
        int dx = DIRECTIONS[direction][0];
        int dy = DIRECTIONS[direction][1];

        // Translate the position
        this.getPos().translate(dx, dy); 
    }

    /**
     * La méthode affiche permet d'afficher les caractéristique de la créature
     */
    public void affiche() {
        System.out.println("Points de vie: " + this.ptVie);
        System.out.println("Degats d'attaque: " + this.degAtt);
        System.out.println("Points de parade: " + this.ptPar);
        System.out.println("Page d'attaque: " + this.pageAtt);
        System.out.println("Page de parade: " + this.pagePar);
        System.out.println("["+this.getPos().getX()+","+this.getPos().getY()+"]");
    }
    
    
}