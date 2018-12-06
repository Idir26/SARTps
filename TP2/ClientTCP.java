import java.net.*;
import java.io.*;

public class ClientTCP{
	public static void main (String[] args){
		int port= 4020 ;
		InetAddress hote=null;
		Socket sc=null;
		BufferedReader in;
		PrintWriter out;
		try{
			if (args.length>=2){
				hote= InetAddress.getByName(args[0]);
				port= Integer.parseInt(args[1]);
			}else{
				hote = InetAddress.getLocalHost();
			}
		}
		catch(UnknownHostException e){
			System.err.println("Machine inconnue :" +e);
		}
		try{
			sc = new Socket(hote, port);
			System.out.println("Demande de connexion  ");
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			out = new PrintWriter(sc.getOutputStream(),true);
			
			String m = "Bonjour";
			for(int i =0; i<10; i++){
			out.println(m + i);
			}
			String entree = in.readLine();
			System.out.println("Serveur dit "+entree);
			
		}
		catch(IOException e){
		System.err.println("Impossible de creer la socket du client : " +e);
		}
		finally{
			try{
				sc.close();
			}
			catch (IOException e){}
		}
	}
}
