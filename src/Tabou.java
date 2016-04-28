import java.util.ArrayList;
import java.util.Collections;



public class Tabou {

	private ArrayList<Agence> LA = new ArrayList<Agence>();
	private ArrayList<LieuFormation> LFF = new ArrayList<LieuFormation>();
	private ArrayList<Integer> voisinPrix = new ArrayList<Integer>();
	private ArrayList<Integer> listTabou = new ArrayList<Integer>();
	
	private ArrayList<Agence> temp = new ArrayList<Agence>();
	
	private ArrayList<LieuFormation> bestSolution = new ArrayList<LieuFormation>();
	private int iteration;
	private int tailleTabou;
	private double bestResult = 0;
	private double currentResult;

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

		solutionInit(LA, LFF); // On répartie aléatoirement les agences dans les
								// lieux de formation
		currentResult = Calcul.prix(LFF);
		bestResult = currentResult;
		Collections.copy(LFF,bestSolution);
		int meilleurVoisin = 0;

		for (int i = 0; i < iteration; i++) {

			temp.addAll(LA);
			getVoisinage(temp, LFF); // permet de stocker dans temp lesmodifications de chaque Agence
			meilleurVoisin = meilleurVoisin(voisinPrix);
			
			if ( voisinPrix.get(meilleurVoisin) >= currentResult){
				listTabou.add(meilleurVoisin);
			}
			
			else if (voisinPrix.get(meilleurVoisin) < bestResult){
				bestResult = voisinPrix.get(meilleurVoisin);
				
			}
			
			
										
		}

	}

	public void getVoisinage(ArrayList<Agence> temp, ArrayList<LieuFormation> LF) {
		for (Agence a : temp) {
			ArrayList<LieuFormation> voisin = new ArrayList<LieuFormation>();
			voisin = a.getVoisin(LF);
			a.setLF(voisin.get(0)); // A améliorer
		}

	}

	public void solutionInit(ArrayList<Agence> LA, ArrayList<LieuFormation> LF) {

		for (Agence A : LA) {
			int random = (int) (LF.size() * Math.random());
			A.changementAffectation(LF.get(random));
		}

	}

	public int meilleurVoisin(ArrayList<Integer> value) {
		int min = Integer.MAX_VALUE;
		int solution = 0;
		for (int i = 0; i < value.size(); i++) {
			if (min > value.get(i) && listeTabou.contains(i)) {
				solution = i;
				min = value.get(i);
			}

		}
		return solution;
	}

}
