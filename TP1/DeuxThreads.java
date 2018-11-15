public class DeuxThreads extends Thread {
	public void run(){
		for (int i=0; i<10; i++){
		try {
			sleep(1000);
		}catch (Exception e) {
			e.printStackTrace();
	}
		this.setName("Thread fils : "+i);
		System.out.println(this.getName());
		System.out.flush();
	
	}
	}
	public static void main (String[] args){
		DeuxThreads th = new DeuxThreads();    
		th.start();
		currentThread().setName("Pere");
		for (int i=0; i<10; i++){
		try {
				sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
		}
			/*currentThread().yield();*/
		System.out.println(currentThread().getName());
		System.out.flush();
		
	}
	}
	}

