package server;
import java.io.*;
import java.net.*;
import service.ICounter;
public class SkeletonThread extends Thread{
	
	private Socket s;
	private ICounter count; //Riferimento all'interfaccia!
	
	public SkeletonThread (Socket s, ICounter count) {
		this.s=s;
		this.count=count;
	}
	
	public void run() {
		// Ciucciariello di fatica
		// Icounter, invoco i metodi remoti che mi dà l'implementatore
		DataOutputStream ostream = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
		DataInputStream istream = new DataInputStream(new BufferedInputStream(s.getInputStream()));
		String operation;
		
		try {
			operation = istream.readUTF();
			if(operation.equals("inc")) {
				count.inc();
			} else if(operation.equals("sum")) {
				int value = istream.readInt();
				count.sum(value);
			} else if (operation.equals("get")) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
