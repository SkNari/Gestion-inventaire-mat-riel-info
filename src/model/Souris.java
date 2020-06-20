package model;

import java.util.Date;
import java.util.Objects;

public class Souris extends Materiel{
    private String connectique;

    public Souris(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat,  String prixAchat, String etat, String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.connectique = connectique;
        this.type = "Souris";
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
        return super.toString() +
            "  Connectique : " + this.getConnectique() + "\n" +
            "╚═══════════════════════════════════════════╝\n";
    }

    public void copy(Souris ma){

        this.setNom(ma.getNom());
        this.setMarque(ma.getMarque());
        this.setProprietaire(ma.getProprietaire());
        this.setDateAchat(ma.getDateAchat());
        this.setPrixAchat(ma.getPrixAchat());
        this.setEtat(ma.getEtat());

        this.connectique = ma.getConnectique();

    }

}