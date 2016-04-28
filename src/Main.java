
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mise en place de l'algo et lancement du Run
/*
		System.out.println("Faire quel test?  ");
		System.out.println("a : Test avec le jeu de 100 Agences");
		System.out.println("b: Test avec le jeu de 300 Agences");
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
			 * Remplacer Votrefichier par le nom de votre fichier txt
			 *//*
			case "d":
				myRun.run("src/Database/Votrefichier.txt");
				break;
			}

		} while (choice == "e");
*/
		ArrayList<Agence> test = new ArrayList<Agence>();
        Agence A = new Agence("t", "t", 10, 10, 10, 0, null);
        Agence B = new Agence("c", "c", 10, 10, 10, 0, null);
        test.add(A);
        test.add(B);
        ArrayList<Agence> LA = ((List) ((ArrayList) test).clone());
        System.out.println(test.get(0).toString());
        LA.get(0).setName("b");
        System.out.println(test.get(0).toString());
	}
	
	

}
