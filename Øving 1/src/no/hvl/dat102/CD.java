package no.hvl.dat102;

public class CD {
	private int CDnummer;
	private String artist;
	private String tittel;
	private int aar;
	private Sjanger genre;
	private String plateselskap;
	
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
	
	public enum Sjanger {POP, ROCK, OPERA, KLASSISK;
		
	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	}
	}

	public int getCDnummer() {
		return CDnummer;
	}

	public void setCDnummer(int cDnummer) {
		CDnummer = cDnummer;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getAar() {
		return aar;
	}

	public void setAar(int aar) {
		this.aar = aar;
	}

	public Sjanger getGenre() {
		return genre;
	}

	public void setGenre(Sjanger genre) {
		this.genre = genre;
	}

	public String getPlateselskap() {
		return plateselskap;
	}

	public void setPlateselskap(String plateselskap) {
		this.plateselskap = plateselskap;
	}

	
	
	
}
