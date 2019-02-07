package no.hvl.dat102;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat102.CD.Sjanger;
import no.hvl.dat102.adt.CDarkivADT;
import no.hvl.dat102.CDarkiv;

public class Fil {
	private static final String SKILLE = "#";
	
	public static CDarkivADT lesFraFil(String filnavn)  {
		CDarkivADT cda = null;
			try {
					  
			FileReader ansFil = new FileReader(filnavn);
			 			  
			BufferedReader innfil = new BufferedReader(ansFil);
			      
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);
			cda = new CDarkiv(n);
			
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int nr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int aar = Integer.parseInt(felt[3]);
				String sjStr = felt[4];
				Sjanger sj = Sjanger.finnSjanger(sjStr);
				String plselskap = felt[5];
				CD cd = new CD(nr, artist, tittel, aar, sj, plselskap);
				cda.leggTilCd(cd);
				
				// 4 - Lukk filen
			    innfil.close();
			}
			
		} catch (FileNotFoundException unntak) {// arver fra IOE.. m� st� f�rst
			                                    // hvis ikke vil unntaket for IOException skygge
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1); //avbryte utf�ringen
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2); //avbryte utf�ringen
		}
      
	return cda;
       
	}// metode
	
	
	public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn)  {
		try {
			 
			FileWriter ansFil = new FileWriter(filnavn, false);  
			 
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = cdarkiv.antall();
			// 3 - Skriver f�rst ut antall cd-info-er p� f�rste linje
			utfil.println(antall);
			CD[] tabell = cdarkiv.hentCdTabell();
			for (int i = 0; i < antall; i++) {
				// 3 - Skriver postene, felt for felt
				utfil.print(tabell[i].getCDnummer());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getAar());
				utfil.print(SKILLE);
				utfil.print(tabell[i].getGenre());
				utfil.print(SKILLE);
				utfil.println(tabell[i].getPlateselskap());
			} // for
				// 4 - Lukk filen
			utfil.close();
		} // try
		
				
		catch(FileNotFoundException e) {
			System.out.print("feil ved �pning av fil: " + filnavn);
			System.exit(1); // avbryte utf�ringen
		}
		catch (IOException e) {
			System.out.println("Feil p� skriving til fil: " + e);
			System.exit(2);// avbryte utf�ringen
		}
	}// metode
}
