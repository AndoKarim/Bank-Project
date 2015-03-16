import _Banque.CompteCourant;
import _Banque.Titulaire;
class T_CompteCourant_N3 {
	

	public static void main(String[] args) {
			 Tests.Begin("Class CompteBancaire","2.0.0");
	
		 Tests.Design("Controle des accesseurs et constructeurs", 3); {
	 	try{
	 		
	 		//Constructeurs
	 		Titulaire num1= new Titulaire();
			Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
			Titulaire num3= new Titulaire("Baratheon","robert","1942/10/29","01 Kings Landing");
			
		//Création de comptes bancaires (constructeurs)	
			CompteCourant Prem=new CompteCourant(num1);
			CompteCourant Deux=new CompteCourant(num2);
			CompteCourant Troi=new CompteCourant(num3);
			CompteCourant Def=new CompteCourant();
			
			
				//Test de la méthode executer		
				Tests.Case("executer");{
					Deux.executer('V',150);
					Tests.Unit(150,Deux.getSoldeCompte());	
					Deux.executer('R',150);
					Tests.Unit(0,Deux.getSoldeCompte());
		
			}
	 	}
	 	
	 		
	 	catch(Throwable e){
			System.out.println(e.getMessage());
		}
	 }
	
	Tests.End(); 
	}	
}
