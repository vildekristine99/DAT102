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
			BigInteger R = BigInteger.valueOf(fileIN.nextInt());
			int N = fileIN.nextInt();
			BigInteger M = BigInteger.valueOf(fileIN.nextInt());
			
			BigInteger rice = BigInteger.valueOf(0);
			
			int x = N*N;
			
			BigInteger rice2 = BigInteger.valueOf(0);
			for(int f = 0; f <= x; f++) {
				BigInteger g = R.pow(f);
				rice2.add(g);
				while(rice2.compareTo(M) > -1) {
					rice2.subtract(M);
				}
			}
			
			//BigInteger k = R.divide(BigInteger.ONE);
			//rice = R.multiply((k.pow(x).subtract(BigInteger.ONE)).divide(k.subtract(BigInteger.ONE)));
			
			BigInteger leftover = rice2;
			
			//System.out.println("Table: " + x + " rice: " + rice.toString() + ", Leftover: " + leftover.toString());
			String output = "Case #" + Integer.toString(i + 1) + ": " + (leftover).toString() + "\n";
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
