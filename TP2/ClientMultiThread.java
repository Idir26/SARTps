import java.net.*;
import java.io.*;
	
public class ClientMultiThread extends Thread{
		static int port=4020;
		static InetAddress hote=null;
		Socket sc=null;
		BufferedReader in;
		PrintWriter out;
		int compteur = 0;
		String nom;

	public ClientMultiThread(String nom){
			this.nom=nom;
			start();
	}

		
	public void run(){
		try{
			sc = new Socket(hote, port);
 			System.out.println("Demande de connexion");

			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			out = new PrintWriter(sc.getOutputStream(), true); 

			for (int i =0;i<10;i++){
				String rep = in.readLine();
				System.out.println("Le serveur me dit :"+rep);

				compteur++;

				String req = "Je suis le client "+nom+" et j'ai fais "+compteur+" appels";
				out.println(req);
				
				try {
				sleep(2000);
				}
				catch(InterruptedException e) {
				System.err.println("Erreur : " +e);
				}
			}

			out.println("bye");
			System.out.println("Bye Bbye :");
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

	public static void main (String[] args){
		
		try{
			if (args.length>=2){
				hote=InetAddress.getByName(args[0]);
				port=Integer.parseInt(args[1]);
			}
			else{
				hote = InetAddress.getLocalHost();
			}
			ClientMultiThread clientth = new ClientMultiThread("toto");

		}
		catch(UnknownHostException e){
				System.err.println("Machine inconnue :" +e);
		}
	}

}
