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
	private int[] voisinage = new int[LA.size()]; // tableau renvoyant le changement de l'entreprise avec son lieu de formation
	private double[] valueVoisin = new double[LA.size()];
	private double bestPrice ;
	private int bestVoisin; //indice de l'entreprise choisis pour le changement 

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
		bestSolution = solutionActuelle;

		for (int x = 0; x < iteration; x++) {

			for (int i = 0; i < voisinage.length; i++) {
				voisinage[i] = getVoisinage(i);
			}
						
			bestVoisin = meilleurVoisin();
			
			if ( valueVoisin[bestVoisin] > bestPrice) {
				if (listTabou.size() == tailleTabou) {
					listTabou.remove(0);
					listTabou.add(bestVoisin);
				}
				else listTabou.add(bestVoisin);
			}
			
			if ( valueVoisin[bestVoisin] < bestPrice) {
				bestPrice = valueVoisin[bestVoisin]; 
				LFF.get(voisinage[bestVoisin]).setNbaccueillis(LFF.get(solutionActuelle[bestVoisin]).getNbaccueillis() - LA.get(bestVoisin).getNbsalaries());
				LFF.get(voisinage[bestVoisin]).setNbaccueillis(LFF.get(voisinage[bestVoisin]).getNbaccueillis() + LA.get(bestVoisin).getNbsalaries());
				bestSolution[bestVoisin] = voisinage[bestVoisin];
			}
			
			solutionActuelle[bestVoisin] = voisinage[bestVoisin];
			
			
			
		}

	}

	/*
	 * choix du voisinage et calcul de celui-ci dans valueVoisin
	 */
	public int getVoisinage(int i) {
		return 1;
	}

	public void solutionInit(ArrayList<Agence> LA, ArrayList<LieuFormation> LFF, int[] tab) {

	}

	public int meilleurVoisin() {
		return 0;
	}

}
