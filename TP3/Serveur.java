import java.rmi.*;

public class Serveur {
    public static void main(String[] argv) {
        try {
            String urlCalcul = "rmi://127.0.0.1/Calcul1";
 
            Naming.rebind(urlCalcul, new Calcul());
 
            String urlCompteur = "rmi://127.0.0.1/Compteur1";
            Naming.rebind(urlCompteur, new Compteur());
 
            System.out.println("Serveur prêt !!");
         
        }
        catch(Exception e) { 
            System.out.println("Erreur serveur : " + e);
        }
 
    }
}
