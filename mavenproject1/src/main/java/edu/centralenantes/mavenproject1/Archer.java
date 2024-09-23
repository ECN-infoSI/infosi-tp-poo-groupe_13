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
public class Archer extends Personnage {
    private int nbFleches;

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
     * @param nbF
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p,int nbF){
        super(n,pV,dA,pPar,paAtt,paPar,dMax,p);
        this.nbFleches=nbF;
    }

    /**
     *
     * @param a
     */
    public Archer(Archer a){
        super(a);
        this.nbFleches=a.nbFleches;
    }

    /**
     *
     */
    public Archer(){
        super();
        this.nbFleches=0;
    }
    public void combattre(creature c){
        double distance=this.getPos().distance(c.pos);
        if (distance == 1) {
        // Combat au corps à corps
        System.out.println("Combat au corps à corps");

        // Jet d'attaque pour l'attaquant
        Random rand = new Random();
        int randAtt = rand.nextInt(101);
        if (randAtt <= this.getPageAtt()) {
            System.out.println("Attaque réussie");
            
            // Jet de défense pour l'adversaire
            int randDef = rand.nextInt(101);
            if (randDef > c.getPagePar()) {
                // Si la parade échoue, l'adversaire subit tous les dégâts
                c.setPtVie(c.getPtVie()-this.getDegAtt());
                System.out.println("L'adversaire subit " + this.getDegAtt() + " dégâts.");
            } else {
                // Si la parade réussit, l'adversaire atténue les dégâts
                int degatsSubis = this.getDegAtt() - c.getPtPar();
                if (degatsSubis < 0) degatsSubis = 0;  // Empêche les dégâts négatifs
                c.setPtVie(c.getPtVie()-degatsSubis);
                System.out.println("L'adversaire parvient à parer, il subit " + degatsSubis + " dégâts.");
            }
        } else {
            System.out.println("Attaque ratée");
        }
    } else if (distance > 1 && distance <= this.getDistAttMax()) {
        // Combat à distance
        System.out.println("Combat à distance");

        // Jet d'attaque pour l'attaquant
        Random rand = new Random();
        int randAtt = rand.nextInt(101);
        if (randAtt <= this.getPageAtt()) {
            System.out.println("Attaque réussie");
            c.setPtVie(c.getPtVie()-this.getDegAtt());
            System.out.println("L'adversaire subit " + this.getDegAtt() + " dégâts.");
        } else {
            System.out.println("Attaque ratée");
        }

        // L'attaquant perd un projectile (flèche par exemple)
        this.nbFleches--;
        System.out.println("L'attaquant perd une flèche, il lui reste " + this.nbFleches + " flèches.");
    } else {
        System.out.println("L'adversaire est hors de portée.");
    }
}
        
    
}
