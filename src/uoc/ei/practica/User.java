package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.Iterador;
import uoc.ei.tads.LlistaEncadenada;

/**
 * classe que modela una entitat usuari
 */
public class User extends IdentifiedObject {


	/**
	 * email de l'usuari
	 */
	private String email;

	/**
	 * password de l'usuari
	 */
	private String password;
	
	/**
	 * llista encadenada de visualitzacions d'un usuari
	 */
	private LlistaEncadenada<Visit> visits;

	public User(String idUser, String email, String password) {
		super(idUser);
		this.update(email, password);
		this.visits=new LlistaEncadenada<Visit>();
	}

	/**
	 * comparador que defineix l'ordre global entre Usuarios
	 */
/*	public static Comparator<String>  COMP = new Comparator<String>() {
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}		
	};
*/
	
	/**
	 * mètode que modifica les dades de l'usuari
	 * @param email email de l'usuari
	 * @param password password de l'usuari
	 */
	public void update(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * mètode que proporciona una representació en forma de string d'un usuari
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.identifier).append(" ");
		sb.append(this.email).append(" ");
		sb.append(this.password).append(" ").append(Messages.LS);
		return sb.toString();
	}

	/**
	 * mètode que afegeix un grup a un usuari
	 * @param g
	 */
	public void addVisit(Visit visits) {
		this.visits.afegirAlFinal(visits);
	}

	/**
	 * mètode que retorna un iterador de grups de l'usuari
	 * @return
	 */
	public Iterador<Visit> groups() {
		return this.visits.elements();
	}

	/**
	 * mètode que retorna l'identificador de l'usuari
	 * @return retorna l'identificador de l'usuari
	 */
	public String getIdUser() {
		return this.identifier;
	}

}
