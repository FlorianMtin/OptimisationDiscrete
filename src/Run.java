import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
						LieuFormation current = new LieuFormation(word[0], Integer.parseInt(word[1]),
								Integer.parseInt(word[2]), Integer.parseInt(word[3]));
						ListFormation.add(current);
					}

					else
						break;
				}

			}

			catch (IOException exception) {

				System.out.println("Erreur lors de la lecture : " + exception.getMessage());

			}

			f = new File("src/Database/LieuxPossibles.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			try {

				line = br.readLine();
				while (true) {

					line = br.readLine();
					if (line != null) {
						word = line.split(";");
						Agence current = new Agence(word[0], Integer.parseInt(word[1]), Integer.parseInt(word[2]),
								Integer.parseInt(word[3]), Integer.parseInt(word[4]), null);
						ListAgence.add(current);
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
