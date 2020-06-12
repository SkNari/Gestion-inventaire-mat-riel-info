package vue;

import java.util.Scanner;

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
        System.out.println("║ 1. Afficher le materiel total                            ║");
        System.out.println("║ 2. Afficher le materiel disponible                       ║");
        System.out.println("║ 3. Afficher le materiel emprunte                         ║");
        System.out.println("║ 4. Afficher le materiel selon leur type                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.println("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    public int supprimer()
    {
        System.out.println("Saisissez l'id du materiel : ");
        int id = scan.nextInt();
        return id;
    }
}