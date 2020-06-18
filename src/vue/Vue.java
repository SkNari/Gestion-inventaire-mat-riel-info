package vue;

import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Scanner;

import model.CapteursDeProfondeur;
import model.CasqueAudio;
import model.CasqueVR;
import model.Emprunt;
import model.Emprunteur;
import model.ManetteJeu;
import model.ManetteVR;
import model.Materiel;
import model.Souris;
import model.Stockage;
import model.Tablette;
import model.Telephone;
import model.Webcam;

public class Vue {

    private final Scanner scan;

    public Vue() {
        this.scan = new Scanner(System.in);
    }

    public void effacerConsole() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void waitForUser(){

        this.scan.nextLine();
        this.scan.nextLine();

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

    public void auRevoir(Emprunteur user){

        System.out.println("\n Au revoir "+user.getPrenom()+" "+user.getNom()+"!");

    }

    public void notRegistered(){

        System.out.println("Vous n'êtes pas enregistré dans la base de données des emprunteurs.\nVeuillez renseigner vos informations personnelles.");

    }

    public int afficherMenu()
    {

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

    public int afficherMenuAjMod(String type){

        System.out.println("╔═════════════════ MENU AJOUTER/MODIFIER ══════════════════╗");
        System.out.println("║ 0. Retour                                                ║");
        System.out.println("║ 1. Ajouter "+type+"                                    ║");
        System.out.println("║ 2. Modifier "+type+"                                   ║");
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
        Materiel materiel = new Materiel(id, null, null, null, null, null, null);
        
        Emprunt emprunt = new Emprunt(dateEmprunt, dateRendu, materiel, null);
   
        return emprunt;
    }

    /*  ----------------------------------------------------*/


    /*  --------------------- STOCKAGE ---------------------*/

    public void afficherTousStockages(HashMap<Integer, Stockage> stockages)
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

    public void afficherTousMateriels(HashMap<Integer, Materiel> materiels)
    {
        for (Materiel materiel : materiels.values()) {
            afficherMateriel(materiel);
        }
    }

    public void afficherMaterielDisponible(HashMap<Integer, Materiel> materiels)
    {
        
    }

    public int afficherMenuAjouterMateriel()
    {   
        System.out.println("╔════════════════ Vous souhaitez ajouter? ═════════════════╗");
        System.out.println("║ 0. Capteur Profondeur             1. Casque Audio        ║");
        System.out.println("║ 2. Casque VR                      3. Manette Jeu         ║");
        System.out.println("║ 4. Manette VR                     5. Souris              ║");
        System.out.println("║ 6. Tablette                       7. Telephone           ║");
        System.out.println("║ 8. Webcam                         9. Sortir              ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        System.out.print("\nChoix : ");
        int choix = scan.nextInt();

        return choix;
    }

    public CapteursDeProfondeur ajouterCapteursDeProfondeur(){

        scan.nextLine();
        System.out.println("| Saisisser le nom du capteur de profondeur : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque du capteur de profondeur : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire du capteur de profondeur : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat du capteur de profondeur : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat du capteur de profondeur : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la connectique du capteur de profondeur : ");
        String connectique = scan.nextLine();

        CapteursDeProfondeur materiel = new CapteursDeProfondeur(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, connectique);
    
        return materiel;

    }
    
    public CasqueVR ajouterCasqueVR(){

        scan.nextLine();
        System.out.println("| Saisisser le nom du casque VR : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque du casque VR : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire du casque VR : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat du casque VR : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat du casque VR : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la connectique du casque VR : ");
        String connectique = scan.nextLine();

        System.out.println("| Saisisser la connectique du casque VR : ");
        String resolution = scan.nextLine();

        CasqueVR materiel = new CasqueVR(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, connectique,resolution);
    
        return materiel;

    }

    public CasqueAudio ajouterCasqueAudio(){

        scan.nextLine();
        System.out.println("| Saisisser le nom du casque audio : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque du casque audio : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire du casque audio : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat du casque audio : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat du casque audio : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la connectique du casque audio : ");
        String connectique = scan.nextLine();

        CasqueAudio materiel = new CasqueAudio(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, connectique);
    
        return materiel;

    }
    
    public ManetteJeu ajouterManetteJeu(){

        scan.nextLine();
        System.out.println("| Saisisser le nom de la manette de jeu : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque de la manette de jeu : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire de la manette de jeu : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat de la manette de jeu : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat de la manette de jeu : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la connectique de la manette de jeu : ");
        String connectique = scan.nextLine();

        ManetteJeu materiel = new ManetteJeu(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, connectique);
    
        return materiel;

    }

    public ManetteVR ajouterManetteVR(){

        scan.nextLine();
        System.out.println("| Saisisser le nom de la manette VR : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque de la manette VR : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire de la manette VR : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat de la manette VR : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat de la manette VR : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la connectique de la manette VR : ");
        String connectique = scan.nextLine();

        ManetteVR materiel = new ManetteVR(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, connectique);
    
        return materiel;

    }

    public Souris ajouterSouris(){

        scan.nextLine();
        System.out.println("| Saisisser le nom de la souris : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque de la souris : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire de la souris : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat de la souris : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat de la souris : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la connectique de la souris : ");
        String connectique = scan.nextLine();

        Souris materiel = new Souris(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, connectique);
    
        return materiel;

    }


    public Telephone ajouterTelephone(){

        scan.nextLine();
        System.out.println("| Saisisser le nom du telephone : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque du telephone : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire du telephone : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat du telephone : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat du telephone : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser l'os du telephone : ");
        String os = scan.nextLine();

        System.out.println("| Saisisser la taille du telephone : ");
        String taille = scan.nextLine();

        System.out.println("| Saisisser la résolution du telephone : ");
        String resolution = scan.nextLine();

        Telephone materiel = new Telephone(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, os, taille, resolution);
    
        return materiel;

    }

    public Tablette ajouterTablette(){

        scan.nextLine();
        System.out.println("| Saisisser le nom de la tablette : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque de la tablette : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire de la tablette : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat de la tablette : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat de la tablette : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser l'os de la tablette : ");
        String os = scan.nextLine();

        System.out.println("| Saisisser la taille de la tablette : ");
        String taille = scan.nextLine();

        System.out.println("| Saisisser la résolution de la tablette : ");
        String resolution = scan.nextLine();

        Tablette materiel = new Tablette(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, os, taille, resolution);
    
        return materiel;

    }

    public Webcam ajouterWebcam(){

        scan.nextLine();
        System.out.println("| Saisisser le nom de la webcam : ");
        String nom = scan.nextLine();

        System.out.println("| Saisisser la marque de la webcam : ");
        String marque = scan.nextLine();

        System.out.println("| Saisisser le proprietaire de la webcam : ");
        String proprietaire = scan.nextLine();

        Date dateEmprunt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dateEmprunt); 

        System.out.println("| Saisissemenur le prix d'achat de la webcam : ");
        String prixAchat = scan.nextLine();

        System.out.println("| Saisisser l'etat de la webcam : ");
        String etat = scan.nextLine();

        System.out.println("| Saisisser la resolution de la webcam : ");
        String resolution = scan.nextLine();

        System.out.println("| Saisisser la connectique de la webcam : ");
        String connectique = scan.nextLine();

        Webcam materiel = new Webcam(-1, nom, marque, proprietaire, dateEmprunt, prixAchat, etat, resolution, connectique);
    
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