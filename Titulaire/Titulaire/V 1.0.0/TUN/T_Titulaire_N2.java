import _Banque.Titulaire;
class T_Titulaire_N2 {

	public static void main(String[] args) {
		 Tests.Begin("Class Operation bancaire","2.0.0");

         Tests.Design("Controle des accesseurs et constructeurs", 3); {
         	try{
         		
         		//Constructeurs
				Titulaire num1= new Titulaire();
				Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
				Titulaire num3= new Titulaire("Baratheon","robert","1942/10/29","01 Kings Landing");
				Titulaire num4= new Titulaire("Stark","arya","1997/05/01","Winterfell");				
		
		
		
				Tests.Case("toString");{
					Tests.Unit("Titulaire :Inconnu,Inconnu,1972/01/01,Inconnue",num1.toString());
					Tests.Unit("Titulaire :STARK,Robb,1980/01/14,CastleBlack",num2.toString());
					Tests.Unit("Titulaire :BARATHEON,Robert,1942/10/29,01 Kings Landing",num3.toString());
					Tests.Unit("Titulaire :STARK,Arya,1997/05/01,Winterfell",num4.toString());
				
				}
		  	    Tests.Case("modifierAdresse"); {
		  	    	//Avant modification adresse
		        	Tests.Unit("Inconnue",num1.getAdresse());
		        	//Après modification adresse
		        	Titulaire.modifierAdresse(num1,"Dorne");
		        	Tests.Unit("Dorne",num1.getAdresse());
				
		         	          	
		        }

         	}
         	catch(Throwable e){
				System.out.println("Erreur !");
			}
         }

      Tests.End();       
	}	
}
