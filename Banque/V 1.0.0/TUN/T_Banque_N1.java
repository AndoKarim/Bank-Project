import _Banque.Banque;
/**
 * @(#)Banque.java
 *
 *
 * @author ANDOLERZAK
 * * @version 1.00 2014/6/04
 */



public class T_Banque_N1 {

    public static void main(String [] args) {

      Tests.Begin("_Banque.Banque", "1.0.0");

         Tests.Design("Controle des constructeurs", 3); {

            Tests.Case("Constructeur par defaut"); {
            	
            	Banque b1 = new Banque();
            	
            	Tests.Unit("Banque n° : 0 , Banque , Inconnue", b1.toString());
            }

            Tests.Case("Constructeur normal"); {
            	
            	Banque b1 = new Banque("Banque de Fer","Braavos",15032,1234567893214d);
            	Banque b2 = new Banque("Banque de France","Paris",12345,32165498774124d);

            	Tests.Unit("Banque n° : 15032 , Banque de Fer , Braavos",b1.toString());
            	Tests.Unit("Banque n° : 12345 , Banque de France , Paris",b2.toString());	
            }
         }

      Tests.End();       
   }  	
}