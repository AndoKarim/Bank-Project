/**
 * @(#)T_AgenceBancaire_N2.java
 *
 *
 * @author 
 * @version 1.00 2014/5/21
 */

import _Banque.AgenceBancaire;

public class T_AgenceBancaire_N2 {

    public static void main(String [] args) {

      Tests.Begin("_Banque.AgenceBancaire", "1.0.0");

         Tests.Design("Controle accesseurs de consultation", 3); {
         	
         	AgenceBancaire ag0 = new AgenceBancaire();
            	
            AgenceBancaire ag1 = new AgenceBancaire("221B, Baker Street, Londres");
            	
            AgenceBancaire ag2 = new AgenceBancaire("222B, Baker Street, Londres");
            	
            AgenceBancaire ag3 = new AgenceBancaire("223B, Baker Street, Londres");

            Tests.Case("Methode getNumeroGuichet"); {
            	
            	Tests.Unit(0, ag0.getNumeroGuichet());
            	
            	Tests.Unit(1001, ag1.getNumeroGuichet());
            	
            	Tests.Unit(1002, ag2.getNumeroGuichet());
            	
            	Tests.Unit(1003, ag3.getNumeroGuichet());
            }
            
            Tests.Case("Methode getAdresseAgence"); {
            	
            	Tests.Unit("---", ag0.getAdresseAgence());
            	
            	Tests.Unit("221B, Baker Street, Londres", ag1.getAdresseAgence());
            	
            	Tests.Unit("222B, Baker Street, Londres", ag2.getAdresseAgence());
            	
            	Tests.Unit("223B, Baker Street, Londres", ag3.getAdresseAgence());	
            }
            
            Tests.Case("Methode nombreComptes"); {
            	
            	Tests.Unit(0, ag0.nombreComptes());
            	
            	Tests.Unit(0, ag1.nombreComptes());
            	
            	Tests.Unit(0, ag2.nombreComptes());
            	
            	Tests.Unit(0, ag3.nombreComptes());	
            }
            
            Tests.Case("Methode nombreComptesCourant"); {
            	
            	Tests.Unit(0, ag0.nombreComptesCourant());
            	
            	Tests.Unit(0, ag1.nombreComptesCourant());
            	
            	Tests.Unit(0, ag2.nombreComptesCourant());
            	
            	Tests.Unit(0, ag3.nombreComptesCourant());	
            }
            
            Tests.Case("Methode nombreComptesEpargne"); {
            	
            	Tests.Unit(0, ag0.nombreComptesEpargne());
            	
            	Tests.Unit(0, ag1.nombreComptesEpargne());
            	
            	Tests.Unit(0, ag2.nombreComptesEpargne());
            	
            	Tests.Unit(0, ag3.nombreComptesEpargne());	
            }
            
            Tests.Case("Methode nombreComptesFermes"); {
            	
            	Tests.Unit(0, ag0.nombreComptesFermes());
            	
            	Tests.Unit(0, ag1.nombreComptesFermes());
            	
            	Tests.Unit(0, ag2.nombreComptesFermes());
            	
            	Tests.Unit(0, ag3.nombreComptesFermes());	
            }
         }

      Tests.End();       
   }  	
}