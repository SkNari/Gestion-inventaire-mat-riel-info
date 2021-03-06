package model;

import java.util.Date;
import java.util.Objects;

public class CasqueVR extends Materiel{

    private String connectique;
    private String resolution;

    public CasqueVR(){
        super();
        this.type = "CasqueVR";
    }

    public CasqueVR(int id, String nom, String marque, String proprietaire, Date dateAchat, String prixAchat,String etat,String connectique, String resolution) {
        super(id, nom, marque, proprietaire, dateAchat, prixAchat, etat);
        this.connectique = connectique;
        this.resolution = resolution;
        this.type = "CasqueVR";
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
        return super.toString() +
            "  Connectique : " + this.getConnectique() + "\n"
            + "  Resolution : " + this.getResolution() + "\n"+
            "╚═══════════════════════════════════════════╝\n";
    }

    public void copy(CasqueVR ma){

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