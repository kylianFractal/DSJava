package exo3DS1;

import java.util.ArrayList;

/**
 * Représente un étudiant et gère ses notes.
 * Cette classe permet de stocker les informations personnelles d'un étudiant
 * et de sécuriser l'ajout de notes pour garantir la cohérence des calculs.
 */
public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private ArrayList<Double> notes;

    /**
     * Constructeur sans paramètre.
     * Permet de créer un étudiant vide, avec une liste de notes initialisée.
     */
    public Etudiant() {
        notes = new ArrayList<>();
    }

    /**
     * Constructeur avec paramètres.
     * Permet de créer un étudiant avec ses informations personnelles
     * et d'initialiser sa liste de notes.
     * 
     * @param id identifiant unique de l'étudiant
     * @param nom nom de l'étudiant
     * @param prenom prénom de l'étudiant
     */
    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        notes = new ArrayList<>();
    }

    // ----- Accesseurs et mutateurs -----
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

    public ArrayList<Double> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Double> notes) {
        this.notes = notes;
    }

    /**
     * Ajoute une note à l'étudiant si elle est valide.
     * Cette méthode sécurise l'ajout pour éviter les notes incorrectes
     * et préserver la cohérence des calculs de moyenne.
     * 
     * @param note la note à ajouter
     */
    public void ajouterNote(double note) {
        try {
            verifierNote(note);
            notes.add(note);
            System.out.println("Note ajoutée: " + note);
        } catch (NoteInvalideException e) {
            // Affiche un message clair à l'utilisateur si la note est invalide
            System.out.println(e.getMessage());
        }
    }

    /**
     * Vérifie qu'une note est comprise entre 0 et 20.
     * Cette vérification garantit que toutes les notes sont valides
     * avant d'être utilisées dans des calculs de moyenne.
     * 
     * @param note la note à vérifier
     * @throws NoteInvalideException si la note est inférieure à 0 ou supérieure à 20
     */
    public void verifierNote(double note) throws NoteInvalideException {
        if (note < 0 || note > 20) {
            throw new NoteInvalideException("Erreur : la note doit être comprise entre 0 et 20.");
        }
    }

    /**
     * Calcule la moyenne des notes de l'étudiant.
     * Cette méthode est utilisée pour évaluer les performances de l'étudiant.
     * 
     * @return la moyenne des notes, ou 0 si aucune note n'est présente
     */
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

    /**
     * Retourne une représentation textuelle de l'étudiant,
     * incluant son identifiant, son nom, prénom et sa moyenne.
     * Utile pour l'affichage et le suivi des étudiants.
     */
    @Override
    public String toString() {
        return "Etudiant{id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + calculerMoyenne() +
                '}';
    }
}