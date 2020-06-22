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
import model.Stockage;
import model.Tablette;
import model.Telephone;
import model.Webcam;
import model.Emprunt;
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

        if(data.getStockages().isEmpty()){
            vue.msg("Veuillez créer des zones de stockages dans la bdd avant de rentrer du matériel");
            vue.waitForUser();
            return true;
        }
        int count,idS;
        int choix = this.vue.afficherMenuAjouterMateriel();
        this.vue.effacerConsole();
        switch (choix) {
            case 0:

                CapteursDeProfondeur cp = this.vue.ajouterCapteursDeProfondeur();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    CapteursDeProfondeur cp2 = new CapteursDeProfondeur();
                    cp2.copy(cp);
                    this.data.ajouterMateriel(cp2);    
                    data.ajouterMaterielDansStockage(idS, cp2);
                }
                return true;

            case 1:

                CasqueAudio ca = this.vue.ajouterCasqueAudio();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    CasqueAudio ca2 = new CasqueAudio();
                    ca2.copy(ca);
                    this.data.ajouterMateriel(ca2);    
                    data.ajouterMaterielDansStockage(idS, ca2);
                }
                return true;

            case 2:

                CasqueVR cvr = this.vue.ajouterCasqueVR();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    CasqueVR cvr2 = new CasqueVR();
                    cvr2.copy(cvr);
                    this.data.ajouterMateriel(cvr2);    
                    data.ajouterMaterielDansStockage(idS, cvr2);
                }
                return true;

            case 3:

                ManetteJeu mj = this.vue.ajouterManetteJeu();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    ManetteJeu mj2 = new ManetteJeu();
                    mj2.copy(mj);
                    this.data.ajouterMateriel(mj2);    
                    data.ajouterMaterielDansStockage(idS, mj2);
                }
                return true;

            case 4:

                ManetteVR mvr = this.vue.ajouterManetteVR();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    ManetteVR mvr2 = new ManetteVR();
                    mvr2.copy(mvr);
                    this.data.ajouterMateriel(mvr2);    
                    data.ajouterMaterielDansStockage(idS, mvr2);
                }
                return true;

            case 5:

                Souris s = this.vue.ajouterSouris();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    Souris s2 = new Souris();
                    s2.copy(s);
                    this.data.ajouterMateriel(s2);    
                    data.ajouterMaterielDansStockage(idS, s2);
                }
                return true;

            case 6:

                Tablette tab = this.vue.ajouterTablette();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    Tablette tab2 = new Tablette();
                    tab2.copy(tab);
                    this.data.ajouterMateriel(tab2);    
                    data.ajouterMaterielDansStockage(idS, tab2);
                }
                return true;

            case 7:

                Telephone tel = this.vue.ajouterTelephone();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    Telephone tel2 = new Telephone();
                    tel2.copy(tel);
                    this.data.ajouterMateriel(tel2);    
                    data.ajouterMaterielDansStockage(idS, tel2);
                }
                return true;

            case 8:

                Webcam w = this.vue.ajouterWebcam();
                count = this.vue.demanderQuantite();
                idS = this.demanderIdStockage();
                for(int i = 0 ; i < count; i++){
                    Webcam w2 = new Webcam();
                    w2.copy(w);
                    this.data.ajouterMateriel(w2);    
                    data.ajouterMaterielDansStockage(idS, w2);
                }
                return true;

            case 9:
                return false;
            default:
                return this.menuAjouterMateriel();
        }

    }

    public boolean menuModifierMateriel(){

        if(data.getMateriels().isEmpty()){
            vue.msg("Pas de matériel enregistré");
            vue.waitForUser();
            return true;
        }

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

    public int demanderIdMateriel(){

        this.vue.afficherMaterielDisponible(data.getStockages());
        int choix = this.vue.demanderId("Matériel");
        return data.getMateriels().containsKey(choix)?choix:demanderIdMateriel();


    }

    //Stockage
    public boolean menuAjouterModifierStockage(){

        Stockage stock;
        int choix = this.vue.afficherMenuAjMod("Stockage  ");

        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                stock = this.vue.ajouterStockage();
                this.data.ajouterStockage(stock);
                return true;
            case 2:
                if(data.getStockages().isEmpty()){
                    vue.msg("Pas de stockage enregistré");
                    vue.waitForUser();
                    return true;
                }
                choix = this.vue.demanderId("Stockage");
                stock = data.getStockages().get(choix);
                stock.copy(this.vue.ajouterStockage());
                return true;
            default:
                return this.menuAjouterModifierStockage();
        }

    }

    public int demanderIdStockage(){

        this.vue.afficherTousStockages(data.getStockages());
        int choix = this.vue.demanderId("Stockage");
        return data.getStockages().containsKey(choix)?choix:demanderIdStockage();


    }

    //Emprunt
    public boolean menuAjouterModifierEmprunt(){

        Emprunt emprunt;
        int id;
        int choix = this.vue.afficherMenuAjMod("Emprunt   ");
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                if(data.getMateriels().isEmpty()){
                    vue.msg("Veuillez insérer du matériel dans la bdd avant de réaliser des emprunts");
                    vue.waitForUser();
                    return true;
                }
                id = this.demanderIdMateriel();
                emprunt = this.vue.ajouterEmprunt();
                Materiel materiel = data.getMateriels().get(id);
                emprunt.setMateriel(materiel);
                this.data.ajouterEmprunt(emprunt, this.user);
                data.getStockages().get(materiel.getIdStockage()).getMateriels().remove(materiel.getId());
                return true;
            case 2:
                if(data.getEmprunts().isEmpty()){
                    vue.msg("Pas d'emprunt enregistré");
                    vue.waitForUser();
                    return true;
                }
                this.vue.afficherTousEmprunts(this.data.getEmprunts());
                choix = this.demanderIdEmprunt();
                emprunt = data.getEmprunts().get(choix);
                emprunt.setDateRendu(vue.demanderDate());
                return true;
            default:
                return this.menuAjouterModifierEmprunt();
        }

    }

    public int demanderIdEmprunt(){

        this.vue.afficherTousEmprunts(data.getEmprunts());
        int choix = this.vue.demanderId("Emprunt");
        return data.getEmprunts().containsKey(choix)?choix:demanderIdEmprunt();


    }

    //Emprunteur
    public boolean menuAjouterModifierEmprunteur(){

        int choix = this.vue.afficherMenuAjMod("Emprunteur");
        Emprunteur res;
        this.vue.effacerConsole();
        switch (choix) {
            case 0:
                return false;
            case 1:
                res = this.vue.ajouterEmprunteur();
                this.data.ajouterEmprunteur(res);
                return true;
            case 2:
                if(data.getEmprunteurs().isEmpty()){
                    vue.msg("Pas d'emprunteur enregistré");
                    vue.waitForUser();
                    return true;
                }
                int id = this.demanderIdEmprunteur();
                res = this.vue.ajouterEmprunteur();
                data.getEmprunteurs().get(id).copy(res);
                return true;
            default:
                return this.menuAjouterModifierEmprunteur();
        }

    }

    public int demanderIdEmprunteur(){

        this.vue.afficherTousEmprunteurs(data.getEmprunteurs());
        int choix = this.vue.demanderId("Emprunteur");
        return data.getEmprunteurs().containsKey(choix)?choix:demanderIdEmprunteur();


    }
}