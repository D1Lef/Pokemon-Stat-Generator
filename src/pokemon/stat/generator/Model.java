/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import api.Client;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import javax.swing.JSpinner;
import models.common.Name;
import models.evolution.ChainLink;
import models.evolution.EvolutionChain;
import models.pokemon.Ability;
import models.pokemon.PokemonSpecies;



/**
 *
 * @author Felix
 */
public class Model {
    
    private final Client pokeApiClient;
    private Pokemon activePKM;
    private String[][] nature;
    private String selectedNature;
    
    private String langCode = "de";
    
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
        initNature();
    }
    
    public Model(Pokemon p){
        pokeApiClient = new Client();
        initNature();
        activePKM = p;
    }
    
    public void initNature(){
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
    
    /**
     * Loads relevant Pokemon information from the API
     * 
     * @param nameID name or ID of the Pokemon to loaded
     * @return Pokemon object with the loaded information
     */
    public Pokemon loadPokemon(String nameID){
        activePKM = new Pokemon(nameID, pokeApiClient);
        return activePKM;
    }
    
    /**
     * Takes given Pokemon object and loads it into the model.
     * 
     * @param p Pokemon object to be loaded
     */
    public void loadPokemon(Pokemon p){
        activePKM = p;
    }
        
    /**
     * Returns the level of evolution of a Pokemon, 101 if it has no evolution level
     * 
     * @param id Pokedex number of Pokemon
     * @return level of evolution of a Pokemon, 101 if it has no evolution level
     */
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
                if (cl.getEvolvesTo().isEmpty())
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
    
    /**
     * Sets ability of Pokemon
     * @param ability String name of ability
     */
    public void setAbility(String ability) {
        activePKM.setAbility(ability);
    }
    
    /**
     * Returns an ArrayLIst of Strings containing the possible abilities of the current Pokemon in the correct language (according to langCode)
     * 
     * @return String-ArrayList of possible abilities 
     */
    public ArrayList<String> getAbilities(){
        models.pokemon.Pokemon test = pokeApiClient.getPokemonById(activePKM.getDexNr());
        
        ArrayList<String> abilityNames = new ArrayList<>();
        ArrayList<String> abilityDescs = new ArrayList<>();
        
        for (int i = test.getAbilities().size()-1; i >= 0; i--){
            String url = test.getAbilities().get(i).getAbility().getUrl();
            int abiID = Integer.parseInt(url.substring(url.indexOf("ability/")+8, url.length()-1));
            Ability a = pokeApiClient.getAbilityById(abiID);
            String name = nameLanguageSearch(a.getNames());
            String effect = descLanguageSearch(a.getEffectEntries());
            
            if (test.getAbilities().get(i).isHidden())
                name += " (HA)";
            abilityNames.add(name);
            abilityDescs.add(effect);
            activePKM.populateAbilities(abilityNames, abilityDescs);
        }
        
        return abilityNames;
    }
    
    public String getAbilityDesc(){
        return activePKM.getAbilityDesc();
    }
    
    /**
     * Gets ZRL of the front sprite of the current Pokemon.
     * 
     * @return URL to sprite of current Pokemon
     */
    public String getSprite(){
        return activePKM.getSprite();
    }
    
    /**
     * Sets name of the Pokemon in the current language (according to langCode)
     * 
     * @param nameLabel label in the view containing the Pokemon name
     */
    void setName(JLabel nameLabel){
        String name = nameLanguageSearch(pokeApiClient.getPokemonSpeciesById(activePKM.getDexNr()).getNames());
        activePKM.setName(name);
        nameLabel.setText(name);
    }
    
    /**
     * Updates the langCode variable
     * @param code language code (en, de, fr, it, es, jp, ko, jp-Hrkt, roomaji, zh-Hans, zt-Hant)
     */
    void updateLanguage(String code){
        this.langCode = code;
    }
    
    String getLanguage(){
        return langCode;
    }
    
    /**
     * Calculates the nature according to the positive and negative Stat selected
     * 
     * @param p RadioButton of positive Stat
     * @param m RadioButton of negative Stat
     * @return name of nature
     */
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
    
    /**
     * Calculates the stats of the current Pokemon according to the EVs, IVs and level selected in the View.
     * 
     * @param EVs Array of EVs [HP, Atk, Def, SpA, SpD, Ini]
     * @param IVs Array of IVs [HP, Atk, Def, SpA, SpD, Ini]
     * @param level level of the Pokemon
     * @param statAnz Array of labels for the stats to be printed to [HP, Atk, Def, SpA, SpD, Ini]
     * @param ev Exp Points gained by defeating this Pokemon
     */
    public void calculateStats(int[] EVs, int[] IVs, int level, JLabel[] statAnz, JLabel ev){
        double e;
        
        if(level >= activePKM.getLvlEntw()){
            e = 1.2;
        } else {
            e = 1;
        }
        
        stats[1] = (int) Math.floor(((2 * activePKM.getBaseStat(1) + IVs[1] + (EVs[1]/4)) * level/100 + 5) * natMUL[0]);
        stats[2] = (int) Math.floor(((2 * activePKM.getBaseStat(2) + IVs[2] + (EVs[2]/4)) * level/100 + 5) * natMUL[1]);
        stats[3] = (int) Math.floor(((2 * activePKM.getBaseStat(3) + IVs[3] + (EVs[3]/4)) * level/100 + 5) * natMUL[2]);
        stats[4] = (int) Math.floor(((2 * activePKM.getBaseStat(4) + IVs[4] + (EVs[4]/4)) * level/100 + 5) * natMUL[3]);
        stats[5] = (int) Math.floor(((2 * activePKM.getBaseStat(5) + IVs[5] + (EVs[5]/4)) * level/100 + 5) * natMUL[4]);
        
        stats[0] = (int) Math.floor(((2 * activePKM.getBaseStat(0)) + IVs[0] + EVs[0]/4 + 100) * level/100 + 10);
        
        for (int i = 0; i < statAnz.length; i++){
            statAnz[i].setText(""+stats[i]);
            ev.setText("+ "+(int) Math.floor(activePKM.getBaseXP()*level*e/7)+" Exp.");
        }
    }
    
    /**
     * Calculates the stats of a Pokemon according to the EVs, IVs and level selected in the View.
     * 
     * @param poke Pokemon Object
     * @param EVs Array of EVs [HP, Atk, Def, SpA, SpD, Ini]
     * @param IVs Array of IVs [HP, Atk, Def, SpA, SpD, Ini]
     * @param level level of the Pokemon
     * @param statAnz Array of labels for the stats to be printed to [HP, Atk, Def, SpA, SpD, Ini]
     * @param natMUL Array of ints representing the stat multipliers of the selected nature
     */
    public void calculateStats(Pokemon poke, int[] EVs, int[] IVs, int level, JLabel[] statAnz, double[] natMUL){
        Pokemon selected = poke;
        
        stats[1] = (int) Math.floor(((2 * selected.getBaseStat(1) + IVs[1] + (EVs[1]/4)) * level/100 + 5) * natMUL[0]);
        stats[2] = (int) Math.floor(((2 * selected.getBaseStat(2) + IVs[2] + (EVs[2]/4)) * level/100 + 5) * natMUL[1]);
        stats[3] = (int) Math.floor(((2 * selected.getBaseStat(3) + IVs[3] + (EVs[3]/4)) * level/100 + 5) * natMUL[2]);
        stats[4] = (int) Math.floor(((2 * selected.getBaseStat(4) + IVs[4] + (EVs[4]/4)) * level/100 + 5) * natMUL[3]);
        stats[5] = (int) Math.floor(((2 * selected.getBaseStat(5) + IVs[5] + (EVs[5]/4)) * level/100 + 5) * natMUL[4]);
        
        stats[0] = (int) Math.floor(((2 * selected.getBaseStat(0)) + IVs[0] + EVs[0]/4 + 100) * level/100 + 10);
        
        for (int i = 0; i < statAnz.length; i++){
            statAnz[i].setText(""+stats[i]);
        }
    }
    
    /**
     * Returns html code to represent the EVs gained by defeating this Pokemon.
     * 
     * @return String of html code containing the EVs
     */
    public String getEV(){
        if (activePKM == null)
            return null;
        return activePKM.getEVs();
    }
    
    /**
     * Updates the Spinners of the stat stages to have the values of the parameter Array 
     * 
     * @param change Array of Spinners representing the stat stages
     */
    public void setStatChange(JSpinner[] change){
        if (change.length != 5){
            System.out.println("ERROR setStatChange: incorrect amount of spinners in parameter array; SIZE OF ARRAY: " + change.length);
            return;
        }
        for (int i = 0; i < change.length; i++){
            if (statChange[i] < -6 || statChange[i] > 6){
                System.out.println("ERROR setStatChange: statChange Array has incorrect value; INDEX: " + i + "; VALUE: " + statChange[i]);
                return;
            }
            change[i].setValue(statChange[i]);
        }
    }
    
    /**
     * Updates the stat stages according to parameter index and stage value
     * 
     * @param index index of stat whose stage should be changed [0 - 4]
     * @param stage stat stage value [-6 - 6]
     */
    public void setStatStage(int index, int stage){
        if (stage <= 6 && stage >= -6){
            statChange[index] = stage;
        } else {
            System.out.println("ERROR setStatStage: parameter has incorrect value; VALUE: " + stage);
        }
    }

    /**
     * Sets all stat changes to 0 both in Model and View.
     * 
     * @param statCha Array of Spinners representing the stat stages
     */
    void statReset(JSpinner[] statCha) {
        statChange = new int[] {0,0,0,0,0};
        setStatChange(statCha);
    }
    
    /**
     * Updates the stat values displayed in the view.
     * 
     * @param anz Array of labels [HP, Atk, Def, SpA, SpD, Ini]
     */
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
    
    /**
     * Returns loaded Pokemon
     * 
     * @return Pokemon object loaded into Model
     */
    public Pokemon getP(){
        return activePKM;
    }
    
    /**
     * Takes the parameter Pokemon and integrates it into the Model.
     * 
     * @param p Pokemon to be loaded
     */
    public void setP(Pokemon p){
        this.activePKM = p;
    }
    
    /**
     * Loads Pokemon by supplying an int number representing the number in the national Pokedex
     * 
     * @param dex number of Pokemon in the national Pokedex
     * @return loaded Pokemon object
     */
    public Pokemon getPokemonbyDexNumber(int dex){
        return loadPokemon(""+dex);
    }
    
    /**
     * Returns the array of stats of the current Pokemon
     * 
     * @return Array of int stats [HP, Atk, Def, SpA, SpD, Ini]
     */
    public int[] getStats(){
        return stats;
    }
    
    /**
     * Looks through Name-List and searches for the language set in the langCode variable
     * 
     * @param names ArrayList of Names
     * @return String of name in language according to langCode value
     */
    public String nameLanguageSearch(ArrayList<Name> names) {
        for (Name name : names){
            if (name.getLanguage().getName().equals(langCode)){
                return name.getName();
            }
        }
        return "Language not found!";
    }
    
    /**
     * Looks through Name-List and searches for the language set in the langCode variable
     * 
     * @param description ArrayList of Descriptions
     * @return String of description in language according to langCode value
     */
    public String descLanguageSearch(ArrayList<models.common.VerboseEffect> descriptions) {
        for (models.common.VerboseEffect desc : descriptions){
            if (desc.getLanguage().getName().equals(langCode)){
                return desc.getEffect();
            }
        }
        return "Language not found!";
    }
    
    /**
     * Loads sprite from URL and displays it
     */
    public void getImage(JLabel gif) {
        URL url;
        try {
            url = new URL(activePKM.getSprite());
            BufferedImage img = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(img);
            
            gif.setIcon(icon);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Fehler bei Laden des Bildes. Überprüfe die Internetverbindung!");
        } catch (NullPointerException ex) {
            
        }
    }
}
