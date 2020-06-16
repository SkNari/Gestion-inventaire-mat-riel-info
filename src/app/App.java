package app;

import controleur.ConnexionControleur;
import model.Emprunteur;
import model.Serialisation;
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
        this.data = Serialisation.deserialiserData();

        this.user = this.connexion.connect();

        System.out.println(this.data.getEmprunteurs().get(1).toString());

        Serialisation.serialiserData(this.data);

    }

}