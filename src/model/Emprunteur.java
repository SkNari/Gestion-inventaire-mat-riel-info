package model;

import java.util.Objects;

public class Emprunteur {

    private int id;
    private String institution;
    private String nom;
    private String prenom;
    private String adresse;
    private int numeroDeTelephone;
    private String mail;

    public Emprunteur(int id, String institution, String nom, String prenom, String adresse, int numeroDeTelephone, String mail) {
        this.id = id;
        this.institution = institution;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroDeTelephone = numeroDeTelephone;
        this.mail = mail;
    }

    public String getInstitution() {
        return this.institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumeroDeTelephone() {
        return this.numeroDeTelephone;
    }

    public void setNumeroDeTelephone(int numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Emprunteur)) {
            return false;
        }
        Emprunteur emprunteur = (Emprunteur) o;
        return id == emprunteur.id && Objects.equals(nom, emprunteur.nom) && Objects.equals(prenom, emprunteur.prenom) && Objects.equals(adresse, emprunteur.adresse) && numeroDeTelephone == emprunteur.numeroDeTelephone && Objects.equals(mail, emprunteur.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, adresse, numeroDeTelephone, mail);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + this.getId() + "'" +
            " institution='" + this.getInstitution() + "'" +
            ", nom='" + this.getNom() + "'" +
            ", prenom='" + this.getPrenom() + "'" +
            ", adresse='" + this.getAdresse() + "'" +
            ", numeroDeTelephone='" + this.getNumeroDeTelephone() + "'" +
            ", mail='" + this.getMail() + "'" +
            "}";
    }
}