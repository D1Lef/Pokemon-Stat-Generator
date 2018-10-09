/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Felix
 */
public class PartyMember extends Pokemon{
    
    int[] IVs;
    String nickname;
    double[] natMUL;
    
    
    public PartyMember(int dexNr, String dex, String name, int baseHP, int baseATK, 
            int baseDEF, int baseSPA, int baseSPD, int baseINI, 
            ArrayList<String> abilities, int baseXP, int lvlEntw, String EVs, String nickname, int[] IVs, double[] natMUL){
        
        super(dexNr, dex, name, baseHP, baseATK, baseDEF, baseSPA, baseSPD, baseINI,abilities, baseXP, lvlEntw,EVs);
        
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
