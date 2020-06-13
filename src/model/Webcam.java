package model;

import java.util.Date;
import java.util.Objects;

public class Webcam extends Materiel {
    private int resolution;
    private String connectique;

    public Webcam(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat,  int prixAchat, String etat, int resolution,  String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.resolution = resolution;
        this.connectique = connectique;
    }

    public int getResolution() {
        return this.resolution;
    }

    public void setResolution( int resolution) {
        this.resolution = resolution;
    }

    public String getConnectique() {
        return this.connectique;
    }

    public void setConnectique( String connectique) {
        this.connectique = connectique;
    }

    @Override
    public boolean equals( Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Webcam)) {
            return false;
        }
         Webcam webcam = (Webcam) o;
        return resolution == webcam.resolution && Objects.equals(connectique, webcam.connectique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resolution, connectique);
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
            " resolution='" + this.getResolution() + "'" +
            " connectique='" + getConnectique() + "'" +
            "}";
    }
    
}