
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
    
    public LieuFormation(String id, String name, int codepostale, float longitude, float latitude) {
        super(id, name, codepostale, longitude, latitude);
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

    public List<Agence> getLA() {
        return LA;
    }

    public void setLA(List<Agence> LA) {
        this.LA = LA;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "LieuFormation{" + this.name + "}\t"
                + "{" + this.open + "}\t"
                + "{Accueil : " + this.nbaccueillis + "}\t"
                + "{Nombre Agences : " + this.getLA().size() + "}";
    }
    
}
