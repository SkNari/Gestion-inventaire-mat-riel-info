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
    private Data data;

    public MenuAfficherMaterielControleur(Vue vue, Emprunteur user, Data data) {
        this.vue = vue;
        this.user = user;
        this.data = data;
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

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuAfficherMaterielControleur)) {
            return false;
        }
        MenuAfficherMaterielControleur menuAfficherMaterielControleur = (MenuAfficherMaterielControleur) o;
        return Objects.equals(vue, menuAfficherMaterielControleur.vue) && Objects.equals(user, menuAfficherMaterielControleur.user) && Objects.equals(data, menuAfficherMaterielControleur.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, user, data);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", user='" + getUser() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }

    public boolean menu()
    {   
        int choix = this.vue.afficherMenuMateriel();
        this.vue.effacerConsole();

        switch (choix) {
            case 0:
                return false;
            case 1:
                this.vue.afficherTousMateriels(this.data.getMateriels());
                this.vue.waitForUser();
                return true;
            case 2:
                this.vue.afficherMaterielDisponible(this.data.getEmprunts(),this.data.getMateriels());
                this.vue.waitForUser();
                return true;
            case 3:
                this.vue.afficherMaterielEmprunte(this.data.getEmprunts(),this.data.getMateriels());
                this.vue.waitForUser();
                return true;
            case 4:

                return true;  
            default:
                return this.menu();
        }
    }
    
}