package uoc.ei.practica;

import java.nio.channels.Channel;
import java.util.Date;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.ExcepcioPosicioInvalida;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class TVUOCManagerImpl implements TVOUCManager {
	
	/**
	 * vector d'estacions del sistema
	 */
	private Channel[] channels;
	private int len;
		
	private Channel[] top10Channels;
	private int lenTop10;
	
	/**
	 * llista encadenada d'usuaris
	 * 
	 */
	private IdentifiedList<User> users;
	

	public TVUOCManagerImpl() {
		this.channels= new Channel[C];
		this.len=0;

		this.top10Channels= new Channel[TOP_10];
		this.len=0;

		this.users= new IdentifiedList<User>();
	}


	@Override
	public void addUser(String idUser, String email, String password)
			throws EIException {
		
		User user = this.users.getIdentifiedObject(idUser);
		if (user==null) {
			user = new User(idUser, email, password);
			this.users.afegirAlPrincipi(user);
		}
		else user.update(email, password);
		
		
	}


	@Override
	public void addChannel(String idChannel, String name, String description) throws EIException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addProgram(String id, String name, String description, String idChannel) throws EIException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void registerVisit(String idChannel, String idProgram, String idUser, Date dateTime) throws EIException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Iterador<Visit> getUserVisit(String idUser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void getTop10Programs() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Iterador<Channel> getChannelTop10Programs(String idChannel) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Program topRating() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterador<User> users() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterador<Program> programs() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

}
