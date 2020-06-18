package model;

import java.util.Date;
import java.util.Objects;

public class Telephone extends Materiel{

    private String os;
    private int taille;
    private int resolution;


    public Telephone(int id, String nom, String marque, String proprietaire, Date dateAchat, int prixAchat, String etat, String os, int taille, int resolution) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.os = os;
        this.taille = taille;
        this.resolution = resolution;
        this.type = "Telephone";
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getResolution() {
        return this.resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Telephone)) {
            return false;
        }
        Telephone telephone = (Telephone) o;
        return Objects.equals(os, telephone.os) && taille == telephone.taille && resolution == telephone.resolution;
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, taille, resolution);
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
            ", etat='" + getEtat() + "'" +
            " os='" + getOs() + "'" +
            ", taille='" + getTaille() + "'" +
            ", resolution='" + getResolution() + "'" +
            "}";
    }



}