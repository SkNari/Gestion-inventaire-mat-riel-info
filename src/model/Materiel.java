package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Materiel implements Serializable{

    private static final long serialVersionUID = 2L;

    private int id;
    private String nom;
    private String marque;
    private String proprietaire;
    private Date dateAchat;
    private String prixAchat;
    private String etat;
    private boolean estEmprunte;
    protected String type;
    protected int idStockage;

    public Materiel(){
        
    }

    public Materiel(int id, String nom, String marque, String proprietaire, Date dateAchat, String prixAchat, String etat) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.proprietaire = proprietaire;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.etat = etat;
        this.idStockage = -1;
        this.estEmprunte = false;
    }

    public String getType()
    {
        return this.type;
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

    public String getMarque() {
        return this.marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getProprietaire() {
        return this.proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Date getDateAchat() {
        return this.dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getPrixAchat() {
        return this.prixAchat;
    }

    public void setPrixAchat(String prixAchat) {
        this.prixAchat = prixAchat;
    }

    public String getEtat() {
        return this.etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdStockage() {
        return this.idStockage;
    }

    public void setIdStockage(int idStockage) {
        this.idStockage = idStockage;
    }

    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }

    public boolean getEstEmprunte(){
        return this.estEmprunte;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Materiel)) {
            return false;
        }
        Materiel materiel = (Materiel) o;
        return id == materiel.id && Objects.equals(nom, materiel.nom) && Objects.equals(marque, materiel.marque) && Objects.equals(proprietaire, materiel.proprietaire) && Objects.equals(dateAchat, materiel.dateAchat) && prixAchat == materiel.prixAchat && Objects.equals(etat, materiel.etat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
    }

    @Override
    public String toString() {
        return
            "\n" + 
            "╔═══════════════════════════════════════════╗\n" +
            "  ID : " + getId() + "\n" +
            "  Type : " + getType() + "\n" + 
            "  Nom : " + getNom() + "\n" +
            "  Marque : " + getMarque() + "\n" +
            "  Proprietaire : " + getProprietaire() + "\n" +
            "  Date d'achat : " + getDateAchat() + "\n" +
            "  Prix d'achat : " + getPrixAchat() + "\n" +
            "  Etat : " + getEtat() + "\n";
    }

    public void copy(Materiel ma){

        this.nom = ma.getNom();
        this.marque = ma.getMarque();
        this.proprietaire = ma.getProprietaire();
        this.dateAchat = ma.getDateAchat();
        this.prixAchat = ma.getPrixAchat();
        this.etat = ma.getEtat();

    }

}


