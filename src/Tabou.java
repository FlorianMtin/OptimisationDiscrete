import java.util.ArrayList;


public class Tabou {
	
	private ArrayList<Agence> listeTabou = new ArrayList<Agence>();
	private ArrayList<Integer> valueVoisinage = new ArrayList<Integer>();
	private int iteration ;
	private int tailleTabou;
	private float meilleurResultat  = 0;
	
	/* 
	 * Initialisation de la méthode Tabou
	 */
	public Tabou(int iteration, int tailleT){
		this.iteration = iteration;
		this.tailleTabou = tailleT;
		
	}
	
	/*
	 * Running de la méthode Tabou
	 */
	public void runTabou(ArrayList<Agence> LA, ArrayList<LieuFormation> LF){
		//System.out.println(iteration + "  " + tailleTabou);
		
		solutionInit(LA,LF); // On répartie aléatoirement les agences dans les lieux de formation
		Integer indiceElu ;
		ArrayList<Agence> temp = new ArrayList<Agence>();
		for ( int i = 0 ; i < iteration; i++){
			
			temp = LA; 
			temp.getVoisinage(valueVoisinage);
			indiceElu = meilleurVoisin(valueVoisinage);
			
			if ( valueVoisinage.get(indiceElu) > meilleurResultat) {
				if (listeTabou.size() >=tailleTabou){
					listeTabou.remove(0);
					listeTabou.add(temp.get(indiceElu));
					
				}
			}
			
			
			
		}
		
		
		
	}
	
	public void solutionInit(ArrayList<Agence> LA, ArrayList<LieuFormation> LF){
		
	}
	
	public int meilleurVoisin(ArrayList<Integer> value){
		return 0;
	}

}
