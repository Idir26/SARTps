import java.net.*;
import java.io.*;	
	public class ThreadClient extends Thread{
			
			Socket ssv=null;
			PrintWriter out;
			BufferedReader in;

		public ThreadClient(Socket ssv){ this.ssv = ssv;}

		public void run() {
			try{

			in = new BufferedReader(new InputStreamReader(ssv.getInputStream()));
			out = new PrintWriter(ssv.getOutputStream(), true); 
	
			String req;

			String rep ="Le serveur est à l'écoute";
			out.println(rep);
			
			while(true){
				req = in.readLine();
		        	System.out.println("Le client me dit :"+req);
				if(req.equals("") || req.equals("bye")){
					break;
				}
				try {
				sleep(2000);
				}
				catch(InterruptedException e) {
				System.err.println("Erreur : " +e);
				}
				
				rep = "Bienvenu sur ce serveur";
				out.println(rep);
			}

			System.out.println("Connexion interrompue");
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
		



			







	
