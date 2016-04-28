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
		// System.out.println(iteration + " " + tailleTabou);

		solutionInit(LA, LF); // On répartie aléatoirement les agences dans les
								// lieux de formation
		Integer indiceElu;
		meilleurSolutionF.addAll(LF);
		ArrayList<Agence> temp = new ArrayList<Agence>();
		for (int i = 0; i < iteration; i++) {

			temp.addAll(LA);
		    temp.getVoisinage(valueVoisinage);
			indiceElu = meilleurVoisin(valueVoisinage);

			if (valueVoisinage.get(indiceElu) > meilleurResultat) {
				if (listeTabou.size() >= tailleTabou) {
					listeTabou.remove(0);
					listeTabou.add(temp.get(indiceElu));

				} else
					listeTabou.add(temp.get(indiceElu));
			} else {
				if (valueVoisinage.get(indiceElu) < meilleurResultat) {
					LA.remove(indiceElu);
					LA.add(indiceElu, temp.get(indiceElu));
					temp.clear();
				}
			}

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
