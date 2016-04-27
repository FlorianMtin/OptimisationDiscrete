/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrien
 */
public class Agence extends Lieu{

    private int nbsalaries;
    
    public Agence(String name, int codepostale, int longitude, int latitude, int nbsalaries) {
        super(name, codepostale, longitude, latitude);
        this.nbsalaries = nbsalaries;
    }
    
}
