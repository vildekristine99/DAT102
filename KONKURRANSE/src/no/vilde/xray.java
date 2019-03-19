package no.vilde;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class xray {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\be24059903\\Desktop\\Skrivebord\\HVL\\DAT102\\DAT102\\KONKURRANSE\\answer.txt"); //create file object, answer.txt must not exists at this point
		Path filePath = Paths.get("C:\\Users\\be24059903\\Desktop\\Skrivebord\\HVL\\DAT102\\DAT102\\KONKURRANSE\\data.txt"); //Creates path to input data
		file.createNewFile(); //Creates answer.txt
		
		FileOutputStream fileOUT = new FileOutputStream(file); //Output stream to answer.txt
		Scanner fileIN = new Scanner(filePath); //Create file scanner object
		
		int cases = fileIN.nextInt(); //Find next int in file
		System.out.println(cases);
		System.out.println("yo");
		for(int i = 0; i < cases; i++) { //For number of cases
			int N = fileIN.nextInt();
			
			int level = 0;
			boolean up = true;
			int radio = 0;
				
			int[] nr = new int[N];
			
			for(int j = 0; j < N; j++) {
				nr[j] = fileIN.nextInt();
			}
			
			for(int k = 0;  k < (N-1); k++) {
				if(up && nr[k+1] < nr[k]) {
					up = false;
					radio += nr[k] - level;
					
				} else if(!up && nr[k+1] > nr[k]) {
					up = true;
					level = nr[k];				
				} 
							
			}	
			
			if(up) {
				radio += nr[N-1] - level;
			}
			String output = "Case #" + Integer.toString(i + 1) + ": " + Integer.toString(radio) + "\n";
			
			byte[] byteOUT = output.getBytes(); //convert string to bytes
			fileOUT.write(byteOUT); //write bytes to file
		}
		fileOUT.flush(); //flush output (push any output saved in buffer)
		fileIN.close();
		fileOUT.close();
		System.out.println("SUCCESS!");
		
	}

}
