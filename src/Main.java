
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mise en place de l'algo et lancement du Run
		boolean stop = false;
		while (!stop){


		System.out.println("Faire quel test?  ");
		System.out.println("a : Test avec le jeu de 100 Agences");
		System.out.println("b : Test avec le jeu de 300 Agences");
		System.out.println("c : Test avec le jeu de 500 Agences");
		System.out.println("d : Test avec votre jeu d'Agences");
		System.out.println("e : Quitter \n ");
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
			 * si vous voulez remplacer le code pour mettre votre fichier, ou alors utilisez le menu dans la console.

			 */
			case "d":
				
				System.out.println("Nom de votre fichier (sans .txt)");
				Scanner scan2 = new Scanner(System.in);
				String Votrefichier = scan.nextLine();
				
				myRun.run("src/Database/"+Votrefichier+".txt");
				break;
			}

		} while (choice == "e");
		
		if (choice == "e") stop = true;

		
		} 

	}
	
	

}
