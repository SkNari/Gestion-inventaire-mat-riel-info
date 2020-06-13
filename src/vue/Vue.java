package vue;

import java.sql.Date;
import java.util.Scanner;

import model.Materiel;
import model.Stockage;

public class Vue {

    private Scanner scan = new Scanner(System.in);;

    public Vue() {

    }

    public static void effacerConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }



    public int afficherMenu()
    {
        effacerConsole();
        System.out.println("╔══════════════════════════ MENU ══════════════════════════╗");
        System.out.println("║ 0. Quitter                                               ║");
        System.out.println("║ 1. Afficher le materiel                                  ║");
        System.out.println("║ 2. Afficher les emprunts                                 ║");
        System.out.println("║ 3. Afficher les lieux de stockage                        ║");
        System.out.println("║ 4. Ajouter/Modifier (Materiel/Lieu/Emprunt/Utilisateur)  ║");
        System.out.println("║ 5. Rendre un emprunt                                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.println("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    public int afficherMenuMateriel()
    {
        effacerConsole();
        System.out.println("╔═════════════════════ MENU MATERIEL ══════════════════════╗");
        System.out.println("║ 0. Retour                                                ║");
        System.out.println("║ 1. Afficher le materiel total                            ║");
        System.out.println("║ 2. Afficher le materiel disponible                       ║");
        System.out.println("║ 3. Afficher le materiel emprunte                         ║");
        System.out.println("║ 4. Afficher le materiel selon leur type                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.println("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    public int afficherMenuEmprunt()
    {
        effacerConsole();
        System.out.println("╔══════════════════════ MENU EMPRUNT ══════════════════════╗");
        System.out.println("║ 0. Retour                                                ║");
        System.out.println("║ 1. Afficher tous les emprunts                            ║");
        System.out.println("║ 2. Afficher les emprunts selon leur raison               ║");
        System.out.println("║ 3. Afficher les emprunts selon l'emprunteur              ║");
        System.out.println("║ 4. Afficher les emprunts en retard                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.println("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    public void afficherStockage(Stockage stockage)
    {
        for (int i : stockage.getMateriels().keySet()) {
            System.out.println("id/reference: " + i + " | nom: " + stockage.getMateriels().get(i).getNom());
        }
    }

    public Materiel ajouterMateriel()
    {
        System.out.print("Saisissez l'id du materiel : ");
        int id = scan.nextInt();
        System.out.print("Saisissez le nom du materiel : ");
        scan.nextLine();
        String nom = scan.nextLine();
        System.out.print("Saisissez la marque du materiel : ");
        scan.nextLine();
        String marque = scan.nextLine();
        System.out.print("Saisissez le proprietaire du materiel : ");
        scan.nextLine();
        String proprietaire = scan.nextLine();
        Date dateAchat = new Date(2020, 12, 06);
        System.out.print("Saisissez le prix d'achat du materiel : ");
        scan.nextLine();
        int prixAchat = scan.nextInt();
        System.out.print("Saisissez l'etat du materiel : ");
        String etat = scan.nextLine();
        return new Materiel(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
    }

    public int supprimerMateriel()
    {
        System.out.println("Saisissez l'id du materiel : ");
        int id = scan.nextInt();
        return id;
    }
}