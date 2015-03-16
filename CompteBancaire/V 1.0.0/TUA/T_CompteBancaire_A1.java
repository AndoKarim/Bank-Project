package _Banque;

class CompteCourant {
	
	public static void main(String[] args) {
		 Tests.Begin("Classe CompteBancaire","2.0.0");
			
         Tests.Design("Controle des constructeurs avec anomalie", 3); {
         
         //Création titulaire
			Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
			
		//Création de comptes bancaires (constructeurs)	
			CompteBancaire Deux=new CompteBancaire(num2);
      		
      		Tests.Case("Montant négatif");{
	         	try{		
				//Exécuter
					Deux.executer('V',-150);
					
					}
	         	catch(Throwable e){
	         		
	         		Tests.Unit("Le titulaire inscrit n'est pas correct",e.getMessage());
	         		}
      		}	
         }

      Tests.End();  

	}	
}
