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
    
    public LieuFormation(String name, int codepostale, int longitude, int latitude, int nbaccueillis) {
        super(name, codepostale, longitude, latitude);
        this.nbaccueillis = nbaccueillis;
    }
    
}
