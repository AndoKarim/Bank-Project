import _Banque.Titulaire;

class T_Titulaire {

	public static void main(String[] args) {
		 Tests.Begin("Class Operation bancaire","2.0.0");

         Tests.Design("Controle des accesseurs et constructeurs", 3); {
         	try{
         		
         		//Constructeurs
				Titulaire num1= new Titulaire();
				Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
				Titulaire num3= new Titulaire("Baratheon","robert","1942/10/29","01 Kings Landing");
				Titulaire num4= new Titulaire("Stark","arya","1997/05/01","Winterfell");				
		
		
		
				Tests.Case("getNom");{
					Tests.Unit("Inconnu",num1.getNom());
					Tests.Unit("STARK",num2.getNom());
					Tests.Unit("BARATHEON",num3.getNom());
					Tests.Unit("STARK",num4.getNom());
				
				}
		        Tests.Case("getPrenom"); {
		        	Tests.Unit("Inconnu",num1.getPrenom());
					Tests.Unit("Robb",num2.getPrenom());
					Tests.Unit("Robert",num3.getPrenom());
					Tests.Unit("Arya",num4.getPrenom());
		         	          	
		        }
		            
		     	Tests.Case("getDateNaissance");{
		     		Tests.Unit("1972/01/01",num1.getDateNaissance());
					Tests.Unit("1980/01/14",num2.getDateNaissance());
					Tests.Unit("1942/10/29",num3.getDateNaissance());
					Tests.Unit("1997/05/01",num4.getDateNaissance());
			
			
	
				}
				
				Tests.Case("getAdresse");{
					Tests.Unit("Inconnue",num1.getAdresse());
					Tests.Unit("CastleBlack",num2.getAdresse());
					Tests.Unit("01 Kings Landing",num3.getAdresse());
					Tests.Unit("Winterfell",num4.getAdresse());
					
				}

         	}
         	catch(Throwable e){
				System.out.println("Erreur !");
			}
         }

      Tests.End();       
	}	
}
