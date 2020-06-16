package controleur;

import model.Emprunteur;
import model.Data;
import vue.Vue;
import java.util.Objects;

public class ConnexionControleur {

    private Vue vue;
    private Data data;

    public ConnexionControleur(Vue vue, Data data) {
        this.vue = vue;
        this.data = data;
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

    public Emprunteur connect(){

        int isConnected = 0;
        String[] user = vue.askName().split(",");
        Emprunteur res = this.data.rechercheEmprunteurParNom(user[1], user[0]);

        if(res==null){

            System.out.println("Existe pas ^^");

        }

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