/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovd
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author leovd
 */
public class Sauvegarder {

    /**
     *
     */
    public Sauvegarder() {
    }

    /**
     *
     * @param monde
     * @param filePath
     */
    public void sauvegarde(World monde, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            ElementDeJeu[][] grille = monde.getGrille();
            writer.write("Largeur " + grille.length);
            writer.newLine();
            writer.write("Hauteur " + grille.length);
            writer.newLine();

            for (int x = 0; x < grille.length; x++) {
                for (int y = 0; y < grille.length; y++) {
                    ElementDeJeu element = grille[x][y];
                    if (element != null && element != monde.getJoueur().getPersonnage()) {

                        switch (element) {
                            case Guerrier guerrier ->
                                writer.write("Guerrier " + formaterGuerrier(guerrier));
                            case Archer archer ->
                                writer.write("Archer " + formaterArcher(archer));
                            case Paysan paysan ->
                                writer.write("Paysan " + formaterPaysan(paysan));
                            case Loup loup ->
                                writer.write("Loup " + formaterLoup(loup));
                            case Lapin lapin ->
                                writer.write("Lapin " + formaterLapin(lapin));
                            case NuageToxique nuage ->
                                writer.write("NuageToxique " + formaterNuageToxique(nuage));
                            case PotionSoin potion ->
                                writer.write("PotionSoin " + formaterPotionSoin(potion));
                            case Epee epee ->
                                writer.write("Epee " + formaterEpee(epee));
                            case PommeDeLaDiscorde pomme ->
                                writer.write("PommeDeLaDiscorde " + formaterPommeDeLaDiscorde(pomme));
                            case PommeEnchantee pomme ->
                                writer.write("PommeEnchantee " + formaterPommeEnchantee(pomme));
                            default -> {
                            }
                        }

                        writer.newLine();
                    }
                }
            }

            Joueur joueur = monde.getJoueur();
            Personnage perso = joueur.getPersonnage();
            switch (perso) {
                case Guerrier guerrier ->
                    writer.write("Joueur Guerrier " + formaterGuerrier(guerrier));
                case Archer archer ->
                    writer.write("Joueur Archer " + formaterArcher(archer));
                default -> {
                }
            }
            writer.newLine();

            for (Utilisable utilisable : joueur.getPersonnage().getInventaire()) {
                switch (utilisable) {
                    case PotionSoin potion ->
                        writer.write("Inventaire PotionSoin " + formaterPotionSoin(potion));
                    case Epee epee ->
                        writer.write("Inventaire Epee " + formaterEpee(epee));
                    case PommeDeLaDiscorde pomme ->
                        writer.write("Inventaire PommeDeLaDiscorde " + formaterPommeDeLaDiscorde(pomme));
                    case PommeEnchantee pomme ->
                        writer.write("Inventaire PommeEnchantee " + formaterPommeEnchantee(pomme));

                    default -> {
                    }
                }
                writer.newLine();
            }
            for (Utilisable utilisable : joueur.getPersonnage().getEffet()) {
                switch (utilisable) {
                    case PommeDeLaDiscorde pomme ->
                        writer.write("Effet PommeDeLaDiscorde " + formaterPommeDeLaDiscorde(pomme));
                    case PommeEnchantee pomme ->
                        writer.write("Effet PommeEnchantee " + formaterPommeEnchantee(pomme));

                    default -> {
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un paysan.
     *
     * @param element
     * @return
     */
    private String formaterElementDeJeu(ElementDeJeu element) {
        return element.getPos().getX() + " " + element.getPos().getY();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'une créature.
     *
     * @param creature
     * @return
     */
    private String formaterCreature(Creature creature) {
        return formaterElementDeJeu(creature) + " " + creature.getPtVie() + " "
                + creature.getDegAtt() + " " + creature.getPtPar() + " "
                + creature.getPageAtt() + " " + creature.getPagePar();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un personnage.
     *
     * @param personnage
     * @return
     */
    private String formaterPersonnage(Personnage personnage) {
        return formaterCreature(personnage) + " " + personnage.getNom() + " " + personnage.getDistAttMax();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un archer.
     *
     * @param archer
     * @return
     */
    private String formaterArcher(Archer archer) {
        return formaterPersonnage(archer) + " " + archer.getNbFleches();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un guerrier.
     *
     * @param guerrier
     * @return
     */
    private String formaterGuerrier(Guerrier guerrier) {
        return formaterPersonnage(guerrier);
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un paysan.
     *
     * @param paysan
     * @return
     */
    private String formaterPaysan(Paysan paysan) {
        return formaterPersonnage(paysan);
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un monstre.
     *
     * @param monstre
     * @return
     */
    private String formaterMonstre(Monstre monstre) {
        return formaterCreature(monstre);
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un loup.
     *
     * @param loup
     * @return
     */
    private String formaterLoup(Loup loup) {
        return formaterMonstre(loup) + " " + loup.getDistAttMax();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un lapin.
     *
     * @param lapin
     * @return
     */
    private String formaterLapin(Lapin lapin) {
        return formaterMonstre(lapin);
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un objet.
     *
     * @param objet
     * @return
     */
    private String formaterObjet(Objet objet) {
        return formaterElementDeJeu(objet);
    }

    /**
     * Méthode pour formatter les caractérisqtique d'un nuage toxique.
     *
     * @param nuage
     * @return
     */
    private String formaterNuageToxique(NuageToxique nuage) {
        return formaterObjet(nuage) + " " + nuage.getDegats() + " " + nuage.getDistAttMax();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'une epee.
     *
     * @param epee
     * @return
     */
    private String formaterEpee(Epee epee) {
        return formaterObjet(epee) + " " + epee.getDegAtt();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'une potion.
     *
     * @param potion
     * @return
     */
    private String formaterPotionSoin(PotionSoin potion) {
        return formaterObjet(potion) + " " + potion.getPtVie();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'une nourriture.
     *
     * @param nourriture
     * @return
     */
    private String formaterNourriture(Nourriture nourriture) {
        return formaterObjet(nourriture) + " " + nourriture.getNom() + " " + nourriture.getModificationCarac() + " " + nourriture.getDureeEffet() + " " + nourriture.getTypeCarac();
    }

    /**
     * Méthode pour formatter les caractérisqtique d'une pomme enchantée.
     *
     * @param pomme
     * @return
     */
    private String formaterPommeEnchantee(PommeEnchantee pomme) {
        return formaterNourriture(pomme);
    }

    /**
     * Méthode pour formatter les caractérisqtique d'une pomme de la discorde.
     *
     * @param pomme
     * @return
     */
    private String formaterPommeDeLaDiscorde(PommeDeLaDiscorde pomme) {
        return formaterNourriture(pomme);
    }
}
