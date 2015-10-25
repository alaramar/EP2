package uoc.ei.practica;

import java.util.Date;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.ExcepcioPosicioInvalida;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class TVUOCManagerImpl implements TVUOCManager {
	
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
		this.channels[this.len++]=new Channel(idChannel, name, description);
		
	}

	private Channel getChannel(String idChannel) {
		int i=0;
		boolean found= false;
		
		while (i<this.len && !found) {
			found = this.channels[i].is(idChannel);			
			i++;
		}
		
		return (found?this.channels[i-1]:null);
	}
	

	@Override
	public void addProgram(String id, String name, String description, String idChannel) throws EIException {
		Channel channel = this.getChannel(idChannel);
		channel.addProgram(id, name, description);
			
	}


	@Override
	public void registerView(String idChannel, String idProgram, String idUser, Date dateTime) throws EIException {
		// TODO Auto-generated method stub
		
		User user = this.users.getIdentifiedObject(idUser);
		
		if (user == null) throw new EIException(Messages.USER_NOT_FOUND);
		
		Channel channel = this.getChannel(idChannel);
		if (channel == null) throw new EIException(Messages.CHANNEL_NOT_FOUND);
		
		Program p = channel.getProgram(idProgram);
		if (p == null) throw new EIException(Messages.PROGRAM_NOT_FOUND);

		p.inc();
		user.addView(p);
		updateTop10(p);
		channel.updateTop10(p);
		
	}


	private void updateTop10(Program p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException {
		Channel channel = this.getChannel(idChannel);
		Program program = channel.getProgram(idProgram);
		
		program.addRating(rating);
		
	}


	@Override
	public Iterador<View> getUserViews(String idUser) {
		User u = this.users.getIdentifiedObject(idUser);
		return u.views();
	}


	@Override
	public Iterador<Program> getTop10Programs() throws EIException {
		Program[] top10Programs = new Program[10];
		top10Programs[0] = this.program("CH1", "P13");
		top10Programs[1] = this.program("CH2", "P21");
		top10Programs[2] = this.program("CH2", "P23");
		top10Programs[3] = this.program("CH1", "P11");
		top10Programs[4] = this.program("CH2", "P22");
		
		// TODO Auto-generated method stub
		return new IteradorVectorImpl(top10Programs,5,0);
	}


	@Override
	public Iterador<Program> getChannelTop10Programs(String idChannel) throws EIException {
		Program[] top10Programs = new Program[10];
		top10Programs[1] = this.program("CH2", "P21");
		top10Programs[2] = this.program("CH2", "P23");
		top10Programs[4] = this.program("CH2", "P22");
		
		// TODO Auto-generated method stub
		return new IteradorVectorImpl(top10Programs,5,0);
	}


	@Override
	public Program topRating() throws EIException {
		
		return this.program("CH1", "P13");
		
	}


	@Override
	public Iterador<User> users() throws EIException {		// TODO Auto-generated method stub
		if (this.users.estaBuit()) throw new EIException(Messages.NO_USERS);
		return this.users.elements();
	}

	public Iterador<Channel> channels() throws EIException {
		if (this.len==0) throw new EIException(Messages.NO_CHANNELS);
		Iterador<Channel> it =  new IteradorVectorImpl(this.channels,this.len,0);

		return it;
	}

	
	
	@Override
	public Iterador<Program> programs(String idChannel) throws EIException {

		Channel c = this.getChannel(idChannel);
		if (c==null) throw new EIException(Messages.CHANNEL_NOT_FOUND);
		Iterador<Program> it = c.programs();
		
		if (!it.hiHaSeguent()) throw new EIException(Messages.NO_PROGRAMS);
		return it;
	}


	@Override
	public Program program(String idChannel, String idProgram) throws EIException {
		Channel c = this.getChannel(idChannel);
		if (c==null) throw new EIException(Messages.CHANNEL_NOT_FOUND);
		Program p = c.getProgram(idProgram);
		if (p==null) throw new EIException(Messages.PROGRAM_NOT_FOUND);
		return p;
	}

}
