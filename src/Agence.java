
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Adrien
 */
public class Agence extends Lieu {

	private int nbsalaries;

	public Agence(String id, String name, int codepostale, float longitude, float latitude, int nbsalaries) {
		super(id, name, codepostale, longitude, latitude);
		this.nbsalaries = nbsalaries;

	}

	public int getNbsalaries() {
		return nbsalaries;
	}

	public void setNbsalaries(int nbsalaries) {
		this.nbsalaries = nbsalaries;
	}

	@Override
	public String toString() {
		return "Agence{" + this.name + "}\t" + "{Nombre salaries : " + this.nbsalaries + "}\t" + "{Lieu Formation : "
				+ "this.LF.getName()" + "}\t";
	}

	public boolean peutAller(LieuFormation LF) {
		return LieuFormation._CAPACITEMAXIMALE_ - LF.getNbaccueillis() < this.nbsalaries ? false : true;
	}

	public ArrayList<Integer> getVoisin(List<LieuFormation> LLF, List<Agence> LA, int[] tab, int indice) {
		ArrayList<Integer> voisinage = new ArrayList();
		for (int i = 0; i < LLF.size(); i++) {

			int ouvert = 0;
			for (int j = 0; j < tab.length; j++) {
				if (indice != j) {
					if (tab[j] == i) {
						ouvert++;
					}

				}

			}
			if (ouvert < 1 || LLF.get(i).distance(LA.get(tab[indice])) < 100) {
				voisinage.add(i);
			}

		}
		return voisinage;

	}
}
