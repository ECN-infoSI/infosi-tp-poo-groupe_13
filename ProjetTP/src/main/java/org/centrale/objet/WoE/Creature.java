/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
public class Creature extends ElementDeJeu implements Deplacable {

    private int ptVie;

    private int degAtt;

    private int ptPar;

    private int pageAtt;

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
     */
    public Creature() {
        super();
        this.ptVie = 0;
        this.degAtt = 0;
        this.ptPar = 0;
        this.pageAtt = 0;
        this.pagePar = 0;
    }

    /**
     *
     */
    public void affiche() {
        System.out.println("\nPoints de vie: " + this.ptVie);
        System.out.println("Degats d'attaque: " + this.degAtt);
        System.out.println("Points de parade: " + this.ptPar);
        System.out.println("% d'attaque: " + this.pageAtt);
        System.out.println("% de parade: " + this.pagePar);
        if (this instanceof Personnage personnage) {
            System.out.println("Distance d'attaque: " + personnage.getDistAttMax());
        }
    }

    /**
     *
     * @return
     */
    public boolean estMorte() {
        return this.getPtVie() <= 0;
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

}
