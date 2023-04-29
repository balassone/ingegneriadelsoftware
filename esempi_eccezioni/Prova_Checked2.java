import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Prova_Checked2 {

	//eclipse subito si accorge che sto usando un metodo
	//che lancia una eccezione CHECKED e mi da 2 opzioni
	//gestirla al momento --> TRY CATCH
	//rilanciarla al chiamante -> THROW
	static int mediaInteraVett(int [] v, int N) throws FileNotFoundException {
		
		PrintWriter backup = new PrintWriter("z:\\nonEsisto.txt");
				
		int somma = 0;
		
		for (int i =0; i<N; i++) 		
			somma+=v[i];
			
		if (N!=0)
			return somma / N ;
		else
			throw new ArithmeticException(); //lancio l'eccezione   //IllegalAccessError();
			//visto che è UNCHECHKED NON DEVO DICHIARARE CHE IL METODO LANCIA ECCEZIONI
	}
	
	public static int metodoIntermedio(int[] v, int N) throws FileNotFoundException{
		
		//dato che è unchecked, nemmeno questo metodo ha l'obbligo di gestire l'eccezione
		
		try {
		
			return mediaInteraVett(v, N);	//il problema ora si è spostato QUA
		
		}catch(ArithmeticException errore) { //qui devo specificare il TIPO DI ECCEZIONE CHE POSSO CATTUARE
											//SE LO CAMBIO CHE SUCCEDE??
			return -1;
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] vettore = {3,8,-78,19,56,0,41,88,12,13,14,90};
		
				
			try {
				System.out.println(metodoIntermedio(vettore,5));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("ciao");
				e.printStackTrace();
			}
	
			System.out.println("sono dopo");
	}

}

