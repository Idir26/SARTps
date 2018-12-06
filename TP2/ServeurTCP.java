import java.net.*;
import java.io.*;

public class ServeurTCP{
	public static void main(String[] args){
	int port= 4020;
	ServerSocket se;
	Socket ssv=null;
	PrintWriter out;
	BufferedReader in;
	try{
		se = new ServerSocket(port);
		System.out.println("Serveur est a l'ecoute");
		ssv = se.accept();
		System.out.println("Demande de connexion acceptee");
		in = new BufferedReader(new InputStreamReader(ssv.getInputStream()));
		out = new PrintWriter(ssv.getOutputStream(),true);  

		for(int i =0; i<10; i++){
		String req = in.readLine();
		System.out.println("Le client me dit :" + req);
		
		
		String m = "Bienvenu";
		
		out.println(m);
		}       
	}
	catch (IOException e){
		System.err.println("Erreur : " +e);
	}
	finally{
		try{
			ssv.close();
	}
		catch (IOException e){}
		}
	}
}
