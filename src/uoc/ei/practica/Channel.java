package uoc.ei.practica;

import uoc.ei.tads.Iterador;

public class Channel {
	private String idChannel;
	private String name;
	private String description;
	private OrderedVector<String, Program> programs;
	
	public Channel(String idChannel, String name, String description) {
		// TODO Auto-generated constructor stub
		this.idChannel = idChannel;
		this.name=name;
		this.description=description;
		this.programs = new OrderedVector<String, Program>(TVUOCManager.PC, Program.PROGRAM_CMP);
	}
	
	public String getIdChannel() {
		return idChannel;
	}

	public void setIdChannel(String idChannel) {
		this.idChannel = idChannel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean is(String idChannel) {
		return this.idChannel.equals(idChannel);
	}

	public void addProgram(String id, String name, String description) {
		this.programs.afegir(id, new Program(id, name, description));
		
	}

	public Program getProgram(String idProgram) {
		// TODO Auto-generated method stub
		return this.programs.consultar(idProgram);
	}

	public void updateTop10(Program p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(idChannel + ", " + name + ", " + description);
		if (!this.programs.estaBuit()) sb.append(this.programs);
		
		return sb.toString();
	}

	public Iterador<Program> programs() {
		// TODO Auto-generated method stub
		return this.programs.elements();
	}
}
