import java.net.*;
import java.io.*;	
	public class ServeurMultiThread {

		public static void main(String[] args){
			int port=4020;
			ServerSocket se;
			Socket ssv=null;
			
		try{

		 	se = new ServerSocket(port);
			System.out.println("Le serveur est à l'écoute");

			while (true){
				ssv = se.accept();
				ThreadClient thClient = new ThreadClient(ssv);
				thClient.start();
			}

		}catch (IOException e){
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
	

				
			
