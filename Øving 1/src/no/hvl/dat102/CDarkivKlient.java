package no.hvl.dat102;
import no.hvl.dat102.adt.CDarkivADT;
import no.hvl.dat102.CDarkiv;

public class CDarkivKlient {
	public static void main(String[] args){
		  //… meny
		int n = 1;
		CDarkivADT cda = new CDarkiv(n);
		Meny meny = new Meny(cda);
		meny.start();
		
	}

}
