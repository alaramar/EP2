package uoc.ei.practica;

/** 
 * Interfície que defineix tots els missatges necessaris per a les excepcions generades
 *
 * @author   Equip docent de Disseny d'Estructura de Dades de la UOC
 * @version  Tardor 2013
 */
public interface Messages {
	
	public static final String LS = System.getProperty("line.separator");
	public static final String PREFIX = "\t";
	
	public static final String NO_USERS = "There are no users";
	public static final String USER_NOT_FOUND = "User not found";
	
	public static final String NO_GROUPS = "There are no groups";
	public static final String GROUP_NOT_FOUND = "Group not found";
	
	public static final String NO_REPOSITORIES = "There are no repositories";
	public static final String REPOSITORY_NOT_FOUND = "Repository not found";
	public static final String NO_PRIVILEGES = "No privileges on this repo";
	public static final String NO_FILES = "There are no files";
	public static final String FILE_NOT_FOUND = "File not found";
	public static final String REVISION_NOT_FOUND = "Revision not found";
	public static final String REPOSITORY_ALREADY_EXISTS = "Repository already exists";
	public static final String REVISION_ALREADY_EXISTS = "Revision already exists";
	
	 
}
