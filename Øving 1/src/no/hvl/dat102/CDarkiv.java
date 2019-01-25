package no.hvl.dat102;

import no.hvl.dat102.CD.Sjanger;
import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {
	private CD[] cdTabell;
	private int antall;
 
	public CDarkiv(int lengde) {
		cdTabell = new CD[lengde];
		antall = 0;
	}
	 
	public CD[] hentCdTabell() {
		return cdTabell;
	}
	
	private void utvidKapasitet(){//eks. utvide 10%
		 CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 *
		cdTabell.length)];
		 for (int i = 0; i < cdTabell.length; i++){
		 hjelpetabell[i] = cdTabell[i];
		 }
		 cdTabell = hjelpetabell;
	}
	
	public void leggTilCd(CD nyCd) {
		if (antall == cdTabell.length){
			 utvidKapasitet();
			 }
		cdTabell[antall] = nyCd;
			 antall++;
		//evt sjekke om det finnes fra før
	}
	
	public boolean slettCd(int cdNr) {
		boolean slett = false;
		for(int i = 0; i < antall && !slett; i++) {
			if(cdTabell[i].getCDnummer() == cdNr) {
				cdTabell[i] = cdTabell[antall];
				antall--;
				slett = true;
			}
		}
		trimTab(cdTabell, antall);
		return slett;
		
	}
	
	public CD[] sokTittel(String delstreng) {
		int antTreff = 0;
		CD[] resultat = new CD[antall];
		for(int i = 0; i < cdTabell.length; i++) {
			if(cdTabell[i].getTittel().contains(delstreng)) {
				cdTabell[i] = resultat[antTreff];
				antTreff++;
			}
		}
		trimTab(resultat, antTreff);
		return resultat;
	}
	
	public CD[] sokArtist(String delstreng) {
		int antTreff = 0;
		CD[] resultat = new CD[antall];
		for(int i = 0; i < cdTabell.length; i++) {
			if(cdTabell[i].getArtist().contains(delstreng)) {
				cdTabell[i] = resultat[antTreff];
				antTreff++;
			}
		}
		trimTab(resultat, antTreff);
		return resultat;
	}
	
	public int antallSjanger(Sjanger sjanger) {
		int antS = 0;
		for(int i = 0; i < antall; i++) {
			if(sjanger == cdTabell[i].getGenre()) {
				antS++;
			}
		}
		return antS;
	}
	
	public int antall() {
		return antall;
	}
	
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
		         cdtab2[i] = tab[i];
		         i++;
		   }
		return cdtab2; 
	}
	
	public CD soekCD(int cdnr) {
		CD cd = null;
		for(int i = 0; i < antall; i++) {
			if(cdnr == cdTabell[i].getCDnummer()) {
				cd = cdTabell[i];
			}
		}
		return cd;
	}

}//class