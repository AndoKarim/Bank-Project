package _Banque;

import _Banque.*;

public class CompteCourant extends CompteBancaire {

	protected boolean cloture;
	
	public CompteCourant() {
		super();
		cloture=false;
	}	
	public CompteCourant(Titulaire unTitulaire)throws Throwable{
		super(unTitulaire);
		cloture=false;
	}
	
	public float cloturer()throws Throwable{
		float soldepreced = getSoldeCompte();
		super.executer('R',getSoldeCompte());
		this.cloture = true;
		return soldepreced;
	}
	
	public float executer(char typeOperation, float montant)throws Throwable{
		if(cloture == true)
			throw new Throwable("-3.3	:	op�ration interdite sur un compte courant cl�tur�");
		return super.executer(typeOperation,montant);
	}
	
	//Surcharge de la m�thode executer afin d'integrer un libell� en param�tre
	public float executer(char typeOperation, float montant, String libelle)throws Throwable{
		if(cloture == true)
			throw new Throwable("-3.3	:	op�ration interdite sur un compte courant cl�tur�");
		return super.executer(typeOperation,montant,libelle);
	}
}
