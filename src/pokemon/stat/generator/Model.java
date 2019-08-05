/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import api.Client;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.io.FileReader; 
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator; 
import java.util.Map; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.evolution.ChainLink;
import models.evolution.EvolutionChain;
import models.pokemon.Ability;
import models.pokemon.PokemonSpecies;
import models.pokemon.PokemonStat;



/**
 *
 * @author Felix
 */
public class Model {
    
    private Client pokeApiClient;
    private Pokemon activePKM;
    private String[][] nature;
    private String selectedNature;
    
    /** natMUL
     * 0: ATK
     * 1: DEF
     * 2: SPA
     * 3: SPD
     * 4: INI
     */
    private double[] natMUL = {1,1,1,1,1};
    private int[] statChange = {0,0,0,0,0};
    /** stats
     * 0: HP
     * 1: ATK
     * 2: DEF
     * 3: SPA
     * 4: SPD
     * 5: INI
     */
    private int[] stats = new int[6];
    
    public Model(){
        pokeApiClient = new Client();
        
        /**
         * Index:
         *      0: -ATK
         *      1: -DEF
         *      2: -SPA
         *      3: -SPD
         *      4: -INI
         */
        String[] atkP = {"Robust", "Solo", "Hart", "Frech", "Mutig"};
        String[] defP = {"Kühn", "Sanft", "Pfiffig", "Lasch", "Locker"};
        String[] spaP = {"Mäßig", "Mild", "Zaghaft", "Hitzig", "Ruhig"};
        String[] spdP = {"Still", "Zart", "Sacht", "Kauzig", "Forsch"};
        String[] iniP = {"Scheu", "Hastig", "Froh", "Naiv", "Ernst"};
        
        nature = new String[5][5];
        nature[0] = atkP;
        nature[1] = defP;
        nature[2] = spaP;
        nature[3] = spdP;
        nature[4] = iniP;
    }

    public Pokemon loadPokemon(String nameID){
        boolean isID = true;
        int id = 1;
        
        try{
            id = Integer.parseInt(nameID);
        } catch (NumberFormatException e){
            isID = false;
        }
        
        models.pokemon.Pokemon poke;
        if (isID)
            poke = pokeApiClient.getPokemonById(id);
        else
            poke = pokeApiClient.getPokemonByName(nameID);

        
        
        
        String EVs = "<html><body>";

        int [] pkmStats = new int[6];

        for (int i = 5, j = 0; i >= 0; i--){
            PokemonStat ps = poke.getStats().get(i);
            pkmStats[j] = ps.getBaseStat();
            if (ps.getEffort() > 0){
                EVs += ps.getEffort() + " " + ps.getStat().getName() + "<br>";
            }
            j++;
        }

        EVs += "</body></html>";

        
        activePKM = new Pokemon(
            poke.getId(), poke.getSprites().getFrontDefault(), 
            poke.getName(), pkmStats[0], pkmStats[1], pkmStats[2], pkmStats[3], pkmStats[4], pkmStats[5], 
            getAbilities(poke.getId()), poke.getBaseExperience(), getEvolutionLevel(poke.getId()), 
            EVs);
        
        return activePKM;
    }
        
    public int getEvolutionLevel(int id){
        models.pokemon.Pokemon test = pokeApiClient.getPokemonById(id);
        PokemonSpecies s = pokeApiClient.getPokemonSpeciesById(id);
        String url = s.getEvolutionChain().getUrl();
        int evoID = Integer.parseInt(url.substring(url.indexOf("chain/")+6, url.length()-1));
        EvolutionChain ec = pokeApiClient.getEvolutionChainById(evoID);
        
        boolean found = false;
        ChainLink cl = ec.getChain();
        while(!found){
            //System.out.println(cl.getSpecies().getName() + " " + test.getSpecies().getName());
            if (cl.getSpecies().getName().equals(test.getSpecies().getName())){
                found = true;
            }
            else {
                if (cl.getEvolvesTo().size() > 1){
                    for(ChainLink chain : cl.getEvolvesTo()){
                        if (chain.getSpecies().getName().equals(test.getSpecies().getName())){
                            cl = chain; found = true;
                        }
                    }
                    if (!found)
                        return 101;
                }
                if (cl.getEvolvesTo().size() == 0)
                    return 101;
                    
                cl = cl.getEvolvesTo().get(0);
            }
        }
        
        ArrayList<ChainLink> ev2 = cl.getEvolvesTo();
        int minLv = 101;
        for (int i = 0; i < ev2.size(); i++){
            if (ev2.get(i).getEvolutionDetails().get(0).getMinLevel() > 0)
                minLv = ev2.get(i).getEvolutionDetails().get(0).getMinLevel();
        }
        
        return minLv;
    }
    
    public ArrayList<String> getAbilities(int id){
        models.pokemon.Pokemon test = pokeApiClient.getPokemonById(id);
        
        ArrayList<String> abilities = new ArrayList<String>();
        
        for (int i = test.getAbilities().size()-1; i >= 0; i--){
            String url = test.getAbilities().get(i).getAbility().getUrl();
            int abiID = Integer.parseInt(url.substring(url.indexOf("ability/")+8, url.length()-1));
            Ability a = pokeApiClient.getAbilityById(abiID);
            
            String s = a.getNames().get(5).getName();
            if (test.getAbilities().get(i).isHidden())
                s += " (VF)";
            abilities.add(s);
        }
        
        return abilities;
    }
    
    public String getDex(){
        return activePKM.getDex();
    }
    
    void setAbilities(JComboBox<String> abilities){
        javax.swing.DefaultComboBoxModel<String> mod = 
                new javax.swing.DefaultComboBoxModel<String>();
        for (String a : activePKM.getAbilities()){
            mod.addElement(a);
        }
        abilities.setModel(mod);
    }
    
    String setNature(JRadioButton[] p, JRadioButton[] m){
        
        natMUL = new double[] {1,1,1,1,1};
        
        int indexP = 0;
        int indexM = 0;
        
        for (int i = 0; i < p.length; i++){
            if(p[i].isSelected()){
                indexP = i;
                break;
            }
        }
        
        for (int i = 0; i < m.length; i++){
            if(m[i].isSelected()){
                indexM = i;
                break;
            }
        }
        
        if (indexP != indexM){
            natMUL[indexP] = 1.1;
            natMUL[indexM] = 0.9;
        }
        /*
        System.out.println(
                "ATK: " + natMUL[0] +
                " DEF: " + natMUL[1] + 
                " SPA: " + natMUL[2] +
                " SPD: " + natMUL[3] +
                " INI: " + natMUL[4]);
        */
        return selectedNature = nature[indexP][indexM];
    }
    
    public void calculateStats(int[] EVs, int[] IVs, int level, JLabel[] statAnz, JLabel ev){
        double e;
        
        if(level >= activePKM.getLvlEntw()){
            e = 1.2;
        } else {
            e = 1;
        }
        
        stats[1] = (int) Math.floor(((2 * activePKM.getBaseATK() + IVs[1] + (EVs[1]/4)) * level/100 + 5) * natMUL[0]);
        stats[2] = (int) Math.floor(((2 * activePKM.getBaseDEF() + IVs[2] + (EVs[2]/4)) * level/100 + 5) * natMUL[1]);
        stats[3] = (int) Math.floor(((2 * activePKM.getBaseSPA() + IVs[3] + (EVs[3]/4)) * level/100 + 5) * natMUL[2]);
        stats[4] = (int) Math.floor(((2 * activePKM.getBaseSPD() + IVs[4] + (EVs[4]/4)) * level/100 + 5) * natMUL[3]);
        stats[5] = (int) Math.floor(((2 * activePKM.getBaseINI() + IVs[5] + (EVs[5]/4)) * level/100 + 5) * natMUL[4]);
        
        stats[0] = (int) Math.floor(((2 * activePKM.getBaseHP()) + IVs[0] + EVs[0]/4 + 100) * level/100 + 10);
        
        for (int i = 0; i < statAnz.length; i++){
            statAnz[i].setText(""+stats[i]);
            ev.setText("+ "+(int) Math.floor(activePKM.getBaseXP()*level*e/7)+" Exp.");
        }
    }
    
    public void calculateStats(Pokemon poke, int[] EVs, int[] IVs, int level, int index, JLabel[] statAnz, double[] natMUL){
        
        Pokemon selected = poke;
        
        double e;
        
        if(level >= poke.getLvlEntw()){
            e = 1.2;
        } else {
            e = 1;
        }
        
        stats[1] = (int) Math.floor(((2 * selected.getBaseATK() + IVs[1] + (EVs[1]/4)) * level/100 + 5) * natMUL[0]);
        stats[2] = (int) Math.floor(((2 * selected.getBaseDEF() + IVs[2] + (EVs[2]/4)) * level/100 + 5) * natMUL[1]);
        stats[3] = (int) Math.floor(((2 * selected.getBaseSPA() + IVs[3] + (EVs[3]/4)) * level/100 + 5) * natMUL[2]);
        stats[4] = (int) Math.floor(((2 * selected.getBaseSPD() + IVs[4] + (EVs[4]/4)) * level/100 + 5) * natMUL[3]);
        stats[5] = (int) Math.floor(((2 * selected.getBaseINI() + IVs[5] + (EVs[5]/4)) * level/100 + 5) * natMUL[4]);
        
        stats[0] = (int) Math.floor(((2 * selected.getBaseHP()) + IVs[0] + EVs[0]/4 + 100) * level/100 + 10);
        
        for (int i = 0; i < statAnz.length; i++){
            statAnz[i].setText(""+stats[i]);
        }
    }
    
    public String getEV(){
        if (activePKM == null)
            return null;
        return activePKM.getEVs();
    }
    
    public void setStatChange(JLabel[] change){
        for (int i = 0; i < change.length; i++){
            if(statChange[i]>0){
                change[i].setText("+"+statChange[i]);
            } else {
                change[i].setText(""+statChange[i]);
            }
        }
    }
    
    public void statRaise(int index, JLabel[] change){
        if (statChange[index] < 6){
            statChange[index]++;
            setStatChange(change);
        }
    }
    public void statFall(int index, JLabel[] change){
        if (statChange[index] > -6){
            statChange[index]--;
            setStatChange(change);
        }
    }

    void statReset(JLabel[] statCha) {
        statChange = new int[] {0,0,0,0,0};
        setStatChange(statCha);
    }
    
    public void adjustStats(JLabel[] anz){
        
        double newVal = 0;
        
        if(anz[0].getText().length() >= 1){
            for (int i = 0; i < statChange.length; i++){
                if(statChange[i] >= 0){
                    newVal = stats[i+1] * (2 + statChange[i]) / 2;
                } else if (statChange[i] < 0){
                    newVal = stats[i+1] * 2 / (2 + Math.abs(statChange[i]));
                }
                anz[i+1].setText(""+(int)Math.floor(newVal));
            }
        }
    }
    
    public Pokemon getP(){
        return activePKM;
    }
    
    public Pokemon getPokemonbyDexNumber(int dex){
        return loadPokemon(""+dex);
    }
    
    public int[] getStats(){
        return stats;
    }
}
