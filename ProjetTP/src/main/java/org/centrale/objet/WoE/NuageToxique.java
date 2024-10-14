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
public class NuageToxique extends Objet implements Combattant,Deplacable {
    private int degats;
    public NuageToxique(){
        super();
        this.degats=20;
    }

    public NuageToxique(int degats,Objet ob) {
        super(ob);
        this.degats = degats;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
    
    @Override
    public void combattre(Creature c){
        double distance=this.getPos().distance(c.getPos());
        if (distance == 0) {
        System.out.println("La creature est sous le nuage");
        c.setPtVie(c.getPtVie()-this.getDegats());
        System.out.println("La creature subit " + this.getDegats() + " degats.");
        } else {
                System.out.println("La creature n'est pas sous le nuage");
            }
        
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
}
