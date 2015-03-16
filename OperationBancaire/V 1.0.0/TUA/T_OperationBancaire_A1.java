package _Banque;
class T_OperationBancaire_A1 {

	public static void main(String[] args) {
		Tests.Begin("Classe CompteBancaire","2.0.0");

         Tests.Design("Controle des constructeurs avec anomalie", 3); {
      			Tests.Case("Type op�ration invalide");{
		         	try{
		         		
						
					//Cr�ation de comptes bancaires (constructeurs)	
						OperationBancaire Prem=new OperationBancaire('J',"Neutre",135);
						
							}
		         	catch(Throwable e){
		         	
		         		Tests.Unit("Le type d'operation est incorrect",e.getMessage());
		         		}
				}
					Tests.Case("Intitul� trop grand");{
		         	try{
		         		
						
					//Cr�ation de comptes bancaires (constructeurs)	
						OperationBancaire Seco=new OperationBancaire('V',"AZaqqsiodjqsdiojqsoidjqsoijdqsoijqsdoijqsoidjsoidfjsdofidazsod",165);
							}
		         	catch(Throwable e){
		         	
		         		Tests.Unit("L'intitule ne doit pas depasser 40 caracteres",e.getMessage());
		         		}
				}
					Tests.Case("Montant n�gatif");{
		         	try{
		         		
						
					//Cr�ation de comptes bancaires (constructeurs)	
						OperationBancaire Prem=new OperationBancaire('V',"Neutre",-156);
							}
		         	catch(Throwable e){
		         	
		         		Tests.Unit("Le montant ne peut etre negatif",e.getMessage());
		         		}
				}
         }

      Tests.End();  
		
	}	
}
