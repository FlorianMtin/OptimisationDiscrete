
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
    private LieuFormation LF;

    public Agence(String id, String name, int codepostale, float longitude, float latitude, int nbsalaries, LieuFormation LF) {
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
                + "{Lieu Formation : " + "this.LF.getName()" + "}\t"
                + "{Distance : " + "this.distance(this.LF)" + "km}";
    }

    public boolean peutAller(LieuFormation LF) {
        return LieuFormation._CAPACITEMAXIMALE_ - LF.getNbaccueillis() < this.nbsalaries ? false : true;
    }

    public boolean changementAffectation(LieuFormation LF) {
        if (!this.peutAller(LF) || LF == this.LF) {
            return false;
        }
        if (this.LF != null) {
            this.LF.remove(this);
        }
        this.LF = LF;
        this.LF.add(this);

        return true;
    }

    
    public ArrayList<LieuFormation> getVoisin (List<LieuFormation> LLF){
        ArrayList<LieuFormation> Voisinage = new ArrayList();
        
        for (LieuFormation LF : LLF){
            if (LF != this.LF && (LF.isOpen() || (this.distance(LF) < 100))){


                   Voisinage.add(LF);
            }
        }

        return Voisinage;
    }
}
