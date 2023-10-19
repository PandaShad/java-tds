package Exercice1;

import java.io.Serializable;

public class Personne implements Serializable {
	
	private String nom;
	private String prenom;
	private String prenom2;
	private int age;
	private Adresse adresse;
	
	public Personne() {
		System.out.println("Constructeur par d�faut de personne");
	}
	
	public Personne (String n, String p, int a) {
		nom = n;
		prenom = p;
		age = a;
		prenom2 = "Pierre";
	}
     
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
