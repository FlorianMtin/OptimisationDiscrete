
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
    
    public double prix (List<LieuFormation> LLF){
        double prix = 0;
        
        for (LieuFormation LF : LLF){
            if(LF.isOpen())
            {
                prix += LieuFormation._COUTFORMATEUR;
                prix += LieuFormation._COUTLOCATION;
                ArrayList<Agence> LA = (ArrayList<Agence>) LF.getLA();
                for (Agence A : LA){
                    prix += A.getNbsalaries() * 2 * A.distance(LF) * _COUTKILOMETRE_;
                }
            }
        }
        
        return prix;
    }
    
}
