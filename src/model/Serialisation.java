package model;

import java.io.*;
import java.util.Date;

import model.Emprunteur;
import model.Materiel;
import model.Stockage;
import model.Emprunt;

public class Serialisation {

    public Serialisation()
    {
    }

    static public void serialiserMateriel(Materiel materiel)
    {
        try {
            FileOutputStream fs = new FileOutputStream("data/materiels.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(materiel);
            oos.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    static public Materiel deserialiserMateriel()
    {
        try {
            FileInputStream fis = new FileInputStream("data/materiels.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Materiel materiel = (Materiel) ois.readObject();
            ois.close();
            return materiel;
        } catch (Exception e) { 
            Date date = new Date();
            Materiel materiel = new Materiel(-1, "null", "null", "null", date, 0, "null");
            e.printStackTrace(); 
            return materiel;
        }
    }

    
    static public void serialiserStockage(Stockage stockage)
    {
        try {
            FileOutputStream fs = new FileOutputStream("data/stockages.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(stockage); 
            os.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    static public Stockage deserialiserStockage()
    {
        try {
            FileInputStream fis = new FileInputStream("data/stockages.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Stockage stockage = (Stockage) ois.readObject();
            ois.close();
            return stockage;
        } catch (Exception e) { 
            Stockage stockage = new Stockage(-1, "null", "null");
            e.printStackTrace(); 
            return stockage;
        }
    }

    static public void serialiserEmprunt(Emprunt emprunt)
    {
        try {
            FileOutputStream fs = new FileOutputStream("data/emprunts.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(emprunt);
            os.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    static public Emprunt deserialiserEmprunt()
    {
        try {
            FileInputStream fis = new FileInputStream("data/emprunts.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Emprunt emprunt = (Emprunt) ois.readObject();
            ois.close();
            return emprunt;
        } catch (Exception e) { 
            Emprunt emprunt = new Emprunt(null,null,null,null);
            e.printStackTrace(); 
            return emprunt;
        }
    }

    static public void serialiserEmprunteur(Emprunteur emprunteur)
    {
        try {
            FileOutputStream fs = new FileOutputStream("data/emprunteurs.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(emprunteur);
            os.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    static public Emprunteur deserialiserEmprunteur()
    {
        try {
            FileInputStream fis = new FileInputStream("data/emprunteurs.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Emprunteur emprunteur = (Emprunteur) ois.readObject();
            ois.close();
            return emprunteur;
        } catch (Exception e) { 
            Emprunteur emprunteur = new Emprunteur(-1, "null", "null", "null", "null", "null", "null");
            e.printStackTrace(); 
            return emprunteur;
        }
    }
}