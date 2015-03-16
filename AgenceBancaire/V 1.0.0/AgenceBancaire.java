package _Banque;
import java.util.*;
import java.lang.*;


public class AgenceBancaire {
	private int numeroGuichet;
	private String adresseAgence;
	private HashMap comptesCourant;
	private HashMap comptesEpargne;
	private HashMap comptesFermes;	
		
	public AgenceBancaire() {
		numeroGuichet = 0;
		adresseAgence = "---";
		comptesCourant = new HashMap();
		comptesEpargne = new HashMap();
		comptesFermes   = new HashMap();
	}
	
	public AgenceBancaire(String adresse) {
		numeroGuichet  = _Banque.numGuichet();
		adresseAgence  = adresse;
		comptesCourant = new HashMap();
		comptesEpargne = new HashMap();
		comptesFermes  = new HashMap();
	}
	
	public String toString () {
    	
    	return "Agence n°" + numeroGuichet + " : " + adresseAgence;
    }
    
    public Object clone () throws CloneNotSupportedException {
		
		throw new CloneNotSupportedException("-3.0 : duplication interdite");
	}
	
	public boolean equals (Object op2) {
		
		return false;
	}
	
	public int getNumeroGuichet () {
		
		return numeroGuichet;
	}
	
	public String getAdresseAgence () {
		
		return adresseAgence;
	}
	
	public int nombreComptesCourant () {
		
		return comptesCourant.size();
	}
	
	public int nombreComptesEpargne () {
		
		return comptesEpargne.size();
	}
	
	public int nombreComptesFermes () {
		
		return comptesFermes.size();
	}
	
	public int nombreComptes () {
		
		return  nombreComptesCourant() + nombreComptesEpargne() +  nombreComptesFermes();
	}

	public int ouvrirCompte(Titulaire t)throws Throwable {
		CompteCourant C = new CompteCourant(t);
		comptesCourant.put(C.getNumeroCompte(),C);
		return C.getNumeroCompte();
		
	}
	
	public int ouvrirCompte(Titulaire t, float taux)throws Throwable {
		CompteEpargne E = new CompteEpargne(t,taux);
		comptesEpargne.put(E.getNumeroCompte(),E);
		return E.getNumeroCompte();
	}
	
	public float fermerCompte(int numeroC)throws Throwable {
		//Si le compte est déjà fermé
		if(comptesFermes.containsKey(numeroC)==true)
			throw new Throwable("-3.2 : tentative de fermeture d'un compte déjà fermé");
		CompteCourant C = (CompteCourant)comptesCourant.get(numeroC);
		if(C!= null)
		{
			comptesFermes.put(C.getNumeroCompte(),C);
			return C.cloturer();
		}
		CompteEpargne E = (CompteEpargne)comptesEpargne.get(numeroC);
		if (E!= null)
		{
			comptesFermes.put(E.getNumeroCompte(),E);
			return E.cloturer();
		}
		//Si le compte est inexistant
		throw new Throwable("-3.1 : tentative de fermeture d'un compte inexistant");
	}

	public float executer(int numeroC, char typeOpe, String libelle, float montant)throws Throwable {
		//Si le compte est déjà fermé
		if(comptesFermes.containsKey(numeroC)==true)
			throw new Throwable("-3.4 : tentative d'accès à un compte bancaire fermé");
		Object c;
		//Execution d'un compte courant
		c = comptesCourant.get(numeroC);
		if(c!=null)
			return ((CompteCourant)c).executer(typeOpe,montant,libelle);
		//Execution d'un compte épargne
		c = comptesEpargne.get(numeroC);
		if(c!=null)
			return ((CompteEpargne)c).executer(typeOpe,montant,libelle);
			
		throw new Throwable("-3.5 : numéro de compte inconnu dans l'agence");
	}	


	public int nombreClients(){
    	ArrayList ListeTitulaire=new ArrayList();
    	int NombreClients=0;
    	Titulaire Titulaire0=null;
		Object c = null;
		Object d = null;
		Iterator i= comptesCourant.keySet().iterator();
		while (i.hasNext()) {
			c = i.next();
    		CompteBancaire cc = (CompteBancaire) comptesCourant.get(c);
    		Titulaire0 = cc.getTitulaire();
    		if((ListeTitulaire.indexOf(Titulaire0))==-1){
    				NombreClients+=1;
    				
    				ListeTitulaire.add(Titulaire0);
    			
    			}
    		}
    	Iterator j= comptesEpargne.keySet().iterator();
    	while(j.hasNext()){
    		d = j.next();	
    		CompteBancaire ce = (CompteBancaire) comptesEpargne.get(d);
    		Titulaire0=ce.getTitulaire();
    		if((ListeTitulaire.indexOf(Titulaire0))==-1){
    				NombreClients+=1;
    				ListeTitulaire.add(Titulaire0);
    			}
    		}
		
    	return NombreClients;
    	}



    public long nombreComptes(Titulaire t, char type) throws Throwable{
        ArrayList ListeTitulaire=new ArrayList();
        long NombreComptes=0;
		Object o = null;
		Object d = null;
		if(type!='c' && type!='e')
			throw new Throwable("-3.0 : Type invalide");

		if(type=='c'){
    		Iterator i= comptesCourant.keySet().iterator();
    		while(i.hasNext()){
    			o = i.next();
    			CompteBancaire cc = (CompteBancaire) comptesCourant.get(o);
    			if((cc.getTitulaire()).equals(t)){
    					NombreComptes+=1;
    				}
    			}
		}

		else{
    	Iterator j= comptesEpargne.keySet().iterator();
    	while(j.hasNext()){
    		d = j.next();
    		CompteBancaire ce = (CompteBancaire) comptesEpargne.get(d);
    			if((ce.getTitulaire()).equals(t)){
    					NombreComptes+=1;
    				}
    		}
		}
    		return NombreComptes;
    }

    public float totalDepots(Titulaire t, char type) throws Throwable{
    	ArrayList ListeTitulaire=new ArrayList();
        long TotalDepots=0;
		Object o = null;
		Object d = null;
		if(type!='c' && type!='e')
			throw new Throwable("-3.0 : Type invalide");

		if(type=='c'){
    		Iterator i= comptesCourant.keySet().iterator();
    		while(i.hasNext()){
    			o = i.next();
    			CompteBancaire cc = (CompteBancaire) comptesCourant.get(o);
    			if((cc.getTitulaire()).equals(t)){
    					TotalDepots+=cc.getSoldeCompte();
    				}
    			}
		}
		else{
    		Iterator j= comptesEpargne.keySet().iterator();
    		while(j.hasNext()){
    			d = j.next();
    			CompteBancaire ce = (CompteBancaire) comptesEpargne.get(d);
    			if((ce.getTitulaire()).equals(t)){
    					TotalDepots+=ce.getSoldeCompte();
    				}
    		}
		}
    		return TotalDepots;

    }


    
	public int nombreOperationJour(String date) throws Throwable{
		ArrayList Operation0=new ArrayList();
		int NombreOperation=0;
		Object c = null;
		Object d = null;

		if (!_Banque.dateValide(date)) throw new Throwable ("-2.3");

	 	Iterator i= comptesCourant.keySet().iterator();
    	while(i.hasNext()){
    	c= i.next();
    	CompteBancaire cc = (CompteBancaire) comptesCourant.get(c);
    	Operation0 = cc.getOperations();
    		for(int l=0; l<Operation0.size(); l++){
    			if(date.compareTo(((OperationBancaire)(Operation0.get(l))).getDateOpe())==0)
    				NombreOperation+=1;
    			}
   			}


    	Iterator j= comptesEpargne.keySet().iterator();
    	while(j.hasNext()){
    	d= j.next();
    	CompteBancaire cc = (CompteBancaire) comptesEpargne.get(d);
    	Operation0 = cc.getOperations();
    		for(int k=0; k<Operation0.size(); k++){
    			if(date.compareTo(((OperationBancaire)(Operation0.get(k))).getDateOpe())==0)
    				NombreOperation+=1;
    			}
   			}

    	return NombreOperation;
	}



	public int nombreOperationMois(String date) throws Throwable{
		String[] parts = date.split("/");
		String dateSauv=date;
		int NombreOperation=0;
		int mois = Integer.valueOf(parts[1]);
		int annee = Integer.valueOf(parts[0]);
		Calendar now = Calendar.getInstance();

		if((mois>=1 && mois<=12) && (annee>0 && annee<now.get(Calendar.YEAR))){
			for(int i=0;i<9;i++){
				dateSauv=date+"/0"+i;
				NombreOperation+=nombreOperationJour(dateSauv);
				dateSauv=date;
			}

			for(int j=10;j<31;j++){
				dateSauv=date+"/"+j;
				NombreOperation+=nombreOperationJour(dateSauv);
				dateSauv=date;
			}
		}
		else
			throw new Throwable("mois invalide");

		return NombreOperation;

	}

	public int nombreOperationAn(String date) throws Throwable{
		int annee = Integer.valueOf(date);
		Calendar now = Calendar.getInstance();
		String dateSauv=date;
		int NombreOperation=0;

		if((annee>0 && annee<now.get(Calendar.YEAR))){
			for(int i=0;i<9;i++){
				dateSauv=date+"/0"+i;
				NombreOperation+=nombreOperationMois(dateSauv);
				dateSauv=date;
			}

			for(int j=10;j<13;j++){
				dateSauv=date+"/"+j;
				NombreOperation+=nombreOperationMois(dateSauv);
				dateSauv=date;
			}
		}
		else
			throw new Throwable("annee invalide");

		return NombreOperation;

	}


    public int nombreOperation(String date) throws Throwable{
    	String[] parts = date.split("/");
		int NombreOperation=0;

		if(parts.length<=0 || parts.length>3)
			throw new Throwable("date invalide");

		if(parts.length==3){
		 	return nombreOperationJour(date);
		}

		if(parts.length==2){
			return nombreOperationMois(date);
		}

		if(parts.length==1){
			return nombreOperationAn(date);
		}

		return 0;

    }
    }
    

