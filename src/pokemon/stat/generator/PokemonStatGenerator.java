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

    public PokemonStatGenerator(){
        Model m = new Model();
        Window w = new Window(this,m);
        w.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PokemonStatGenerator();
        new AttackSim().setVisible(true);
    }
    
}
