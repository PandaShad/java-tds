package Exercice1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

import javax.swing.event.SwingPropertyChangeSupport;

public class Promotion2022 {
    ArrayList<Etudiant> arrayEtudiants;
    Adresse rootAddress;
    Etudiant rootEtudiant;

    public ArrayList<Etudiant> getArrayEtudiants() {
        return this.arrayEtudiants;
    }

    public Adresse getRootAddress() {
        return this.rootAddress;
    }

    public Etudiant getRootEtudiant() {
        return this.rootEtudiant;
    }

    public Promotion2022() {
        initArray();
    }

    private void initArray() {
        arrayEtudiants = new ArrayList<>();

        Etudiant student1 = new Etudiant("Bellet", "Maxime", 25, new Date(), "9294562389");
        student1.setAdresse(new Adresse("Nice", "Notre-Dame", 18, false));
		rootAddress = student1.getAdresse();
		rootEtudiant = student1;
		arrayEtudiants.add(0,student1);

		Etudiant student2 = new Etudiant("Garacian", "Evy", 20, new Date(), "9494562390");
		student2.setAdresse(new Adresse("Nice", "Notre-Dame", 28, false));
		arrayEtudiants.add(1,student2);

		Etudiant student3 = new Etudiant("Saez", "Mery", 112, new Date(), "9394545689");
		arrayEtudiants.add(2,student3);
        student3.setAdresse(new Adresse("Nice", "Valrose", 28, false));

		Etudiant student4 = new Etudiant("Guillou", "Quentin", 30, new Date(), "9294565478");
		arrayEtudiants.add(3,student4);
        student4.setAdresse(new Adresse("Antibes", "Quelque-part", 28, false));
    }

    public void saveEtudiants(String fileName) {
        ObjectOutputStream g_etudiant;
        try {
            FileOutputStream support = new FileOutputStream(fileName);
		    g_etudiant = new ObjectOutputStream(support);
		    g_etudiant.writeObject(arrayEtudiants);
		    g_etudiant.writeObject(rootEtudiant);
		    g_etudiant.writeObject(rootAddress);
		    support.flush();
		    support.close();
        } catch(final java.io.IOException e) {
            System.out.println(e);
        }
    }

    public void retrieveEtudiants(String fileName) throws ClassNotFoundException {
        ObjectInputStream g_etudiant;
        try{
            FileInputStream support = new FileInputStream(fileName);
            g_etudiant = new ObjectInputStream(support);
            arrayEtudiants = (ArrayList<Etudiant>) g_etudiant.readObject();
            rootEtudiant = (Etudiant) g_etudiant.readObject();
		    rootAddress = (Adresse) g_etudiant.readObject();
			support.close();
        } catch(final java.io.IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Promotion2022 promotion2022 = new Promotion2022();
        // System.out.println("Before serialized : ");
        // promotion2022.saveEtudiants("f_etudiants");
        promotion2022.retrieveEtudiants("f_etudiants");
        System.out.println("After deserialized : ");

        promotion2022.getArrayEtudiants().forEach(new Consumer<Etudiant>() {
            public void accept(Etudiant etudiant){
                System.out.println(etudiant.getNom() + " " + etudiant.getPrenom() + " " + etudiant.getNumTel());
            }         
        });
    }
}
