
public class Prova3 {

	static int mediaInteraVett(int [] v, int N) {
		
		
		int somma = 0;
		
		for (int i =0; i<N; i++) 
			
			somma+=v[i];
			
		if (N!=0)	
			return somma / N ;
		else
			throw new ArithmeticException(); //lancio l'eccezione   //IllegalAccessError();
			//visto che è UNCHECHKED NON DEVO DICHIARARE CHE IL METODO LANCIA ECCEZIONI
	}
	
	public static int metodoIntermedio(int[] v, int N) {
		
		//dato che è unchecked, nemmeno questo metodo ha l'obbligo di gestire l'eccezione
		
		try {
			
			return mediaInteraVett(v, N);
			
			}catch(ArithmeticException errore) { //qui devo specificare il TIPO DI ECCEZIONE CHE POSSO CATTUARE
				System.out.println("ciao");						//SE LO CAMBIO CHE SUCCEDE??
				return -1;
			}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] vettore = {3,8,-78,19,56,0,41,88,12,13,14,90};
		
		System.out.println(metodoIntermedio(vettore,0));
		
		System.out.println("sono dopo l'ecc");
	}

}
