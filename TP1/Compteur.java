public class Compteur extends Thread {
	public void run(){
		for (int i=0; i<10; i++){
		int hasard = (int)(Math.random()*5000);
		try {
			sleep(hasard);
		}catch (Exception e) {
			e.printStackTrace();
	}
		
		System.out.println("Thread "+ this.getName() +"a fini de compter jusqu'à 10");
		System.out.flush();
	
	}
	}
	public static void main (String[] args){
		int n = Integer.parseInt(args[0]);
		
		for (int i=0; i<n; i++){
		Thread th = new Compteur();    
		th.start();	
		System.out.flush();
		
	}
	}
	}



