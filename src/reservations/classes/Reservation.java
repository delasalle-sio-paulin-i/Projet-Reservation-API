/**
 * Application de suivi des r�servations de la Maison des Ligues de Lorraine
 * Th�me : d�veloppement et test des classes Salle, Reservation, Utilisateur et Passerelle
 * Auteur : JM CARTRON
 * Derni�re mise � jour : 7/11/2016
 */

package reservations.classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cette classe repr�sente une r�servation
 */
public class Reservation {

	/** Membres priv�s */
	private int _id;				// identifiant de la r�servation
	private Date _timestamp;		// date et heure de la derni�re mise � jour de la r�servation
	private Date _start_time;		// date de d�but de la r�servation
	private Date _end_time;			// date de fin de la r�servation
	private String _room_name;		// nom de la salle r�serv�e
	private int _status;			// 0 = r�servation confirm�e ; 4 = r�servation provisoire
	private String _digicode;		// digicode d'acc�s � la salle pour cette r�servation uniquement
	
	/**
	 * convertit une date en une chaine format�e comprenant �galement l'heure
	 * @param uneDate  : la date et l'heure � formater
	 * @param unFormat : le format de la chaine fournie (ex : "yyyy-MM-dd HH:mm:ss" pour format US)
	 * @return         : la chaine format�e
	 */
	private static String FormaterDateHeure(Date uneDate, String unFormat) {
		SimpleDateFormat leFormat = new SimpleDateFormat(unFormat);
		return leFormat.format(uneDate);
	}
	
	/** Constructeur  */	
	public Reservation(int unId, Date unTimeStamp, Date unStartTime, Date unEndTime, String unRoomName, int unStatus, String unDigicode) {
		this._id = unId;
		this._timestamp = unTimeStamp;
		this._start_time = unStartTime;
		this._end_time = unEndTime;
		this._room_name = unRoomName;
		this._status = unStatus;
		this._digicode = unDigicode;
	}
	
	/** Accesseurs */	
	public int getId() {
		return _id;
	}
	public void setId(int unId) {
		this._id = unId;
	}
	public Date getTimeStamp() {
		return _timestamp;
	}
	public void setTimeStamp(Date unTimeStamp) {
		this._timestamp = unTimeStamp;
	}
	public Date getStartTime() {
		return _start_time;
	}
	public void setStartTime(Date unStartTime) {
		this._start_time = unStartTime;
	}
	public Date getEndTime() {
		return _end_time;
	}
	public void setEndTime(Date unEndTime) {
		this._end_time = unEndTime;
	}
	public String getRoomName() {
		return _room_name;
	}
	public void setRoomName(String unRoomName) {
		this._room_name = unRoomName;
	}
	public int getStatus() {
		return _status;
	}
	public void setStatus(int unStatus) {
		this._status = unStatus;
	}
	public String getDigicode() {
		return _digicode;
	}
	public void setDigicode(String unDigicode) {
		this._digicode = unDigicode;
	}
	
	/** M�thodes publiques */	
	public String toString() {
		String msg = "";
		msg += "id :\t\t" + this._id + "\n";
		msg += "timestamp :\t" + FormaterDateHeure(this._timestamp, "yyyy-MM-dd HH:mm:ss") + "\n";
		msg += "start_time :\t" + FormaterDateHeure(this._start_time, "yyyy-MM-dd HH:mm:ss") + "\n";
		msg += "end_time :\t" + FormaterDateHeure(this._end_time, "yyyy-MM-dd HH:mm:ss") + "\n";
		msg += "room_name :\t" + this._room_name + "\n";
		msg += "status :\t\t" + this._status + "\n";
		msg += "digicode :\t" + this._digicode + "\n";
		return msg;
	}
}
