package _Banque;
class T_CompteBancaire_A2 {
	
	public static void main(String[] args) {
		 Tests.Begin("Classe CompteBancaire","2.0.0");

         Tests.Design("Controle de la méthode executer avec anomalie", 3); {
         	Tests.Case("Montant négatif");{
	         	try{	
		         //Création titulaire	
		         	Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
		         //Création compte bancaire
		         	CompteBancaire Deux=new CompteBancaire(num2);		
					Deux.executer('V',150);	
				}
	         	catch(Throwable e){
	         		
	         		Tests.Unit("-3.3 : le montant doit etre positif",e.getMessage());
	         		}
	      		}
	      		Tests.Case("Type opé invalide");{	
	      			try{	
			         //Création titulaire	
			         	Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
			         //Création compte bancaire
			         	CompteBancaire Deux=new CompteBancaire(num2);		
						Deux.executer('O',150);	
				}
	         	catch(Throwable e){
	         		
	         		Tests.Unit("-3.2 : opération bancaire invalide sur ce type de compte",e.getMessage());
	         		}
	      		}
	      		
	      			Tests.Case("Solde inférieur au montant");{	
	      			try{	
			         //Création titulaire	
			         	Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
			         //Création compte bancaire
			         	CompteBancaire Deux=new CompteBancaire(num2);		
						Deux.executer('R',150);	
					}
		         	catch(Throwable e){
		         		
		         		Tests.Unit("-3.0 : retrait invalide par insuffisance du soldeCompte courant",e.getMessage());
		         		}
	      			}
	      			
	      			Tests.Case("Clonage du compte bancaire");{	
	      			try{	
			         //Création titulaire	
			         	Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
			         //Création compte bancaire
			         	CompteBancaire Deux=new CompteBancaire(num2);		
						Deux.clone();	
					}
		         	catch(Throwable e){
		         		
		         		Tests.Unit("-3.0 : retrait invalide par insuffisance du soldeCompte courant",e.getMessage());
		         		}
	      		
	      		
	      		
	         }

      Tests.End();  

	}	
}
