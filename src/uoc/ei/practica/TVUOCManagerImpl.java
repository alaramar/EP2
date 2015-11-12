package uoc.ei.practica;

import java.util.Date;

import uoc.ei.tads.Iterador;

public class TVUOCManagerImpl implements TVUOCManager {

	@Override
	public void addUser(String idUser, String email, String password) throws EIException {
		// TODO Auto-generated method stub
		
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
	public void registerView(String idChannel, String idProgram, String idUser, Date dateTime) throws EIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterador<View> getUserViews(String idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterador<Program> getTop10Programs() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterador<Program> getChannelTop10Programs(String idChannel) throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program topRating() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterador<User> users() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterador<Channel> channels() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterador<Program> programs(String idChannel) throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program program(String idChannel, String idProgram) throws EIException {
		// TODO Auto-generated method stub
		return null;
	}


}
