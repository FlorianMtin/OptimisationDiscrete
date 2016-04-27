
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mise en place de l'algo et lancement du Run

		System.out.println("Faire quel test?  ");
		System.out.println("a : Test avec le jeu de 100 Agences");
		System.out.println("b: Test avec le jeu de 300 Agences");
		System.out.println("c : Test avec le jeu de 500 Agences");
		System.out.println("d : Test avec votre jeu d'Agences");
		System.out.println("e : Quitter");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		Run myRun = new Run();

		do {
			switch (choice) {
			case "a":
				myRun.run("src/Database/ListeAgences_100.txt");
				break;

			case "b":
				myRun.run("src/Database/ListeAgences_300.txt");
				break;

			case "c":
				myRun.run("src/Database/ListeAgences_500.txt");
				break;

			/*
			 * Remplacer Votrefichier par le nom de votre fichier txt
			 */
			case "d":
				myRun.run("src/Database/Votrefichier.txt");
				break;
			}

		} while (choice == "e");

	}

}
