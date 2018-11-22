public class TriParallele{
	private int[] t;
	private TriParallele(int[] t){
		this.t=t;
	}

	private void permuter (int a, int b){
		int temp=t[a];
		t[a]=t[b];
		t[b]=temp;
	}

	private void trier (int debut, int fin){
		if ((fin-debut)<2){
			if (t[debut]>t[fin]){
				permuter(debut,fin);
			}
		} else{
			int milieu=debut + (fin-debut)/2;
			trier(debut,milieu);
			trier(milieu+1,fin);
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
		TriParallele t = new TriParallele(tableau);
		t.trier(0,tableau.length-1);
		for(int i=0; i<tableau.length; i++){
		System.out.println(tableau[i] + " ; ");     
		}
		System.out.println();
	}
	}
