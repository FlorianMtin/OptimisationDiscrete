
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
public class LieuFormation extends Lieu {

	public static final int _CAPACITEMAXIMALE_ = 60;
	public static final int _COUTFORMATEUR = 2000;
	public static final int _COUTLOCATION = 1000;

	private int nbaccueillis;

	public LieuFormation(String id, String name, int codepostale, float longitude, float latitude) {
		super(id, name, codepostale, longitude, latitude);
		this.nbaccueillis = 0;

	}

	public LieuFormation(LieuFormation LF) {
		super(LF.getId(), LF.getName(), LF.getCodepostale(), LF.getLongitude(), LF.getLatitude());
		this.nbaccueillis = LF.getNbaccueillis();

	}

	public int getNbaccueillis() {
		return nbaccueillis;
	}

	public void setNbaccueillis(int nbaccueillis) {
		this.nbaccueillis = nbaccueillis;
	}

	@Override
	public String toString() {
		return "LieuFormation{" + this.name + "}\t"  + "{Accueil : " + this.nbaccueillis
				+ "}\t" + "}";
	}

	public boolean peutAccueillir(Agence A) {
		return _CAPACITEMAXIMALE_ - this.nbaccueillis < A.getNbsalaries() ? false : true;
	}

}
