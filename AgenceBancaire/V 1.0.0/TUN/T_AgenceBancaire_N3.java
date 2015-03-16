import _Banque.AgenceBancaire;
import _Banque.Titulaire;

public class T_AgenceBancaire_N3 {
	
	public static void main(String[] args) {
				 Tests.Begin("Class AgenceBancaire","1.0.0");

         Tests.Design("Controle des methodes Ouvrir, Fermer compte et executer operation", 3); {
         	try{
         		
         		//Constructeurs
         		Titulaire num1= new Titulaire();
				Titulaire num2= new Titulaire("Stark","robb","1980/01/14","CastleBlack");
				Titulaire num3= new Titulaire("Baratheon","robert","1942/10/29","01 Kings Landing");
			
				AgenceBancaire A1=new AgenceBancaire("Iron Bank");
				int	C1=A1.ouvrirCompte(num1);
				int	C2=A1.ouvrirCompte(num2);
				
					
					Tests.Case("OuvrirCompte",3);{
					
						Tests.Unit(80000003,A1.ouvrirCompte(num1));
						Tests.Unit(80000004,A1.ouvrirCompte(num2));
						Tests.Unit(80000005,A1.ouvrirCompte(num3));
						
						Tests.Unit(40000001,A1.ouvrirCompte(num1,0.1f));
						Tests.Unit(40000002,A1.ouvrirCompte(num2,0.1f));
						Tests.Unit(40000003,A1.ouvrirCompte(num3,0.1f));
					}
				
					Tests.Case("Executer",3);{
						Tests.Unit(150,A1.executer(C1,'V',"Versement",150f));
						Tests.Unit(300,A1.executer(C1,'V',"Versement2",150f));
						Tests.Unit(0,A1.executer(C1,'R',"Retrait",300f));
					}
					
					Tests.Case("fermerCompte",3);{
						Tests.Unit(0,A1.nombreComptesFermes());
						A1.fermerCompte(C1);
						Tests.Unit(1,A1.nombreComptesFermes());
						A1.fermerCompte(C2);
						Tests.Unit(2,A1.nombreComptesFermes());
						
						
					}
         	}
         		catch(Throwable e){
				System.out.println(e.getMessage());
			}
         }
	Tests.End();  
	}
}