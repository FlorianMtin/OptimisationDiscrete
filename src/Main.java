import java.io.*;
import java.util.ArrayList;

public class Main {

	// public ArrayList<Agence> ListAgence;
	// public ArrayList<LieuFormation> ListFormation;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mise en place de l'algo et lancement du Run

		try {
			File f = new File("LieuxPossibles.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
				line = br.readLine();
				System.out.println(line);
			} catch (IOException exception) {

				System.out.println("Erreur lors de la lecture : " + exception.getMessage());

			}

		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}

	}

}
