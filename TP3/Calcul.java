import java.rmi.*;
import java.rmi.server.*;

public class Calcul extends java.rmi.server.UnicastRemoteObject implements CalculInterface {
	
	public Calcul() throws RemoteException{
		super();
	}
     
    public int somme(int a, int b) throws RemoteException {
		return a+b;
    }
}
