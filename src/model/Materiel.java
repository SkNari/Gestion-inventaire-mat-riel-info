package model;

import java.sql.Date;
import java.util.Objects;

public class Materiel{

    private int id;
    private String nom;
    private String marque;
    private String proprietaire;
    private Date dateAchat;
    private int prixAchat;

    public Materiel(int id, String nom, String marque, String proprietaire, Date dateAchat, int prixAchat) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.proprietaire = proprietaire;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
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

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getProprietaire() {
        return this.proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Date getDateAchat() {
        return this.dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getPrixAchat() {
        return this.prixAchat;
    }

    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Materiel id(int id) {
        this.id = id;
        return this;
    }

    public Materiel nom(String nom) {
        this.nom = nom;
        return this;
    }

    public Materiel marque(String marque) {
        this.marque = marque;
        return this;
    }

    public Materiel proprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
        return this;
    }

    public Materiel dateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
        return this;
    }

    public Materiel prixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Materiel)) {
            return false;
        }
        Materiel materiel = (Materiel) o;
        return id == materiel.id && Objects.equals(nom, materiel.nom) && Objects.equals(marque, materiel.marque) && Objects.equals(proprietaire, materiel.proprietaire) && Objects.equals(dateAchat, materiel.dateAchat) && prixAchat == materiel.prixAchat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, marque, proprietaire, dateAchat, prixAchat);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", marque='" + getMarque() + "'" +
            ", proprietaire='" + getProprietaire() + "'" +
            ", dateAchat='" + getDateAchat() + "'" +
            ", prixAchat='" + getPrixAchat() + "'" +
            "}";
    }

    

}


