
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
public class Calcul {

	public static final double _COUTKILOMETRE_ = 0.4;

	public static double prix(int[] tab, ArrayList<Agence> LA, ArrayList<LieuFormation> LF) {
		double prix = 0;
		List<LieuFormation> LFF = new ArrayList<LieuFormation>();
		for (int i = 0; i < tab.length; i++) {
			
			

			if (LFF.contains(LF.get(tab[i]))) {
				prix += LA.get(i).getNbsalaries() * 2 * LA.get(i).distance(LF.get(tab[i])) * _COUTKILOMETRE_;
			}

			else {
				LFF.add(LF.get(tab[i]));
				prix += LieuFormation._COUTFORMATEUR;
				prix += LieuFormation._COUTLOCATION;
				prix += LA.get(i).getNbsalaries() * 2 * LA.get(i).distance(LF.get(tab[i])) * _COUTKILOMETRE_;
			}
		}
		return prix;
	}

}
