package _Banque;

class CompteCourant {
	
	public static void main(String[] args) {
		 Tests.Begin("Classe CompteBancaire","2.0.0");
			
         Tests.Design("Controle des constructeurs avec anomalie", 3); {
         
         //Cr�ation titulaire
			Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
			
		//Cr�ation de comptes bancaires (constructeurs)	
			CompteBancaire Deux=new CompteBancaire(num2);
      		
      		Tests.Case("Montant n�gatif");{
	         	try{		
				//Ex�cuter
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
