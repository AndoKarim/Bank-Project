import _Banque.Banque;
/**
 * @(#)Banque.java
 *
 *
 * @author ANDOLERZAK 
 * * @version 1.00 2014/6/04
 */



public class T_Banque_N2 {

    public static void main(String [] args) {

      Tests.Begin("_Banque.Banque", "1.0.0");

         Tests.Design("Controle des accesseurs", 3); {

            Tests.Case("getNomBanque"); {
            	
            	Banque b1 = new Banque();
            	Banque b2 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	Banque b3 = new Banque("Banque de France","Paris",12345,32165498774124d);
            	
            	Tests.Unit("Banque",b1.getNomBanque());
            	Tests.Unit("Banque de Fer",b2.getNomBanque());
            	Tests.Unit("Banque de France",b3.getNomBanque());

            }
              Tests.Case("getCodeBanque"); {
              		
            	Banque b1 = new Banque();
            	Banque b2 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	Banque b3 = new Banque("Banque de France","Paris",12345,32165498774124d);
            	
            	Tests.Unit(0,b1.getCodeBanque());
            	Tests.Unit(15032,b2.getCodeBanque());
            	Tests.Unit(12345,b3.getCodeBanque());
            	

            }
              Tests.Case("getAdresseBanque"); {
            	
            	Banque b1 = new Banque();
            	Banque b2 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	Banque b3 = new Banque("Banque de France","Paris",12345,32165498774124d);
            	
            	Tests.Unit("Inconnue",b1.getAdresseBanque());
            	Tests.Unit("Braavos",b2.getAdresseBanque());
            	Tests.Unit("Paris",b3.getAdresseBanque());

            }
              Tests.Case("getNumeroSIRET"); {
            	
            	Banque b1 = new Banque();
            	Banque b2 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	Banque b3 = new Banque("Banque de France","Paris",12345,32165498774124d);
            	
            	Tests.Unit(0,b1.getNumeroSIRET());
            	Tests.Unit(1234567893214d,b2.getNumeroSIRET());
            	Tests.Unit(32165498774124d,b3.getNumeroSIRET());

            }
              Tests.Case("getRegions"); {
            	
            	Banque b2 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	b2.creerRegion("PACA");
            	
            	Tests.Unit(1,b2.getRegions().size());
            	
            	b2.creerRegion("Aquitaine");
            	
            	Tests.Unit(2,b2.getRegions().size());
            	
            	

            }
              Tests.Case("getRegistreAgences"); {
            	
            	Banque b2 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	Tests.Unit(1001,b2.getRegistreAgences());
            	
            	

            }
              Tests.Case("getRegistreComptesCourants"); {
            	
            	Banque b1 = new Banque();

            }
              Tests.Case("getRegistreComptesEpargne"); {
            	
            	Banque b1 = new Banque();

            }
       }

      Tests.End();       
   
    }
}