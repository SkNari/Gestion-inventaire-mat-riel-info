package controleur;

import java.util.Objects;

import model.Data;
import model.Emprunteur;
import vue.Vue;

/**
 * MenuMaterielControleur
 */
public class MenuAjouterModifierControleur {
    
    private Vue vue;
    private Data data;
    private Emprunteur user;

    public MenuAjouterModifierControleur(Vue vue, Data data, Emprunteur user) {
        this.vue = vue;
        this.data = data;
        this.user = user;
    }

    public Vue getVue() {
        return this.vue;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Emprunteur getUser() {
        return this.user;
    }

    public void setUser(Emprunteur user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuAjouterModifierControleur)) {
            return false;
        }
        MenuAjouterModifierControleur menuAjouterModifierControleur = (MenuAjouterModifierControleur) o;
        return Objects.equals(vue, menuAjouterModifierControleur.vue) && Objects.equals(data, menuAjouterModifierControleur.data) && Objects.equals(user, menuAjouterModifierControleur.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, data, user);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", data='" + getData() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

    public boolean menu()
    {   
        boolean rep;
        int choix = this.vue.afficherMenuAjouterModifier();
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                rep = this.menuAjouterModifierMateriel();
                return rep?true:this.menu();
            case 2:
                rep = this.menuAjouterModifierStockage();
                return rep?true:this.menu();
            case 3:
                rep = this.menuAjouterModifierEmprunt();
                return rep?true:this.menu();
            case 4:
                rep = this.menuAjouterModifierEmprunteur();
                return rep?true:this.menu();    
            default:
                return this.menu();
        }
    }

    public boolean menuAjouterModifierMateriel(){

        int choix = this.vue.afficherMenuAjMod("Materiel");
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menu();
        }

    }

    public boolean menuAjouterModifierStockage(){

        int choix = this.vue.afficherMenuAjMod("Stockage");
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menu();
        }

    }

    public boolean menuAjouterModifierEmprunt(){

        int choix = this.vue.afficherMenuAjMod("Emprunt");
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menu();
        }

    }

    public boolean menuAjouterModifierEmprunteur(){

        int choix = this.vue.afficherMenuAjMod("Materiel");
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menu();
        }

    }
}