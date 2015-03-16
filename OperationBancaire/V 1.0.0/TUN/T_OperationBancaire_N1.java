import _Banque.OperationBancaire;


//
// IUT de Nice / Departement informatique / Module APO Java
// Annee 2013_2014 - Classes de _Banque
//
// Classe String - Tests unitaires de la méthode valueOf() 
//						et un float en paramètre
//                  (cas nominaux)
//
// Auteur : ANDOLERZAK 
//
class T_OperationBancaire {

 public static void main (String[] args) {
		
     	 Tests.Begin("Class Operation bancaire","2.0.0");

         Tests.Design("Controle des accesseurs et constructeurs", 3); {
         	try{
         		
         		//Constructeurs
				OperationBancaire Prem=new OperationBancaire('N',"Neutre",135);
				OperationBancaire Seco=new OperationBancaire('V',"Virement",165);
				OperationBancaire Trois=new OperationBancaire('R',"Retrait",125689);
				OperationBancaire Quatr=new OperationBancaire('I',"Remunération",2248);
				
				OperationBancaire Def=new OperationBancaire();
				Tests.Case("getTypeOpe");{
				
					Tests.Unit('N',Prem.getTypeOpe());
					Tests.Unit('V',Seco.getTypeOpe());
					Tests.Unit('R',Trois.getTypeOpe());
					Tests.Unit('I',Quatr.getTypeOpe());
					Tests.Unit('N',Def.getTypeOpe());
				}
		        Tests.Case("getMontantOpe"); {
		          	Tests.Unit(135,Prem.getmontantOp());
		          	Tests.Unit(165,Seco.getmontantOp());	
		          	Tests.Unit(125689,Trois.getmontantOp());	
		          	Tests.Unit(2248,Quatr.getmontantOp());
		          	Tests.Unit(0,Def.getmontantOp());		          	
		        }
		            
		     	Tests.Case("getIntituOpe");{
			
					Tests.Unit("Neutre",Prem.getIntituOpe());
					Tests.Unit("Virement",Seco.getIntituOpe());
					Tests.Unit("Retrait",Trois.getIntituOpe());
					Tests.Unit("Remunération",Quatr.getIntituOpe());
					Tests.Unit("Neutre",Def.getIntituOpe());
	
				}
				
				Tests.Case("getDateOpe");{
					Tests.Unit("2014/05/03",Prem.getDateOpe());
					Tests.Unit("2014/05/03",Seco.getDateOpe());
					Tests.Unit("2014/05/03",Trois.getDateOpe());
					Tests.Unit("2014/05/03",Quatr.getDateOpe());
					Tests.Unit("2014/05/03",Def.getDateOpe());
					
				}
				Tests.Case("getNumOpe");{
					Tests.Unit(1000001, Prem.getNumOpe());
					Tests.Unit(1000002, Seco.getNumOpe());
					Tests.Unit(1000003, Trois.getNumOpe());
					Tests.Unit(1000004, Quatr.getNumOpe());
					Tests.Unit(1000005, Def.getNumOpe());
					
				}
				Tests.Case("toString");{
					Tests.Unit("Operation N°=1000001:Versement de 135.0 Euros le 2014/05/03", Prem.toString());
					Tests.Unit("Operation N°=1000002:Versement de 165.0 Euros le 2014/05/03", Seco.toString());
					Tests.Unit("Operation N°=1000003:Versement de 125689.0 Euros le 2014/05/03", Trois.toString());
					Tests.Unit("Operation N°=1000004:Versement de 2248.0 Euros le 2014/05/03", Quatr.toString());
					Tests.Unit("Operation N°=1000005:Versement de 0.0 Euros le 2014/05/03", Def.toString());
				}

         	}
         	catch(Throwable e){
				System.out.println("Erreur !");
			}
         }

      Tests.End();       
   }
}

