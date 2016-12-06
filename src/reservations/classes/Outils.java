// TP Java
// Classe offrant diff�rents services courants sous forme de m�thodes � port�e classe
// Auteur : JM CARTRON
// Derni�re mise � jour : 10/9/2013

package reservations.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat; 

public class Outils {
	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des nombres-----------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * teste si une chaine est bien num�rique
	 * @param laChaine : la chaine � tester
	 * @return         : bool�en - true si la chaine repr�sente un nombre correct
	 *                             false dans les autres cas
	 */
	public static boolean isNumeric (String laChaine) {
		if (laChaine == null) return false;
		try {
			laChaine = laChaine.replace(",", ".");
			@SuppressWarnings("unused")
			double Nombre = Double.parseDouble(laChaine);
			// new java.math.BigDecimal(laChaine);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * convertit un nombre en chaine format�e
	 * @param unNombre : le nombre � formater
	 * @param unFormat : le format de conversion (exemples : "00", "0.00", "###,###,##0.00", ...)
	 * @return
	 */
	public static String FormaterNombre(double unNombre, String unFormat) {
	    DecimalFormat df = new DecimalFormat(unFormat);	
		return df.format(unNombre);
	}	
	
	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des dates-------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------	

	/**
	 * teste si une chaine est bien une date
	 * @param laChaine : la chaine � tester
	 * @return         : bool�en - true si la chaine repr�sente une date correcte
	 *                             false dans les autres cas
	 */
	public static boolean isDate (String laChaine) throws ParseException {
		if (laChaine == null) return false;
		try {
			@SuppressWarnings("unused")
			Date uneDate;
			uneDate = Outils.ConvertirEnDate(laChaine);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}  
	
	/**
	 * convertit une chaine date en un objet Date
	 * @param uneChaineDate   : la chaine � convertir
	 * @return                : l'objet Date obtenu par la conversion de la chaine
	 * @throws ParseException
	 */
	public static Date ConvertirEnDate(String uneChaineDate) throws ParseException {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy");
		return leFormat.parse(uneChaineDate);
	}

	/**
	 * convertit une chaine date en un objet Date
	 * @param uneChaineDate   : la chaine � convertir
	 * @param unFormat        : le format de la chaine fournie (ex : "yyyy-MM-dd HH:mm:ss" pour format US)
	 * @return                : l'objet Date obtenu par la conversion de la chaine
	 * @throws ParseException
	 */
	public static Date ConvertirEnDate(String uneChaineDate, String unFormat) throws ParseException {
		SimpleDateFormat leFormat = new SimpleDateFormat(unFormat);
		return leFormat.parse(uneChaineDate);
	}
	
	/**
	 * convertit une date en une chaine format�e
	 * @param uneDate : la date � formater
	 * @return        : la chaine format�e
	 */
	public static String FormaterDate(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy");
		return leFormat.format(uneDate);
	}

	/**
	 * convertit une date en une chaine format�e
	 * @param uneDate  : la date � formater
	 * @param unFormat : le format de la chaine fournie (ex : "yyyy-MM-dd" pour format US)
	 * @return         : la chaine format�e
	 */
	public static String FormaterDate(Date uneDate, String unFormat) {
		SimpleDateFormat leFormat = new SimpleDateFormat(unFormat);
		return leFormat.format(uneDate);
	}
	
	/**
	 * convertit une date en une chaine format�e comprenant �galement l'heure
	 * @param uneDate : la date et l'heure � formater
	 * @return        : la chaine format�e
	 */
	public static String FormaterDateHeure(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return leFormat.format(uneDate);
	}

	/**
	 * convertit une date en une chaine format�e comprenant �galement l'heure
	 * @param uneDate : la date et l'heure � formater
	 * @param unFormat : le format de la chaine fournie (ex : "yyyy-MM-dd HH:mm:ss" pour format US)
	 * @return        : la chaine format�e
	 */
	public static String FormaterDateHeure(Date uneDate, String unFormat) {
		SimpleDateFormat leFormat = new SimpleDateFormat(unFormat);
		return leFormat.format(uneDate);
	}
	
	/**
	 * fournit le jour de la semaine � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : le jour de la semaine (exemples : "dimanche", "lundi", ...)
	 */
	public static String JourDeLaSemaine(Date uneDate)	{
		SimpleDateFormat leFormat = new SimpleDateFormat("EEEE");	// "EEEE" : jour de la semaine
		return leFormat.format(uneDate);
	}
	
	/**
	 * fournit l'ann�e � partir d'une date
	 * @param uneDate : la date �tudi�e
	 * @return        : l'ann�e sur 4 chiffres
	 */
	public static int Annee(Date uneDate) {
		SimpleDateFormat leFormat = new SimpleDateFormat("yyyy");	// "yyyy" : ann�e sur 4 chiffres
		return Integer.parseInt(leFormat.format(uneDate));
	}
	
	/**
	 * fournit une date en ajoutant des jours � une autre date
	 * @param uneDate   : la date de d�part
	 * @param nbDeJours : le nombre de jours � ajouter (ce nombre peut �tre n�gatif)
	 * @return          : la nouvelle date obtenue
	 */
	public static Date AjouterDesJours(Date uneDate, int nbDeJours) {
		Calendar calendrier = Calendar.getInstance();
		calendrier.setTime(uneDate);
		calendrier.add(Calendar.DATE, nbDeJours);
		return calendrier.getTime();
	}
	
	/**
	 * La fonction DateUS convertit une date fran�aise (j/m/a) au format US (a-m-j)
	 * par exemple, le param�tre '16/05/2007' donnera '2007-05-16'
	 * @param laDate : la date � transformer
	 * @return       : la date transform�e
	 */
	public static String DateUS (String laDate)
	{	String[] tableau = laDate.split ("/");		// on extrait les segments de la chaine laDate s�par�s par des "/"
		String J = tableau[0];
		String M = tableau[1];
		String A = tableau[2];
		return (A + "-" + M + "-" + J);				// on les reconcat�ne dans un ordre diff�rent
	}

	/**
	 * La fonction DateFR convertit une date US (a-m-j) au format Fran�ais (j/m/a)
	 * par exemple, le param�tre '2007-05-16' donnera '16/05/2007'
	 * @param laDate : la date � transformer
	 * @return       : la date transform�e
	 */
	public static String DateFR (String laDate)
	{	String[] tableau = laDate.split ("-");		// on extrait les segments de la chaine laDate s�par�s par des "-"
		String A = tableau[0];
		String M = tableau[1];
		String J = tableau[2];
		return (J + "/" + M + "/" + A);				// on les reconcat�ne dans un ordre diff�rent
	}

	
	// --------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------outils concernant le traitement des chaines ----------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------	

	/**
	 * compl�te la chaine fournie par des espaces jusqu'� la longueur d�sir�e
	 * @param laChaine : la chaine � compl�ter
	 * @param longueur : la longueur � obtenir
	 * @return         : la chaine compl�t�e
	 */
	public static String CompleterChaine(String laChaine, int longueur) {
		while ( laChaine.length() < longueur ) {
			laChaine = laChaine + " ";
		}
		return laChaine;
	}
	
	/**
	 * compl�te la chaine fournie par un caract�re choisi jusqu'� la longueur d�sir�e
	 * @param laChaine    : la chaine � compl�ter
	 * @param longueur    : la longueur � obtenir
	 * @param leCaractere : le caract�re utilis� pour compl�ter la chaine
	 * @return            : la chaine compl�t�e
	 */
	public static String CompleterChaine(String laChaine, int longueur, char leCaractere) {
		while ( laChaine.length() < longueur ) {
			laChaine = laChaine + leCaractere;
		}
		return laChaine;
	}	
	
	
	
}
