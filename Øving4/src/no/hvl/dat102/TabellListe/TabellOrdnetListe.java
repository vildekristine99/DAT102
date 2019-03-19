package no.hvl.dat102.TabellListe;

import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	
	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;
		if(!erTom()) {
			resultat = liste[bak-1];
			bak--;
		}
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		T resultat = null;
		if(!(erTom())) {
			resultat = liste[0];
			for(int i = 0; i < bak - 1; i++) {
				liste[i] = liste[i+1];
			}
			bak--;
		}
		return resultat;
	}

     @Override
	public T foerste() {
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		//...Fyll ut
		
	return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
    @Override
	public void leggTil(T element) {
    	if(bak == liste.length - 1) { //hvis tabellen er full m� vi utvide
    		utvid();
    	}
    	
    	//Finner index der vi skal sette inn elementet
    	int i = 0;
    	while(liste[i] != null && element.compareTo(liste[i]) > 0) {
    		i++;
    	}
    	
    	//I peker paa plassen vi skal ha inn element, setter j = bak og flytter
    	//alle elmentene som er stoerre til i+1
    	int j = bak;
    	while(j > i) {
    		liste[j] = liste[j+1];
    		j--;
    		i++;
    	}
    	
    	//Setter liste[i] til elmentet vi vil sette inn
    	liste[i] = element;
    	bak++;
    	
	}

	
	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		T resultat = null;
		int indeks = finn(element);
		
		if(indeks != IKKE_FUNNET) {
			resultat = liste[indeks];
			bak--;
			
			for(int i = indeks; i < bak; i++) {
				liste[i] = liste[i+1];
			}
		}
		return resultat;
		
	}		

	private int finn(T el) {
		int resultat = IKKE_FUNNET;
		if(!erTom()) {
			for(int i = 0; i < bak; i++) {
				if(el == liste[i]) {
					resultat = i;
				}
			}
		}
		
		/*
		 int i = 0, resultat = -1;
		if (!erTom()) {
			while (i < bak && el.compareTo(liste[i]) > 0) {
				i++;
			}
			if (i < bak && el.compareTo(liste[i]) == 0) {
				resultat = i;
			}
		}
		*/
		
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}


	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++){
			hjelpeTabell[i] = liste[i];
		}
		
		liste = hjelpeTabell;
	}

}// class
