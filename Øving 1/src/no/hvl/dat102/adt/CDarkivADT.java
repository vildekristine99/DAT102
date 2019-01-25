package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.CD.Sjanger;

public interface CDarkivADT {
	
	
	CD[] hentCdTabell();
	
	void leggTilCd(CD nyCd);
	
	boolean slettCd(int cdNr);
	
	CD[] sokTittel(String delstreng);
	
	CD[] sokArtist(String delstreng);
	
	// Henter antall CD-er for en gitt sjanger
	int antallSjanger(Sjanger sjanger);
	
	int antall();
	
	public CD soekCD(int cdnr);
}
//interface 
