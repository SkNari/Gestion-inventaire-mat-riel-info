package controleur;

import vue.Vue;

public class Controleur {

    private String prenomUtilisateur;
    private String nomUtilisateur;
    private Vue vue;

    public String getPrenomUtilisateur() {
        return this.prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return this.nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public Controleur(String prenomUtilisateur, String nomUtilisateur)
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

    private boolean interpreterChoix(int choix) {
        if(choix == 0)
            return false;
        else if(choix == 1)
        {
            this.vue.afficherMenuMateriel();
            return true;
        }

        return true;
    }

    private boolean utilisateurExiste()
    {
        return true;
    }
}