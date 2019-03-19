package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.KjedetListe.KjedetOrdnetListe;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.TabellListe.TabellOrdnetListe;

public class Main2 {
	public static void main(String[] args) {
		OrdnetListeADT<Person> KjedetListe = new KjedetOrdnetListe<Person>();
		OrdnetListeADT<Person> TabellListe = new TabellOrdnetListe<Person>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hvor mange Personer?");		
		int ant = sc.nextInt();
		sc.nextLine();
		int i = 0;
		while(i<ant) {
			System.out.println("Fødselsår:");
			int fodselsar = sc.nextInt();
			sc.nextLine();
			System.out.println("Fornavn:");
			String fornavn = sc.nextLine();
			System.out.println("Etternavn:");
			String etternavn = sc.nextLine();
			
			KjedetListe.leggTil(new Person(fornavn, etternavn, fodselsar));
			TabellListe.leggTil(new Person(fornavn, etternavn, fodselsar));
			i++;
		}
		
		/*
		Person p1 = new Person("Vilde", "Fossum", 1999);
		Person p2 = new Person("Linnea", "Gustavsen", 1999);
		Person p3 = new Person("Åsmund", "Fossum", 2000);
		Person p4 = new Person("Tellef", "Angelsen", 2000);
		
		KjedetListe.leggTil(p1);
		KjedetListe.leggTil(p2);
		KjedetListe.leggTil(p3);
		KjedetListe.leggTil(p4);
		
		TabellListe.leggTil(p1);
		TabellListe.leggTil(p2);
		TabellListe.leggTil(p3);
		TabellListe.leggTil(p4);
		*/
		
		while(!(KjedetListe.erTom())) {
			System.out.println(KjedetListe.fjernFoerste().toString());
		}
		
		while(!(TabellListe.erTom())) {
			System.out.println(TabellListe.fjernFoerste().toString());
		}
	}
}
