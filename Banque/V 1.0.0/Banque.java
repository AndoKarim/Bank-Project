package _Banque;

import _Banque.*;
import java.util.*;

public class Banque {

	private String nomBanque;
	private int codeBanque;
	private String adresseBanque;
	private double numeroSIRET;
	private HashMap regions;
	private int registreAgences;
	private int registreComptesCourants;
	private int registreComptesEpargne;

	public Banque() {
		this.nomBanque = "Banque";
		this.codeBanque = 00000;
		this.adresseBanque = "Inconnue";
		this.numeroSIRET = 00000000000000;
		this.regions = new HashMap(); 
		this.registreAgences = 1001;
		this.registreComptesCourants = 8000000;
		this.registreComptesEpargne = 4000000;
	}

	/**
	 * 
	 * @param unNom
	 * @param uneAdresse
	 * @param unCodeBanque
	 * @param unSIRET
	 */
	public Banque(String unNom, String uneAdresse, int unCodeBanque, double unSIRET) {
		this.nomBanque = unNom;
		this.codeBanque = unCodeBanque;
		this.adresseBanque = uneAdresse;
		this.numeroSIRET = unSIRET;
		this.regions = new HashMap(); 
		this.registreAgences = 1001;
		this.registreComptesCourants = 8000000;
		this.registreComptesEpargne = 4000000;
	}

	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}

	public String toString () {
    	
    	return "Banque n° : " + codeBanque + " , " + nomBanque + " , " + adresseBanque ;
    }
    
	public String getNomBanque() {
		return this.nomBanque;
	}

	public int getCodeBanque() {
		return this.codeBanque;
	}

	public String getAdresseBanque() {
		return this.adresseBanque;
	}

	public double getNumeroSIRET() {
		return this.numeroSIRET;
	}

	public HashMap getRegions() {
		return this.regions;
	}

	public int getRegistreAgences() {
		return this.registreAgences;
	}

	public int getRegistreComptesCourants() {
		return this.registreComptesCourants;
	}

	public int getRegistreComptesEpargne() {
		return this.registreComptesEpargne;
	}

	/**
	 * 
	 * @param uneRegion
	 * @param uneAdresse
	 */
	public int ouvrirAgence(String uneRegion, String uneAdresse)throws Throwable {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param unNumGuichet
	 */
	public void fermerAgence(int unNumGuichet)throws Throwable {
		throw new UnsupportedOperationException();
		
		
	}
	
	/**
	 * 
	 * @param unGuichetOrigine
	 * @param unGuichetDestination
	 */
	public void transfererCompte(int unGuichetOrigine, int unGuichetDestination) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param type
	 */
	public void nombreClients(Titulaire t, char type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param type
	 */
	public void nombreComptes(Titulaire t, char type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param type
	 */
	public void totalDepots(Titulaire t, char type) {
		throw new UnsupportedOperationException();
	}

	public void nombreOperations() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uneRegion
	 */
	public void nombreClients(String uneRegion) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param type
	 * @param uneRegion
	 */
	public void nombreComptes(Titulaire t, char type, String uneRegion) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 * @param type
	 * @param uneRegion
	 */
	public void totalDepots(Titulaire t, char type, String uneRegion) {
		throw new UnsupportedOperationException();
	}

	public void comptesClient() {
		throw new UnsupportedOperationException();
	}

	public void depotsClient() {
		throw new UnsupportedOperationException();
	}

	public void nombreAgences() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uneRegion
	 */
	public void creerRegion(String uneRegion)throws Throwable {
		if(regions.get(uneRegion)!= null)throw new Throwable();
		regions.put(uneRegion,new HashMap());
		
	}

	/**
	 * 
	 * @param uneRegion
	 */
	public void supprimerRegion(String uneRegion)throws Throwable {
		if(regions.get(uneRegion)== null) throw new Throwable();
		if(((HashMap)regions.get(uneRegion)).size() !=0)throw new Throwable();
		
		regions.remove(uneRegion);
	}

}