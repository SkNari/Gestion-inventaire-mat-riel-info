package controleur;

import model.Stockage;
import vue.Vue;

public class Controleur {

    private String prenomUtilisateur;
    private String nomUtilisateur;
    private final Vue vue;

    public String getPrenomUtilisateur() {
        return this.prenomUtilisateur;
    }

    public void setPrenomUtilisateur(final String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return this.nomUtilisateur;
    }

    public void setNomUtilisateur(final String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public Controleur(final String prenomUtilisateur, final String nomUtilisateur)
    {
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.vue = new Vue();

        if(this.utilisateurExiste())
        {

        }

        this.controleurCommande();
    }

    private void controleurCommande(){
        boolean continuer = true;
        int choix;

        while(continuer)
        {
            choix = this.vue.afficherMenu();
            continuer = this.interpreterChoix(choix);
        }
    }

    private boolean interpreterChoix(final int choix) {
        if(choix == 0)
            return false;
        else if(choix == 1)
        {
            this.vue.afficherMenuMateriel();
            return true;
        }
        else if(choix == 2)
        {
            this.vue.afficherMenuEmprunt();
            return true;
        }
        else if(choix == 3)
        {
            final Stockage stockage = new Stockage(1,"Salle 209","Erwan",this.vue.ajouterMateriel());
            
            this.vue.afficherStockage(stockage);
            return true;
        }
        else if(choix == 4)
        {
            this.interpreterChoixAjouter();
            return true;
        }
        else if(choix == 5)
        {
            // Rendre un emprunt
            return true;
        }
        return true;
    }

    private boolean interpreterChoixAjouter()
    {
        int choix = -1;

        while (choix != 0)
        {
            choix = this.vue.afficherMenuAjouterModifier();
            if (choix == 1)
            {
                // Ajout matériel
            }
            else if (choix == 2)
            {
                // Ajout lieu de stockage
            }
            else if (choix == 3)
            {
                // Ajout emprunt
            }
            else if (choix == 4 )
            {
                // Ajout utilisateur
            }
        }

        return false;
    }

    private boolean utilisateurExiste()
    {
        return true;
    }
}