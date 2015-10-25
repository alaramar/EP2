package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.Iterador;
import uoc.ei.tads.LlistaEncadenada;

public class Program {
	private int views;
	private String id;
	private String name;
	private String description;
	private double sumRating;
	private int nRating;
		
	public static Comparator<String> PROGRAM_CMP = new Comparator<String>() {

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
	};
	
	public Program(String id, String name, String description) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.sumRating = 0;
		this.nRating=0;
	}

	public void inc() {
		views++;
	}

	public void addRating(int rating) {
		this.sumRating+=rating;
		this.nRating++;
	}

	public double rating() {						
		double ret =  (this.nRating!=0?this.sumRating/this.nRating:0);
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer( id + ", " + name + ", " + description+" views("+this.views+") rating("+this.rating()+"):");
		return sb.toString();
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getId() {
		return id;
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

}
