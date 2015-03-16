import _Banque.*;

public class T_AgenceBancaire_N4 {
	
	public static void main(String[] args) {
		Tests.Begin("Agence bancaire : nombreClient et nombreCompte","1.0.0");{
					AgenceBancaire AB;
					Titulaire T1;
					Titulaire T2;
					long L1,L2,L3,L4;
		     Tests.Design("Controle des nombreClient et nombreCompte", 3); {
         	
				Tests.Case("nombreClients",3);{
					try{
						AB = new AgenceBancaire("Nice");
						T1 = new Titulaire("CRISTOL", "Luc", "1994/04/03", "Nice");
						T2 = new Titulaire("GAUTHIER", "Justine", "1995/06/29", "Cagnes");
						L1 = AB.ouvrirCompte(T1);
						L2 = AB.ouvrirCompte(T2);
						L3 = AB.ouvrirCompte(T1,1);
						L4 = AB.ouvrirCompte(T2,03);
						
						Tests.Unit(2,AB.nombreClients());
					}
					catch(Throwable e){
						System.out.println(e.getMessage());
    				}
				}
				
			Tests.Case("nombreCompte",3);{
					try{
						AB = new AgenceBancaire("Nice");
						T1 = new Titulaire("CRISTOL", "Luc", "1994/04/03", "Nice");
						T2 = new Titulaire("GAUTHIER", "Justine", "1995/06/29", "Cagnes");
						AB.ouvrirCompte(T1);
						AB.ouvrirCompte(T2);
						AB.ouvrirCompte(T2);
						AB.ouvrirCompte(T1,1);
						AB.ouvrirCompte(T1,0.3f);
						AB.ouvrirCompte(T2,0.3f);
						
						Tests.Unit(1,AB.nombreComptes(T1,'c'));
						Tests.Unit(2,AB.nombreComptes(T2,'c'));
						Tests.Unit(2,AB.nombreComptes(T1,'e'));
						Tests.Unit(1,AB.nombreComptes(T2,'e'));
					}
					catch(Throwable e){
						System.out.println(e.getMessage());
    				}
				}
			}
         }
	Tests.End();  
	}
}