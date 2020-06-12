package model;

import java.sql.Date;
import java.util.Objects;

public class CasqueVR extends Materiel{

    private String connectique;
    private String resolution;

    public CasqueVR(int id, String nom, String marque, String proprietaire, Date dateAchat, int prixAchat,String connectique, String resolution) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat);
        this.connectique = connectique;
        this.resolution = resolution;
    }

    public String getConnectique() {
        return this.connectique;
    }

    public void setConnectique(String connectique) {
        this.connectique = connectique;
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
        if (!(o instanceof CasqueVR)) {
            return false;
        }
        CasqueVR casqueVR = (CasqueVR) o;
        return Objects.equals(connectique, casqueVR.connectique) && Objects.equals(resolution, casqueVR.resolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectique, resolution);
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
            ", resolution='" + getResolution() + "'" +
            "}";
    }


}