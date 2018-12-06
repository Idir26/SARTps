import java.io.*;
import java.net.*;
 
public class ThreadClient {
     
    public static void main (String[] args) {
        int port = 4020;
        InetAddress hote;
        Socket sc = null;
        BufferedReader in; 
        PrintWriter out; 
        int compteur = 0;
         
        try {
            if (args.length>=2) {
                hote = InetAddress.getByName(args[0]);
                port = Integer.parseInt(args[1]);
            }
            else {
                hote = InetAddress.getLocalHost();
            }
        }
        catch(UnknownHostException e){
            System.err.println("Machine inconnue :" +e);
        }
 
        try{
            sc = new Socket(hote,port);
            System.out.println("Socket cree");
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            out = new PrintWriter(sc.getOutputStream(), true);
         
            for(int i=0; i<10; i++) {
                String reception = in.readLine();
                System.out.println("Serveur : "+reception);
                compteur++;
                String str = "Je suis le client "+InetAddress.getLocalHost()+ ", j'ai fait 			"+compteur+" appels.";
                out.println(str);
                System.out.println("Client : " +str);
                Thread.sleep(2000);
            }
            out.println("Bye");
            System.out.println("Client : Bye");
        }
        catch(Exception e){
            System.err.println("Impossible de creer la socket du client : "+e);
        }
        finally{
            try{
                sc.close();
                in.close();
                out.close();
            }
            catch (IOException e){}
        }
    }
}
