package app;

import controleur.ConnexionControleur;
import model.Emprunteur;
import vue.Vue;

public class App {
    private ConnexionControleur connexion;
    private Emprunteur user;
    private Vue vue;

    public App(){

        this.vue = new Vue();
        this.connexion = new ConnexionControleur(this.vue);

        this.user = this.connexion.connect();

        System.out.println(user.toString());

    }

}