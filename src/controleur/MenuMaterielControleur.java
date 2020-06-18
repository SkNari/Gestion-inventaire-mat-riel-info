package controleur;

import java.util.Objects;

import model.Data;
import model.Emprunteur;
import vue.Vue;

/**
 * MenuMaterielControleur
 */
public class MenuMaterielControleur {
    
    private Vue vue;
    private Data data;
    private Emprunteur user;

    public MenuMaterielControleur() {
    }

    public MenuMaterielControleur(Vue vue, Data data, Emprunteur user) {
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
        if (!(o instanceof MenuMaterielControleur)) {
            return false;
        }
        MenuMaterielControleur menuMaterielControleur = (MenuMaterielControleur) o;
        return Objects.equals(vue, menuMaterielControleur.vue) && Objects.equals(data, menuMaterielControleur.data) && Objects.equals(user, menuMaterielControleur.user);
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
        int choix = this.vue.afficherMenuMateriel();
        switch (choix) {
            case 1:

            case 2:

            case 3:

            case 4:
        
            default:
                return this.menu();
        }
    }
}