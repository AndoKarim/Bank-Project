/**
 * @(#)T_AgenceBancaire_N1.java
 *
 *
 * @author 
 * @version 1.00 2014/5/21
 */

import _Banque.AgenceBancaire;

public class T_AgenceBancaire_N1 {

    public static void main(String [] args) {

      Tests.Begin("_Banque.AgenceBancaire", "1.0.0");

         Tests.Design("Controle des constructeurs", 3); {

            Tests.Case("Constructeur par defaut"); {
            	
            	AgenceBancaire ag0 = new AgenceBancaire();
            	
            	Tests.Unit("Agence n°0 : ---", ag0.toString());
            }

            Tests.Case("Constructeur normal"); {
            	
            	AgenceBancaire ag1 = new AgenceBancaire("221B, Baker Street, Londres");

            	Tests.Unit("Agence n°1001 : 221B, Baker Street, Londres",ag1.toString());	
            }
         }

      Tests.End();       
   }  	
}