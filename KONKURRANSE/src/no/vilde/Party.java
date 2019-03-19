package no.vilde;

import java.io.*;
import java.util.*;



public class Party {
	private static final String SKILLE = "";
	
	public static String[] lesFraFil(String filnavn){
		String[] svar = null;
		try {
			Scanner leser = new Scanner(new File(filnavn));

			int cases = Integer.parseInt(leser.nextLine());
			svar = new String[cases];
			
			for(int i = 0; i < cases; i++) {
				int caseSum = 0;
				int n = Integer.parseInt(leser.nextLine());
				for(int j = 0; j < n; j++ ) {
					String post = leser.nextLine();
					String[] felt = post.split(SKILLE);
					int nr = leser.nextInt();
					caseSum += nr;						
				}
				svar[i] = "Case #" + (i+1) + ": " + "caseSum";
			}
			
			leser.close();
			
			
			
		} catch (Exception e) {
			System.out.println("error");
		}
		
		return svar;
		
		
	}
	
	
	public static void skrivTilFil(String[] res, String filnavn)  {
		try {
			 
			FileWriter ansFil = new FileWriter(filnavn, false);  
			 
			PrintWriter utfil = new PrintWriter(ansFil);
			int antall = res.length;
			
			for (int i = 0; i < antall; i++) {
				utfil.print(res[i]);
				utfil.print(SKILLE);
			} 
			
			utfil.close();
		}catch (Exception e) {
			System.out.println("error");
		}
	}
}
