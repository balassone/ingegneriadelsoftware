package client;
import service.ICounter;

import java.net.*;
import java.io.*;

public class CounterProxy implements ICounter{

	private String host;
	private int port;
	
	public CounterProxy(String host, int port) {
		this.host=host;
		this.port=port;
	}
	
	public void inc() {
		try {
			
			Socket soc = new Socket(host,port);
			DataOutputStream ostream = new DataOutputStream(new BufferedOutputStream(soc.getOutputStream()));
			
			
			ostream.writeUTF("inc"); //Usa il tipo opportuno!
			ostream.flush();
			
			
			soc.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Host sconosciuto, stai attento!");
		}
	}
	
	public void sum(int value) {
		try {
			
			Socket soc = new Socket(host,port);
			DataOutputStream ostream = new DataOutputStream(new BufferedOutputStream(soc.getOutputStream()));
			
			// TCP: sono sicuro che viene inviato prima sum e poi value! UDP non avrei avuto garanzie!
			ostream.writeUTF("sum"); //Usa il tipo opportuno!
			ostream.writeInt(value);
			ostream.flush();
			
			
			soc.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Host sconosciuto, stai attento!");
		}
	}
	
	public int get() {
		
		try {
			
			Socket soc = new Socket(host,port);
			DataOutputStream ostream = new DataOutputStream(new BufferedOutputStream(soc.getOutputStream()));
			DataInputStream istream = new DataInputStream(new BufferedInputStream(soc.getInputStream()));
			
			ostream.writeUTF("get"); //Usa il tipo opportuno!
			ostream.flush();
			
			int x = istream.readInt();
			
			soc.close();
			
			return x;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Host sconosciuto, stai attento!");
		}
		return 0;
		
	}
	
	public void square() {
		try {
			
			Socket soc = new Socket(host,port);
			DataOutputStream ostream = new DataOutputStream(new BufferedOutputStream(soc.getOutputStream()));
			
			
			ostream.writeUTF("sqr"); //Usa il tipo opportuno!
			ostream.flush();
			
			
			soc.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Host sconosciuto, stai attento!");
		}
	}
	
}
