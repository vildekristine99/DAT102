package no.hvl.dat102;
import javax.swing.JOptionPane;

import no.hvl.dat102.adt.CDarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private boolean run;
	
	public Meny(CDarkivADT cda){
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
		run = true;
	}
	public void start(){
		String message = "1. Eksisterende arkiv \n2. Opprette ett nytt arkiv";
		String input = JOptionPane.showInputDialog(message);
		int valg = Integer.parseInt(input);
		
		switch(valg) {
		case 1: 
			String filnavn = JOptionPane.showInputDialog("Skriv inn eksisterende filnavn");
			Fil.lesFraFil(filnavn);
			
			while(run) {
				menyValg(cda);
			}
			break;
		case 2:
			String lengde = JOptionPane.showInputDialog("Hvor mange CD ønsker du i arkivet?");
			int tall = Integer.parseInt(lengde);
			CDarkivADT cda = new CDarkiv(tall);
			
			while(run) {
				menyValg(cda);
			}
			
			
			break;
		default:
			JOptionPane.showMessageDialog(null, "Ikke gyldig");
			
		}
	}
	
	public void menyValg(CDarkivADT cda) {
		String meny = "1. Legg til CD\n2. Slett CD\n"
				+ "3.Vis CD\n4. Søk Tittel\n5. Søk artist\n"
				+ "6. Vis statestikk for Sjangere og CDer\n7. Avslutt";
		String input = JOptionPane.showInputDialog(meny);
		int menyValg = Integer.parseInt(input);
		switch(menyValg) {
		case 1:
			CD nyCd = tekstgr.lesCD();
			cda.leggTilCd(nyCd);
			break;
			
		case 2:
			String input2 = JOptionPane.showInputDialog("Skriv inn CDnummer:");
			int cdnr = Integer.parseInt(input2);
			cda.slettCd(cdnr);
			break;
			
		case 3:
			String input3 = JOptionPane.showInputDialog("Skriv inn CDnummer:");
			int cdnr2 = Integer.parseInt(input3);
			CD cd = cda.soekCD(cdnr2);
			tekstgr.visCD(cd);
			break;
		
		case 4:
			String input4 = JOptionPane.showInputDialog("Skriv inn tittel du ønsker å søke på:");
			tekstgr.skrivUtCdDelstrengITittel(cda, input4);
			break;
		
		case 5:
			String input5 = JOptionPane.showInputDialog("Skriv inn tittel du ønsker å søke på:");
			tekstgr.skrivUtCdArtist(cda, input5);
			break;
		
		case 6:
			tekstgr.skrivUtStatistikk(cda);
			break;
		
		case 7:
			String filnavn2 = JOptionPane.showInputDialog("Skriv inn filnavn");
			Fil.skrivTilFil(cda, filnavn2);
			break;
		
		case 8:
			String melding = "Avslutter programmet";
			JOptionPane.showMessageDialog(null, melding);
			run = false;
			break;
		
		default:
			JOptionPane.showMessageDialog(null, "Ikke gyldig");
			
		}
		
	}
}
