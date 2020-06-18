package controleur;

import model.Data;
import model.Emprunteur;
import model.Stockage;
import vue.Vue;

public class Controleur {

    private Emprunteur user;
    private final Vue vue;
    private Data data;


    public Controleur(final Emprunteur user, Vue vue, Data data)
    {
        this.user = user;
        this.vue = vue;
        this.data = data;
    }

    public void menu()
    {
        while(interpreterChoix(this.vue.afficherMenu()));
    }

    private boolean interpreterChoix(final int choix) {
        if(choix == 0)
            return false;
        else if(choix == 1)
        {
            this.vue.afficherMenuMateriel();
            return true;
        }
        else if(choix == 2)
        {
            this.vue.afficherMenuEmprunt();
            return true;
        }
        else if(choix == 3)
        {
            final Stockage stockage = new Stockage(1,"Salle 209","Erwan",this.vue.ajouterMateriel());
            
            this.vue.afficherStockage(stockage);
            return true;
        }
        else if(choix == 4)
        {
            this.interpreterChoixAjouter();
            return true;
        }
        else if(choix == 5)
        {
            // Rendre un emprunt
            return true;
        }
        return true;
    }

    private boolean interpreterChoixAjouter()
    {
        int choix = -1;

        while (choix != 0)
        {
            choix = this.vue.afficherMenuAjouterModifier();
            if (choix == 1)
            {
                // Ajout matériel
                this.data.ajouterMateriel(this.vue.ajouterMateriel());
            }
            else if (choix == 2)
            {
                // Ajout lieu de stockage
            }
            else if (choix == 3)
            {
                // Ajout emprunt
            }
            else if (choix == 4 )
            {
                // Ajout utilisateur
            }
        }

        return false;
    }
}