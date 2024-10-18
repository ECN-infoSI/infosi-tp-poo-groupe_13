/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
public class ElementDeJeu {

    private Point2D pos;

    /**
     *
     * @param pos
     */
    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }

    /**
     *
     */
    public ElementDeJeu() {
        this.pos = new Point2D();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if(this instanceof Personnage personnage){
            return String.format("%-5s", personnage.getNom().length() > 5 ? personnage.getNom().substring(0, 5) : personnage.getNom());
        }
        String className = this.getClass().getSimpleName();
        return String.format("%-5s", className.length() > 5 ? className.substring(0, 5) : className);
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
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
