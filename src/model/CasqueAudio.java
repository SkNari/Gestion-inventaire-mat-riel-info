package model;

import java.util.Date;
import java.util.Objects;

public class CasqueAudio extends Materiel{

    private String connectique;

    public CasqueAudio(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat, int prixAchat, String etat,String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.connectique = connectique;
        this.type = "CasqueAudio";
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
        if (!(o instanceof CasqueAudio)) {
            return false;
        }
        CasqueAudio casqueAudio = (CasqueAudio) o;
        return Objects.equals(connectique, casqueAudio.connectique);
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
            " connectique='" + getConnectique() + "'" +
            "}";
    }



}