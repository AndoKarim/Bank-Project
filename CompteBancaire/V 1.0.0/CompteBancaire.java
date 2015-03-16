/**
 * @(#)CompteBancaire.java
 *
 *
 * @author ANDOLERZAK 
 * @version 1.00 2014/5/2
 */
 package _Banque;
import java.util.ArrayList;

import java.util.*;
import java.text.*;

public abstract class CompteBancaire {

	protected Titulaire titulaireCompte;
	protected int numeroCompte;
	protected float soldeCompte;
	protected final ArrayList operations;
	
    public CompteBancaire() {
    	titulaireCompte = new Titulaire();
    	numeroCompte = -1;
    	soldeCompte= 0;
    	operations=new ArrayList();
    }
    
    //Constructeur normal
    public CompteBancaire(Titulaire unTitulaire)throws Throwable{
    	int numTemp;
    	if(unTitulaire == null)
    		throw new Throwable("Le titulaire inscrit n'est pas correct");
    	titulaireCompte = unTitulaire;
    	soldeCompte = 0;
    	if(this instanceof CompteCourant)
    		numeroCompte = _Banque.numeroRegistreCptCourant();
    	if(this instanceof CompteEpargne)
    		numeroCompte=_Banque.numeroRegistreCptEpargne();
    	operations=new ArrayList();
    
    }
    
    public float executer(char typeOperation, float montant)throws Throwable{
	//Exceptions
		if(montant<0){
			throw new Throwable ("-3.3 : le montant doit etre positif");
		}
				
		if(typeOperation!= 'V' && typeOperation!='R' && typeOperation!='I'){
				throw new Throwable("-3.2 : opération bancaire invalide sur ce type de compte");
		}
		
		if(typeOperation== 'R' && soldeCompte<montant){
				throw new Throwable("-3.0 : retrait invalide par insuffisance du soldeCompte courant");
		}
		
	//Si l'opération est un virement
		if(typeOperation=='V'){
			OperationBancaire uneOperation = new OperationBancaire('V',"Versement",montant);
			soldeCompte = soldeCompte + montant;
			operations.add(uneOperation);
		}
	//Si l'opération est un Retrait	
		if(typeOperation=='R'){
				OperationBancaire uneOperation = new OperationBancaire('R',"Retrait",montant);
				soldeCompte = soldeCompte - montant;
				operations.add(uneOperation);
			}
	//Si l'opération est une Remuneration d'interet
		if(typeOperation=='I'){
				OperationBancaire uneOperation = new OperationBancaire('I',"Remuneration",montant);
				soldeCompte = soldeCompte + montant;
				operations.add(uneOperation);
			}
		
		return soldeCompte;
	}
	
	//Surcharge de la méthode executer afin d'integrer un libellé en paramètre
	 public float executer(char typeOperation, float montant, String libelle)throws Throwable{
	//Exceptions
		if(montant<=0){
			throw new Throwable ("-3.3 : le montant doit etre positif");
		}
				
		if(typeOperation!= 'V' && typeOperation!='R' && typeOperation!='I'){
				throw new Throwable("-3.2 : opération bancaire invalide sur ce type de compte");
		}
		
		if(typeOperation== 'R' && soldeCompte<montant){
				throw new Throwable("-3.0 : retrait invalide par insuffisance du soldeCompte courant");
		}
		
	//Si l'opération est un virement
		if(typeOperation=='V'){
			OperationBancaire uneOperation = new OperationBancaire('V',libelle,montant);
			soldeCompte = soldeCompte + montant;
			operations.add(uneOperation);
		}
	//Si l'opération est un Retrait	
		if(typeOperation=='R'){
				OperationBancaire uneOperation = new OperationBancaire('R',libelle,montant);
				soldeCompte = soldeCompte - montant;
				operations.add(uneOperation);
			}
	//Si l'opération est une Remuneration d'interet
		if(typeOperation=='I'){
				OperationBancaire uneOperation = new OperationBancaire('I',libelle,montant);
				soldeCompte = soldeCompte + montant;
				operations.add(uneOperation);
			}
		
		return soldeCompte;
	}
	
   //Accesseurs 
    public Titulaire getTitulaire(){return titulaireCompte;}
    public int getNumeroCompte(){return numeroCompte;}
    public float getSoldeCompte(){return soldeCompte;}
    public ArrayList getOperations(){return operations;}
    
   
   //Modification adresse
   	public void modifierAdresse(String uneAdresse){
   		this.titulaireCompte.setAdresse(uneAdresse);
   	}
   	
   //Methdode nbOperations	
   	public int nbOperation(){
   		return this.operations.size();
   	}
   	
   //Methode dateDerniereOp
   	public String dateDerniereOp(){
   		if(operations.size()==0)
   			return null;
   		OperationBancaire lastOp= (OperationBancaire) operations.get(operations.size()-1);
   		return lastOp.getDateOpe();
   	}	
   		
   //Methode releveMensuel
   	public void releveMensuel(int m)throws Throwable {
   		int i;
   		Calendar now = Calendar.getInstance();
   	
   		/*if(m>= now.get(Calendar.MONTH))
   			throw new Throwable("Le mois n'est pas encore fini ou n'a pas encore commencé");*/
   		System.out.printf("***************** %n");
   		System.out.printf("%s%s%n%s%n","*"+this.titulaireCompte.getNom()+" ",this.titulaireCompte.getPrenom()+"	*",
   						"*"+this.titulaireCompte.getAdresse()+"	*" );
   		System.out.printf("*****************\t %n%n");
   		
   		System.out.printf("\t\t\t\t\t\t      ---\n");
   		System.out.printf("\t\t\t\t\tReleve numero:|%d| \n",m);
   		System.out.printf("\t\t\t\t\t\t      ---\n");		
   			
   		System.out.printf("Liste des operations %n%n");	
   		
   		System.out.printf("Date         Libelle     Debit   Credit %n");	
   			
   		for(i=0;i<operations.size();i++){
   		
   			OperationBancaire temp=(OperationBancaire) operations.get(i);
   			if(temp.getTypeOpe()=='V')
   				System.out.printf("%10s |%10s|        |%7.2f %n",temp.getDateOpe(), temp.getIntituOpe(), temp.getmontantOp());
   				
   			if(temp.getTypeOpe()=='R')
   				System.out.printf("%10s |%10s|%7.2f | %n",temp.getDateOpe(), temp.getIntituOpe(), temp.getmontantOp());
   		}
   			chariot(5);
   			System.out.printf("\t\t\t\t\t   ---------\n");	
   			System.out.printf("Solde %45.2f| %n",this.getSoldeCompte());	
   			System.out.printf("\t\t\t\t\t   ---------\n");		
   	//	System.out.prinf("Solde");
   	}
	public void chariot(int chariot){
		for(int i = 0; i < chariot; i++){
			System.out.printf("%n");
		}
	}
   	
   	public String dateDerniereOperation(){
		OperationBancaire opB=(OperationBancaire) operations.get(operations.size()-1);
		return opB.getDateOpe();
	}
	
		
   	
  //Methode toString 
  	public String toString(){
		return "Compte N°"+numeroCompte+  "| solde compte: " +soldeCompte+ "Euros|" +titulaireCompte.toString();
	}
    
  //Methode clone
    public Object clone() throws CloneNotSupportedException {
	   throw new CloneNotSupportedException("-3.1 : duplication interdite pour un compte bancaire");
	}
	
		
}