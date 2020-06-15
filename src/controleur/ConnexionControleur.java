package controleur;

import model.Emprunteur;
import vue.Vue;
import java.util.Objects;

public class ConnexionControleur {

    private Vue vue;

    public ConnexionControleur(Vue vue) {
        this.vue = vue;
    }

    public Vue getVue() {
        return this.vue;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public Emprunteur connect(){

        String[] user = vue.askName().split(",");
        Emprunteur res = new Emprunteur(0,"Ensiie",user[0],user[1],"toto","0645784512","toto@toto");
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConnexionControleur)) {
            return false;
        }
        ConnexionControleur connexionControleur = (ConnexionControleur) o;
        return Objects.equals(vue, connexionControleur.vue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vue);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            "}";
    }
    

}