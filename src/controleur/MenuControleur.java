package controleur;

import model.Emprunteur;
import model.Data;
import vue.Vue;
import java.util.Objects;

public class MenuControleur {

    private Vue vue;
    private Data data;
    private Emprunteur user;
    private MenuAjouterModifierControleur menuAjoutModif;


    public MenuControleur(Vue vue, Data data, Emprunteur user) {
        this.vue = vue;
        this.data = data;
        this.user = user;
        this.menuAjoutModif = new MenuAjouterModifierControleur(vue,data,user);
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

    public MenuAjouterModifierControleur getMenuAjoutModif() {
        return this.menuAjoutModif;
    }

    public void setMenuAjoutModif(MenuAjouterModifierControleur menuAjoutModif) {
        this.menuAjoutModif = menuAjoutModif;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuControleur)) {
            return false;
        }
        MenuControleur menuControleur = (MenuControleur) o;
        return Objects.equals(vue, menuControleur.vue) && Objects.equals(data, menuControleur.data) && Objects.equals(user, menuControleur.user) && Objects.equals(menuAjoutModif, menuControleur.menuAjoutModif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, data, user, menuAjoutModif);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", data='" + getData() + "'" +
            ", user='" + getUser() + "'" +
            ", menuMateriel='" + getMenuAjoutModif() + "'" +
            "}";
    }

    
    public boolean menu()
    {   
        int choix = this.vue.afficherMenu();
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                boolean rep = this.menuAjoutModif.menu();
                return rep?true:this.menu();
            case 5:
                return true;
            default:    
                return this.menu();
        }
    }

   

}