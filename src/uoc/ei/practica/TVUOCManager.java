package uoc.ei.practica;

import java.util.Date;

import uoc.ei.tads.Iterador;

/** 
 * Definició del TAD de gestió de programes de TVUOC
 */
public interface TVUOCManager {
	
	public static final int C= 50;
	public static final int TOP_10 = 10;
	public static final int PC = 100; 

	
	/*
     * Mètode que afegeix un nou usuari al sistema de gestió de repositoris SVN
     * @pre cert
     * @post si el codi d’usuari és nou, els usuaris seran els mateixos més un 
     * nou usuari amb les dades indicades. Sinó les dades de l’usuari s’hauran
     * actualitzat amb les noves
	 *
     * @param userId identificador de l'usuari
     * @param email email del nou usuari
     * @param password password del nou usuari
     * @throws EIException  
     * 
     */
	public void addUser (String idUser, String email, String password) throws EIException;


	
	/**
	 * 
	 * @pre no existeix cap canal amb el codi idChannel
	 * @post els canals seran els mateixos més un nou canal amb les dades indicades
	 * 
	 */
	public void addChannel(String idChannel, String name, String description) throws EIException;
	
	
	/**
	 * @pre  existeix un canal amb el codi idChannel, i no existeix cap programa amb el codi id
	 * @post els programes del canal idChannel seran els mateixos més un nou programa amb les dades indicades
	 */
	public void addProgram(String id, String name, String description, String idChannel) throws EIException;

	/**
	 * @pre  cert
	 * @post Si existeix el canal idChanel, el programa idProgram, i l'usuari idUser, les visualitzacions 
	 * de l'usuari idUser seran les mateixes més una nova visualització amb les dades indicades. En cas contrari retorna error.
	 */
	public void registerView(String idChannel, String idProgram, String idUser, Date dateTime) throws EIException;
	

	/**
	 * @pre  existeix un canal amb el codi idChannel, un programa amb idProgram dins del canal idChanel i rating és un valor entre 0 i5
	 * @post el promig de les valoracions del programa idProgram incorporarà aquesta nova valoració. 
	 */
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException;

	
	/**
	 * @pre  existeix un uduari amb codi idUser
	 * @post retorna un iterador per recórrer les visualitzacions realitzades per l'usuari idUser
	 */ 
	public Iterador<View> getUserViews(String idUser);

	/**
	 * @pre  cert
	 * @post retorna un iterador per recórrer els 10 programes més vistos de TvUoc. En cas d'empat
	 *  a les darreres posicions dels top 10, descarta alguns dels empatats per ajustar-se al límit de 10 programes.
	 */
	public Iterador<Program> getTop10Programs() throws EIException;
	
	/**
	 * @pre  existeix un canal amb codi idChannel
	 *	@post retorna un iterador per recórrer els 10 programes més vistos del canal idChannel. En cas d'empat a les darreres posicions dels top 10, descarta alguns dels empatats per ajustar-se al límit de 10 programes.
	 */
	public Iterador<Program> getChannelTop10Programs(String idChannel) throws EIException;


	/**
	 * @pre  cert
	 * @post retorna el programa més ben valorat, o un d'ells en cas d'empat
	 */
	public Program topRating() throws EIException;

	/**
	 * mètode que proporciona els usuaris del sistema
	 */
	public Iterador<User> users() throws EIException;
	
	/**
	 * mètode que proporciona els canals del sistema
	 */
	public Iterador<Channel> channels()  throws EIException;

	/**
	 * mètode que proporciona els programes del sistema
	 */
	public Iterador<Program> programs(String idChannel) throws EIException;
	
	/**
	 * mètode que proporciona els programe especificat
	 */
	public Program program(String idChannel, String idProgram) throws EIException;
	

}
