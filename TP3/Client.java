import java.rmi.*;
 
public class Client {
 
    public static void main(String[] argv) {
        try {
        String urlCalcul = "rmi://127.0.0.1/Calcul1";
        CalculInterface calcul = (CalculInterface)Naming.lookup(urlCalcul);
        System.out.println(calcul.somme(2,3));
        String urlCompteur = "rmi://127.0.0.1/Compteur1";
        CompteurInterface compteur = (CompteurInterface)Naming.lookup(urlCompteur); 
        System.out.println(compteur.nbOccurrences("d","dedicace"));
        }
        catch(Exception e) {
            System.out.println("Erreur client : " +e);
        }
    }
 
}
