import java.util.ArrayList;
import java.util.Collections;

public class Tabou {

	private ArrayList<Agence> LA = new ArrayList<Agence>();
	private ArrayList<LieuFormation> LFF = new ArrayList<LieuFormation>();
	private int iteration;
	private int tailleTabou;
	private ArrayList<Integer> listTabou = new ArrayList<Integer>();
	private int[] solutionActuelle = new int[LA.size()];
	private int[] bestSolution = new int[LA.size()];
	private int[] voisinage = new int[LA.size()]; // tableau renvoyant le
													// changement de
													// l'entreprise avec son
													// lieu de formation
	private double[] valueVoisin = new double[LA.size()];
	private double bestPrice;
	private int bestVoisin; // indice de l'entreprise choisis pour le changement

	/*
	 * Initialisation de la méthode Tabou
	 */
	public Tabou(int iteration, int tailleT, ArrayList<Agence> LA, ArrayList<LieuFormation> LF) {
		this.iteration = iteration;
		this.tailleTabou = tailleT;
		this.LA = LA;
		this.LFF = LF;

	}

	/*
	 * Running de la méthode Tabou
	 */
	public void runTabou() {

		solutionInit(LA, LFF, solutionActuelle);
		bestPrice = Calcul.prix(solutionActuelle, LA, LFF);
		bestSolution = solutionActuelle.clone();

		for (int x = 0; x < iteration; x++) {

			for (int i = 0; i < voisinage.length; i++) {
				voisinage[i] = getVoisinage(i);
			}

			bestVoisin = meilleurVoisin();

			if (valueVoisin[bestVoisin] > bestPrice) {
				if (listTabou.size() == tailleTabou) {
					listTabou.remove(0);
					listTabou.add(bestVoisin);
				} else
					listTabou.add(bestVoisin);
			}

			if (valueVoisin[bestVoisin] < bestPrice) {
				bestPrice = valueVoisin[bestVoisin];
				LFF.get(voisinage[bestVoisin]).setNbaccueillis(
						LFF.get(solutionActuelle[bestVoisin]).getNbaccueillis() - LA.get(bestVoisin).getNbsalaries());
				LFF.get(voisinage[bestVoisin]).setNbaccueillis(
						LFF.get(voisinage[bestVoisin]).getNbaccueillis() + LA.get(bestVoisin).getNbsalaries());
				bestSolution[bestVoisin] = voisinage[bestVoisin];
			}

			solutionActuelle[bestVoisin] = voisinage[bestVoisin];

		}
		
		System.out.println( " L'algo tabou trouve le comme coût : " + bestPrice);
		

	}

	/*
	 * choix du voisinage et calcul de celui-ci dans valueVoisin
	 */
	public int getVoisinage(int i) {
		ArrayList<Integer> formationProche = new ArrayList<Integer>();
		formationProche = LA.get(i).getVoisin(LFF, solutionActuelle, i);
		int[] temp = solutionActuelle.clone();
		temp[i] = formationProche.get(0);
		double prix = Calcul.prix(temp, LA, LFF);
		valueVoisin[i] = prix; // on ajoute dans le tableau des voisinages la
								// valeur du prix lié avec le lieu de formation
								// choisis
		return formationProche.get(0); // on retourne l'indice du lieu de
										// formation choisis

	}

	public void solutionInit(ArrayList<Agence> LA, ArrayList<LieuFormation> LFF, int[] tab) {
		for (int i = 0; i < tab.length; i++) {

			int random = (int) (LFF.size() * Math.random());
			solutionActuelle[i] = random ;

		}
	}

	public int meilleurVoisin() {
		double min = Integer.MAX_VALUE;
		int indice = 0;
		for (int i = 0; i < voisinage.length; i++) {

			if (valueVoisin[i] < min && !listTabou.contains(i)) {
				min = valueVoisin[i];
				indice = i;

			}
		}

		return indice;
	}

}
