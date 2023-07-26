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
public class Pokemon {

    Pokemon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Pokemon (Pokemon p){
        this.dexNr = p.dexNr;
        this.EVs = p.EVs;
        this.lvlEntw = p.lvlEntw;
        this.baseXP = p.baseXP;
        this.dex = p.dex;
        this.name = p.name;
        this.baseHP = p.baseHP;
        this.baseATK = p.baseATK;
        this.baseDEF = p.baseDEF;
        this.baseSPA = p.baseSPA;
        this.baseSPD = p.baseSPD;
        this.baseINI = p.baseINI;
        this.abilities = p.abilities;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the ability
     */
    public String getAbility() {
        return ability;
    }

    /**
     * @param ability the ability to set
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }

    public int getDexNr(){
        return dexNr;
    }
    
    /**
     * @return the exp
     */
    public String getExp() {
        return exp;
    }
    
    /**
     * @param name name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(String exp) {
        this.exp = exp;
    }

    /**
     * @return the EVs
     */
    public String getEVs() {
        return EVs;
    }
    
    private int baseXP;
    private String exp;
    private String ability;
    private int level;
    
    private int lvlEntw; //wenn keine Entw. = 101
    
    private int dexNr;
    private String dex;
    private String name;
    private int baseHP;
    private int baseATK;
    private int baseDEF;
    private int baseSPA;
    private int baseSPD;
    private int baseINI;
    private ArrayList<String> abilities;
    private String nature;
    private int[] stats;
    
    private String EVs;
    
    
    public Pokemon(int dexNr, String dex, String name, int baseHP, int baseATK, 
            int baseDEF, int baseSPA, int baseSPD, int baseINI, 
            ArrayList<String> abilities, int baseXP, int lvlEntw, String EVs){
        this.dexNr = dexNr;
        this.EVs = EVs;
        this.lvlEntw = lvlEntw;
        this.baseXP = baseXP;
        this.dex = dex;
        this.name = name;
        this.baseHP = baseHP;
        this.baseATK = baseATK;
        this.baseDEF = baseDEF;
        this.baseSPA = baseSPA;
        this.baseSPD = baseSPD;
        this.baseINI = baseINI;
        this.abilities = abilities;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the baseHP
     */
    public int getBaseHP() {
        return baseHP;
    }

    /**
     * @return the baseATK
     */
    public int getBaseATK() {
        return baseATK;
    }

    /**
     * @return the baseDEF
     */
    public int getBaseDEF() {
        return baseDEF;
    }

    /**
     * @return the baseSPA
     */
    public int getBaseSPA() {
        return baseSPA;
    }

    /**
     * @return the baseSPD
     */
    public int getBaseSPD() {
        return baseSPD;
    }

    /**
     * @return the baseINI
     */
    public int getBaseINI() {
        return baseINI;
    }

    /**
     * @return the nature
     */
    public String getNature() {
        return nature;
    }

    /**
     * @return the abilities
     */
    public ArrayList<String> getAbilities() {
        return abilities;
    }

    /**
     * @param nature the nature to set
     */
    public void setNature(String nature) {
        this.nature = nature;
    }

    String getDex() {
        return dex;
    }

    /**
     * @return the baseXP
     */
    public int getBaseXP() {
        return baseXP;
    }

    /**
     * @return the lvlEntw
     */
    public int getLvlEntw() {
        return lvlEntw;
    }
    
    public void setStats(int[] stats) {
        this.stats = stats;
    }
    
    public int[] getStats() {
        return stats;
    }
    
    public void updateAbilities(ArrayList<String> a) {
        this.abilities = a;
    }
}
