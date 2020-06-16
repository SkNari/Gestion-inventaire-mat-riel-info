package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class Data implements Serializable{
    private static final long serialVersionUID = 1L;
    private HashMap<Integer, Stockage> stockages;
    private HashMap<Integer, Materiel> materiels;
    private HashMap<Integer, Emprunteur> emprunteurs;
    private ArrayList<Emprunt> emprunts;

    public Data(){

        this.stockages = new HashMap<Integer, Stockage>();
        this.materiels = new HashMap<Integer, Materiel>();;
        this.emprunteurs = new HashMap<Integer, Emprunteur>();
        this.emprunts = new ArrayList<Emprunt>();

        //Serialisation.serialiserMateriel(new Materiel(0, "toto", "titi", "tutu",new Date(1999, 11, 24), 50, "zou"));
        Materiel materiel = Serialisation.deserialiserMateriel();
        System.out.println(materiel.toString());

    }

    public Data(HashMap<Integer,Stockage> stockages, HashMap<Integer,Materiel> materiels, HashMap<Integer,Emprunteur> emprunteurs, ArrayList<Emprunt> emprunts) {
        this.stockages = stockages;
        this.materiels = materiels;
        this.emprunteurs = emprunteurs;
        this.emprunts = emprunts;
    }

    public HashMap<Integer,Stockage> getStockages() {
        return this.stockages;
    }

    public void setStockages(HashMap<Integer,Stockage> stockages) {
        this.stockages = stockages;
    }

    public HashMap<Integer,Materiel> getMateriels() {
        return this.materiels;
    }

    public void setMateriels(HashMap<Integer,Materiel> materiels) {
        this.materiels = materiels;
    }

    public HashMap<Integer,Emprunteur> getEmprunteurs() {
        return this.emprunteurs;
    }

    public void setEmprunteurs(HashMap<Integer,Emprunteur> emprunteurs) {
        this.emprunteurs = emprunteurs;
    }

    public ArrayList<Emprunt> getEmprunts() {
        return this.emprunts;
    }

    public void setEmprunts(ArrayList<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Data)) {
            return false;
        }
        Data data = (Data) o;
        return Objects.equals(stockages, data.stockages) && Objects.equals(materiels, data.materiels) && Objects.equals(emprunteurs, data.emprunteurs) && Objects.equals(emprunts, data.emprunts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockages, materiels, emprunteurs, emprunts);
    }

    @Override
    public String toString() {
        return "{" +
            " stockages='" + getStockages() + "'" +
            ", materiels='" + getMateriels() + "'" +
            ", emprunteurs='" + getEmprunteurs() + "'" +
            ", emprunts='" + getEmprunts() + "'" +
            "}";
    }
}