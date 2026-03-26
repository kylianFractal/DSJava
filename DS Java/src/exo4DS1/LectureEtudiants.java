package exo4DS1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import exo3DS1.Etudiant;

/**
 * Lit un fichier d'étudiants et affiche :
 *  - tous les étudiants
 *  - les étudiants admis
 * permet de charger et exploiter les données externes d’étudiants.
 */
public class LectureEtudiants {

    public static void main(String[] args) {
        try {
            FileReader fichier = new FileReader("etudiants.txt");
            BufferedReader lecteur = new BufferedReader(fichier);

            ArrayList<Etudiant> etudiants = new ArrayList<>();

            // Lire et transformer chaque ligne en étudiant
            String ligne = lecteur.readLine();
            while (ligne != null) {
                String[] parties = ligne.split(";");

                int id = Integer.parseInt(parties[0]);
                String nom = parties[1];
                String prenom = parties[2];

                Etudiant e = new Etudiant(id, nom, prenom);

                for (int i = 3; i <= 5; i++) {
                    double note = Double.parseDouble(parties[i]);
                    e.ajouterNote(note);
                }

                etudiants.add(e);
                ligne = lecteur.readLine();
            }

            // Afficher tous les étudiants
            System.out.println("Liste des étudiants :");
            for (Etudiant e : etudiants) System.out.println(e);

            // Afficher les étudiants admis
            System.out.println("Étudiants admis :");
            for (Etudiant e : etudiants) {
                if (e.calculerMoyenne() >= 10) System.out.println(e);
            }

            lecteur.close();

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}