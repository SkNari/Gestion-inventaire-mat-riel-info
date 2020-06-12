package model;

import java.sql.Date;
import java.util.Objects;

public class ManetteJeu extends Materiel{
    private String connectique;


    public ManetteJeu(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat,  int prixAchat, String etat, int resolution, String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat,etat);
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
        if (!(o instanceof ManetteJeu)) {
            return false;
        }
        ManetteJeu manetteJeu = (ManetteJeu) o;
        return Objects.equals(connectique, manetteJeu.connectique);
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