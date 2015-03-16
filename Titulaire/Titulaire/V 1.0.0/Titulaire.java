/**
 * @(#)_Banque.java
 *
 *
 * @author ANDOLERZAK 
 * @version 1.00 2014/4/16
 */

package _Banque;

public class Titulaire {

	private final String nom;
	private final String prenom;
	private final String dateNaissance;
	private String adresse;

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	
	public Titulaire() {
		nom = "Inconnu";
		prenom = "Inconnu";
		dateNaissance = "1972/01/01";
		adresse = "Inconnue";
	}

	public Titulaire(String nom, String prenom, String dateNaissance, String adresse) throws Throwable{
		this.nom=nom.toUpperCase();
		int i;
		this.prenom = prenom.substring(0,1).toUpperCase()+prenom.substring(1);
		if(_Banque.dateValide(dateNaissance) == false)
			throw new Throwable("La date de naissance n'est pas valide");
		this.dateNaissance=dateNaissance;
		this.adresse=adresse;
	}	
		
  public void setAdresse(String uneAdresse){
    	this.adresse = uneAdresse;
    }
    

	public boolean  equals(Object client){
		Titulaire T = (Titulaire) client;
		return (nom.equals(T.nom) && prenom.equals(T.prenom) && dateNaissance.equals(T.dateNaissance));
	}

	public String toString(){
		return "Titulaire :" +nom+"," +prenom+"," +dateNaissance+"," +adresse;
	}
}