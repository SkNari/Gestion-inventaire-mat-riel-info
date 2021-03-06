package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Emprunt implements Serializable{

    private Date dateEmprunt;
    private Date dateRendu;
    private Materiel materiel;
    private Emprunteur emprunteur;
    private int id;

    private static final long serialVersionUID = 5L;

    public Emprunt(Date dateEmprunt, Date dateRendu, Materiel materiel, Emprunteur emprunteur) {
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

    public Materiel getMateriel() {
        return this.materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Emprunteur getEmprunteur() {
        return this.emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
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
        return
            "\n| Id : " + this.getId() + "\n" +
            "| Emprunteur : " + this.getEmprunteur().getPrenom() + " " + this.getEmprunteur().getNom() + "\n" +
            "| Date d'emprunt : " + this.getDateEmprunt() + "\n" +
            "| Date de rendu : " + this.getDateRendu() + "\n" +
            "| Materiel emprunte : \n" + getMateriel() + "\n";
    }

    public void copy(Emprunt emprunt){

        this.dateEmprunt = emprunt.getDateEmprunt();
        this.dateRendu = emprunt.getDateRendu();
        this.materiel = emprunt.getMateriel();
        this.emprunteur = emprunt.getEmprunteur();

    }


}