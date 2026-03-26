package exo2DS1;

import java.util.ArrayList;

/**
 * Représente un étudiant avec ses notes.
 */
public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private ArrayList<Double> notes;

    public Etudiant() {
        notes = new ArrayList<>();
    }

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        notes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void ajouterNote(double note) {
        notes.add(note);
    }

    public double calculerMoyenne() {

        if (notes.isEmpty()) {
            return 0;
        }

        double somme = 0;

        for (double note : notes) {
            somme += note;
        }

        return somme / notes.size();
    }

    @Override
    public String toString() {
        return "Etudiant{id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + calculerMoyenne() +
                '}';
    }
}