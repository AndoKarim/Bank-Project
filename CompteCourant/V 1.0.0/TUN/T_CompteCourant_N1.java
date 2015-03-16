import _Banque.CompteCourant;
import _Banque.Titulaire;

class T_CompteCourant_N1 {
	


	public static void main(String[] args) {
				 Tests.Begin("Class CompteBancaire","2.0.0");

         Tests.Design("Controle des constructeurs", 3); {
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
				
			//Test de la méthode toString		
				Tests.Case("toString");{
					Tests.Unit("Compte N°1| Solde compte: 0.0Euros|Titulaire :Inconnu,Inconnu,1972/01/01,Inconnue",Prem.toString());
					Tests.Unit("Compte N°2| Solde compte: 0.0Euros|Titulaire :STARK,Robb,1980/01/14,CastleBlack",Deux.toString());
					Tests.Unit("Compte N°3| Solde compte: 0.0Euros|Titulaire :BARATHEON,Robert,1942/10/29,01 Kings Landing",Troi.toString());
					Tests.Unit("Compte N°4| Solde compte: 0.0Euros|Titulaire :Inconnu,Inconnu,1972/01/01,Inconnue",Def.toString());
			}
         	}
         	catch(Throwable e){
				System.out.println(e.getMessage());
			}
         }

      Tests.End();  
	}	
}
