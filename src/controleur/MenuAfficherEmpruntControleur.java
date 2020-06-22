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
public class MenuAfficherEmpruntControleur {
    private Vue vue;
    private Emprunteur user;
    private Data data;

    public MenuAfficherEmpruntControleur(Vue vue, Emprunteur user, Data data) {
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
        if (!(o instanceof MenuAfficherEmpruntControleur)) {
            return false;
        }
        MenuAfficherEmpruntControleur menuAfficherEmpruntControleur = (MenuAfficherEmpruntControleur) o;
        return Objects.equals(vue, menuAfficherEmpruntControleur.vue) && Objects.equals(user, menuAfficherEmpruntControleur.user) && Objects.equals(data, menuAfficherEmpruntControleur.data);
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
        int choix = this.vue.afficherMenuEmprunt();
        this.vue.effacerConsole();

        switch (choix) {
            case 0:
                return false;
            case 1:
                this.vue.afficherTousEmprunts(this.data.getEmprunts());
                this.vue.waitForUser();
                return true;
            case 2:
                this.vue.waitForUser();
                return true;
            case 3:
                this.vue.afficherEmpruntUtilisateur(this.data.getEmprunts(),this.vue.demanderQuelUtilisateur(this.data.getEmprunteurs()));
                this.vue.waitForUser();
                return true;
            case 4:
                this.vue.afficherEmpruntRetard(this.data.getEmprunts());
                this.vue.waitForUser();
                return true;  
            default:
                return this.menu();
        }
    }
    
}