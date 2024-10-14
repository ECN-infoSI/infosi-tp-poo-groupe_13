/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nadhem
 */
public class Joueur {
    public Personnage perso;
    public World w;
    public String nom;
    
       public Joueur(){
        this.w=new World();
        choisirPersonnage();
       }
       public Joueur(World w){
           this.w= w;
           choisirPersonnage();
       }
    /**
     *
     * @param x
     * @param y
     */
    public void deplace(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Ou voulez-vous vous déplacer ? (1: avant, 2: derriere, 3:droite, 4:gauche)");
         int choix = sc.nextInt();
         int dx=0;
         int dy=0;
         switch (choix) {
           
            case 1:
                dx=0;
                dy=1;
                break;
            case 2:
                dx=0;
                dy=-1;
                break;
            case 3:
                dx=1;
                dy=0;
                break;
            case 4:
                dx=-1;
                dy=0;
                break;
            default:
                System.out.println("Choix invalide.");
          }
        if (w.testerPositionsOccupees(this.perso.getPos().getX()+dx,this.perso.getPos().getY()+dy)){
            System.out.println("La position est occupée");
        }
        else{
        this.perso.getPos().translate(dx,dy);
        }
    }
    public void choisirPersonnage(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose your name:");
        String n = keyboard.nextLine();
        this.nom=n;
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
    public void Jouer(World w){
        int i=1;
        Scanner sc = new Scanner(System.in);
        while (this.perso.getPtVie()>0){
        System.out.println("tour : "+i);
        System.out.println("Que voulez-vous faire ? (1: Se déplacer, 2: Combattre)");
        int choix = sc.nextInt();
        switch (choix) {
           
            case 1:
                this.deplace();
                break;
            case 2:
                Random rand = new Random();
                int r1=rand.nextInt(2);
                if (r1==0){
                int r = rand.nextInt(w.getPersonnages().size());
                if (this.perso instanceof Guerrier guerrier){
                    guerrier.combattre(w.getPersonnages().get(r));
                }
                else {
                        ((Archer) this.perso).combattre(w.getPersonnages().get(r));
                        }
                }
                else{
                    int r = rand.nextInt(w.getMonstres().size());
                if (this.perso instanceof Guerrier guerrier){
                    guerrier.combattre(w.getMonstres().get(r));
                }
                else {
                        ((Archer) this.perso).combattre(w.getMonstres().get(r));
                        }
                }
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }
    }
}

