import _Banque.AgenceBancaire;
import _Banque.CompteCourant;
import _Banque.CompteEpargne;
import _Banque.Titulaire;

class T_AgenceBancaire_N5 {
	public static void main(String[] args) throws Throwable{
		Tests.Begin(" AgenceBancaire","1.0.0");{
			Titulaire T1;
			Titulaire T2;
			AgenceBancaire AB;
			int L1, L2, L3;
			Tests.Design("Tests totalDepots et nombreOperation", 3); {

    			Tests.Case("Test du totalDepot"); {
					try {
						T1 = new Titulaire("Luc","Cristol","1943/04/10","Nice");
						T2 = new Titulaire("Justine","Gauthier", "2005/06/05", "Cagnes sur mer");
						AB = new AgenceBancaire("adresse");
						L1 = AB.ouvrirCompte(T1);
						L2 = AB.ouvrirCompte(T2);
						L3 = AB.ouvrirCompte(T1,0.3f);
			
						AB.executer(L1,'V',"Versement 1",200f);
						AB.executer(L1,'R',"Retrait 1",50f);
						AB.executer(L2,'V',"Versement 2",200f);
						AB.executer(L2,'R',"Retrait 2",200f);
						AB.executer(L3,'V',"Versement 3",100f);
						AB.executer(L3,'V',"Versement 4",100f);
						AB.executer(L3,'V',"Versement 5",100f);
					
					
						Tests.Unit(150.0, AB.totalDepots(T1,'c'));
						Tests.Unit(0.0, AB.totalDepots(T2,'c'));
						Tests.Unit(300.0, AB.totalDepots(T1,'e'));
			
					}
					catch(Throwable e){
					throw new Throwable(e.getMessage());
					}
    			}
    			
    			
    			
    		Tests.Case("Test du nombre d'operation par jour"); {
					try {
						AB = new AgenceBancaire("Nice");
						T1 = new Titulaire("CRISTOL", "Luc", "1994/04/03", "Nice");
						T2 = new Titulaire("GAUTHIER", "Justine", "1995/06/29", "Cagnes");
						int NT1=AB.ouvrirCompte(T1);
						int NT2=AB.ouvrirCompte(T2);
						int NT3=AB.ouvrirCompte(T2);
						int NT4=AB.ouvrirCompte(T1,1);

						AB.executer(NT1,'V', "Versement de 150€", 150f);
						AB.executer(NT2,'V', "Versement de 100€", 100f);
						AB.executer(NT3,'V', "Versement de 150€", 150f);
						AB.executer(NT4,'V', "Versement de 100€", 100f);

						Tests.Unit(4, AB.nombreOperation("2014/06/04"));


					}
					catch(Throwable e){
					throw new Throwable(e.getMessage());
					}
    			}
			}
		}
		Tests.End();

	}
}
