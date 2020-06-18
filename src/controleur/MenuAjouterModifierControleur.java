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

    //Materiel
    public boolean menuAjouterModifierMateriel(){
        
        boolean rep;
        int choix = this.vue.afficherMenuAjMod("Materiel  ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                rep = this.menuAjouterMateriel();
                return rep?true:this.menuAjouterModifierMateriel();
            case 2:
                return true;
            default:
                return this.menuAjouterModifierMateriel();
        }

    }

    public boolean menuAjouterMateriel(){

        int choix = this.vue.afficherMenuAjouterMateriel();
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return true;
            case 8:
                return true;
            case 9:
                return false;
            default:
                return this.menuAjouterMateriel();
        }

    }

    //Stockage
    public boolean menuAjouterModifierStockage(){

        int choix = this.vue.afficherMenuAjMod("Stockage  ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menuAjouterModifierStockage();
        }

    }

    //Emprunt
    public boolean menuAjouterModifierEmprunt(){

        int choix = this.vue.afficherMenuAjMod("Emprunt   ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menuAjouterModifierEmprunt();
        }

    }

    //Emprunteur
    public boolean menuAjouterModifierEmprunteur(){

        int choix = this.vue.afficherMenuAjMod("Emprunteur");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menuAjouterModifierEmprunteur();
        }

    }
}