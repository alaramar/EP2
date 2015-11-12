package uoc.ei.practica;

import uoc.ei.tads.Iterador;

/**
 * classe que modela una entitat usuari
 */
public class User extends IdentifiedObject {
	
	/**
	 * identificador de l'usuari
	 */
	private String idUser;
	
	/**
	 * email de l'usuari
	 */
	private String email;
	
	/**
	 * password de l'usuari
	 */
	private String password;
	
	public User (String idUser, String email, String password) {
		super(idUser);
		this.update(email, password);
	}
	
	/**
	 * mètode que modifica les dades de l'usuari si aquest existeix
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
		sb.append(super.getIdentifier()).append(" ").append(this.email).append(" ").append(this.password).append(" ").append(Messages.LS);

			
		return sb.toString();
	}


}
