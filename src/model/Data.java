package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class Data implements Serializable{
    private static final long serialVersionUID = 1L;
    private HashMap<Integer, Stockage> stockages;
    private HashMap<Integer, Materiel> materiels;
    private HashMap<Integer, Emprunteur> emprunteurs;
    private HashMap<Integer, Emprunt> emprunts;

    public Data(){

        this.stockages = new HashMap<Integer, Stockage>();
        this.materiels = new HashMap<Integer, Materiel>();;
        this.emprunteurs = new HashMap<Integer, Emprunteur>();
        this.emprunts = new HashMap<Integer, Emprunt>();

    }

    public Data(HashMap<Integer,Stockage> stockages, HashMap<Integer,Materiel> materiels, HashMap<Integer,Emprunteur> emprunteurs, HashMap<Integer, Emprunt> emprunts) {
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

    public HashMap<Integer, Emprunt> getEmprunts() {
        return this.emprunts;
    }

    public void setEmprunts(HashMap<Integer, Emprunt> emprunts) {
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

    //fonctions de recherche

    public Emprunteur rechercheEmprunteurParNom(String nom, String prenom){

        Collection<Emprunteur> collection = this.emprunteurs.values();

        for (Emprunteur s : collection) {
            if(s.getNom().toLowerCase().equals(nom.toLowerCase())&&s.getPrenom().toLowerCase().equals(prenom.toLowerCase()))
                return s;
        }
        return null;

    }

    //fonction d'ajout

    public void ajouterEmprunteur(Emprunteur emp){

        int maxid;

        if(this.emprunteurs.isEmpty()){
            maxid = 0;
        }else{
            maxid = Collections.max(this.emprunteurs.keySet());
        }
        emp.setId(maxid);
        this.emprunteurs.put(maxid, emp);
    }

    public void ajouterEmprunt(Emprunt emprunt, Emprunteur user){

        int maxid = Collections.max(this.emprunts.keySet());

        emprunt.setMateriel(this.materiels.get(emprunt.getMateriel().getId()));
        emprunt.setEmprunteur(user);
        this.emprunts.put(maxid, emprunt);
    }

    public void ajouterMateriel(Materiel materiel){

        int maxid = this.materiels.isEmpty()? 0 : Collections.max(this.materiels.keySet())+1;
        materiel.setId(maxid);
        this.materiels.put(maxid, materiel);
    }

    public void ajouterStockage(Stockage stockage){

        int maxid = Collections.max(this.stockages.keySet());
        stockage.setId(maxid);
        this.stockages.put(maxid, stockage);
    }

}