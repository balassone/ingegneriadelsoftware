package uno_molti;

import java.util.ArrayList;

public class Cliente {
	
	public int id;
	public String name;
	
	private ArrayList<Auto> autoPosseduta;

	public Cliente(int id, String name) {
		
		this.id = id;
		this.name = name;
		
		this.autoPosseduta = new ArrayList<Auto>(); //0..*
	}
	
	public void associaAuto(Auto x) {
		
		this.autoPosseduta.add(x);
	}
	
	public void rimuoviAuto(Auto x) {
		
		this.autoPosseduta.remove(x);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Auto> getAutoPosseduta() {
		return autoPosseduta;
	}

}
