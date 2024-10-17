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

    public Creature(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos) {
        super(pos);
        this.ptVie = ptVie;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pageAtt = pageAtt;
        this.pagePar = pagePar;
    }
    
    public Creature() {
        super();
        this.ptVie = 0;
        this.degAtt = 0;
        this.ptPar = 0;
        this.pageAtt = 0;
        this.pagePar = 0;
    }

    @Override
    public void deplace() {
        //TODO
    }

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
    
    public boolean estMorte(){
        return this.getPtVie()<=0;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

}
