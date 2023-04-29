import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Prova_Checked {

	//eclipse subito si accorge che sto usando un metodo
	//che lancia una eccezione CHECKED e mi da 2 opzioni
	//gestirla al momento --> TRY CATCH
	//rilanciarla al chiamante -> THROW
	static int mediaInteraVett(int [] v, int N) {
		
		try {
		
			
		PrintWriter backup = new PrintWriter("z:\\nonEsisto.txt");
		
			}catch (FileNotFoundException e) {
			
			e.printStackTrace(); 
			System.out.println("Non è stato possibile aprire il file di backup :( ");
			//qui dentro metto la logica applicativa per gestire l'eccezione,
			//ad esempio potrei provare lettura su un altro disco --> c:\\nonEsisto.txt
		
		}finally{
			
			System.out.println("Io vengo eseguito in ogni caso!");
		}												
		
		int somma = 0;
		
		for (int i =0; i<N; i++) 		
			somma+=v[i];
			
		if (N!=0)
			return somma / N ;
		else
			throw new ArithmeticException(); //lancio l'eccezione   //IllegalAccessError();
			
	}
	
	public static int metodoIntermedio(int[] v, int N) {
		
		
		
		//try {
		return mediaInteraVett(v, N);
		//}catch(ArithmeticException errore) { //qui devo specificare il TIPO DI ECCEZIONE CHE POSSO CATTUARE
											//SE LO CAMBIO CHE SUCCEDE??
		//	return -1;
		//}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] vettore = {3,8,-78,19,56,0,41,88,12,13,14,90};
			
		System.out.println(metodoIntermedio(vettore,5));
	}

}
