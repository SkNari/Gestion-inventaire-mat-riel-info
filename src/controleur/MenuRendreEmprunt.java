package controleur;

import model.Data;
import model.Emprunt;
import model.Materiel;
import vue.Vue;

public class MenuRendreEmprunt {

    private Data data;
    private Vue vue;

    public MenuRendreEmprunt(Data data, Vue vue) {
        this.data = data;
        this.vue = vue;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Vue getVue() {
        return this.vue;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }


    public boolean menu(){

        vue.afficherTousEmprunts(data.getEmprunts());
        int idE = this.demanderIdEmprunt();
        int idS = this.demanderIdStockage();

        Emprunt emprunt = data.getEmprunts().get(idE);
        Materiel materiel = emprunt.getMateriel();
        
        data.getEmprunts().remove(idE);
        data.ajouterMaterielDansStockage(idS, materiel);

        return true;

    }

    public int demanderIdEmprunt(){

        this.vue.afficherTousEmprunts(data.getEmprunts());
        int choix = this.vue.demanderId("Emprunt");
        return data.getEmprunts().containsKey(choix)?choix:demanderIdEmprunt();


    }

    public int demanderIdStockage(){

        this.vue.afficherTousStockages(data.getStockages());
        int choix = this.vue.demanderId("Stockage");
        return data.getStockages().containsKey(choix)?choix:demanderIdStockage();


    }

}