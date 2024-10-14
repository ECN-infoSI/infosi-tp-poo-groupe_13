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
public class Personnage extends Creature{
    /**
     * le nom de la personnage
     */
    private String nom;
    /**
     * représente la distance maximale pour attaquer
     */
    private int distAttMax;

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
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
        nom = n;
        distAttMax = dMax;      
    }
    
    /**
     *
     * @param person
     */
    public Personnage(Personnage person){
        super((Creature)person);
        this.distAttMax = person.getDistAttMax();
        this.nom = person.getNom();
    }
    
    /**
     *
     */
    public Personnage(){
        Point2D p = new Point2D();
        this("Person",0,0,0,0,0,0,p);

    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */

     
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *
     * @return
     */

   
    

    
    /**
     *
     */
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
     
  
    
    
    /**
     * la methode deplace permet de déplacer un personnage à une case adjacente aléatoire et teste aprés le déplacement si une potion de soin existe et la consomme si oui
     * @param w */
    public void deplace(World w){
        Random randInt = new Random();
        int direction = randInt.nextInt(8); // Random int between 0 and 7

        // Get the dx and dy from the DIRECTIONS array
        int dx = DIRECTIONS[direction][0];
        int dy = DIRECTIONS[direction][1];

        // Translate the position
        this.getPos().translate(dx, dy);
        
        
        
            
            
                 
        
    }
    
}