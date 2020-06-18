package app;

import controleur.ConnexionControleur;
import controleur.Controleur;
import model.Emprunteur;
import model.Serialisation;
import vue.Vue;
import model.Data;

public class App {
    private ConnexionControleur connexion;
    private Emprunteur user;
    private Vue vue;
    private Data data;
    private Controleur controleur;

    public App(){

        this.vue = new Vue();
        this.data = Serialisation.deserialiserData();
        this.connexion = new ConnexionControleur(this.vue,this.data);

        this.user = this.connexion.connect();
        this.controleur = new Controleur(this.user, this.vue, this.data);
        this.controleur.menu();
        
        Serialisation.serialiserData(this.data);
        this.vue.closeScan();

    }

}