
public class Prova2 {

	static int mediaInteraVett(int [] v, int N) { //throws IllegalArgumentException {
		
		
		int somma = 0;
		
		for (int i =0; i<N; i++) 
			
			somma+=v[i];
			
		if (N!=0)	
			return somma / N ;
		else
			System.out.println("ciao");
			//return -1;
			throw new IllegalArgumentException(); //lancio l'eccezione 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] vettore = {3,8,-78,19,56,0,41,88,12,13,14,90};
		
		try {
				
				//il metodo sotto può lanciare eccezione
		System.out.println("Media: "+mediaInteraVett(vettore, 0));
		
		}catch(IllegalArgumentException e) {
			
			e.printStackTrace();
			//System.out.println("Eccezione rilevata");
		}
		
		
		System.out.println("Sono dopo l'eccezione");
		
		//SE ELIMINIAMO IL BLOCCO TRY-CATCH nel MAIN CHE SUCCEDE?
	}

}