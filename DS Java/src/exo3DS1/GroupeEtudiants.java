package exo3DS1;

import java.util.ArrayList;

/**
 * Classe permettant de gérer un groupe d'étudiants.
 */
public class GroupeEtudiants {

    // Liste contenant tous les étudiants
    private ArrayList<Etudiant> etudiants;

    /**
     * Constructeur : initialise la liste des étudiants
     */
    public GroupeEtudiants() {
        etudiants = new ArrayList<>();
    }

    /**
     * Ajoute un étudiant dans le groupe
     */
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    /**
     * Affiche tous les étudiants du groupe
     */
    public void afficherEtudiants() {

        for (Etudiant e : etudiants) {
            System.out.println(e);
        }

    }

    /**
     * Calcule la moyenne générale du groupe
     */
    public double calculerMoyenneGenerale() {

        if (etudiants.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (Etudiant e : etudiants) {
            somme += e.calculerMoyenne();
        }

        return somme / etudiants.size();
    }

    /**
     * Recherche un étudiant par son nom
     */
    public Etudiant rechercherParNom(String nom) {

        for (Etudiant e : etudiants) {

            if (e.getNom().equals(nom)) {
                return e;
            }

        }

        return null;
    }

    /**
     * Retourne l'étudiant ayant la meilleure moyenne
     */
    public Etudiant meilleurEtudiant() {

        if (etudiants.isEmpty()) {
            return null;
        }

        Etudiant meilleur = etudiants.get(0);

        for (Etudiant e : etudiants) {

            if (e.calculerMoyenne() > meilleur.calculerMoyenne()) {
                meilleur = e;
            }

        }

        return meilleur;
    }

    /**
     * Compte le nombre d'étudiants admis (moyenne >= 10)
     */
    public int compterAdmis() {

        int compteur = 0;

        for (Etudiant e : etudiants) {

            if (e.calculerMoyenne() >= 10) {
                compteur++;
            }

        }

        return compteur;
    }

}