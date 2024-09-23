package edu.centralenantes.mavenproject1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Nadhem
 */
public class TestPoint2D {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Point2D A=new Point2D();
        Point2D B=new Point2D(1,1);
        Point2D C=new Point2D(B);
        C.setposition(2,1);
        A.translate(1, 1);
        System.out.println(B.distance(C));
        System.out.println(A.getX());
        System.out.println(A.getY());
        System.out.println(A.affiche());
        System.out.println(C.affiche());
        
    }
}
