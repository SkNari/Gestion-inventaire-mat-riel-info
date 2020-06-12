package model;

import java.sql.Date;

public class Materiel{

    private int id;
    private String nom;
    private String marque;
    private String proprietaire;
    private Date dateAchat;
    private int prixAchat;

    public Materiel(int id, String nom, String marque, String proprietaire, Date dateAchat, int prixAchat){

        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.proprietaire = proprietaire;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;

    }

}


