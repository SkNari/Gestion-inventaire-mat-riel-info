package vue;

import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Scanner;

import model.Emprunt;
import model.Emprunteur;
import model.Materiel;
import model.Stockage;

public class Vue {

    private final Scanner scan;

    public Vue() {
        this.scan = new Scanner(System.in);
    }

    public static void effacerConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public String askName(){

        String prenomUtilisateur, nomUtilisateur;
        
        System.out.print("Quel est votre prenom ? : ");
        prenomUtilisateur = scan.nextLine();
        
        System.out.print("Quel est votre nom ? : ");
        nomUtilisateur = scan.nextLine();

        if(prenomUtilisateur.equals("")||nomUtilisateur.equals("")){

            System.out.println("Un des champs que vous avez entré est vide. Veuillez recommencer.");
            return this.askName();

        }

        return prenomUtilisateur+","+nomUtilisateur;

    }

    public void saluer(String prenomUtilisateur, String nomUtilisateur){

        System.out.println("\nBienvenu(e) "+prenomUtilisateur+" "+nomUtilisateur+"!\n");

    }

    public void notRegistered(){

        System.out.println("Vous n'êtes pas enregistré dans la base de données des emprunteurs.\nVeuillez renseigner vos informations personnelles.");

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

        System.out.print("\nChoix : ");
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

        System.out.print("\nChoix : ");
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

        System.out.print("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    public int afficherMenuAjouterModifier()
    {
        effacerConsole();
        System.out.println("╔═════════════════ MENU AJOUTER/MODIFIER ══════════════════╗");
        System.out.println("║ 0. Retour                                                ║");
        System.out.println("║ 1. Ajouter/Modifier un matériel                          ║");
        System.out.println("║ 2. Ajouter/Modifier un lieu de stockage                  ║");
        System.out.println("║ 3. Ajouter/Modifier un emprunt                           ║");
        System.out.println("║ 4. Ajouter/Modifier un utilisateur                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.print("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    /*  --------------------- EMPRUNTEUR -------------------*/
    
        public Emprunteur ajouterEmprunteur()
        {
            System.out.print("\n| Saisisser l'institution auquel vous appartenez : ");
            String institution = scan.nextLine();

            System.out.print("| Saisisser votre nom : ");
            String nom = scan.nextLine();

            System.out.print("| Saisisser votre prenom : ");
            String prenom = scan.nextLine();

            System.out.print("| Saisisser votre adresse : ");
            String adresse = scan.nextLine();

            System.out.print("| Saisisser votre numero de telephone : ");
            String numeroDeTelephone = scan.nextLine();

            System.out.print("| Saisisser votre mail : ");
            String mail = scan.nextLine();

            Emprunteur emprunteur = new Emprunteur(-1, institution, nom, prenom, adresse, numeroDeTelephone, mail);
            return emprunteur;
        }


    /*  ----------------------------------------------------*/

    /*  --------------------- EMPRUNT ----------------------*/

    /* public void afficherListeEmprunt(HashMap<Integer, Emprunt> emprunts)
    {

    } */
    
    public Emprunt ajouterEmprunt() //return ??
    {
        System.out.print("\n| Saisisser l'id du materiel a emprunter : ");
        scan.nextLine();
        int id = scan.nextInt();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt);

        while(true)
        {
            System.out.print("| Saisisser la date de rendu (Exemple : 25/06/2020): ");
            String stringRendu = scan.nextLine();
            String [] tabRendu = stringRendu.split("/");
            if (tabRendu.length == 3)
            {
                c.set(Integer.parseInt(tabRendu[0]), Integer.parseInt(tabRendu[1]),Integer.parseInt(tabRendu[2]));
                break;
            }
            else
            {
                System.out.println("Mauvaise saisie !");
            }
        }

        Date dateRendu = c.getTime();
        Materiel materiel = new Materiel(id, null, null, null, null, -1, null);
        Emprunteur emprunteur = new Emprunteur(-1, null, null, null, null, null, null);
        
        Emprunt emprunt = new Emprunt(dateEmprunt, dateRendu, materiel, emprunteur);
   
        return emprunt;
    }

    /*  ----------------------------------------------------*/


    /*  --------------------- STOCKAGE ---------------------*/

    public void afficherListeStockages(HashMap<Integer, Stockage> stockages)
    {
        for (Stockage stockage : stockages.values()) {
            afficherStockage(stockage);
        }
    }

    public void afficherStockage(Stockage stockage)
    {
        System.out.println(stockage);
    }

    public void afficherStockageContenu(Stockage stockage)
    {
        System.out.println("\n╔═════════════════ "+stockage.getNom()+" ═════════════════╗");
        System.out.println("\n  Proprietaire : "+stockage.getProprietaire() +"     ID : "+stockage.getId());
        for (int i : stockage.getMateriels().keySet()) {
            afficherMateriel(stockage.getMateriels().get(i));
        }
        System.out.println("╚═════════════════ "+stockage.getNom()+" ═════════════════╝");
    }

    public Stockage ajouterStockage()
    {
        System.out.print("| Saisisser le nom du stockage : ");
        scan.nextLine();
        String nom = scan.nextLine();

        System.out.print("| Saisisser le proprietaire du stockage : ");
        String proprietaire = scan.nextLine();

        Stockage stockage = new Stockage(-1, nom, proprietaire);
        return stockage;
    }

    /*  ----------------------------------------------------*/


    /*  --------------------- MATERIEL ---------------------*/
    
    public void afficherMateriel(Materiel materiel)
    {
        System.out.println(materiel);
    }

    public Materiel ajouterMateriel()
    {
        System.out.print("| Saisisser le nom du materiel : ");
        scan.nextLine();
        String nom = scan.nextLine();

        System.out.print("| Saisisser la marque du materiel : ");
        String marque = scan.nextLine();

        System.out.print("| Saisisser le proprietaire du materiel : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.print("| Saisisser le prix d'achat du materiel : ");
        int prixAchat = scan.nextInt();

        System.out.print("| Saisisser l'etat du materiel : ");
        scan.nextLine();
        String etat = scan.nextLine();

        Materiel materiel = new Materiel(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat);
    
        return materiel;
    }
    

    public int supprimerMateriel()
    {
        System.out.println("Saisisser l'id du materiel : ");
        int id = scan.nextInt();
        return id;
    }

    /*  ----------------------------------------------------*/

    public void closeScan(){

        this.scan.close();

    }
}