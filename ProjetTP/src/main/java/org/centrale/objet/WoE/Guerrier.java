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
public class Guerrier extends Personnage implements Combattant{

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        
    }
    
    /**
     *
     * @param g
     */
    public Guerrier(Guerrier g){
        super((Personnage)g);
        
    }
    
    /**
     *
     */
    public Guerrier(){
        super();
        
    }
    
    /**
     * La méthode permet à un personnage d'attaquer un autre personnage, 
     * soit au corps à corps, soit à distance. Elle prend en compte la distance entre 
     * les deux personnages, ainsi que les chances de succès de l'attaque et de la parade.
     * @param c
     */
    @Override
    public void combattre(Creature c){
        double distance=this.getPos().distance(c.getPos());
        if (distance == 1) {
        // Combat au corps à corps
        System.out.println("Combat au corps a corps");

        // Jet d'attaque pour l'attaquant
        Random rand = new Random();
        int randAtt = rand.nextInt(101);
        if (randAtt <= this.getPageAtt()) {
            System.out.println("Attaque reussie");
            
            // Jet de défense pour l'adversaire
            int randDef = rand.nextInt(101);
            if (randDef > c.getPagePar()) {
                // Si la parade échoue, l'adversaire subit tous les dégâts
                c.setPtVie(c.getPtVie()-this.getDegAtt());
                System.out.println("L'adversaire subit " + this.getDegAtt() + " degats.");
            } else {
                // Si la parade réussit, l'adversaire atténue les dégâts
                int degatsSubis = this.getDegAtt() - c.getPtPar();
                if (degatsSubis < 0) degatsSubis = 0;  // Empêche les dégâts négatifs
                c.setPtVie(c.getPtVie()-degatsSubis);
                System.out.println("L'adversaire parvient a parer, il subit " + degatsSubis + " degats.");
            }
        } else {
            System.out.println("Attaque ratee");
        }
    } else if (distance > 1 && distance <= this.getDistAttMax()) {
        // Combat à distance
        System.out.println("Combat à distance");

        // Jet d'attaque pour l'attaquant
        Random rand = new Random();
        int randAtt = rand.nextInt(101);
        if (randAtt <= this.getPageAtt()) {
            System.out.println("Attaque reussie");
            c.setPtVie(c.getPtVie()-this.getDegAtt());
            System.out.println("L'adversaire subit " + this.getDegAtt() + " degats.");
        } else {
            System.out.println("Attaque ratee");
        }

        // L'attaquant perd un projectile 
        
        
    } else {
        System.out.println("L'adversaire est hors de portee.");
    }
    }
    


}