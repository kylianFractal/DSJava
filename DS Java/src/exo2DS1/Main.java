package exo2DS1;

public class Main {
    public static void main(String[] args) {

        // Création de quelques étudiants
        Etudiant e1 = new Etudiant(1, "Dupont", "Alice");
        e1.ajouterNote(12);
        e1.ajouterNote(15);
        e1.ajouterNote(14);

        Etudiant e2 = new Etudiant(2, "Martin", "Paul");
        e2.ajouterNote(8);
        e2.ajouterNote(10);
        e2.ajouterNote(9);

        Etudiant e3 = new Etudiant(3, "Durand", "Sofia");
        e3.ajouterNote(16);
        e3.ajouterNote(18);
        e3.ajouterNote(17);

        // Création du groupe et ajout des étudiants
        GroupeEtudiants groupe = new GroupeEtudiants();
        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.ajouterEtudiant(e3);

        // Affichage de tous les étudiants
        System.out.println("Liste des étudiants :");
        groupe.afficherEtudiants();

        // Affichage de la moyenne générale
        System.out.println("Moyenne générale : " + groupe.calculerMoyenneGenerale());

        // Nombre d'étudiants admis (moyenne >= 10)
        System.out.println("Nombre d’étudiants admis : " + groupe.compterAdmis());

        // Meilleur étudiant
        System.out.println("Meilleur étudiant : " + groupe.meilleurEtudiant());

        // Recherche par nom
        String nomRecherche = "Martin";
        Etudiant recherche = groupe.rechercherParNom(nomRecherche);
        if (recherche != null) {
            System.out.println("Étudiant trouvé pour le nom '" + nomRecherche + "' : " + recherche);
        } else {
            System.out.println("Aucun étudiant trouvé pour le nom '" + nomRecherche + "'");
        }
    }
}