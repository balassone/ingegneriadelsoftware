package mappa;

import java.util.Collections;
import java.util.HashMap;

import gen.Persona;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer,Persona> pmap = new HashMap<Integer,Persona>();
		  
		Persona p1 = new Persona("marco", 10);
		Persona p2 = new Persona("michele", 9);
		Persona p3 = new Persona("francesco", 5);
		Persona p4 = new Persona("chiara", 6);
		
		Persona p5 = new Persona("luccio", 10);
		Persona p6 = new Persona("lele", 8);
		Persona p7 = new Persona("enzo", 7);
		Persona p8 = new Persona("daniela", 4);
		
		//		k   v
		pmap.put(1, p1); //marco
		pmap.put(2, p2); //michele
		pmap.put(3, p3); //francesco
		pmap.put(4, p4); //chiara
		pmap.put(4, p8); //non sono ammesse chiavi duplicate
		pmap.putIfAbsent(10, p1); //marco
		
				
		for(Integer key : pmap.keySet()) {
				System.out.println(pmap.get(key));
		  }
		
		
	}

}
