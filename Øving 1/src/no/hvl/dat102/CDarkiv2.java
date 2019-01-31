package no.hvl.dat102;

import no.hvl.dat102.CD.Sjanger;
import no.hvl.dat102.adt.*;

public class CDarkiv2 implements CDarkivADT {
	 private int antall;
     private LinearNode<CD> start;
     
     public CDarkiv2() {
    	 start = null;
    	 antall = 0;
     }
     
	@Override
	public CD[] hentCdTabell() {
		CD[] arkiv = new CD[antall];
		LinearNode<CD> nynode = start;
		for (int i = 0; i<antall && nynode != null; i++) {
			arkiv[i] = nynode.getElement();
			nynode = nynode.getNeste();
		}
		return arkiv;
	}
	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	
	@Override
	public boolean slettCd(int cdNr) {
		boolean slettet = false;
		LinearNode<CD> forrige = null;
		LinearNode<CD> p = start;
		
		if (antall == 0) {
			System.out.println("Tabellen er tom.");
			return slettet;
			
		} else if (p.getElement().getCDnummer() == cdNr) {
			LinearNode<CD> nyNode = start.getNeste();
			start = nyNode;
			antall--;
			slettet = true;
			
		} else {
			while ((p.getNeste() != null) || slettet == false) {
				if (p.getElement().getCDnummer() == cdNr ) {
					forrige.setNeste(p.getNeste());
					antall--;
					slettet = true;
				}
				forrige = p;
				p = p.getNeste();
			}
			
		}
		
		return slettet;
	}
	
	@Override
	public CD[] sokTittel(String delstreng) {
		
		CD[] tittel = new CD[antall];
		int ant = 0;
		
		LinearNode<CD> denne = start;
		while (denne != null) {
			if (denne.getElement().getArtist().contains(delstreng)) {
				tittel[ant] = denne.getElement();
				ant++;
			} 
				denne = denne.getNeste();
		}
		trimTab(tittel, ant);
		return tittel;
	}
	
	
	@Override
	public CD soekCD(int cdnr) {
		
		CD cd = null;
		boolean funnet = false;
		
		LinearNode<CD> denne = start;
		for (int i = 0; i<antall && !funnet; i++) {
			if (denne.getElement().getCDnummer() == cdnr) {
				funnet = true;
			} else {
				denne = denne.getNeste();
			}
		}
		return cd;
	}
	@Override
	public CD[] sokArtist(String delstreng) {
		
		CD[] artist = new CD[antall];
		int ant = 0;
		
		LinearNode<CD> denne = start;
		while (denne != null) {
			if (denne.getElement().getArtist().contains(delstreng)) {
				artist[ant] = denne.getElement();
				ant++;
			} 
				denne = denne.getNeste();
		}
		trimTab(artist, ant);
		return artist;
	}
	
	@Override
	public int antallSjanger(Sjanger sjanger) {
		int teller = 0;
		LinearNode<CD> denne = start;
		for (int i = 0; i< antall && denne != null ; i++) {
			if (denne.getElement().getGenre() == sjanger) {
				teller++;
			} 
			denne = denne.getNeste();
		}
		
		return teller;
	}

	@Override
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
     
}
