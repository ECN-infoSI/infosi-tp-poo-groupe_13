/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Nadhem
 */
public class ElementDeJeu {
    private Point2D pos;

    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }
    public ElementDeJeu(ElementDeJeu element) {
        this(element.pos);
    }
    public ElementDeJeu() {
        this.pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}
