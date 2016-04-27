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
    private LieuFormation LF;
    
    public Agence(String id, String name, int codepostale, int longitude, int latitude, int nbsalaries, LieuFormation LF) {
        super(id, name, codepostale, longitude, latitude);
        this.nbsalaries = nbsalaries;
        this.LF = LF;
    }

    public int getNbsalaries() {
        return nbsalaries;
    }

    public void setNbsalaries(int nbsalaries) {
        this.nbsalaries = nbsalaries;
    }

    public LieuFormation getLF() {
        return LF;
    }

    public void setLF(LieuFormation LF) {
        this.LF = LF;
    }

    @Override
    public String toString() {
        return "Agence{" + this.name + "}\t"
                + "{Nombre salaries : " + this.nbsalaries + "}\t"
                + "{Lieu Formation : " + this.LF.getName() + "}\t"
                + "{Distance : " + this.distance(this.LF) + "km}";
    }
    
}
