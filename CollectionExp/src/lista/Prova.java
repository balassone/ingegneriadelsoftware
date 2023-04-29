package lista;

import java.util.ArrayList;
import gen.Persona;


public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p1 = new Persona("marco", 10);
		Persona p2 = new Persona("michele", 9);
		Persona p3 = new Persona("francesco", 5);
		Persona p4 = new Persona("chiara", 6);
		Persona p5 = new Persona("luccio", 10);
		Persona p6 = new Persona("lele", 8);
		Persona p7 = new Persona("enzo", 7);
		Persona p8 = new Persona("daniela", 4);
		
		
		//creando ed inizializzando 
		ArrayList<Persona> plist = new ArrayList<Persona>();
		
		ArrayList<Persona> plist2 = new  ArrayList<Persona>();
		ArrayList<Persona> plist3 = new  ArrayList<Persona>();
		
		
		//aggiungo elemento
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		//plist.add("cane"); //non posso farlo perché la mia lista è di solo oggetti PERSONA
		
			
		plist2.add(p5);
		plist2.add(p6);
		plist2.add(p7);
		plist2.add(p8);
		
		System.out.println("plist"+plist);
		
		//posso aggiungere in una posizione specifica
		plist.add(0, p3);

		System.out.println(plist);
		
		//posso eliminare una posizione specifica
		plist.remove(3);
		
		System.out.println(plist);		
	
		System.out.println(plist.get(2));

		System.out.println("La dim della lista è: "+ plist.size());
		
		//posso iterare la lista con un ciclo for
		
		for(int i =0; i<plist.size();i++)  { //for(Persona i : plist)
			
			System.out.println(plist.get(i).getEta());
		}
		
		
		plist3.addAll(plist2);
		plist3.addAll(plist);
		
		System.out.println(plist3);
		
	}

}
