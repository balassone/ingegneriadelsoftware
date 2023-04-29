package server;
import server.CounterSkeleton;

// Delega sarebbe stato CounterImp implements ICounter
//poi nel ciucciariello faccio Delegate

public class CounterImp extends CounterSkeleton{
	
	// Sto rischiando che ci siano dei problemi tra thread, potremmo utilizzare la gestione della concorrenza
	
	private int count;
	public CounterImp() {
		this.count = 0;
	}
	
	public int get() {
		return count;
	}
	
	public void inc() {
		count++;
	}
	
	public void sum(int value) {
		count +=value;
	}
	
	public void square() { //Possiamo aggiungere synchronized, non è il massimo delle performance ma evitiamo race condition
		count=count*count;
	}
	
}
