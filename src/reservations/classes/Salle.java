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
public class Salle {
	
	/** Membres priv�s */
	private int _id;				// identifiant de l'utilisateur
	private String _room_name;			// nom de la salle
	private int _capacity;		// taille de la salle
	private String _area_name;			// nom de la zone
	
	/** Constructeurs  */
	public Salle() {
		this._id = 0;
		this._capacity = 0;
		this._area_name = "";
		this._room_name = "";
	}	
	public Salle(int unId, String unName, int uneCapacity, String unAreaName) {
		this._id = unId;
		this._capacity = uneCapacity;
		this._area_name = unAreaName;
		this._room_name = unName;
	}	
	
	/** Accesseurs */	
	public int getId() {
		return _id;
	}
	public void setId(int unId) {
		this._id = unId;
	}
	public int getCapacity() {
		return _capacity;
	}
	public void setCapacity(int uneCapacity) {
		this._capacity = uneCapacity;
	}
	public String getRoomName() {
		return _room_name;
	}
	public void setRoomName(String unName) {
		this._room_name = unName;
	}
	public String getAreaName() {
		return _area_name;
	}
	public void setAreaName(String unAreaName) {
		this._area_name = unAreaName;
	}

	
	/** M�thodes d'instance publiques */
	public String toString() {
		String msg = "";
		msg += "Salle :\n";
		msg += "id : \t " + this._id + "\n";
		msg += "Capacity :\t" + this._capacity +"\n";
		msg += "Area Name :\t" + this._area_name + "\n";
		msg += "Room Name :\t" + this._room_name + "\n";
		return msg;
	}
}

