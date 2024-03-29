/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Handling class for the PokeApiV2
 * It holds data retrieved from the PokeAPIV2 including abilities, stats, EVs and more.
 *
 * @author Felix
 */
public class Pokemon {
    
    
    private String name;
    
    
    
    private int[] stats;
    private int lvlEntw; //wenn keine Entw. = 101
    private String exp;
    private String ability;
    private String EVText;
    private int level;
    private int dexNr;
    private final String spriteURL;
    private final api.Client pokeApiClient;
    private models.pokemon.Pokemon pokemonObj;
    ArrayList<models.moves.Move> moves;
    private ArrayList<models.pokemon.PokemonStat> statsList;
    private String nature;
    private Dictionary<String, String> abilities;
    
    
    /**
     * NEW Constructor with PokeAPIClient implementation into the Pokemon object class.
     * @param nameID String of Pokemon name or Pokedex number
     * @param pokeApiClient Client of the PokeAPI
     */
    public Pokemon(String nameID, api.Client pokeApiClient){
        this.pokeApiClient = pokeApiClient;
        
        this.pokemonObj = loadByNameorID(nameID);
        
        this.dexNr = pokemonObj.getId();
        
        this.spriteURL = pokemonObj.getSprites().getFrontDefault();
        this.statsList = pokemonObj.getStats();        
    }

    /**
     * Constructor to create a copy of a Pokemon.
     * TODO: Rework to fit new Constructor and remove unneeded variables.
     * 
     * @param p the Pokemon that should be made a copy of.
     */
    Pokemon (Pokemon p){
        this.abilities = p.abilities;
        this.dexNr = p.dexNr;
        this.lvlEntw = p.lvlEntw;
        this.spriteURL = p.spriteURL;
        this.nature = p.nature;
        this.name = p.name;
        this.stats = p.stats;
        this.statsList = p.statsList;
        this.pokeApiClient = p.pokeApiClient;
        this.pokemonObj = loadByNameorID("" + this.dexNr);
    }
    
    /**
     * Loads and returns a Pokemon
     * 
     * @param nameID Pokedex number or english name of Pokemon
     * @return loaded Pokemon object
     */
    private models.pokemon.Pokemon loadByNameorID (String nameID) {
        boolean isID = true;
        int id = 1;
        
        try{
            id = Integer.parseInt(nameID);
        } catch (NumberFormatException e){
            isID = false;
        }
        
        if (isID)
            return pokeApiClient.getPokemonById(id);
        else
            return pokeApiClient.getPokemonByName(nameID);
    }
    
    /**
     * 
     * @param id id of the stat: 0:HP, 1:Atk, 2:Def, 3:SpA, 4:SpD, 5:Ini
     * @return 
     */
    public int getBaseStat(int id){
        return statsList.get(id).getBaseStat();
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
     * @return description of current ability 
     */
    public String getAbilityDesc() {
        return abilities.get(ability);
    }

    /**
     * @param ability the ability to set
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }
    
    public void populateAbilities(ArrayList<String> names, ArrayList<String> desc){
        abilities = new Hashtable<>();
        for (int i = 0; i < names.size(); i++){
            abilities.put(names.get(i), desc.get(i));
        }
    }
    
    /**
     * Returns the national Pokedex number of the Pokemon
     * 
     * @return national Pokedex number of Pokemon
     */
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
        String EVs = "<html><body>";

        int [] pkmStats = new int[6];
        
        for (int i = 5, j = 0; i >= 0; i--){
            models.pokemon.PokemonStat ps = statsList.get(i);
            pkmStats[j] = ps.getBaseStat();
            if (ps.getEffort() > 0){
                String n = ps.getStat().getName();
                n = n.substring(0, 1).toUpperCase() + n.substring(1);
                EVs += ps.getEffort() + " " + n + "<br>";
            }
            j++;
        }

        EVs += "</body></html>";
        EVText = EVs;
        return EVs;
    }
    
    /**
     * @return saved EV Text
     */
    public String getEVText(){
        return EVText;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return ArrayList of names in different languages
     */
    public ArrayList<models.common.Name> getNames() {
        return pokemonObj.getSpecies().getNames();
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
    public ArrayList<models.pokemon.PokemonAbility> getAbilities() {
        return pokeApiClient.getPokemonById(dexNr).getAbilities();
    }

    /**
     * @param nature the nature to set
     */
    public void setNature(String nature) {
        this.nature = nature;
    }

    String getSprite() {
        return spriteURL;
    }

    /**
     * @return the baseXP
     */
    public int getBaseXP() {
        return pokemonObj.getBaseExperience();
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
    
    public ArrayList<String> getAttackList(String langCode){
        ArrayList<String> ret = new ArrayList<>();
        if (this.moves == null){
            this.moves = new ArrayList<>();
            ArrayList<models.pokemon.PokemonMove> pmoves = pokemonObj.getMoves();

            for (models.pokemon.PokemonMove pmove : pmoves) {
                String[] strsplit = pmove.getMove().getUrl().split("/", 0);
                int id = Integer.parseInt(strsplit[strsplit.length-1]);
                this.moves.add(models.moves.Move.getById(id));
            }
        }
        
        for (models.moves.Move move : moves) {
            ret.add(getNameFromNamesList(move.getNames(), langCode));
        }
        
        return ret;
    }
    
    /**
     * Looks through Name-List and searches for the language set in the langCode variable
     * 
     * @param nameList ArrayList of Names
     * @param langCode identifying string of the chosen language
     * @return String of name in language according to langCode value
     */
    public static String getNameFromNamesList(ArrayList<models.common.Name> nameList, String langCode) {
        for (models.common.Name name : nameList){
            if (name.getLanguage().getName().equals(langCode)){
                return name.getName();
            }
        }
        return "Language not found!";
    }
    
    
    /**
     * Looks through Name-List and searches for the language set in the langCode variable
     * 
     * @param descriptions ArrayList of Descriptions
     * @param langCode identifying string of the chosen language
     * @return String of description in language according to langCode value
     */
    public static String descLanguageSearch(ArrayList<models.common.VerboseEffect> descriptions, String langCode) {
        for (models.common.VerboseEffect desc : descriptions){
            if (desc.getLanguage().getName().equals(langCode)){
                return desc.getEffect();
            }
        }
        return "Language not found!";
    }
}
