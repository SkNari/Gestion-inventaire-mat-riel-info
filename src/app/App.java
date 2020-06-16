package app;

import controleur.ConnexionControleur;
import model.Emprunteur;
import vue.Vue;
import model.Data;

public class App {
    private ConnexionControleur connexion;
    private Emprunteur user;
    private Vue vue;
    private Data data;

    public App(){

        this.vue = new Vue();
        this.connexion = new ConnexionControleur(this.vue);
        this.data = new Data();

        this.user = this.connexion.connect();

        System.out.println(user.toString());

    }

}