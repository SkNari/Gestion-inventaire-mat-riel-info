package model;

import java.sql.Date;
import java.util.Objects;

public class Emprunt <T>{

    private Date dateEmprunt;
    private Date dateRendu;
    private T materiel;
    private Emprunteur emprunteur;

    public Emprunt(Date dateEmprunt, Date dateRendu, T materiel, Emprunteur emprunteur) {
        this.dateEmprunt = dateEmprunt;
        this.dateRendu = dateRendu;
        this.materiel = materiel;
        this.emprunteur = emprunteur;
    }

    public Date getDateEmprunt() {
        return this.dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRendu() {
        return this.dateRendu;
    }

    public void setDateRendu(Date dateRendu) {
        this.dateRendu = dateRendu;
    }

    public T getMateriel() {
        return this.materiel;
    }

    public void setMateriel(T materiel) {
        this.materiel = materiel;
    }

    public Emprunteur getEmprunteur() {
        return this.emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Emprunt)) {
            return false;
        }
        Emprunt emprunt = (Emprunt) o;
        return Objects.equals(dateEmprunt, emprunt.dateEmprunt) && Objects.equals(dateRendu, emprunt.dateRendu) && Objects.equals(materiel, emprunt.materiel) && Objects.equals(emprunteur, emprunt.emprunteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateEmprunt, dateRendu, materiel, emprunteur);
    }

    @Override
    public String toString() {
        return "{" +
            " dateEmprunt='" + getDateEmprunt() + "'" +
            ", dateRendu='" + getDateRendu() + "'" +
            ", materiel='" + getMateriel() + "'" +
            ", emprunteur='" + getEmprunteur() + "'" +
            "}";
    }




}