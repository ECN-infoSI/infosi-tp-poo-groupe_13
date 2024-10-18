/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author leovdb
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Classe Sauvegarder contenant les méthodes pour sauvegarder et charger les
 * parties du jeu.
 */
public class ChargementPartie {

    public ChargementPartie() {
    }

    /**
     * Méthode pour charger une partie depuis un fichier texte.
     *
     * @param filePath Le chemin du fichier de sauvegarde.
     * @return
     */
    public World chargement(String filePath) {
        World monde = new World();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            line = reader.readLine();
            int largeur = Integer.parseInt(line.split(" ")[1]);
            line = reader.readLine();
            int hauteur = Integer.parseInt(line.split(" ")[1]);

            monde.setGrille(new ElementDeJeu[largeur][hauteur]);
            monde.setTailleGrille(largeur);

            while ((line = reader.readLine()) != null) {
                String[] params = line.split(" ");
                String type = params[0];
                switch (type) {
                    case "Guerrier" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        Guerrier guerrier = chargerGuerrier(params);
                        monde.getGrille()[x][y] = guerrier;
                    }

                    case "Archer" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        Archer archer = chargerArcher(params);
                        monde.getGrille()[x][y] = archer;
                    }

                    case "Paysan" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        Paysan paysan = chargerPaysan(params);
                        monde.getGrille()[x][y] = paysan;
                    }

                    case "Loup" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        Loup loup = chargerLoup(params);
                        monde.getGrille()[x][y] = loup;
                    }

                    case "Lapin" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        Lapin lapin = chargerLapin(params);
                        monde.getGrille()[x][y] = lapin;
                    }

                    case "NuageToxique" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        NuageToxique nuage = chargerNuageToxique(params);
                        monde.getGrille()[x][y] = nuage;
                    }

                    case "Epee" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        Epee epee = chargerEpee(params);
                        monde.getGrille()[x][y] = epee;
                    }

                    case "PotionSoin" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        PotionSoin potion = chargerPotionSoin(params);
                        monde.getGrille()[x][y] = potion;
                    }

                    case "PommeEnchantee" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        PommeEnchantee pomme = chargerPommeEnchantee(params);
                        monde.getGrille()[x][y] = pomme;
                    }

                    case "PommeDeLaDiscorde" -> {
                        int x = Integer.parseInt(params[1]);
                        int y = Integer.parseInt(params[2]);
                        PommeDeLaDiscorde pomme = chargerPommeDeLaDiscorde(params);
                        monde.getGrille()[x][y] = pomme;
                    }

                    case "Joueur" -> {
                        int x = Integer.parseInt(params[2]);
                        int y = Integer.parseInt(params[3]);
                        Joueur joueur = chargerJoueur(monde, params);
                        monde.getGrille()[x][y] = joueur.getPersonnage();
                    }

                    case "Inventaire" -> {
                        Objet objet = chargerInventaire(params);
                        monde.getJoueur().getPersonnage().getInventaire().add((Utilisable) objet);
                    }

                    case "Effet" -> {
                        Nourriture effet = chargerEffet(params);
                        monde.getJoueur().getPersonnage().getEffet().add(effet);
                    }

                    default ->
                        System.out.println("Type d'élément inconnu : " + type);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monde;
    }

    /**
     * Méthode pour charger un Guerrier.
     *
     * @param params Les paramètres du guerrier.
     * @return
     */
    private Guerrier chargerGuerrier(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new Guerrier(
                params[8],
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6]),
                Integer.parseInt(params[7]),
                Integer.parseInt(params[9]),
                p
        );
    }

    /**
     * Méthode pour charger un Archer.
     *
     * @param params Les paramètres de l'archer.
     * @return
     */
    private Archer chargerArcher(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new Archer(
                params[8],
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6]),
                Integer.parseInt(params[7]),
                Integer.parseInt(params[9]),
                p,
                Integer.parseInt(params[10])
        );
    }

    /**
     * Méthode pour charger un Paysan.
     *
     * @param params Les paramètres du paysan.
     * @return
     */
    private Paysan chargerPaysan(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new Paysan(
                params[8],
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6]),
                Integer.parseInt(params[7]),
                Integer.parseInt(params[9]),
                p
        );
    }

    /**
     * Méthode pour charger un Loup.
     *
     * @param params Les paramètres du loup.
     * @return
     */
    private Loup chargerLoup(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new Loup(
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6]),
                Integer.parseInt(params[7]),
                Integer.parseInt(params[8]),
                p
        );
    }

    /**
     * Méthode pour charger un Lapin.
     *
     * @param params Les paramètres du lapin.
     * @return
     */
    private Lapin chargerLapin(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new Lapin(
                Integer.parseInt(params[3]),
                Integer.parseInt(params[4]),
                Integer.parseInt(params[5]),
                Integer.parseInt(params[6]),
                Integer.parseInt(params[7]),
                p
        );
    }

    /**
     * Méthode pour charger un Nuage Toxique.
     *
     * @param params Les paramètres du nuage toxique.
     * @return
     */
    private NuageToxique chargerNuageToxique(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new NuageToxique(p, Integer.parseInt(params[3]), Integer.parseInt(params[4]));
    }

    /**
     * Méthode pour charger une Epee.
     *
     * @param params Les paramètres d'une epee.
     * @return
     */
    private Epee chargerEpee(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new Epee(Integer.parseInt(params[3]), p);
    }

    /**
     * Méthode pour charger une Potion de soin.
     *
     * @param params Les paramètres d'une potion de soin.
     * @return
     */
    private PotionSoin chargerPotionSoin(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new PotionSoin(Integer.parseInt(params[3]), p);
    }

    /**
     * Méthode pour charger une Pomme Enchantée.
     *
     * @param params Les paramètres d'une pomme enchantée.
     * @return
     */
    private PommeEnchantee chargerPommeEnchantee(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new PommeEnchantee(p, params[3], Integer.parseInt(params[4]), Integer.parseInt(params[5]), params[6]);
    }

    /**
     * Méthode pour charger une Pomme De La Discorde.
     *
     * @param params Les paramètres d'une pomme de la discorde.
     * @return
     */
    private PommeDeLaDiscorde chargerPommeDeLaDiscorde(String[] params) {
        int x = Integer.parseInt(params[1]);
        int y = Integer.parseInt(params[2]);
        Point2D p = new Point2D(x, y);
        return new PommeDeLaDiscorde(p, params[3], Integer.parseInt(params[4]), Integer.parseInt(params[5]), params[6]);
    }

    /**
     * Méthode pour charger un joueur et son personnage.
     *
     * @param params Les paramètres du joueur.
     * @return
     */
    private Joueur chargerJoueur(World monde, String[] params) {
        String[] paramsSansJoueur = Arrays.copyOfRange(params, 1, params.length);
        Joueur joueur = new Joueur(monde);
        Personnage perso;
        switch (params[1]) {
            case "Guerrier" ->
                perso = chargerGuerrier(paramsSansJoueur);
            case "Archer" ->
                perso = chargerArcher(paramsSansJoueur);
            default ->
                throw new IllegalArgumentException("Type de personnage inconnu : " + params[1]);
        }
        joueur.setPersonnage(perso);
        monde.setJoueur(joueur);
        return joueur;
    }

    /**
     * Méthode pour charger un objet de l'inventaire.
     *
     * @param params Les paramètres de l'objet de l'inventaire.
     * @return
     */
    private Objet chargerInventaire(String[] params) {
        String[] paramsSansInventaire = Arrays.copyOfRange(params, 1, params.length);
        return switch (params[1]) {
            case "Epee" ->
                chargerEpee(paramsSansInventaire);
            case "PotionSoin" ->
                chargerPotionSoin(paramsSansInventaire);
            case "PommeEnchantee" ->
                chargerPommeEnchantee(paramsSansInventaire);
            case "PommeDeLaDiscorde" ->
                chargerPommeDeLaDiscorde(paramsSansInventaire);
            default ->
                throw new IllegalArgumentException("Type d'objet inconnu");
        };
    }

    /**
     * Méthode pour charger un effet.
     *
     * @param params Les paramètres de l'effet.
     * @return
     */
    private Nourriture chargerEffet(String[] params) {
        String[] paramsSansEffet = Arrays.copyOfRange(params, 1, params.length);
        return switch (params[1]) {
            case "PommeEnchantee" ->
                chargerPommeEnchantee(paramsSansEffet);
            case "PommeDeLaDiscorde" ->
                chargerPommeDeLaDiscorde(paramsSansEffet);
            default ->
                throw new IllegalArgumentException("Type d'objet inconnu");
        };
    }
}
