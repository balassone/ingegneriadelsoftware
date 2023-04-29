package server;
import service.ICounter;
import java.net.*;
// Ereditarietà, chi implementa tutti i metodi è il server stesso

public abstract class CounterSkeleton implements ICounter {
	// Aggiungi per delega nel caso
	void runSkeleton() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		serverSocket = new ServerSocket(2500);
		System.out.println("Server in ascolto sul porto 2500");
		
		while(true) {
			// prendere la richiesta
			
			socket = serverSocket.accept();
			// servi la richiesta schedula un nuovo thread SkeletonThread
			SkeletonThread st = new SkeletonThread(socket, this); //This implementa l'interfaccia
			st.start();
			
		}
	}
	
}
