public class Compte {
	private int solde=0;    
	public  void ajouter(int somme){
		solde=solde+somme;
		System.out.println(" ajout de " +somme);
		System.out.flush();
	}    
	public  void retirer (int somme){
		solde=solde-somme;
		System.out.println(" retrait de " +somme);
		System.out.flush();
	}    
	public void operationNulle (int somme){
		solde=solde+somme;
		System.out.print(" ajout de " +somme +",");
		solde=solde-somme;
		System.out.print(" et retrait de " +somme +".");
		System.out.println();
		System.out.flush();
	}
	public  int getSolde(){
		return solde;
	}
}
 



