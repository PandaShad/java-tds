package Exercice1;

import java.io.Serializable;
import java.util.Date;

public class Etudiant extends Personne implements Serializable{
    private Date datePremiereInscription;
	private  transient String numTel;
	Personne[] parents;

	public Etudiant() {
		System.out.println("Constructeur par d�faut d_�tudiant");
	}

	public Etudiant(String n, String p, int a, Date d, String t) {
		super(n, p, a);
		datePremiereInscription = d;
		numTel = t;
	}

	public Personne[] getParents() {
		return parents;
	}

	public void setParents(Personne[] parents) {
		this.parents = parents;
	}

	public Date getDatePremiereInscription() {
		return datePremiereInscription;
	}

	public void setDatePremiereInscription(Date datePremiereInscription) {
		this.datePremiereInscription = datePremiereInscription;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
}
