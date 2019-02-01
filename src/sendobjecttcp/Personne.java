/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendobjecttcp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Mouad
 */
public class Personne implements Serializable {

    String nom;
    String prenom;
    String adr;

    public Personne(String nom, String prenom, String adr) {
        this.nom = nom;
        this.prenom = prenom;
        this.adr = adr;
    }

    public void afficher() {
         System.out.println( "Nom:"+this.nom +" Prenom:"+ this.prenom +" Adresse:"+ this.adr);
    }

    public static void main(String[] args) {
        Personne p = new Personne("Nour eddine", "naouaoui", "agadir");
        Personne p1 = new Personne("Shaimae", "Hizem", "ourzazate");
        Personne p2 = new Personne("Asmae", "Meziane", "ourzazate");
        
        ObjectOutputStream oop = null;
        ObjectInputStream ips = null;
        try {
            oop = new ObjectOutputStream(new FileOutputStream("fich.txt"));
            oop.writeObject(p);
            oop.flush();
            oop.close();
            ips = new ObjectInputStream(new FileInputStream("fich.txt"));
            Personne pf = (Personne) ips.readObject();
            pf.afficher();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
