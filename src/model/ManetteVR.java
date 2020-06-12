package model;

import java.sql.Date;
import java.util.Objects;

public class ManetteVR extends Materiel{

    private String connectique;

    public ManetteVR(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat, int prixAchat,String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat);
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
        if (!(o instanceof ManetteVR)) {
            return false;
        }
        ManetteVR manetteVR = (ManetteVR) o;
        return Objects.equals(connectique, manetteVR.connectique);
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
            " connectique='" + getConnectique() + "'" +
            "}";
    }



}