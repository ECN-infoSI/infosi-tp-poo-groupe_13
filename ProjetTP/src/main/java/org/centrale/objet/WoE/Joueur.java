/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Scanner;

/**
 *
 * @author Nadhem
 */
public class Joueur {
    public Personnage perso;
       public Joueur(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose your name:");
        String nom = keyboard.nextLine();
        String c = "Nothing";
        while (!"A".equals(c) && !"G".equals(c)){
        System.out.println("Choose your character!");
        System.out.println("type the letter: A - Archer");
        System.out.println("type the letter: G - Guerrier");
        c = keyboard.nextLine();
        if (!"A".equals(c) && !"G".equals(c)){
            System.out.println("Wrong letter !!!!");
        }        
        }
        keyboard.close();
        
        switch (c) {
            case "A" -> perso = new Archer();
            case "G" -> perso = new Guerrier();
                         
        }
       }
    /**
     *
     * @param x
     * @param y
     */
    public void deplace(int x,int y){
        this.perso.setPos(new Point2D(x,y));
    }
}
