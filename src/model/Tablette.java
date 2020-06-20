package model;

import java.util.Date;
import java.util.Objects;

public class Tablette extends Materiel{

    private String os;
    private String taille;
    private String resolution;

    public Tablette(int id, String nom, String marque, String proprietaire, Date dateAchat, String prixAchat, String etat, String os, String taille, String resolution) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.os = os;
        this.taille = taille;
        this.resolution = resolution;
        this.type = "Tablette";
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getTaille() {
        return this.taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String resolution) {
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
        return super.toString() +
            "  OS : " + this.getOs() + "\n" +

            "  Taille : " + this.getTaille() + "\n" +

            "  Resolution : " + this.getResolution() + "\n"+
            "╚═══════════════════════════════════════════╝\n";
    }

    public void copy(Tablette ma){

        this.setNom(ma.getNom());
        this.setMarque(ma.getMarque());
        this.setProprietaire(ma.getProprietaire());
        this.setDateAchat(ma.getDateAchat());
        this.setPrixAchat(ma.getPrixAchat());
        this.setEtat(ma.getEtat());

        this.os = ma.getOs();
        this.taille = ma.getTaille();
        this.resolution = ma.getResolution();

    }

}