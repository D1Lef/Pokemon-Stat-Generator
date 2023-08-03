/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import java.util.ArrayList;

/**
 *
 * @author Felix
 */
public class PartyMember extends Pokemon{
    
    int[] IVs;
    String nickname;
    double[] natMUL;
    
    
    public PartyMember(int dexNr, String nickname, int[] IVs, double[] natMUL){
        
        super("" + dexNr, new api.Client());
        
        this.IVs = IVs;
        this.nickname = nickname;
        this.natMUL = natMUL;
        
        
        
    }
    
    public PartyMember(Pokemon p, String nickname, int[] IVs, double[] natMUL){
        
        super(p);
        
        this.IVs = IVs;
        this.nickname = nickname;
        this.natMUL = natMUL;
    }
    
}
