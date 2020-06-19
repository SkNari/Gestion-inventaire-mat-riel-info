package controleur;

import java.util.Objects;

import model.CapteursDeProfondeur;
import model.CasqueAudio;
import model.CasqueVR;
import model.Data;
import model.Emprunteur;
import model.ManetteJeu;
import model.ManetteVR;
import model.Materiel;
import model.Souris;
import model.Tablette;
import model.Telephone;
import model.Webcam;
import vue.Vue;

/**
 * MenuMaterielControleur
 */
public class MenuAjouterModifierControleur {
    
    private Vue vue;
    private Data data;
    private Emprunteur user;

    public MenuAjouterModifierControleur(Vue vue, Data data, Emprunteur user) {
        this.vue = vue;
        this.data = data;
        this.user = user;
    }

    public Vue getVue() {
        return this.vue;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Emprunteur getUser() {
        return this.user;
    }

    public void setUser(Emprunteur user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuAjouterModifierControleur)) {
            return false;
        }
        MenuAjouterModifierControleur menuAjouterModifierControleur = (MenuAjouterModifierControleur) o;
        return Objects.equals(vue, menuAjouterModifierControleur.vue) && Objects.equals(data, menuAjouterModifierControleur.data) && Objects.equals(user, menuAjouterModifierControleur.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vue, data, user);
    }

    @Override
    public String toString() {
        return "{" +
            " vue='" + getVue() + "'" +
            ", data='" + getData() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

    public boolean menu()
    {   
        boolean rep;
        int choix = this.vue.afficherMenuAjouterModifier();
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                rep = this.menuAjouterModifierMateriel();
                return rep?true:this.menu();
            case 2:
                rep = this.menuAjouterModifierStockage();
                return rep?true:this.menu();
            case 3:
                rep = this.menuAjouterModifierEmprunt();
                return rep?true:this.menu();
            case 4:
                rep = this.menuAjouterModifierEmprunteur();
                return rep?true:this.menu();    
            default:
                return this.menu();
        }
    }

    //Materiel
    public boolean menuAjouterModifierMateriel(){
        
        boolean rep;
        int choix = this.vue.afficherMenuAjMod("Materiel  ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                rep = this.menuAjouterMateriel();
                return rep?true:this.menuAjouterModifierMateriel();
            case 2:
                rep = this.menuModifierMateriel();
                return rep?true:this.menuAjouterModifierMateriel();
            default:
                return this.menuAjouterModifierMateriel();
        }

    }

    public boolean menuAjouterMateriel(){

        int choix = this.vue.afficherMenuAjouterMateriel();
        this.vue.effacerConsole();
        switch (choix) {
            case 0:

                CapteursDeProfondeur cp = this.vue.ajouterCapteursDeProfondeur();
                this.data.ajouterMateriel(cp);
                return true;

            case 1:

                CasqueAudio ca = this.vue.ajouterCasqueAudio();
                this.data.ajouterMateriel(ca);
                return true;

            case 2:

                CasqueVR cvr = this.vue.ajouterCasqueVR();
                this.data.ajouterMateriel(cvr);
                return true;

            case 3:

                ManetteJeu mj = this.vue.ajouterManetteJeu();
                this.data.ajouterMateriel(mj);
                return true;

            case 4:

                ManetteVR mvr = this.vue.ajouterManetteVR();
                this.data.ajouterMateriel(mvr);
                return true;

            case 5:

                Souris s = this.vue.ajouterSouris();
                this.data.ajouterMateriel(s);
                return true;

            case 6:

                Tablette tab = this.vue.ajouterTablette();
                this.data.ajouterMateriel(tab);
                return true;

            case 7:

                Telephone tel = this.vue.ajouterTelephone ();
                this.data.ajouterMateriel(tel);
                return true;

            case 8:

                Webcam w = this.vue.ajouterWebcam();
                this.data.ajouterMateriel(w);
                return true;

            case 9:
                return false;
            default:
                return this.menuAjouterMateriel();
        }

    }

    public boolean menuModifierMateriel(){

        int choix = this.vue.demanderId("Materiel");

        if(this.data.getMateriels().containsKey(choix)){

            Materiel mat = data.getMateriels().get(choix);
            switch (mat.getType()){

                case "CapteursDeProfondeur":
                    CapteursDeProfondeur cp = (CapteursDeProfondeur)mat;
                    cp.copy(this.vue.ajouterCapteursDeProfondeur());
                    return true;
                case "CasqueAudio":
                    CasqueAudio ca = (CasqueAudio)mat;
                    ca.copy(this.vue.ajouterCasqueAudio());
                    return true;
                case "CasqueVR":
                    CasqueVR cvr = (CasqueVR)mat;
                    cvr.copy(this.vue.ajouterCasqueVR());
                    return true;
                case "ManetteJeu":
                    ManetteJeu mj = (ManetteJeu)mat;
                    mj.copy(this.vue.ajouterManetteJeu());
                    return true;
                case "ManetteVR":
                    ManetteVR mvr = (ManetteVR)mat;
                    mvr.copy(this.vue.ajouterManetteVR());
                    return true;
                case "Souris":
                    Souris sou = (Souris)mat;
                    sou.copy(this.vue.ajouterSouris());
                    return true;
                case "Tablette":
                    Tablette tab = (Tablette)mat;
                    tab.copy(this.vue.ajouterTablette());
                    return true;
                case "Telephone":
                    Telephone tel = (Telephone)mat;
                    tel.copy(this.vue.ajouterTelephone());
                    return true;
                case "Webcam":
                    Webcam web = (Webcam)mat;
                    web.copy(this.vue.ajouterWebcam());
                    return true;
                default:
                    return true;

            }

        }else{

            return this.menuModifierMateriel();

        }

    }

    //Stockage
    public boolean menuAjouterModifierStockage(){

        int choix = this.vue.afficherMenuAjMod("Stockage  ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menuAjouterModifierStockage();
        }

    }

    //Emprunt
    public boolean menuAjouterModifierEmprunt(){

        int choix = this.vue.afficherMenuAjMod("Emprunt   ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menuAjouterModifierEmprunt();
        }

    }

    //Emprunteur
    public boolean menuAjouterModifierEmprunteur(){

        int choix = this.vue.afficherMenuAjMod("Emprunteur");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            default:
                return this.menuAjouterModifierEmprunteur();
        }

    }
}