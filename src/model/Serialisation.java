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

    static public void serialiserData(Data data)
    {
        try {
            FileOutputStream fs = new FileOutputStream("data/data.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(data);
            oos.close();
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    static public Data deserialiserData()
    {
        try {
            FileInputStream fis = new FileInputStream("data/data.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Data data = (Data) ois.readObject();
            ois.close();
            return data;
        } catch (Exception e) { 
            Data data = new Data();
            //e.printStackTrace(); 
            return data;
        }
    }
}