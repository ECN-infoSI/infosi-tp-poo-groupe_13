/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralenantes.mavenproject1;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Nadhem
 */
public class World {

    /**
     *
     */
    public Archer robin;

    /**
     *
     */
    public Paysan peon;

    /**
     *
     */
    public Lapin bugs1;
    public Archer guillaumeT;
    public Guerrier grosBill;
    public Loup wolfie;
    /**
     *
     */
    public Lapin bugs2;
    public World(){
        this.robin=new Archer();
        this.peon=new Paysan();
        this.bugs1=new Lapin();
    }

    /**
     *
     */
    public void creerMondeAlea(){
        ArrayList<Point2D> positionsUtilisees = new ArrayList<>();

        // Déplacement du premier personnage (pas besoin de vérifier pour le premier)
        Random rand = new Random();
        this.robin.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        positionsUtilisees.add(this.robin.getPos());

        // Déplacement du deuxième personnage, en s'assurant qu'il n'a pas la même position que le premier
        do {
            this.peon.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        } while (positionsUtilisees.contains(this.peon.getPos()));
        positionsUtilisees.add(this.peon.getPos());

        // Déplacement du troisième personnage, en s'assurant qu'il n'a pas la même position que les autres
        do {
            this.bugs1.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        } while (positionsUtilisees.contains(this.bugs1.getPos()));
        positionsUtilisees.add(this.bugs1.getPos());
        // Déplacement du 4éme personnage, en s'assurant qu'il n'a pas la même position que les autres
        do {
            this.guillaumeT.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        } while (positionsUtilisees.contains(this.guillaumeT.getPos()));
        positionsUtilisees.add(this.guillaumeT.getPos());
        // Déplacement du 4éme personnage, en s'assurant qu'il n'a pas la même position que les autres
        do {
            this.bugs2.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        } while (positionsUtilisees.contains(this.bugs2.getPos()));
        positionsUtilisees.add(this.bugs2.getPos());
        // Déplacement du 5éme personnage, en s'assurant qu'il n'a pas la même position que les autres
        do {
            this.grosBill.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        } while (positionsUtilisees.contains(this.grosBill.getPos()));
        positionsUtilisees.add(this.grosBill.getPos());
        // Déplacement du 7éme personnage, en s'assurant qu'il n'a pas la même position que les autres
        do {
            this.wolfie.setPos(new Point2D(rand.nextInt(100),rand.nextInt(100)));
        } while (positionsUtilisees.contains(this.wolfie.getPos()));
        
    }
    
    
}
