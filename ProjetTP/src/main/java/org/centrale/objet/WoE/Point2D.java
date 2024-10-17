/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
public class Point2D {

    private int x;
    private int y;

    public Point2D(int a, int b) {
        this.x = a;
        this.y = b;
    }

    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public void affiche() {
        String res = "[" + this.x + "," + this.y + "]";
        System.out.println(res);
    }

    public void setX(int coordx) {
        this.x = coordx;
    }

    public void setY(int coordy) {
        this.y = coordy;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setposition(int coordx, int coordy) {
        setX(coordx);
        setY(coordy);
    }

    public void translate(int dx, int dy) {
        setposition(this.x + dx, this.y + dy);
    }

    public double distance(Point2D p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point2D point = (Point2D) obj;
        return x == point.x && y == point.y;
    }
}
