package vue;

import java.util.Scanner; 

public class Vue {
    
    private Scanner scan = new Scanner(System.in);;
    
    public Vue()
    {
        
    }

    public int afficherMenu()
    {
        System.out.println("╔═════════════ MENU ═════════════╗");
        System.out.println("║                                ║");
        System.out.println("║                                ║");
        System.out.println("║                                ║");
        System.out.println("║                                ║");
        System.out.println("╚════════════════════════════════╝");

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