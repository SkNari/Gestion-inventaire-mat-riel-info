package controleur;

import java.util.HashMap;
import java.util.Objects;

import model.Data;
import model.Emprunteur;
import model.Materiel;
import vue.Vue;

/**
 * MenuAfficherMaterielControleur
 */
public class MenuAfficherMaterielControleur {
    private Vue vue;
    private Emprunteur user;
    private HashMap<Integer, Materiel> materiels;

    public MenuAfficherMaterielControleur(Vue vue, Emprunteur user, HashMap<Integer, Materiel> materiels) {
        this.vue = vue;
        this.user = user;
        this.materiels = materiels;
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

    public HashMap<Integer, Materiel> getMateriels() {
        return this.materiels;
    }

    public void setMateriels(HashMap<Integer, Materiel> materiels) {
        this.materiels = materiels;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuAfficherMaterielControleur)) {
            return false;
        }
        MenuAfficherMaterielControleur menuAfficherMaterielControleur = (MenuAfficherMaterielControleur) o;
        return Objects.equals(vue, menuAfficherMaterielControleur.vue) && Objects.equals(user, menuAfficherMaterielControleur.user) && Objects.equals(materiels, menuAfficherMaterielControleur.materiels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, user, materiels);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", user='" + getUser() + "'" +
            ", data='" + getMateriels() + "'" +
            "}";
    }

    public boolean menu()
    {   
        boolean rep;
        int choix = this.vue.afficherMenuMateriel();
        this.vue.effacerConsole();

        switch (choix) {
            case 0:
                return false;
            case 1:
                this.vue.afficherTousMateriels(this.materiels);
                return true;
            case 2:
                this.vue.afficherMaterielDisponible(this.materiels);
                return true;
            case 3:

                return true;
            case 4:

                return true;  
            default:
                return this.menu();
        }
    }
    
}