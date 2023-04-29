package client;
import service.ICounter;
public class Client {
	public static void main(String args[]) {
		
		//Host, metodo e parametro da passare.
		String host = args[0];
		String operation = args[1];
		System.out.println("HOST: "+host);
		System.out.println("operation: "+operation);
		
		// Gestiamo gli errori di utilizzo
		
		//Instanziamo il Counter Proxy
		
		ICounter counter = new CounterProxy(host,2500); //Classe che implementa il proxy che implementa ICounter
		
		// Invocare i metodi remoti sull'oggetto counter
		
		if(operation.equals("sum")) {
			int value = Integer.parseInt(args[2]);
			counter.sum(value);
		} else if(operation.equals("get")) {
			System.out.println("Valore letto: "+counter.get());
		} else if (operation.equals("sqr")) {
			counter.square();
		} else if (operation.equals("inc")) {
			counter.inc();
		}
		
	}
}
