package model;

import java.util.Date;
import java.util.Objects;

public class CapteursDeProfondeur extends Materiel{
    private String connectique;

    public CapteursDeProfondeur( int id,  String nom,  String marque,  String proprietaire,  Date dateAchat, int prixAchat, String etat, String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.connectique = connectique;
    }

    public String getConnectique() {
        return this.connectique;
    }

    public void setConnectique(String connectique) {
        this.connectique = connectique;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CapteursDeProfondeur)) {
            return false;
        }
        CapteursDeProfondeur capteursDeProfondeur = (CapteursDeProfondeur) o;
        return Objects.equals(connectique, capteursDeProfondeur.connectique);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(connectique);
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
            " connectique='" + this.getConnectique() + "'" +
            "}";
    }
}