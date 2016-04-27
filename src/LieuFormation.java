
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
public class LieuFormation extends Lieu{

    public static final int _CAPACITEMAXIMALE_ = 60;
    public static final int _COUTFORMATEUR = 2000;
    public static final int _COUTLOCATION = 1000;
    
    private int nbaccueillis;
    private List<Agence> LA;
    private boolean open;
    
    public LieuFormation(String name, int codepostale, int longitude, int latitude) {
        super(name, codepostale, longitude, latitude);
        this.nbaccueillis = 0;
        LA = new ArrayList();
        open = false;
    }

    public int getNbaccueillis() {
        return nbaccueillis;
    }

    public void setNbaccueillis(int nbaccueillis) {
        this.nbaccueillis = nbaccueillis;
    }
    
}
