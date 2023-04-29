package lista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gen.Persona;

public class Prova3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Persona p1 = new Persona("marco", 10);
		Persona p2 = new Persona("michele", 9);
		Persona p3 = new Persona("francesco", 5);
		Persona p4 = new Persona("chiara", 6);
		Persona p5 = new Persona("luccio", 10);
	
		
		ArrayList<Persona> plist = new ArrayList<Persona>();
	
		
		//aggiungo elemento
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		
		
		//Iterator<Persona> it = plist.iterator();
		Iterator<Persona> it = plist.iterator();
		
		//System.out.println(it.next());
		
		while(it.hasNext()) {
			
			System.out.println(it.next());
		}
		
	}

}
