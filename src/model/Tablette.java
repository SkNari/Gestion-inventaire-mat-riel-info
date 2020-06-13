package model;

import java.util.Date;
import java.util.Objects;

public class Tablette extends Materiel{

    private String os;
    private int taille;
    private int resolution;

    public Tablette(int id, String nom, String marque, String proprietaire, Date dateAchat, int prixAchat, String etat, String os, int taille, int resolution) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.os = os;
        this.taille = taille;
        this.resolution = resolution;
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
        if (!(o instanceof Tablette)) {
            return false;
        }
        Tablette tablette = (Tablette) o;
        return Objects.equals(os, tablette.os) && taille == tablette.taille && resolution == tablette.resolution;
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, taille, resolution);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + this.getId() + "'" +
            ", nom='" + this.getNom() + "'" +
            ", marque='" + this.getMarque() + "'" +
            ", proprietaire='" + this.getProprietaire() + "'" +
            ", dateAchat='" + this.getDateAchat() + "'" +
            ", prixAchat='" + this.getPrixAchat() + "'" +
            ", etat='" + getEtat() + "'" +
            " os='" + this.getOs() + "'" +
            ", taille='" + this.getTaille() + "'" +
            ", resolution='" + this.getResolution() + "'" +
            "}";
    }
}