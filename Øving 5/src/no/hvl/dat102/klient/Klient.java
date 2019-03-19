package no.hvl.dat102.klient;

import java.time.Duration;
import java.time.Instant;

import no.hvl.dat102.hanoi.Hanoi;
import no.hvl.dat102.rekursjon.Rekursjon;

public class Klient {

	public static void main(String[] arg) {
		System.out.println(Rekursjon.sum(100));
		
		for(int i = 0; i < 10; i++) {
			System.out.println(Rekursjon.metode(i));
		}
		
		Hanoi taarn = new Hanoi(4);
		taarn.solve();
		
		System.out.println("\n\n");
		
		
		Hanoi taarn2 = new Hanoi(4);
		taarn2.solveAntall();
		
		System.out.println("\n\n");
		
		long nanotid1 = System.nanoTime();
		Instant tid1 = Instant.now();
		Hanoi taarn3 = new Hanoi(16);
		taarn3.solveAntall();
		long nanotid2 = System.nanoTime();
		Instant tid2 = Instant.now();
		
		
		
		Duration varighet = Duration.between(tid1, tid2);
		System.out.println("Med Instant.now() og Duration.toMillis(): Tok " + varighet.toMillis() + "ms." );
		System.out.println("Med System.nanoTime: Tok " + (nanotid2-nanotid1) + " nanosek");
		
	
		
	}

}
