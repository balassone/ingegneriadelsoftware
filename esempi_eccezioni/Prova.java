
public class Prova {

	static int mediaInteraVett(int [] v, int N) {
				
		int somma = 0;
		
		for (int i =0; i<N; i++) 
			
			somma+=v[i];
			
		if(N!=0) //SOLUZIONE NAIVE METTO UN IF
			return somma / N ;
		else 
			return -1; //codice di errore
			
		//1.il codice IF è semplice, ma il codice di gestione di una eccezione
		//potrebbe essere complicato e rendere poco leggible il codice
		//2. il metodo che rileva l'errore spesso non ha tutte le informazioni per gestire l'errore
		// spesso queste informazioni si trovano nel metodo chiamante, o nel chiamante del chiamante e così via..
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] vettore = {3,8,-78,19,56,0,41,88,12,13,14,90};
		
		//posso dividere per zero! il programmatore deve farsi
		//carico di gestire questa situazione
		System.out.println("Media: "+mediaInteraVett(vettore, 0));
		
		
	}

}
