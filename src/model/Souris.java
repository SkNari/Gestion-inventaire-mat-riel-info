package model;

import java.sql.Date;
import java.util.Objects;

public class Souris extends Materiel{
    private String connectique;

    public Souris(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat,  int prixAchat, int resolution, String connectique) {
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
        if (!(o instanceof Souris)) {
            return false;
        }
        Souris souris = (Souris) o;
        return Objects.equals(connectique, souris.connectique);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(connectique);
    }

    @Override
    public String toString() {
        return "{" +
            " connectique='" + getConnectique() + "'" +
            "}";
    }

    
}