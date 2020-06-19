package controleur;

import java.util.HashMap;
import java.util.Objects;

import model.Data;
import model.Emprunteur;
import model.Stockage;
import vue.Vue;

/**
 * MenuAfficherStockageControleur
 */
public class MenuAfficherStockageControleur {
    private Vue vue;
    private Emprunteur user;
    private HashMap<Integer, Stockage> stockages;

    public MenuAfficherStockageControleur(Vue vue, Emprunteur user, HashMap<Integer,Stockage> stockages) {
        this.vue = vue;
        this.user = user;
        this.stockages = stockages;
    }

    public Vue getVue() {
        return this.vue;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public Emprunteur getUser() {
        return this.user;
    }

    public void setUser(Emprunteur user) {
        this.user = user;
    }

    public HashMap<Integer,Stockage> getStockages() {
        return this.stockages;
    }

    public void setStockages(HashMap<Integer,Stockage> stockages) {
        this.stockages = stockages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuAfficherStockageControleur)) {
            return false;
        }
        MenuAfficherStockageControleur menuAfficherStockageControleur = (MenuAfficherStockageControleur) o;
        return Objects.equals(vue, menuAfficherStockageControleur.vue) && Objects.equals(user, menuAfficherStockageControleur.user) && Objects.equals(stockages, menuAfficherStockageControleur.stockages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, user, stockages);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", user='" + getUser() + "'" +
            ", stockages='" + getStockages() + "'" +
            "}";
    }

    public boolean menu()
    {   
        int choix = this.vue.afficherMenuStockage();
        this.vue.effacerConsole();

        switch (choix) {
            case 0:
                return false;
            case 1:
                this.vue.afficherTousStockages(this.stockages);
                this.vue.waitForUser();
                return true; 
            default:
                return this.menu();
        }
    }
    
}