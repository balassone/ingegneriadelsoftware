package entity;

import java.util.ArrayList;

import database.DBSegreteria;
import database.DBStudente;

public class EntitySegreteria {
	
	
	private ArrayList<EntityStudente> studenti;
	private ArrayList<EntityTesto> testi;
	
	
	public ArrayList<EntityStudente> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<EntityStudente> studenti) {
		this.studenti = studenti;
	}
	
	
	
	public ArrayList<EntityTesto> getTesti() {
		return testi;
	}

	public void setTesti(ArrayList<EntityTesto> testi) {
		this.testi = testi;
	}

	public EntitySegreteria() {	
		
	}
	

	public static ArrayList<String> getListaMatricole(){
				
		
		ArrayList<String> matricole = new ArrayList<String>();		
		
		matricole = DBSegreteria.getListaMatricole();
		
		return matricole;
	}
}
