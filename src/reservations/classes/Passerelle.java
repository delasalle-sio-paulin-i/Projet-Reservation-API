/**
<<<<<<< HEAD
 * Application de suivi des réservations de la Maison des Ligues de Lorraine
 * Thème : développement et test des classes Salle, Reservation, Utilisateur et Passerelle
=======
 * Application de suivi des r�servations de la Maison des Ligues de Lorraine
 * Th�me : d�veloppement et test des classes Salle, Reservation, Utilisateur et Passerelle
>>>>>>> branch 'master' of https://github.com/delasalle-sio-paulin-i/Projet-Reservation-API.git
 * Auteur : JM CARTRON
<<<<<<< HEAD
 * Dernière mise à jour : 8/11/2016
=======
 * Derni�re mise � jour : 8/11/2016
>>>>>>> branch 'master' of https://github.com/delasalle-sio-paulin-i/Projet-Reservation-API.git
 */
package reservations.classes;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;


//les import suivant nécessitent d'ajouter au projet tous les composant du plugin (fourni) 
//httpcomponents-client-4.2.3 / lib  (ces plugins font partie également du SDK Android)

//les import suivant n�cessitent d'ajouter au projet tous les composant du plugin (fourni) 
//httpcomponents-client-4.2.3 / lib  (ces plugins font partie �galement du SDK Android)

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

//les import suivant sont inclus dans le JDK
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Cette classe fait le lien entre les services web et l'application
<<<<<<< HEAD
 * Elle utilise le modèle Jaxp pour parcourir le document XML
 * Ce modèle fait partie du JDK (et également du SDK Android)
=======
 * Elle utilise le mod�le Jaxp pour parcourir le document XML
 * Ce mod�le fait partie du JDK (et �galement du SDK Android)
>>>>>>> branch 'master' of https://github.com/delasalle-sio-paulin-i/Projet-Reservation-API.git
 */
public class Passerelle {


	private static String _adresseHebergeur = "http://xxxxxxxxxxxxxxxx/m.m2l/services/";

	private static String _urlConnecter = "Connecter.php";
	private static String _urlConsulterReservations = "ConsulterReservations.php";
	private static String _urlCreerUtilisateur = "CreerUtilisateur.php";
	

	// noms des services web pas encore traités par la passerelle (à développer)

	private static String _urlConsulterSalles = "ConsulterSalles.php";
	private static String _urlAnnulerReservation = "AnnulerReservation.php";
	private static String _urlChangerDeMdp = "ChangerDeMdp.php";	
	private static String _urlConfirmerReservation = "ConfirmerReservation.php";	
	private static String _urlDemanderMdp = "DemanderMdp.php";	
	private static String _urlSupprimerUtilisateur = "SupprimerUtilisateur.php";
	private static String _urlTesterDigicodeBatiment = "TesterDigicodeBatiment.php";
	private static String _urlTesterDigicodeSalle = "TesterDigicodeSalle.php";
	

	private static Document getDocumentXML(String urlDuServiceWeb, ArrayList<NameValuePair> parametresPostes)
	{
    	try

    	{	// création d'un DefaultHttpClient

    		
			HttpClient unClientHttp = new DefaultHttpClient();
			
			// création d'une requête HTTP de type POST
			// cr�ation d'une requ�te HTTP de type POST
			HttpPost uneRequeteHttp = new HttpPost(urlDuServiceWeb);
			uneRequeteHttp.setHeader("Content-Type", "application/x-www-form-urlencoded");
			

			// passage des paramètres à poster

			// passage des param�tres � poster

			uneRequeteHttp.setEntity(new UrlEncodedFormEntity(parametresPostes, "UTF-8"));

			// exécution de la requête HTTP

			// ex�cution de la requ�te HTTP
			HttpResponse uneReponseHttp = unClientHttp.execute(uneRequeteHttp);
			
			// récupération de la réponse dans un flux en lecture (InputStream)
			// r�cup�ration de la r�ponse dans un flux en lecture (InputStream)
			InputStream unFluxEnEntree = uneReponseHttp.getEntity().getContent();
	
			// création d'une instance de DocumentBuilderFactory et DocumentBuilder
			// cr�ation d'une instance de DocumentBuilderFactory et DocumentBuilder
			DocumentBuilderFactory leDBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder leDB = leDBF.newDocumentBuilder();
	
			// création d'un nouveau document XML avec en argument le flux XML
			// cr�ation d'un nouveau document XML avec en argument le flux XML
			Document leDocument = leDB.parse(unFluxEnEntree);
			return leDocument;
    	}
    	catch (Exception ex)
    	{	return null;
		}	
	}
	
    // Méthode de classe pour se connecter (service Connecter.php)
    // M�thode de classe pour se connecter (service Connecter.php)
    public static String connecter(String nomUtilisateur, String mdpUtilisateur)
    {
    	String reponse = "";
    	try
    		// préparation des paramètres à poster vers le service web
    	{	// pr�paration des param�tres � poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", nomUtilisateur));
    		parametresPostes.add(new BasicNameValuePair("mdp", mdpUtilisateur));    		
    		
    		// création d'un nouveau document XML à partir de l'URL du service web et des paramètres
    		// cr�ation d'un nouveau document XML � partir de l'URL du service web et des param�tres
    		String urlDuServiceWeb = _adresseHebergeur + _urlConnecter;	
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		// parsing du flux XML
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		
    		// retour de la réponse du service web

    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    }


    public static String creerUtilisateur(String nomAdmin, String mdpAdmin, Utilisateur unUtilisateur)
    {
    	String reponse = "";
    	try

    		// préparation des paramètres à poster vers le service web

    	{	// pr�paration des param�tres � poster vers le service web

    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nomAdmin", nomAdmin));
    		parametresPostes.add(new BasicNameValuePair("mdpAdmin", mdpAdmin));
    		parametresPostes.add(new BasicNameValuePair("name", unUtilisateur.getName()));
    		parametresPostes.add(new BasicNameValuePair("level", String.valueOf(unUtilisateur.getLevel())));
    		parametresPostes.add(new BasicNameValuePair("email", unUtilisateur.getEmail()));
    		

    		// cr�ation d'un nouveau document XML � partir de l'URL du service web et des param�tres

    		String urlDuServiceWeb = _adresseHebergeur + _urlCreerUtilisateur;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		// parsing du flux XML
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		

    		// retour de la réponse du service web

    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    }


    public static String consulterReservations(Utilisateur unUtilisateur)
    {
    	String reponse = "";
    	try

    		// préparation des paramètres à poster vers le service web

    	{	// pr�paration des param�tres � poster vers le service web

    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", unUtilisateur.getName()));
    		parametresPostes.add(new BasicNameValuePair("mdp", unUtilisateur.getPassword()));

    		// création d'un nouveau document XML à partir de l'URL du service web et des paramètres

    		String urlDuServiceWeb = _adresseHebergeur + _urlConsulterReservations;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);

    		// parsing du flux XML
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);

    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		
			NodeList listeNoeudsMembres = leDocument.getElementsByTagName("reservation");

			
			String formatUS = "yyyy-MM-dd HH:mm:ss";
			
			// parcours de la liste des noeuds <reservation> et ajout dans l'objet unUtilisateur
			for (int i = 0 ; i <= listeNoeudsMembres.getLength()-1 ; i++)

				// création de l'élement courant à chaque tour de boucle

			{	// cr�ation de l'�lement courant � chaque tour de boucle

				Element courant = (Element) listeNoeudsMembres.item(i);
				

				// lecture des balises intérieures

				// lecture des balises int�rieures
				int id = Integer.parseInt(courant.getElementsByTagName("id").item(0).getTextContent());
				Date timestamp = Outils.ConvertirEnDate(courant.getElementsByTagName("timestamp").item(0).getTextContent(), formatUS);
				Date start_time = Outils.ConvertirEnDate(courant.getElementsByTagName("start_time").item(0).getTextContent(), formatUS);
				Date end_time = Outils.ConvertirEnDate(courant.getElementsByTagName("end_time").item(0).getTextContent(), formatUS);
				String room_name = courant.getElementsByTagName("room_name").item(0).getTextContent();
				int status = Integer.parseInt(courant.getElementsByTagName("status").item(0).getTextContent());
				String digicode = courant.getElementsByTagName("digicode").item(0).getTextContent();
				

				// crée un objet Reservation

				// cr�e un objet Reservation
				Reservation uneReservation = new Reservation(id, timestamp, start_time, end_time, room_name, status, digicode);
				

				unUtilisateur.ajouteReservation(uneReservation);
			}


    		// retour de la réponse du service web

    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    }

    
    public static String ChangerDeMdp(Utilisateur unUtilisateur, String nouveauMdp, String confirmationMdp){
    	String reponse = "";
    	try
    	{	// préparation des paramètres à poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", unUtilisateur.getName()));
    		parametresPostes.add(new BasicNameValuePair("mdpOld", unUtilisateur.getPassword()));
    		parametresPostes.add(new BasicNameValuePair("mdpNew1", nouveauMdp));
    		parametresPostes.add(new BasicNameValuePair("mdpNew2", confirmationMdp));
    		
    		String urlDuServiceWeb = _adresseHebergeur + _urlChangerDeMdp;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		   
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    	  	
    }
    public static String DemanderMdp(Utilisateur unUtilisateur){
    	String reponse = "";
    	try
    	{	// préparation des paramètres à poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", unUtilisateur.getName()));
    		
    		String urlDuServiceWeb = _adresseHebergeur + _urlDemanderMdp;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		   
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    	  	
    }
    
    public static String SupprimerUtilisateur(String nomAdmin, String mdpAdmin, Utilisateur unUtilisateur){
    	String reponse = "";
    	try
    	{	// préparation des paramètres à poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", unUtilisateur.getName()));
    		
    		parametresPostes.add(new BasicNameValuePair("nomAdmin", nomAdmin));
    		parametresPostes.add(new BasicNameValuePair("mdpAdmin", mdpAdmin));
    		
    		String urlDuServiceWeb = _adresseHebergeur + _urlSupprimerUtilisateur;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		   
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    	  	
    }
    
    
    
    

    public static String consulterSalle(String nomUtilisateur, String mdpUtilisateur)
    {
    	String reponse = "";
    	try
    	{	// pr�paration des param�tres � poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", nomUtilisateur));
    		parametresPostes.add(new BasicNameValuePair("mdp", mdpUtilisateur));    		
    		
    		// cr�ation d'un nouveau document XML � partir de l'URL du service web et des param�tres
    		String urlDuServiceWeb = _adresseHebergeur + _urlConsulterSalles;	
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		// parsing du flux XML
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();			
		
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    }
    public static String confirmerReservation(String nomUtilisateur, String mdpUtilisateur, String numReserv )
    {
    	String reponse = "";
    	try
    	{	// pr�paration des param�tres � poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", nomUtilisateur));
    		parametresPostes.add(new BasicNameValuePair("mdp", mdpUtilisateur));   
    		parametresPostes.add(new BasicNameValuePair("numRes", numReserv));    		

    		
    		// cr�ation d'un nouveau document XML � partir de l'URL du service web et des param�tres
    		String urlDuServiceWeb = _adresseHebergeur + _urlConfirmerReservation;	
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		// parsing du flux XML
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    }
    public static String annulerReservation(String nomUtilisateur, String mdpUtilisateur, String numReserv ){
    	
    
    	String reponse = "";
    	try
    	{	// pr�paration des param�tres � poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("nom", nomUtilisateur));
    		parametresPostes.add(new BasicNameValuePair("mdp", mdpUtilisateur));   
    		parametresPostes.add(new BasicNameValuePair("numRes", numReserv));    		

    		
    		// cr�ation d'un nouveau document XML � partir de l'URL du service web et des param�tres
    		String urlDuServiceWeb = _adresseHebergeur + _urlAnnulerReservation;	
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		// parsing du flux XML
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    }

    public static String testerDigicodeBatiment(String digicode){
    	String reponse = "";
    	try
    	{	// préparation des paramètres à poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("digi", digicode));
    		
    		String urlDuServiceWeb = _adresseHebergeur + _urlTesterDigicodeBatiment;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		   
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    	  	
    }
    public static String testerDigicodeSalle(String digicode){
    	String reponse = "";
    	try
    	{	// préparation des paramètres à poster vers le service web
    		ArrayList<NameValuePair> parametresPostes = new ArrayList<NameValuePair>();
    		parametresPostes.add(new BasicNameValuePair("digi", digicode));
    		
    		String urlDuServiceWeb = _adresseHebergeur + _urlTesterDigicodeSalle;
    		Document leDocument = getDocumentXML(urlDuServiceWeb, parametresPostes);
    		
    		Element racine = (Element) leDocument.getElementsByTagName("data").item(0);
    		reponse = racine.getElementsByTagName("reponse").item(0).getTextContent();
    		   
    		// retour de la r�ponse du service web
    		return reponse;
    	}
    	catch (Exception ex)
    	{	String msg = "Erreur : " + ex.getMessage();
			return msg;
		}
    	  	
    }
 

}
