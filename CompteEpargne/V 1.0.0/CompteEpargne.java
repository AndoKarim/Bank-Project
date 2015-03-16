package _Banque;

import _Banque.*;

public class CompteEpargne extends CompteCourant {
	
	private final float tauxInteret;
	private static final float tauxRetrait = 0.00008f;
	
	public CompteEpargne()throws Throwable {
		super();
		tauxInteret = 0;
	}	
	
	public CompteEpargne(Titulaire unTitulaire, float unTaux)throws Throwable {	
		super(unTitulaire);

		if(unTaux<0)
			throw new Throwable("-3.5	:	Taux mensuel inf�rieur � 0");
			
		tauxInteret = unTaux;	
	}
	
	public float executer(char typeOperation, float montant) throws Throwable{
		//V�rifier si il faut appliuer le taux de retrait
		if(montant<200 && typeOperation=='R')
			 montant+=montant*tauxRetrait;

		if(dateDerniereOperation()!=null){
			//Si c'est la premi�re op�ration du mois, on fait les interets
			String dateJ = _Banque.dateJour();
			int dateJMois = Integer.parseInt(dateJ.substring(5,7));
			int dateJAnnee = Integer.parseInt(dateJ.substring(0,3));

			String dateOp = dateDerniereOperation();
			int dateOpMois = Integer.parseInt(dateOp.substring(5,7));
			int dateOpAnnee = Integer.parseInt(dateOp.substring(0,3));

			//Calcul : Suite g�om�trique : U0*q^n
			//Nombre de mois d'interets a faire
			int n=(dateJAnnee-dateOpAnnee)*12+(dateJMois-dateOpMois);

			//Si au moins un mois est pass�
			if(n>0){
				//Solde total avec interets :
				float soldeInteret = getSoldeCompte()*((float)Math.pow(tauxInteret,n));
				//On a besoin d'ajouter SEULEMENT les interets au solde du compte pour afficher l'op�ration
				super.executer('I', soldeInteret-getSoldeCompte());
			}
		}
		
		//Ex�cuter l'op�ration de retrait
		return super.executer(typeOperation, montant);
	}
	
	//Surcharge de la m�thode executer afin d'integrer un libell� en param�tre
	public float executer(char typeOperation, float montant, String libelle) throws Throwable{
		//V�rifier si il faut appliuer le taux de retrait
		if(montant<200 && typeOperation=='R')
			 montant+=montant*tauxRetrait;

		if(dateDerniereOperation()!=null){
			//Si c'est la premi�re op�ration du mois, on fait les interets
			String dateJ = _Banque.dateJour();
			int dateJMois = Integer.parseInt(dateJ.substring(5,7));
			int dateJAnnee = Integer.parseInt(dateJ.substring(0,3));

			String dateOp = dateDerniereOperation();
			int dateOpMois = Integer.parseInt(dateOp.substring(5,7));
			int dateOpAnnee = Integer.parseInt(dateOp.substring(0,3));

			//Calcul : Suite g�om�trique : U0*q^n
			//Nombre de mois d'interets a faire
			int n=(dateJAnnee-dateOpAnnee)*12+(dateJMois-dateOpMois);

			//Si au moins un mois est pass�
			if(n>0){
				//Solde total avec interets :
				float soldeInteret = getSoldeCompte()*((float)Math.pow(tauxInteret,n));
				//On a besoin d'ajouter SEULEMENT les interets au solde du compte pour afficher l'op�ration
				super.executer('I', soldeInteret-getSoldeCompte());
			}
		}
		
		//Ex�cuter l'op�ration de retrait
		return super.executer(typeOperation,montant,libelle);
	}
}
