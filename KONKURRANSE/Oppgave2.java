package kon;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Oppgave2 {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\be24059903\\Desktop\\Skrivebord\\HVL\\DAT102\\DAT102\\KONKURRANSE\\answer.txt"); //create file object, answer.txt must not exists at this point
		Path filePath = Paths.get("C:\\Users\\be24059903\\Desktop\\Skrivebord\\HVL\\DAT102\\DAT102\\KONKURRANSE\\data.txt"); //Creates path to input data
		file.createNewFile(); //Creates answer.txt
		
		FileOutputStream fileOUT = new FileOutputStream(file); //Output stream to answer.txt
		Scanner fileIN = new Scanner(filePath); //Create file scanner object
		
		int cases = fileIN.nextInt(); //Find next int in file
		System.out.println(cases);
		for(int i = 0; i < cases; i++) { //For number of cases
			int R = fileIN.nextInt();
			int N = fileIN.nextInt();
			int M = fileIN.nextInt();
			long rice = 0;
			
			long x = N*N;
			
			for(int j = 0; j <= x; j++) {
				rice += Math.pow(R, j);
			}
			
			long leftover = rice % M;
			
			System.out.println(x+" rice: " + rice + ", Leftover: " + leftover);
			String output = "Case #" + Integer.toString(i + 1) + ": " + Long.toString(leftover) + "\n";
			System.out.println(output);
			
			byte[] byteOUT = output.getBytes(); //convert string to bytes
			fileOUT.write(byteOUT); //write bytes to file
		}
		fileOUT.flush(); //flush output (push any output saved in buffer)
		fileIN.close();
		fileOUT.close();
		System.out.println("SUCCESS!");
		
	}

}
