package controleur;

import model.Emprunteur;
import model.Data;
import vue.Vue;
import java.util.Objects;

public class MenuControleur {

    private Vue vue;
    private Data data;
    private Emprunteur user;
    private MenuMaterielControleur menuMateriel;


    public MenuControleur(Vue vue, Data data, Emprunteur user) {
        this.vue = vue;
        this.data = data;
        this.user = user;
        this.menuMateriel = new MenuMaterielControleur(vue,data,user);
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

    public MenuMaterielControleur getMenuMateriel() {
        return this.menuMateriel;
    }

    public void setMenuMateriel(MenuMaterielControleur menuMateriel) {
        this.menuMateriel = menuMateriel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuControleur)) {
            return false;
        }
        MenuControleur menuControleur = (MenuControleur) o;
        return Objects.equals(vue, menuControleur.vue) && Objects.equals(data, menuControleur.data) && Objects.equals(user, menuControleur.user) && Objects.equals(menuMateriel, menuControleur.menuMateriel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, data, user, menuMateriel);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", data='" + getData() + "'" +
            ", user='" + getUser() + "'" +
            ", menuMateriel='" + getMenuMateriel() + "'" +
            "}";
    }

    
    public boolean menu()
    {
        int choix = this.vue.afficherMenu();

        switch (choix) {
            case 0:
                return false;
            case 1:
                this.vue.effacerConsole();
                menuMateriel.menu();
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            default:    
                this.vue.effacerConsole();
                return this.menu();
        }
    }

   

}