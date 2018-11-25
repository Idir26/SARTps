public class Operation extends Thread {
	private Compte compte;    
	public Operation(String nom, Compte compte){
		super(nom);
		this.compte=compte;    
	}    
	
	public void run(){
		while(true){
			int i= (int) (Math.random() * 10);
			String nom=this.getName();
			System.out.print(nom); 
			synchronized (compte) {
			this.compte.ajouter(i); /* Il faut mettre ajouter et retirer dans le même bloc pour faire l'ajout et le retrait avant de donner le verrou
						cela marchait pour opération nulle car l'ajout et le retrait marchait dans le corps de la méthode donc mettre synchronized 
						dans la methode suffit par contre avec ajout et retirer ca suffit pas */
			this.compte.retirer(i); 
			//this.compte.operationNulle(i); dans ce cas pas la peine de la mettre en synchronized ni get solde d'ailleurs si on enlève synchronized(compte) il faudrait
			// rajouter synchronized dans les signatures de operationNulle et get solde
			int montant=this.compte.getSolde(); 
			
			if (montant !=0){
				System.out.println(nom +"solde =" +montant);
					System.exit(1);
			}} 
		}
	}
	
	public static void main(String[] args){
		Compte c = new Compte();
		for(int i=1; i<=2; i++){
			Operation op= new Operation("op"+i,c);
			op.start();
			}
		}
	}
