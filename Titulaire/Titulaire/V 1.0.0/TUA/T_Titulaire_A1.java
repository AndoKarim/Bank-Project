import _Banque.Titulaire;
class T_Titulaire_A1 {
	
	public static void main(String[] args) {
		 Tests.Begin("Classe Titulaire","2.0.0");

         Tests.Design("Controle des constructeurs avec anomalie", 3); {
      		Tests.Case("Titulaire");{
         	try{
         		
				
			//Création de comptes bancaires (constructeurs)	
				Titulaire num2= new Titulaire("Stark","robb","2018/01/14","CastleBlack");
				
					}
         	catch(Throwable e){
         		
         		Tests.Unit("La date de naissance n'est pas valide",e.getMessage());
         		}
			}
         }

      Tests.End();  
	}	
}
