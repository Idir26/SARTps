import java.net.*;
import java.io.*;

public class ServeurMultiThread {
	static int port= 4020;
	Socket soc;

	public ServeurMultiThread(Socket soc) {
		this.soc = soc;
	}

	public static void main(String[] args){
	try{
		ServerSocket se = new ServerSocket(port);
		System.out.println("Serveur est a l'ecoute");
		while(true){    
			Socket ssv = se.accept();
			ThreadClient th = new ThreadClient(se);
			th.start(); 
	      }
	}
	catch (IOException e){
		System.err.println("Erreur : " +e);
	}
	}
}
