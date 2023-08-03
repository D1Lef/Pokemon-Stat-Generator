/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import pokemon.attack.simulator.AttackSim;

/**
 *
 * @author Felix
 */
public class PokemonStatGenerator{

    private AttackSim as;
    private PartyLevelManager pm;
    private final Model m;
    private final MainView v;
    
    public PokemonStatGenerator(){
        m = new Model();
        v = new MainView(this,m);
        v.setVisible(true);
    }
    
    /**
     * Opens a new AttackSim window if there isn't one open yet.
     */
    public void openAttackSim(){
        if (as == null){
            as = new AttackSim();
        }
        as.setVisible(true);
    }
    
    public void openPartyManager(){
        if (pm == null){
            pm = new PartyLevelManager();
        }
        pm.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PokemonStatGenerator();
    }
    
}