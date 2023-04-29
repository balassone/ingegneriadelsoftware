package lista;

import java.util.ArrayList;
import java.util.Collections;

import gen.Studente;

public class Prova2 {

	public static void main(String args[]){
		   
		 	ArrayList<String> cars = new ArrayList<String>();
		    cars.add("Volvo");
		    cars.add("BMW");
		    cars.add("Ford");
		    cars.add("Mazda");
		    
		    System.out.println(cars);
		    Collections.sort(cars);		  		    
		    System.out.println(cars);
		
		
		   //se invece utilizziamo una lista di oggetti definiti da noi?
		   ArrayList<Studente> arraylist = new ArrayList<Studente>();
		   arraylist.add(new Studente("Marco", 223, 26));
		   arraylist.add(new Studente("Francesco", 245, 24));
		   arraylist.add(new Studente("Chiara", 209, 32));

		   
		   
		   Collections.sort(arraylist); //ordina la lista

		   for(Studente str: arraylist){
				System.out.println(str);
		   }
	     
	
	}
}
