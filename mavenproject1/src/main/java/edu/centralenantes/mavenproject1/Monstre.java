/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralenantes.mavenproject1;

import java.util.Random;

/**
 *
 * @author Nadhem
 */
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;

    /**
     *
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param p
     */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.pos = p;
    }

    /**
     *
     * @param m
     */
    public Monstre(Monstre m){
        this.ptVie = m.ptVie;
        this.degAtt = m.degAtt;
        this.ptPar = m.ptPar;
        this.pageAtt = m.pageAtt;
        this.pagePar = m.pagePar;
        this.pos = m.pos;
    }

    /**
     *
     */
    public Monstre(){
        this.ptVie = 0;
        this.degAtt = 0;
        this.ptPar = 0;
        this.pageAtt = 0;
        this.pagePar = 0;
        this.pos = new Point2D();
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
     * @param pv
     */
    public void setPtVie(int pv){
        this.ptVie=pv;
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
     * @param da
     */
    public void setDegAtt(int da){
        this.degAtt=da;
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
     * @param ppar
     */
    public void setPtPar(int ppar){
        this.ptPar=ppar;
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
     * @param pageatt
     */
    public void setPageAtt(int pageatt){
        this.pageAtt=pageatt;
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
     * @param pagepar
     */
    public void setPagePar(int pagepar){
        this.pagePar=pagepar;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param p
     */
    public void setPos(Point2D p){
        this.pos=p;
    }
    // Méthode pour déplacer le personnage 

    /**
     *
     */
    public void deplace() {
        Random rand = new Random();
        int direction = rand.nextInt(8);
        switch(direction){
            case 0: // Haut
                this.pos.setY(this.pos.getY() + 1);
                break;
            case 1: // Bas
                this.pos.setY(this.pos.getY() - 1);
                break;
            case 2: // Gauche
                this.pos.setX(this.pos.getX() - 1);
                break;
            case 3: // Droite
                this.pos.setX(this.pos.getX() + 1);
                break;
            case 4: // Haut-Gauche
                this.pos.setX(this.pos.getX() - 1);
                this.pos.setY(this.pos.getY() + 1);
                break;
            case 5: // Haut-Droite
                this.pos.setX(this.pos.getX() + 1);
                this.pos.setY(this.pos.getY() + 1);
                break;
            case 6: // Bas-Gauche
                this.pos.setX(this.pos.getX() - 1);
                this.pos.setY(this.pos.getY() - 1);
                break;
            case 7: // Bas-Droite
                this.pos.setX(this.pos.getX() + 1);
                this.pos.setY(this.pos.getY() - 1);
                break;
        }
        
    }

    // Méthode d'affichage

    /**
     *
     */
    public void affiche() {
        System.out.println("Points de vie: " + this.ptVie);
        System.out.println("Degats d'attaque: " + this.degAtt);
        System.out.println("Points de parade: " + this.ptPar);
        System.out.println("Page d'attaque: " + this.pageAtt);
        System.out.println("Page de parade: " + this.pagePar);
        System.out.println("["+this.pos.getX()+","+this.pos.getY()+"]");
    }
}

