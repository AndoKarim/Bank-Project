/**
 * @(#)OperationBancaire.java
 *
 *
 * @author ANDOLERZAK 
 * @version 1.00 2014/4/25
 */
package _Banque;

public class OperationBancaire {

	private char typeOperation;
	private long numeroOperation;
	private String intituleOperation;
	private String dateOperation;
	private float montantOperation;
	
	public char getTypeOpe() {return typeOperation;}

	public long getNumOpe() {return numeroOperation;}
	
	public String getIntituOpe() {return intituleOperation;}
	
	public String getDateOpe() {return dateOperation;}

	public float getmontantOp() {return montantOperation;}


	public OperationBancaire(char type, String intitule, float montant) throws Throwable {
		if(type != 'N' && type != 'V' && type != 'R' && type != 'I')
			throw new Throwable("Le type d'operation est incorrect");
		typeOperation = type;
		if(intitule.length()>40)
			throw new Throwable("L'intitule ne doit pas depasser 40 caracteres");
		intituleOperation = intitule;
		if(montant <0)
			throw new Throwable("Le montant ne peut etre negatif");
		montantOperation = montant;
		dateOperation = _Banque.dateJour();
		numeroOperation = _Banque.numeroRegistreOp();
	}

	public OperationBancaire() {
		typeOperation = 'N';
		intituleOperation = "Neutre";
		montantOperation = 0;
		dateOperation = _Banque.dateJour();
		numeroOperation = _Banque.numeroRegistreOp();
	}

	public String toString(){
		return "Operation N°="+numeroOperation+ ":" +"Versement de " +montantOperation+ " Euros le " +dateOperation;
	}
}