package sets;
import java.util.HashSet;

public class Prova {
	


  public static void main(String[] args) {
	    
	  	HashSet<String> cars = new HashSet<String>(); //nei SET ogni elemento � UNICO
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("BMW"); //non avr� effetto
	    cars.add("Mazda");
	    
	    
	    System.out.println(cars);
	  }


}
