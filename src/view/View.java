package view;

import java.util.Scanner; 

public class View {
    
    private Scanner scan;
    
    public View()
    {
        
    }

    public void afficherMenu()
    {
        System.out.println("╔═════════════ MENU ═════════════╗");
        System.out.println("║                                ║");
        System.out.println("║                                ║");
        System.out.println("║                                ║");
        System.out.println("║                                ║");
        System.out.println("╚════════════════════════════════╝");
    }

    public String supprimer()
    {
        System.out.println("Saisissez l'id du materiel : ");
        String id = scan.nextLine();
        return id;
    }
    


}