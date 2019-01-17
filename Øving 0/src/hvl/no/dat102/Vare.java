package hvl.no.dat102;

import javax.swing.JOptionPane;

public class Vare {
	int varenummer;
	String navn;
	double pris;
	int antall;
	
	public Vare(){
		
	}
	
	public Vare(int varenr) {
		varenummer = varenr;
	}
	
	public Vare(int varenummer, String navn, double pris) {
		this.varenummer = varenummer;
		this.navn = navn;
		this.pris = pris;
	}
	
	public int getVarenummer() {
		return varenummer;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public double getPris() {
		return pris;
	}
	
	public void setVarenummer(int varenummer) {
		this.varenummer = varenummer;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public void lesVare(int varenummer) {
		String navn = JOptionPane.showInputDialog("Skriv inn navn på varen");
		String tpris = JOptionPane.showInputDialog("Skriv inn prisen på varen");
		double pris = Double.parseDouble(tpris);
		
		if(pris < 0) {
			JOptionPane.showMessageDialog(null, "Du kan ikke sette negativ pris");
		} else {
			Vare(varenummer, navn, pris);
			
		
		}
	}
}
