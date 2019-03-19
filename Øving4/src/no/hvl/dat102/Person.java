package no.hvl.dat102;

public class Person implements Comparable<Person>{
	public String fornavn;
	public String etternavn;
	public int fodselsar;
	
	public Person(String fornavn, String etternavn, int fodselsar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsar = fodselsar;
	}
	
	@Override
	public int compareTo(Person denAndre) {
		int resultat = 0;
		int nr;
		if(this.fodselsar == denAndre.getFodselsar()) {
			if(this.etternavn.equals(denAndre.getEtternavn())) {
				nr = this.fornavn.compareTo(denAndre.getFornavn());
				if(nr < 0) {
					resultat = -1;
				} else {
					resultat = 1;
				}
			}else {
				nr = this.etternavn.compareTo(denAndre.getEtternavn());
				if(nr < 0) {
					resultat = -1;
				} else {
					resultat = 1;
				}
			}
		}else {
			if(this.fodselsar < denAndre.getFodselsar()) {
				resultat = -1;
			} else {
				resultat = 1;
			}
		}
		return resultat;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFodselsar() {
		return fodselsar;
	}

	public void setFodselsar(int fodselsar) {
		this.fodselsar = fodselsar;
	}
	
	public String toString() {
		String ut = this.fodselsar + " " + this.etternavn + ", " + this.fornavn;
		return ut;
	}
	
	
}
