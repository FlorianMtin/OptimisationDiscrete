import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	public ArrayList<Agence> ListAgence = new ArrayList<Agence>();
	public ArrayList<LieuFormation> ListFormation = new ArrayList<LieuFormation>();

	public void run(String choice) {

		try {
			File f = new File("src/Database/LieuxPossibles.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			String word[];

			try {

				line = br.readLine();
				while (true) {

					line = br.readLine();
					if (line != null) {
						word = line.split(";");

						String cp = word[2].replaceAll("\"", "").substring(0, 5);
						LieuFormation current = new LieuFormation(word[0], word[1], Integer.parseInt(cp),
								Float.parseFloat(word[3]), Float.parseFloat(word[4]));
						ListFormation.add(current);
					}

					else
						break;
				}

			}

			catch (IOException exception) {

				System.out.println("Erreur lors de la lecture : " + exception.getMessage());

			}

			f = new File(choice);
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			try {

				line = br.readLine();
				while (true) {

					line = br.readLine();
					if (line != null) {
						word = line.split(";");
						String cp = word[2].replaceAll("\"", "").substring(0, 5);
						Agence current = new Agence(word[0], word[1], Integer.parseInt(cp), Float.parseFloat(word[3]),
								Float.parseFloat(word[4]), Integer.parseInt(word[5]));
						ListAgence.add(current);
					}

					else
						break;

				}
			} catch (IOException exception) {

				System.out.println("Erreur lors de la lecture : " + exception.getMessage());

			}
			System.out.println("Rentrez le nombre d'iteration voulu : \n ");
			Scanner scan = new Scanner(System.in);
			int ite = Integer.parseInt(scan.nextLine());
			System.out.println("Rentrez la taille du tableau Tabou voulu : \n ");
			Scanner scan2 = new Scanner(System.in);
			int size = Integer.parseInt(scan.nextLine());
			Tabou tab = new Tabou(ite,size,ListAgence, ListFormation);
			tab.runTabou();

		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
		
		
		

		

		
	}
}
