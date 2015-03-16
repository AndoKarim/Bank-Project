import _Banque.CompteCourant;
import _Banque.Titulaire;
class T_CompteCourant_N2 {
	

	public static void main(String[] args) {
		 Tests.Begin("Class CompteCourant","2.0.0");
	
		 Tests.Design("Controle des accesseurs", 3); {
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
		
			//Test de la méthode getTitulaire
				Tests.Case("getTitulaire");{
					Tests.Unit("Titulaire :STARK,Robb,1980/01/14,CastleBlack", Deux.getTitulaire().toString());
					Tests.Unit("Titulaire :Inconnu,Inconnu,1972/01/01,Inconnue", Prem.getTitulaire().toString());
					Tests.Unit("Titulaire :Inconnu,Inconnu,1972/01/01,Inconnue",Def.getTitulaire().toString());
				}
			//Test de la méthode getNumeroCompte	
		        Tests.Case("getNumeroCompte"); {      	
			        Tests.Unit(80000001,Prem.getNumeroCompte());	 
			        Tests.Unit(80000002,Deux.getNumeroCompte());
			        Tests.Unit(80000003,Troi.getNumeroCompte());
			        Tests.Unit(80000004,Def.getNumeroCompte());   	        	   	
		        }
		    //Test de la méthode getSoldeCompte   
				Tests.Case("getSoldeCompte");{
					Tests.Unit(0,Prem.getSoldeCompte());
					Tests.Unit(0,Deux.getSoldeCompte());
					Tests.Unit(0,Troi.getSoldeCompte());
					Tests.Unit(0,Def.getSoldeCompte());
				}	
			//Test de la méthode modiferAdresse   
				Tests.Case("modifierAdresse");{
					Prem.modifierAdresse("Le Val");
					Deux.modifierAdresse("Mort");
					
					Tests.Unit("Le Val",Prem.getTitulaire().getAdresse());
					Tests.Unit("Mort",Deux.getTitulaire().getAdresse());
					
				}		
	 	}
	 	catch(Throwable e){
			System.out.println(e.getMessage());
		}
	 }
	
	Tests.End();  

	}	
}
