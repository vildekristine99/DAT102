package no.hvl.dat102;

public class CD {
	public int CDnummer;
	public String artist;
	public String tittel;
	public int aar;
	public Sjanger genre;
	public String plateselskap;
	
	public CD() {
		
	}
	
	public CD(int CDnummer, String artist, String tittel, int aar, Sjanger genre, String plateselskap) {
		this.CDnummer = CDnummer;
		this.artist = artist;
		this.tittel = tittel;
		this.aar = aar;
		this.genre = genre;
		this.plateselskap = plateselskap;
	}
	
	public enum Sjanger {POP, ROCK, OPERA, KLASSISK;}
	
	
}
