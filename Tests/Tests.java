
//
// IUT de Nice / Departement informatique / Module APO-Java
// Annee 2013_2014 - Composants generiques
//
// Classe Tests - Utilitaires de tests unitaires
//
// Edition B         : edition initiale
//
//    + Version 2.0.0    : version initiale complete
//    + Version 2.0.1    : formattage des commentaires pour impression
//    + Version 2.1.0    : correction du bug verboseLevel (ligne 111)
//                         + correction du bug statusDesign (ligne 100)
//                         + la classe devient abstraite
//    + Version 2.2.0    : modification de la methode Unit pour gerer
//                         les references nulles
//                         + suppression de la methode main (module de
//                           tests unitaires externalise)
//    + Version 2.3.0    : introduction d'une extension de la methode
//    + Version 2.4.0    : Case prise en compte des types primitifs int
//                         et double par la methode Unit
//    + Version 2.5.0    : introduction d'une forme polymorphe de la
//                         methode Unit pour autoriser une marge d'erreur
//    + Version 2.6.0    : introduction d'une forme polymorphe de la
//                         methode Unit pour autoriser le controle global
//                         de deux tableaux pris dans leur ensemble
//    + Version 2.7.0    : introduction d'une forme polymorphe de la
//                         methode Unit pour autoriser le controle du
//                         type primitif boolean
//    + Version 2.8.0    : introduction d'un niveau 4 de visualisation
//                         (correction de l'IE_1 S2T - 2011/2012)
//    + Version 2.9.0    : introduction d'une forme polymorphe de la
//                         methode Unit pour controler une valeur obtenue 
//                         par rapport a un tableau de valeurs possibles
//                         (correction de l'IE_2 S2D - 2013/2014)
//
// Edition C         : elaboration et enregistrement des rapports de tests
//
//    + Version 3.0.0    : historisation de tous les messages ecran 
//                         + enregistrement final dans un fichier designe
//                           par le parametre effectif de la signature
//                           ad hoc de la methode End
/**
 *
 * La classe Tests fournit un ensemble complet de services destines à 
 * simplifier et a uniformiser la mise en oeuvre de la charte de 
 * realisation des modules de tests unitaires exposee en cours. La 
 * classe est egalement utilisee en TD comme un exemple tres concret 
 * de codes sources "ecrits par d'autres".
 *
 * Les services fournis sont :
 *
 * Begin    : debut d'execution des tests unitaires de la classe cible,
 * Design   : executer un "test design",
 * Case     : executer un "test case",
 * Unit     : executer un "test unit",
 * End      : fin d'execution des tests unitaires de la classe cible.
 *
 * La classe produit une visualisation standardisee de tous les services
 * executes et un rapport de tests final designe par le parametre effectif
 * de la signature ad hoc de la methode End  (rapport enregistre dans le 
 * repertoire courant).
 * 
 * @author Alain Thuaire - Universite de Nice/IUT - Departement informatique
 *
**/
import java.util.*;
import java.io.*;

abstract public class Tests {
private static int levelDesign;		// Numero d'ordre du test_design 
private static int levelCase;		// Numero d'ordre du test_case
private static int levelUnit;		// Numero d'ordre du test_unit
private static int verboseLevel;	// Niveau courant de visualisation
private static int statusDesign;	// CR du test_design courant
private static int statusCase;		// CR de test_case courant
private static boolean testBegin;	// Indicateur execution Begin
private static String  designName;	// Nom du test design courant;
private static String  caseName;	// Nom du test case courant;

private static ArrayList rapport;

/**
 *
 * La methode Begin visualise la ligne d'entete du module de tests 
 * unitaires.
 * 
**/
   public static void Begin (String name, String version) {
   	  
   	  rapport= new ArrayList();
      visuEntete(name, version);	// Visualiser entete des tests
      testBegin=true;			    // Service Begin execute
   }

/**
 *
 * La methode End visualise d'abord le compte rendu (CR) du dernier 
 * "test case" et/ou du dernier "test design" du module, en fonction 
 * du niveau de visualisation courant (attribut verboseLevel).
 *
 * Seuls les CR non nuls sont visualises.
 *
 * La methode End visualise ensuite la ligne de cloture du module de 
 * tests unitaires, si et seulement si ce dernier s'est termine 
 * globalement avec succes. Dans la charte, un "test design" (y compris
 * le dernier) n'est execute que si le précédent se termine avec succes 
 * (CR=0).
 *
 * La seconde signature de la methode enregistre l'historique des messages
 * ecran (rapport de tests) dans le fichier designe par son parametre.
 * 
**/
   public static void End () {
   String lastLine;
   lastLine= "\n------------------------------------------------------------\n";
      
      // Visualiser le CR dernier test case et dernier test design
   	  //
      visuCR("Case"); visuCR("Design"); 
      
      // Visualiser la ligne de cloture des tests unitaires
   	  //
      if (statusDesign == 0) {
         System.out.println(lastLine);
         rapport.add(lastLine);
      }
      else {
         System.out.println();
         rapport.add("\n");
      }
   }
   
   public static void End (String chemin) {
      
      Tests.End();
      
      // Controler la validite du parametre
      //
      if (chemin == null) System.exit(1);
      if (chemin.equals("")) System.exit(1);
      if (chemin.lastIndexOf('*') != -1) System.exit(1);
      if (chemin.lastIndexOf('?') != -1) System.exit(1);
      
      // Enregistrer le rapport de tests
      //
      Tests.Store(rapport, chemin);
      
      // Gerer le cas du dernier test design en anomalie
      //
      if (statusDesign != 0) System.exit(statusDesign);
   }

/**
 *
 * La méthode Design visualise d'abord le compte rendu (CR) du dernier 
 * "test case" et/ou du dernier "test design" exécutes, en fonction du 
 * niveau de visualisation courant (attribut verboseLevel).
 *
 * La methode renseigne ensuite les attributs du "test design" et le 
 * niveau requis de visualisation (second paramètre).
 *
 * La methode visualise pour terminer la ligne d'entete des "test 
 * design".
 * 
**/
   public static void Design (String name, int level) {
   	
      // Controler les conditions initiales requises par la charte
      //
      if (!valid("Begin")) System.exit(1);
      
      // Visualiser le CR du test case et du test design precedents
      //
      visuCR("Case"); visuCR("Design"); 
      
      // Controler que le status OK du test design precedent
      //
      if (statusDesign != 0) System.exit(1);

      // Initialiser les attributs du test design
      //
      levelCase   =0;
      statusCase  =0;
      statusDesign=0;
      designName  =name;
      levelDesign++;
      levelUnit=0;
      
      // Controler et affecter le nouveau niveau de visualisation
      //
      verboseLevel=level;
      if (level > 4) verboseLevel=4;
      if (level < 0) verboseLevel=0;
      
      // Visualiser la ligne d'entete du nouveau test design
      //   
      visuEntete(name);
   }
/**
 *
 * La methode Case visualise d'abord le compte rendu (CR) du dernier
 * "test case" execute, en fonction du niveau de visualisation courant 
 * (attribut verboseLevel).
 *
 * La methode renseigne ensuite les attributs du "test case".
 *
 * La methode visualise pour terminer la ligne d'entete des "test cases".
 * 
**/
   public static void Case (String name) {
      
      // Controler les conditions initiales requises par la charte
      //
      if (!valid("Begin") || !valid("Design"))  System.exit(1);

      // Visualiser le CR du dernier test case execute
      //  
      visuCR("Case");
      
      // Initialiser les attributs du nouveau test case
      // 
      caseName=name;
      levelCase++;
      
      // Visualiser la ligne d'entete du nouveau test case
      //  
      visuEntete();
   }
   
   public static void Case (String name, int level) {
      
      // Modifier le niveau verbose courant
      //  
      verboseLevel=level;
      if (level > 4) verboseLevel=4;
      if (level < 0) verboseLevel=0;
      
      // Appliquer la methode d'origine
      // 
      Case(name); 
   }
   
 
 /**
 *
 * La methode Unit visualise d'abord les deux messages standard d'un 
 * test elementaire, en fonction du niveau de visualisation courant 
 * (attribut verboseLevel).
 *
 * La methode elabore pour terminer les CR du "test case" et du "test
 * design" courant. 
 *
**/ 
   
   public static void Unit (int attendu, int obtenu) {

      // Effectuer un "boxing" des deux parametres
      //
      Unit(new Integer(attendu), new Integer(obtenu));	  
   }
   
   public static void Unit (double attendu, double obtenu) {

      // Effectuer un "boxing" des deux parametres
      //
      Unit(new Double(attendu), new Double(obtenu));	
   }
   
   public static void Unit (boolean attendu, boolean obtenu) {

      // Effectuer un "boxing" des deux parametres
      //
      Unit(new Boolean(attendu), new Boolean(obtenu));	  
   }

   public static void Unit (double attendu, double obtenu, double epsilon) {

      // Controler les conditions initiales requises par la charte
      //
      if (!valid("Begin") || !valid("Design") || !valid("Case")) System.exit(1);	  
  
      // Visualiser les messages du test de ce niveau
      // 
      visuEntete(new Double(attendu), new Double(obtenu));

      // Elaborer le CR du test case courant
      //  
      if (statusCase != 0) return;
      if (Math.abs(attendu-obtenu) > Math.abs(epsilon)) statusCase=levelCase;

      // Elaborer le CR du test design courant
      //  
      if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
      
      // Incrementer le total courant des tests unit
      //  
      levelUnit++;
   }
   
   public static void Unit (Object[] attendu, Object[] obtenu) {

      // Controler les conditions initiales requises par la charte
      //
      if (!valid("Begin") || !valid("Design") || !valid("Case")) System.exit(1);	  
  
      // Visualiser les messages du test de ce niveau
      // 
      visuEntete(attendu, obtenu);

      // Elaborer le CR du test case courant
      // 
      if (statusCase != 0 ||(obtenu==null && attendu ==null)) {
         levelUnit++;
         return;
      }
      
      if((obtenu==null && attendu !=null) ||
         (obtenu!=null && attendu ==null)    )  statusCase=levelCase;
         
      else {
      	      
      	 String classeAttendue, classeObtenue;
      	  
      	 // Traiter le cas de tableaux de tailles differentes
      	 //
      	 if (attendu.length != obtenu.length) statusCase=levelCase;
      	
      	 // Analyser tous les elements deux a deux
      	 //
         else for (int i=0;i <attendu.length; i++) {
         	
                 // Traiter le cas particulier de deux references nulles
                 //
                 if (attendu[i] == null && obtenu[i] == null) continue;
            
                 // Traiter le cas particulier d'une reference nulle seulement
                 //
        	 if ((attendu[i]== null && obtenu[i] != null)  ||
           	     (attendu[i] != null && obtenu[i] == null)) {
                    statusCase=levelCase;
           	    break;
           	 }
           	
           	 // Controler les deux classes d'origine
           	 //
           	 classeAttendue= attendu[i].getClass().getName();
           	 classeObtenue = obtenu[i].getClass().getName();
           	 if (!classeAttendue.equals(classeObtenue)) {
           	    statusCase=levelCase;
           	    break;
           	 }
           	
           	 // Controler les deux valeurs courantes de rang identique
           	 //
                if (!attendu[i].equals(obtenu[i])) {
           	    statusCase=levelCase;
           	    break;
           	 }
          }
      }
      
      // Elaborer le CR du test design courant
      //  
      if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
      
      // Incrementer le total courant des tests unit
      //  
      levelUnit++;
   }
   
   public static void Unit (Object[] possibles, Object obtenu) {

      // Controler les conditions initiales requises par la charte
      //
      if (!valid("Begin") || !valid("Design") || !valid("Case")) System.exit(1); 
  
      // Formatter une visualisation des valeurs possibles
      // 
      String attendu= "[";
      int cardinal= 0;
      
      if (possibles == null) attendu= "null";
      else {
         cardinal= possibles.length;
         
         for (int i=0; i<cardinal-1; i++ ) {
           	if (possibles[i] == null) attendu += "null" + "|";
           	else attendu += possibles[i].toString() + "|";
         }
         
         if (cardinal != 0)
           	
            if (possibles[cardinal -1] == null) attendu += "null";
            else attendu += possibles[cardinal -1].toString();
         
         attendu += "]";
      }
      
      // Visualiser les messages du test de ce niveau
      // 
      visuEntete(attendu, obtenu);     	 
      
      // Elaborer le CR du test case courant
      // 
      if (statusCase != 0 || (obtenu == null && possibles == null)) {
         levelUnit++;
         return;
      }
      
      if (obtenu != null && possibles == null) statusCase=levelCase;
      else {
      	      
      	 String classeAttendue;
      	 String classeObtenue= obtenu.getClass().getName();
      	 boolean indic= false;
      	 
      	 // Traiter le cas d'un tableau des possibles de taille nulle
      	 //
      	 if (possibles.length == 0) statusCase=levelCase;
         else {
         	
         	// Comparer la valeur obtenue avec les valeurs possibles
            //
            for (int i=0;i <possibles.length && !indic; i++) {
         	
               // Ignorer une reference nulle parmi les possibles
               //    
               if (possibles[i] == null) continue;
           	
           	   // Controler la classe d'origine
           	   //
           	   classeAttendue= possibles[i].getClass().getName();
           	     
           	   if (classeAttendue.equals(classeObtenue)) {
         
           	      // Controler la valeur courante
           	      //
                  if (possibles[i].equals(obtenu)) indic= true;
           	   }
           	}
           	  
           	// Traiter le cas ou aucun valeur possible ne convient
           	//
           	if (!indic) statusCase=levelCase;
         }
      }
      
      // Elaborer le CR du test design courant
      //  
      if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
      
      // Incrementer le total courant des tests unit
      //  
      levelUnit++;
   }
   
   public static void Unit (Object attendu, Object obtenu) {

      // Controler les conditions initiales requises par la charte
      //
      if (!valid("Begin") || !valid("Design") || !valid("Case")) System.exit(1);	  
  
      // Visualiser les messages du test de ce niveau
      // 
      visuEntete(attendu, obtenu);

      // Elaborer le CR du test case courant
      //  
      if (statusCase != 0 ||(obtenu==null && attendu ==null)) return;
      
      if((obtenu==null && attendu !=null) ||
         (obtenu!=null && attendu ==null) || 
         !obtenu.equals(attendu))             statusCase=levelCase;
      
      // Elaborer le CR du test design courant
      //  
      if (statusDesign == 0 && statusCase != 0) statusDesign=statusCase;
      
      // Incrementer le total courant des tests unit
      //  
      levelUnit++;
   }
   
/**
 *
 * La methode privee valid verifie les conditions d'exécution du niveau 
 * de tests passe en parametre.
 * 
**/
   private static boolean valid (String level) {
   String headText   = "\n*** Erreur fatale (Tests) : ";
   String errorBegin = "Begin requis au prealable\n";
   String errorDesign= "Design requis au prealable\n";
   String errorCase  = "Case requis au prealable\n";
   
      // Controler l'execution prealable du service Begin
      //
      if (level.equals("Begin") && !testBegin) {
         System.out.println( headText + errorBegin);
         return false;
      }
      
      // Controler l'execution prealable du service Design
      //   
      if (level.equals("Design") && levelDesign == 0) {
         System.out.println(headText + errorDesign);
         return false;
      }
      
      // Controler l'execution prealable du service Case
      // 
      if (level.equals("Case") && levelCase == 0) {
         System.out.println(headText + errorCase);
         return false;
      }
      
      return true;  
   }

/**
 *
 * La methode privee visuEntete visualise la ligne d'entete du niveau
 * de description fixe par sa signature, en fonction du niveau de 
 * visualisation courant (attribut verboseLevel).
 * 
**/
   private static void visuEntete (String name, String version) {
   String beginPart  = "\n--- Tests unitaires de la classe ";
   String versionPart= " - Version ";
   String endPart    = " ---\n\n";
      
      System.out.print(beginPart);
      System.out.print(name + versionPart + version);
      System.out.print(endPart);
      
      rapport.add(" ");
      rapport.add(beginPart + name + versionPart + version + endPart);
      rapport.add(" ");
      rapport.add(" ");
   }
  
   private static void visuEntete (String name) {
   String beginPart = "\n** [";
   String endPart   = "]\n";
   
      if (verboseLevel > 0) {
         System.out.print(beginPart + name + endPart);
         
         rapport.add(beginPart + name + endPart);
         rapport.add(" ");
      }
   }
   
   private static void visuEntete () {
   String beginPart = "\n   + (";
   String endPart   = ")\n";
   
      if (verboseLevel > 1) {
         System.out.print(beginPart + caseName + endPart);
         
         rapport.add(beginPart + caseName + endPart);
         rapport.add(" ");
      }
   }
   
   private static void visuEntete (Object attendu, Object obtenu) {
   String beginPart = "\n     Valeur attendue : ";
   String middlePart= "\n     Valeur obtenue  : ";
   String LF        = "\n";
   
      if (verboseLevel > 2) {
         System.out.print(beginPart + attendu);
         System.out.print(middlePart + obtenu + LF);

         rapport.add(beginPart + attendu);
         rapport.add(middlePart + obtenu);
         rapport.add(" ");
         
      }
   }
   
 /**
 *
 * La methode privee visuCR visualise le compte rendu courant du niveau
 * de tests fourni en parametre.
 * 
**/
   private static void visuCR (String level) {
   String beginPartCase ="     => CR= ";
   String beginPartDesign = "=> CR= ";
   String LF   = "\n";
   String msgDesign_1= LF + "     Nombre total de \"tests case\" : ";
   String msgDesign_2= "     Nombre total de \"tests unit\" : ";
   
      // Visualiser le CR du dernier test case execute
      //
      if (level.equals("Case") && levelCase > 0 && 
                                  verboseLevel > 1 && 
                                  statusCase != 0) {
         if (verboseLevel == 2) {
            System.out.print(beginPartCase + statusCase + LF);
            rapport.add(beginPartCase + statusCase + LF);
         }
         else {
         	System.out.print(LF + beginPartCase + statusCase + LF);
         	rapport.add(LF + beginPartCase + statusCase + LF);
         }
      }  	
      
      // Visualiser le CR du dernier test design execute
      //
      if (level.equals("Design")&&verboseLevel >0 &&statusDesign != 0) {
      	 if (verboseLevel == 1 && statusDesign != 0) {
      	 	System.out.print(beginPartDesign + statusDesign + LF);
      	 	rapport.add(beginPartDesign + statusDesign + LF);
         }
         else {
            System.out.print(LF + beginPartDesign + statusDesign + LF);
            rapport.add(LF + beginPartDesign + statusDesign + LF);
         }
      }
      
      // Visualiser les informations de niveau 4
      //
      if (verboseLevel > 3 && levelDesign > 0 && level.equals("Design")) {
         System.out.print(msgDesign_1 + levelCase + LF);
         System.out.print(msgDesign_2 + levelUnit + LF);
         rapport.add(msgDesign_1 + levelCase + LF);
         rapport.add(msgDesign_2 + levelUnit + LF);
      }
   }
/**
 *
 * La methode Store enregistre le rapport de tests dans un fichier texte 
 * dont le chemin est fourni en second parametre.  
 * 
**/
   
   private static void Store (ArrayList rapport, String chemin) {
   FileWriter f= null;
   BufferedWriter out= null;
   String message= "Enregistrement du rapport ";
      
      // Construire un fichier logique et le fichier physique associe
      //
      try {f= new FileWriter(chemin);}
      catch (Exception e) {
      	 System.out.println(message + chemin + " : NOK\n");
      	 return;
      }
      
      // Construire un flux de sortie base sur le fichier logique
      //
      try {out= new BufferedWriter(f);}
      catch (Exception e) {
      	 System.out.println(message + chemin + " : NOK\n");
      	 return;
      }
      
      // Enregistrer chaque ligne du rapport dans le flux de sortie
      //
      int taille= rapport.size();
      for (int i=0; i < taille; i++) {
      
         try{out.write((String)rapport.get(i));out.newLine(); }
         catch (Exception e) {
         	System.out.println(message + chemin + " : NOK\n");
         	return;
         }
      }
      
      // Fermer le flux et le fichier de sortie
      //
      try {out.close();f.close();}
      catch (Exception e) {
      	 System.out.println(message + chemin + " : NOK\n");
      	 return;
      }
      
      // Visualiser la reussite de l'operation dans la console
      //
      System.out.println(message + chemin + " : OK\n");
   }
}
