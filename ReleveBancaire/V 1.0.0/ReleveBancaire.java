package _Banque;

class ReleveBancaire {

	public static void main(String[] args) {
		try{
			//Constructeurs
	 		Titulaire num1= new Titulaire();
			Titulaire num2= new Titulaire("Snow","john","1980/01/14","CastleBlack");
			Titulaire num3= new Titulaire("Baratheon","robert","1942/10/29","01 Kings Landing");
			
		//Création de comptes bancaires (constructeurs)	
			CompteCourant Prem=new CompteCourant(num1);
			CompteCourant Deux=new CompteCourant(num2);
			CompteCourant Troi=new CompteCourant(num3);
			
		//Création d'opérations bancaires
			Deux.executer('V',150);	
			Deux.executer('R',150);
			Deux.executer('V',100000);
			Deux.executer('R',1000);
			
			Deux.releveMensuel(6);
				
				
				
			
		}
		catch(Throwable e){
			System.out.println(e.getMessage());
		}
		
		
		
		
	}	
}
