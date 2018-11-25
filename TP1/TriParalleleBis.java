public class TriParalleleBis extends Thread{
	private int[] t;
	private int debut;
	private int fin;
	private int cptNotif = 0;

	private TriParalleleBis(int[] t, int debut, int fin){
		this.t=t;
		this.debut = debut;
		this.fin = fin;
	}

	private void permuter (int a, int b){
		int temp=t[a];
		t[a]=t[b];
		t[b]=temp;
	}

	public void run(){
		if ((fin-debut)<2){
			if (t[debut]>t[fin]){
				permuter(debut,fin);
			}
		} else{
			int milieu=debut + (fin-debut)/2;
			TriParalleleBis t1 = new TriParalleleBis(t, debut, milieu);
			TriParalleleBis t2 = new TriParalleleBis(t, milieu+1, fin);
			trifusion(debut,fin);
		}
	}


	private void trifusion(int debut, int fin){
		int[] tfusion = new int[fin-debut+1];
		int milieu = (debut + fin)/2;
		int i1=debut;
		int i2=milieu+1;
		int ifusion=0;
		while (i1<=milieu && i2<=fin){
			if (t[i1]<t[i2]){
				tfusion[ifusion++]=t[i1++];         
			} else{
				tfusion[ifusion++]=t[i2++];
			}
		}      
		if (i1>milieu){
			for (int i=i2; i<=fin; i++){
				tfusion[ifusion++]=t[i];
			}
		} else{
			for (int i=i1; i<=milieu; i++){
				tfusion[ifusion++]=t[i];
			}
		}               
		for (int i=0, j=debut; i<=fin-debut; i++, j++){
			t[j]= tfusion[i];
			}   
		}
	public static void main(String[] args){
		int[] tableau={5,8,3,2,7,10,1,12,4};
		TriParalleleBis t = new TriParalleleBis(tableau, 0, tableau.length-1);
		t.start();
		try{
			t.join();
		}
		catch(InterruptedException exc) {}
		for(int i=0; i<tableau.length; i++){
		System.out.println(tableau[i] + " ; ");     
		}
		System.out.println();
	}
	}
