import java.util.ArrayList;

public class Tabou {

	private ArrayList<Agence> listeTabou = new ArrayList<Agence>();
	private ArrayList<Integer> valueVoisinage = new ArrayList<Integer>();
	private ArrayList<Agence> meilleurSolution = new ArrayList<Agence>();
	private ArrayList<LieuFormation> meilleurSolutionF = new ArrayList<LieuFormation>();
	private int iteration;
	private int tailleTabou;
	private float meilleurResultat = 0;

	/*
	 * Initialisation de la méthode Tabou
	 */
	public Tabou(int iteration, int tailleT) {
		this.iteration = iteration;
		this.tailleTabou = tailleT;

	}

	/*
	 * Running de la méthode Tabou
	 */
	public void runTabou(ArrayList<Agence> LA, ArrayList<LieuFormation> LF) {
		
		solutionInit(LA, LF); // On répartie aléatoirement les agences dans les
								// lieux de formation
		

	}
	
	public void getVoisinage(ArrayList<Agence> temp, ArrayList<LieuFormation> LF){
		for ( Agence a : temp){
			ArrayList<LieuFormation> voisin = new ArrayList<LieuFormation>();
			voisin = a.getVoisin(LF);
			a.changementAffectation(voisin.get(0));
		}
		
	}

	public void solutionInit(ArrayList<Agence> LA, ArrayList<LieuFormation> LF) {

            for (Agence A : LA){
                int random = (int)(LF.size()*Math.random());
                A.changementAffectation(LF.get(random));
            }

	}

	public int meilleurVoisin(ArrayList<Integer> value) {
		int max = Integer.MIN_VALUE;
		int solution = 0;
		for (int i = 0; i < value.size(); i++) {
			if (max < value.get(i)) {
				solution = i;
				max = value.get(i);
			}

		}
		return solution;
	}

}
