package model;

import java.util.HashMap;
import java.util.Objects;

public class Stockage {
    private int id;
    private String nom;
    private String proprietaire;
    private HashMap<Integer, Materiel> materiels = new HashMap<Integer, Materiel>();

    public Stockage(int id, String nom, String proprietaire, Materiel materiel) {
        this.id = id;
        this.nom = nom;
        this.proprietaire = proprietaire;
        this.materiels.put(materiel.getId(), materiel);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProprietaire() {
        return this.proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public HashMap<Integer,Materiel> getMateriels() {
        return this.materiels;
    }

    public void setMateriels(HashMap<Integer,Materiel> materiels) {
        this.materiels = materiels;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Stockage)) {
            return false;
        }
        Stockage stockage = (Stockage) o;
        return id == stockage.id && Objects.equals(nom, stockage.nom) && Objects.equals(proprietaire, stockage.proprietaire) && Objects.equals(materiels, stockage.materiels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, proprietaire, materiels);
    }

    @Override
    public String toString() {
        return
            "\n-" + 
            "  ID : " + getId() + "|" +
            "  Nom : " + getNom() + "|" +
            "  Proprietaire : " + getProprietaire();
    }

    public void ajouterMateriel(Materiel materiel)
    {
        this.materiels.put(materiel.getId(),materiel);
    }

    public void supprimerMateriel(Materiel materiel)
    {
        this.materiels.remove(materiel.getId());
    }
    
}