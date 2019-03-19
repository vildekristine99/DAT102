package no.hvl.dat102.hanoi;

public class Hanoi {
	private int totalDisks;
	private long flyttninger;
	
	private long tidsystem;
	
	public Hanoi(int antallDisker) {
		totalDisks = antallDisker;
		flyttninger = 0;	
	}
	
	public void solve() {
		flytt(totalDisks,1,3,2);
	}
	
	public void solveAntall() {
		//instant tid1
		long nanoTid1 = System.nanoTime();
		
		flytt2(totalDisks,1,3,2);
		long nanoTid2 = System.nanoTime();
		
		tidsystem = nanoTid2 - nanoTid1;
		
		System.out.println("Brukt " + totalDisks + " disker. Gjort " + flyttninger + " flyttinger.");
		System.out.println("Formel: a_n = 2^n - 1 = " + (Math.pow(2, totalDisks)  -1));
	}
	
	public void flytt(int numDisks, int start, int end, int temp) {
		if(numDisks == 1) {
			flyttEn(start, end);
		} else {
			flytt(numDisks-1, start, temp, end);
			flyttEn(start, end);
			flytt(numDisks-1, temp, end, start);
		}
	}
	
	public void flyttEn(int start, int end) {
		System.out.println("Flytt en disk fra " + start + " til " + end);
	}
	
	public void flytt2 (int antallDisker, int start, int slutt, int temp) {
		if(antallDisker == 1) {
			flyttninger++;
		} else {
			flytt2(antallDisker-1, start, temp, slutt);
			flyttninger++;
			flytt2(antallDisker-1, start, temp, slutt);
		}
	}
	
	public long getTid() {
		return tidsystem;
	}
}
