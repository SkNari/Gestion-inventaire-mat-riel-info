package app;

import controleur.ConnexionControleur;
import controleur.MenuControleur;
import model.Emprunteur;
import model.Serialisation;
import vue.Vue;
import model.Data;

public class App {
    private ConnexionControleur connexion;
    private Emprunteur user;
    private Vue vue;
    private Data data;
    private MenuControleur menuControleur;

    public App(){

        this.vue = new Vue();
        this.data = Serialisation.deserialiserData();

        this.vue.effacerConsole();
        this.connexion = new ConnexionControleur(this.vue,this.data);

        this.user = this.connexion.connect();
        this.menuControleur = new MenuControleur(this.vue, this.data,this.user);

        boolean running = true;


        while(running){

            running = this.menuControleur.menu();
            this.vue.effacerConsole();

        }
        
        Serialisation.serialiserData(this.data);
        this.vue.closeScan();
        this.vue.auRevoir(this.user);

    }

}