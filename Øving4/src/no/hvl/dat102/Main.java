package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.SirkulearKoe.SirkulaerKoe;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedetKoe.KjedetKoe;

public class Main {

	public static void main(String[] args) {
		KoeADT<Person> koe1 = new KjedetKoe<Person>();
		KoeADT<Person> koe2 = new SirkulaerKoe<Person>();
		
		Scanner inn = new Scanner(System.in);
		
		System.out.println("Hvor mange Personer?");		
		int ant = inn.nextInt();
		int i = 0;
		while(i<ant) {
			System.out.println("Fødselsår:");
			int fodselsar = inn.nextInt();
			inn.nextLine();
			System.out.println("Fornavn:");
			String fornavn = inn.nextLine();
			System.out.println("Etternavn:");
			String etternavn = inn.nextLine();
			
			koe1.innKoe(new Person(fornavn, etternavn, fodselsar));
			koe2.innKoe(new Person(fornavn, etternavn, fodselsar));
			i++;
		}
		/*
		Person p1 = new Person("Vilde", "Fossum", 1999);
		Person p2 = new Person("Linnea", "Gustavsen", 1999);
		Person p3 = new Person("Åsmund", "Fossum", 2000);
		Person p4 = new Person("Tellef", "Angelsen", 2000);
		
		koe1.innKoe(p1);
		koe1.innKoe(p2);
		koe1.innKoe(p3);
		koe1.innKoe(p4);
		
		koe2.innKoe(p1);
		koe2.innKoe(p2);
		koe2.innKoe(p3);
		koe2.innKoe(p4);
		*/
		
		while(!(koe1.erTom())) {
			Person p = koe1.utKoe();
			String ut = p.toString();
			System.out.println(ut);
		}
		
		while(!(koe2.erTom())) {
			Person p = koe2.utKoe();
			String ut = p.toString();
			System.out.println(ut);
		}
		
		
	}

}
