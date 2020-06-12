import java.util.Scanner;

import controleur.Controleur;

public class Main {

    public static void main(String[] args) {

        final Scanner sc = new Scanner(System.in);
        String prenomUtilisateur, nomUtilisateur;
        
        System.out.print("Quel est votre prenom ? : ");
        prenomUtilisateur = sc.nextLine();
        
        System.out.print("Quel est votre nom ? : ");
        nomUtilisateur = sc.nextLine();

        System.out.println("\nBienvenu(e) "+prenomUtilisateur+" "+nomUtilisateur+"!\n");

        Controleur controleur = new Controleur(prenomUtilisateur,nomUtilisateur);

    }
}