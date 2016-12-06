/**
 * Application de suivi des r�servations de la Maison des Ligues de Lorraine
 * Th�me : d�veloppement et test des classes Salle, Reservation, Utilisateur et Passerelle
 * Auteur : JM CARTRON
 * Derni�re mise � jour : 7/11/2016
 */

package reservations.classes;

import java.util.ArrayList;

/**
 * Cette classe repr�sente un utilisateur
 */
public class Utilisateur {
	
	/** Membres priv�s */
	private int _id;				// identifiant de l'utilisateur
	private int _level;				// 0=simple visiteur  1=utilisateur pouvant r�server  2=administrateur
	private String _name;			// nom de l'utilisateur
	private String _password;		// mot de passe de l'utilisateur
	private String _email;			// adresse mail de l'utilisateur
	private ArrayList<Reservation> _lesReservations;	// les r�servations pass�es par l'utilisateur
	
	/** Constructeurs  */
	public Utilisateur() {
		this._id = 0;
		this._level = 0;
		this._name = "";
		this._password = "";
		this._email = "";
		this._lesReservations = new ArrayList<Reservation>();
	}	
	public Utilisateur(int unId, int unLevel, String unName, String unPassword, String unEmail) {
		this._id = unId;
		this._level = unLevel;
		this._name = unName;
		this._password = unPassword;
		this._email = unEmail;
		this._lesReservations = new ArrayList<Reservation>();
	}	
	
	/** Accesseurs */	
	public int getId() {
		return _id;
	}
	public void setId(int unId) {
		this._id = unId;
	}
	public int getLevel() {
		return _level;
	}
	public void setLevel(int unLevel) {
		this._level = unLevel;
	}
	public String getName() {
		return _name;
	}
	public void setName(String unName) {
		this._name = unName;
	}
	public String getPassword() {
		return _password;
	}
	public void setPassword(String unPassword) {
		this._password = unPassword;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String unEmail) {
		this._email = unEmail;
	}
	public ArrayList<Reservation> getLesReservations() {
		return _lesReservations;
	}
	
	/** M�thodes d'instance publiques */
	public void ajouteReservation(Reservation uneReservation)
	{	// ajoute l'objet � la liste
		this._lesReservations.add(uneReservation);
	}
	public Reservation getLaReservation(int i)
	{	// fournit la r�servation correspondant � l'index demand�
		return this._lesReservations.get(i);
	}
	public int getNbReservations()
	{	// fournit le nombre de r�servations dans la liste
		return this._lesReservations.size();
	}
	public void viderListeReservations()
	{	// vide la collection des r�servations
		_lesReservations.clear();
	}

}
