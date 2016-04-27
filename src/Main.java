import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	// public ArrayList<Agence> ListAgence;
	// public ArrayList<LieuFormation> ListFormation;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mise en place de l'algo et lancement du Run
		System.out.println("Faire quel test?  ");
		System.out.println("a : ");
		System.out.println("?: Display");
		System.out.println("q: Quit");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();

		try {
			File f = new File("src/Database/LieuxPossibles.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				String line;
				String word[];
				line = br.readLine();
				while(true) {
					
				line = br.readLine();	
				if (line != null){	
					
					word = line.split(";");									
				}
				
					
			
				else 
					break;	
				
				
				}
			} catch (IOException exception) {

				System.out.println("Erreur lors de la lecture : " + exception.getMessage());

			}
			
			

		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}

	}

}
