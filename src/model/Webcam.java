package model;

import java.util.Date;
import java.util.Objects;

public class Webcam extends Materiel {
    private String resolution;
    private String connectique;

    public Webcam(){
        super();
        this.type = "Webcam";
    }

    public Webcam(int id,  String nom,  String marque,  String proprietaire,  Date dateAchat,  String prixAchat, String etat, String resolution,  String connectique) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.resolution = resolution;
        this.connectique = connectique;
        this.type = "Webcam";
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution( String resolution) {
        this.resolution = resolution;
    }

    public String getConnectique() {
        return this.connectique;
    }

    public void setConnectique( String connectique) {
        this.connectique = connectique;
    }

    @Override
    public boolean equals( Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Webcam)) {
            return false;
        }
         Webcam webcam = (Webcam) o;
        return resolution == webcam.resolution && Objects.equals(connectique, webcam.connectique);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resolution, connectique);
    }

    @Override
    public String toString() {
        return super.toString() +
            "  Resolution : " + this.getResolution() + "\n" +

            "  Connectique : " + this.getConnectique() + "\n"+
            "╚═══════════════════════════════════════════╝\n";
    }
    
    public void copy(Webcam ma){

        this.setNom(ma.getNom());
        this.setMarque(ma.getMarque());
        this.setProprietaire(ma.getProprietaire());
        this.setDateAchat(ma.getDateAchat());
        this.setPrixAchat(ma.getPrixAchat());
        this.setEtat(ma.getEtat());

        this.connectique = ma.getConnectique();
        this.resolution = ma.getResolution();

    }

}