/**
 * @(#)_Banque.java
 *
 *
 * @author ANDOLERZAK 
 * @version 1.00 2014/4/16
 */

package _Banque;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

public abstract class _Banque {
	
	private static int numeroDebut=1000000;
  	private static int numRegCptCourant=80000000;
  	private static int numRegCptEpargne=40000000;
  	private static int numeroGuichet=1001;
	
	//Methode incrém' num registre
	public static int numeroRegistreOp() {
		numeroDebut=numeroDebut+1;
		return numeroDebut;
	}
	
	//increm Num compteCourant
	public static int numeroRegistreCptCourant(){
			numRegCptCourant=numRegCptCourant+1;
			return numRegCptCourant;
	}
	
	//increm Num compteEpargne	
	public static int numeroRegistreCptEpargne()throws Throwable{
			numRegCptEpargne=numRegCptEpargne+1;
			if(numRegCptEpargne>=80000000)
			throw new Throwable("-3.4	:	numéro de compte épargne incorrect");	
			return numRegCptEpargne;
	}	
	
	 public static boolean dateValide(String date){
		Calendar now = Calendar.getInstance();
		if(date.split("[0-9/]").length!=0) return false;
		
		String[] parts = date.split("/");
		
		int annee = Integer.valueOf(parts[0]);
		int mois = Integer.valueOf(parts[1]);
		int jour = Integer.valueOf(parts[2]);

		if(annee>now.get(Calendar.YEAR))
			return false;
			
		if(mois<01 || mois>12)
			return false;
			
		if(jour<01)
			return false;
		
		if((mois==01 || mois==03 || mois==05 || mois==07 || mois==(07+01) || mois==10 || mois==12) && (jour>31))	
			return false;		
				
		if((mois==02 ) && (jour>29))
			return false; 
				
		if((mois==04 || mois==06 || mois==(07+02) || mois==11 ) && (jour>30))	
			return false;	
				
		return true;

	}
    

	
	public static String dateJour(){
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return String.valueOf(dateFormat.format(cal.getTime()));
	}
	
	public static int numGuichet(){
		return numeroGuichet++;
	}
}