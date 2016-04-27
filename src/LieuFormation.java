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
    private int nbaccueillis;
    
    public LieuFormation(String name, int codepostale, int longitude, int latitude) {
        super(name, codepostale, longitude, latitude);
        this.nbaccueillis = 0;
    }

    public int getNbaccueillis() {
        return nbaccueillis;
    }

    public void setNbaccueillis(int nbaccueillis) {
        this.nbaccueillis = nbaccueillis;
    }
    
}
