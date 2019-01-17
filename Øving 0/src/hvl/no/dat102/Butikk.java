package hvl.no.dat102;

public class Butikk {
	private String navn;
	private Vare[] vare;
	private int[] lager;
	private int AntallTyper;
	
	public Butikk(String navn, int maks) {
		this.navn = navn;
		lager = new int[maks];
	}
	
	public int finnVare(int varenr) {
		for(int i = 0; i < 0; i++) {
			if(varenr == vare[i].getVarenummer()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean erLedigPlass() {
		if(AntallTyper < vare.length) {
			return true;
		}
		return false;
	}
	
	public void leggInnNyVare(int varenr) {
		
	}
	
	public void slettVare(int varenr) {
		
	}
	
	public void detaljSalg(int varenr) {
		
	}
	
	public void grossInnkjøp(int varenr, int tall) {
		
	}
	
	public double selgsVerdi() {
		
	}
}
