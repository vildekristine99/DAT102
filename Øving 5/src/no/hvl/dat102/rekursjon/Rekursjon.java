package no.hvl.dat102.rekursjon;

public class Rekursjon {
	
	
	public static int sum(int n) {
		if(n == 1) {
			return 1;
		} else {
			return sum(n-1)+n;
		}
	}
	
	public static int metode(int n) {
		if(n == 0) {
			return 2;
		} else if (n == 1) {
			return 5;
		} else {
			return 5 * metode(n-1) - 6 * metode(n-2) + 2;
		}
	}
}
