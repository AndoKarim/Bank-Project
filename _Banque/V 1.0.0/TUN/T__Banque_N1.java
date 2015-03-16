package _Banque;
class T__Banque_N1 {

	public static void main(String[] args) {
		 Tests.Begin("Class CompteBancaire","2.0.0");

         Tests.Design("Controle des accesseurs et constructeurs", 3); {
         try{
         
	         //Création des dates
	        	 //String date1="1955/02/10"; //année trop basse
		         String date2="1955/02/60";	//Jour trop grand
		         String date3="1955/60/10";	//Mois trop grand
		         String date4="3000/02/10";	//Année trop grande
		         String date5="2005/02/30";	//30 février impossible
		         String date6="2009/03/10";	//Date valide
	                  	
			//Test de la méthode numeroRegistreOp
				Tests.Case("numeroRegistreOp");{
					Tests.Unit(1000001,_Banque.numeroRegistreOp());
					Tests.Unit(1000002,_Banque.numeroRegistreOp());
					Tests.Unit(1000003,_Banque.numeroRegistreOp());
					Tests.Unit(1000004,_Banque.numeroRegistreOp());
				}
			//Test de la méthode numeroRegistreCpt
				Tests.Case("numeroRegistreCpt");{
					Tests.Unit(1,_Banque.numeroRegistreCptCourant());
					Tests.Unit(2,_Banque.numeroRegistreCptCourant());
					Tests.Unit(3,_Banque.numeroRegistreCptCourant());
					Tests.Unit(4,_Banque.numeroRegistreCptCourant());
				}
			//Test de la méthode dateJour
				Tests.Case("dateJour");{
					Tests.Unit("2014/05/06",_Banque.dateJour());
				}
			//Test de la méthode dateValide
				Tests.Case("dateValide");{
				//	Tests.Unit(false,_Banque.dateValide(date1));
					Tests.Unit(false,_Banque.dateValide(date2));
					Tests.Unit(false,_Banque.dateValide(date3));
					Tests.Unit(false,_Banque.dateValide(date4));
					Tests.Unit(false,_Banque.dateValide(date5));
					Tests.Unit(true,_Banque.dateValide(date6));
				}
				
	         }
	         catch(Throwable e){
				System.out.println(e.getMessage());
			}
	         	
         }

      Tests.End();  
	}	
}
