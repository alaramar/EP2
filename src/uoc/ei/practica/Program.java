package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.Iterador;
import uoc.ei.tads.LlistaEncadenada;

public class Program {
	private int views;
	private String id;
	private String name;
	private String description;
	private double average;
	private LlistaEncadenada<Integer> ratings;
	
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
		this.average = 0;
		this.ratings = new LlistaEncadenada<Integer>();
	}

	public void inc() {
		views++;
	}

	public void addRating(int rating) {
		this.ratings.afegirAlFinal(rating);
	}

	public double rating() {
		double i=0;
		double sum =0;
		Iterador<Integer> it = this.ratings.elements();
		while (it.hiHaSeguent()) {
			sum+= it.seguent();
			i++;
		}
						
		double ret =  (i!=0?sum/i:0);
		return ret;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer( id + ", " + name + ", " + description+" rating("+this.rating()+"):" );
		
		Iterador<Integer> it = this.ratings.elements();
		while (it.hiHaSeguent()) {
			sb.append(it.seguent()+" ");
		}
	
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
