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
    private MenuAfficherMaterielControleur menuAffichMater;
    private MenuAfficherStockageControleur menuAffichStock;
    private MenuAfficherEmpruntControleur menuAffichEmprunt;
    private MenuRendreEmpruntControleur menuRendreEmprunt;

    public MenuControleur(Vue vue, Data data, Emprunteur user) {
        this.vue = vue;
        this.data = data;
        this.user = user;
        this.menuAjoutModif = new MenuAjouterModifierControleur(vue, data, user);
        this.menuAffichMater = new MenuAfficherMaterielControleur(vue, user, data);
        this.menuAffichStock = new MenuAfficherStockageControleur(vue, user, data.getStockages());
        this.menuAffichEmprunt = new MenuAfficherEmpruntControleur(vue, user, data);
        this.menuRendreEmprunt = new MenuRendreEmpruntControleur(data, vue);
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

    public MenuAfficherMaterielControleur getMenuAffichMater() {
        return this.menuAffichMater;
    }

    public void setMenuAffichMater(MenuAfficherMaterielControleur menuAffichMater) {
        this.menuAffichMater = menuAffichMater;
    }

    public MenuAfficherStockageControleur getMenuAffichStock() {
        return this.menuAffichStock;
    }

    public void setMenuAffichStock(MenuAfficherStockageControleur menuAffichStock) {
        this.menuAffichStock = menuAffichStock;
    }

    public void setMenuRendreEmprunt(MenuRendreEmpruntControleur menuRendreEmprunt) {
        this.menuRendreEmprunt = menuRendreEmprunt;
    }

    public MenuRendreEmpruntControleur getMenuRendreEmprunt(){
        return this.menuRendreEmprunt;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuControleur)) {
            return false;
        }
        MenuControleur menuControleur = (MenuControleur) o;
        return Objects.equals(vue, menuControleur.vue) && Objects.equals(data, menuControleur.data) && Objects.equals(user, menuControleur.user) && Objects.equals(menuAjoutModif, menuControleur.menuAjoutModif) && Objects.equals(menuAffichMater, menuControleur.menuAffichMater) && Objects.equals(menuAffichStock, menuControleur.menuAffichStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, data, user, menuAjoutModif, menuAffichMater, menuAffichStock);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", data='" + getData() + "'" +
            ", user='" + getUser() + "'" +
            ", menuAjoutModif='" + getMenuAjoutModif() + "'" +
            ", menuAffichMater='" + getMenuAffichMater() + "'" +
            ", menuAffichStock='" + getMenuAffichStock() + "'" +
            "}";
    }

    
    
    public boolean menu()
    {   
        int choix = this.vue.afficherMenu();
        boolean rep;
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                rep = this.menuAffichMater.menu();
                return rep?true:this.menu();
            case 2:
                rep = this.menuAffichEmprunt.menu();
                return rep?true:this.menu();
            case 3:
                rep = this.menuAffichStock.menu();
                return rep?true:this.menu();
            case 4:
                rep = this.menuAjoutModif.menu();
                return rep?true:this.menu();
            case 5:
                rep = this.menuRendreEmprunt.menu();
                return rep?true:this.menu();
            default:    
                return this.menu();
        }
    }

   

}