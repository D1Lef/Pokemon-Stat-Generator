/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Felix
 */
public class Model {
    
    private ArrayList<Pokemon> p;
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
        p = new ArrayList<>();
        
        p.add(new Pokemon(
                1, "http://www.pokewiki.de/images/a/a9/Pokémonsprite_001_XY.gif",
                "Bisasam", 45, 49, 49, 65, 65, 45, 
                new ArrayList<>(Arrays.asList("Notdünger", 
                        "Chlorophyll (VF)")), 64, 16, 
                "<html><body>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                2, "http://www.pokewiki.de/images/4/49/Pokémonsprite_002_XY.gif",
                "Bisaknosp", 60, 62, 63, 80, 80, 60, 
                new ArrayList<>(Arrays.asList("Notdünger", 
                        "Chlorophyll (VF)")), 142, 32, 
                "<html><body>1 SpA<br>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                3, "http://www.pokewiki.de/images/4/46/Pokémonsprite_003_XY.gif",
                "Bisaflor", 80, 82, 83, 100, 100, 80, 
                new ArrayList<>(Arrays.asList("Notdünger", 
                        "Chlorophyll (VF)")), 236, 101, 
                "<html><body>2 SpA<br>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                4, "http://www.pokewiki.de/images/5/55/Pokémonsprite_004_XY.gif",
                "Glumanda", 39, 52, 43, 60, 50, 65, 
                new ArrayList<>(Arrays.asList("Großbrand", 
                        "Solarkraft (VF)")), 62, 16, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                5, "http://www.pokewiki.de/images/4/4b/Pokémonsprite_005_XY.gif",
                "Glutexo", 58, 64, 58, 80, 65, 80, 
                new ArrayList<>(Arrays.asList("Großbrand", 
                        "Solarkraft (VF)")), 142, 36, 
                "<html><body>1 SpA<br>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                6, "http://www.pokewiki.de/images/9/9e/Pokémonsprite_006_XY.gif",
                "Glurak", 78, 84, 78, 109, 85, 100, 
                new ArrayList<>(Arrays.asList("Großbrand", 
                        "Solarkraft (VF)")), 240, 101, 
                "<html><body>3 SpA</body></html>"));
        
        p.add(new Pokemon(
                7, "http://www.pokewiki.de/images/a/a3/Pokémonsprite_007_XY.gif",
                "Schiggy", 44, 48, 65, 50, 64, 43, 
                new ArrayList<>(Arrays.asList("Sturzbach", 
                        "Regengenuss (VF)")), 63, 16, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                8, "http://www.pokewiki.de/images/c/c2/Pokémonsprite_008_XY.gif",
                "Schillok", 59, 63, 80, 65, 80, 58, 
                new ArrayList<>(Arrays.asList("Sturzbach", 
                        "Regengenuss (VF)")), 142, 36, 
                "<html><body>1 Def<br>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                9, "http://www.pokewiki.de/images/c/cd/Pokémonsprite_009_XY.gif",
                "Turtok", 79, 83, 100, 85, 105, 78, 
                new ArrayList<>(Arrays.asList("Sturzbach", 
                        "Regengenuss (VF)")), 239, 101, 
                "<html><body>3 SpD</body></html>"));
        
        p.add(new Pokemon(
                10, "http://www.pokewiki.de/images/1/1d/Pokémonsprite_010_XY.gif",
                "Raupy", 45, 30, 35, 20, 20, 45, 
                new ArrayList<>(Arrays.asList("Puderabwehr", 
                        "Angsthase (VF)")), 39, 7, 
                "<html><body>1 HP</body></html>"));
        
        p.add(new Pokemon(
                11, "http://www.pokewiki.de/images/9/9b/Pokémonsprite_011_XY.gif",
                "Safcon", 50, 20, 55, 25, 25, 30, 
                new ArrayList<>(Arrays.asList("Expidermis")), 72, 10, 
                "<html><body>2 Def</body></html>"));
        
        p.add(new Pokemon(
                12, "http://www.pokewiki.de/images/2/2d/Pokémonsprite_012_XY.gif",
                "Smettbo", 60, 45, 50, 90, 80, 70, 
                new ArrayList<>(Arrays.asList("Facettenauge", 
                        "Aufwertung (VF)")), 178, 101, 
                "<html><body>2 SpA<br>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                13, "http://www.pokewiki.de/images/e/eb/Pokémonsprite_013_XY.gif",
                "Hornliu", 40, 35, 30, 20, 20, 50, 
                new ArrayList<>(Arrays.asList("Puderabwehr", 
                        "Angsthase (VF)")), 39, 7, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                14, "http://www.pokewiki.de/images/a/a5/Pokémonsprite_014_XY.gif",
                "Kokuna", 45, 25, 50, 25, 25, 35, 
                new ArrayList<>(Arrays.asList("Expidermis")), 72, 10, 
                "<html><body>2 Def</body></html>"));
        
        p.add(new Pokemon(
                15, "http://www.pokewiki.de/images/a/a4/Pokémonsprite_015_XY.gif",
                "Bibor", 65, 90, 40, 45, 80, 75, 
                new ArrayList<>(Arrays.asList("Hexaplaga", 
                        "Superschütze (VF)")), 178, 101, 
                "<html><body>2 Atk<br>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                16, "http://www.pokewiki.de/images/7/76/Pokémonsprite_016_XY.gif",
                "Taubsi", 40, 45, 40, 35, 35, 56, 
                new ArrayList<>(Arrays.asList("Adlerauge", "Fußangel",
                        "Brustbieter (VF)")), 50, 18, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                17, "http://www.pokewiki.de/images/f/f2/Pokémonsprite_017_XY.gif",
                "Tauboga", 63, 60, 55, 50, 50, 71, 
                new ArrayList<>(Arrays.asList("Adlerauge", "Fußangel",
                        "Brustbieter (VF)")), 122, 36, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                18, "http://www.pokewiki.de/images/a/a4/Pokémonsprite_018_XY.gif",
                "Tauboss", 83, 80, 75, 70, 70, 101, 
                new ArrayList<>(Arrays.asList("Adlerauge", "Fußangel",
                        "Brustbieter (VF)")), 216, 101, 
                "<html><body>3 Ini</body></html>"));
       
        p.add(new Pokemon(
                19, "http://www.pokewiki.de/images/f/fa/Pokémonsprite_019_XY.gif",
                "Rattfratz", 30, 56, 35, 25, 35, 72, 
                new ArrayList<>(Arrays.asList("Angsthase", "Adrenalin",
                        "Übereifer (VF)")), 51, 20, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                20, "http://www.pokewiki.de/images/8/82/Pokémonsprite_020_XY.gif",
                "Rattikarl", 55, 81, 60, 50, 70, 97, 
                new ArrayList<>(Arrays.asList("Angsthase", "Adrenalin",
                        "Übereifer (VF)")), 145, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                21, "http://www.pokewiki.de/images/c/c7/Pokémonsprite_021_XY.gif",
                "Habitak", 40, 60, 30, 31, 31, 70, 
                new ArrayList<>(Arrays.asList("Adlerauge", 
                        "Superschütze (VF)")), 52, 20, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                22, "http://www.pokewiki.de/images/3/32/Pokémonsprite_022_XY.gif",
                "Ibitak", 85, 90, 65, 61, 61, 100, 
                new ArrayList<>(Arrays.asList("Adlerauge", 
                        "Superschütze (VF)")), 155, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                23, "http://www.pokewiki.de/images/8/80/Pokémonsprite_023_XY.gif",
                "Rettan", 35, 60, 44, 40, 54, 55, 
                new ArrayList<>(Arrays.asList("Bedroher", "Expidermis",
                        "Anspannung (VF)")), 58, 22, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                24, "http://www.pokewiki.de/images/8/8f/Pokémonsprite_024_XY.gif",
                "Arbok", 60, 95, 69, 65, 79, 80, 
                new ArrayList<>(Arrays.asList("Bedroher", "Expidermis",
                        "Anspannung (VF)")), 157, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                25, "http://www.pokewiki.de/images/c/c7/Pokémonsprite_025_XY.gif",
                "Pikachu", 35, 55, 40, 50, 50, 90, 
                new ArrayList<>(Arrays.asList("Statik", 
                        "Blitzfänger (VF)")), 112, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                26, "http://www.pokewiki.de/images/f/f2/Pokémonsprite_026_XY.gif",
                "Raichu", 60, 90, 55, 90, 80, 110, 
                new ArrayList<>(Arrays.asList("Statik", 
                        "Blitzfänger (VF)")), 218, 101, 
                "<html><body>3 Ini</body></html>"));
       
        p.add(new Pokemon(
                27, "http://www.pokewiki.de/images/f/f0/Pokémonsprite_027_XY.gif",
                "Sandan", 50, 75, 85, 20, 30, 40, 
                new ArrayList<>(Arrays.asList("Sandschleier", 
                        "Sandscharrer (VF)")), 60, 22, 
                "<html><body>1 Def</body></html>"));
       
        p.add(new Pokemon(
                28, "http://www.pokewiki.de/images/7/78/Pokémonsprite_028_XY.gif",
                "Sandamer", 75, 100, 110, 45, 55, 65, 
                new ArrayList<>(Arrays.asList("Sandschleier", 
                        "Sandscharrer (VF)")), 158, 101, 
                "<html><body>2 Def</body></html>"));
       
        p.add(new Pokemon(
                29, "http://www.pokewiki.de/images/e/ed/Pokémonsprite_029_XY.gif",
                "Nidoran ♀", 55, 47, 52, 40, 40, 41, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Rivalität", 
                        "Übereifer (VF)")), 55, 16, 
                "<html><body>1 HP</body></html>"));
       
        p.add(new Pokemon(
                30, "http://www.pokewiki.de/images/8/81/Pokémonsprite_030_XY.gif",
                "Nidorina", 70, 62, 67, 55, 55, 56, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Rivalität", 
                        "Übereifer (VF)")), 128, 101, 
                "<html><body>2 HP</body></html>"));
       
        p.add(new Pokemon(
                31, "http://www.pokewiki.de/images/7/7b/Pokémonsprite_031_XY.gif",
                "Nidoqueen", 90, 92, 87, 75, 85, 76, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Rivalität", 
                        "Rohe Gewalt (VF)")), 227, 101, 
                "<html><body>3 HP</body></html>"));
       
        p.add(new Pokemon(
                32, "http://www.pokewiki.de/images/8/8a/Pokémonsprite_032_XY.gif",
                "Nidoran ♂", 46, 57, 40, 40, 40, 50, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Rivalität", 
                        "Übereifer (VF)")), 55, 16, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                33, "http://www.pokewiki.de/images/6/63/Pokémonsprite_033_XY.gif",
                "Nidorino", 61, 72, 57, 55, 55, 65, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Rivalität", 
                        "Übereifer (VF)")), 128, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                34, "http://www.pokewiki.de/images/f/f6/Pokémonsprite_034_XY.gif",
                "Nidoking", 81, 102, 77, 85, 75, 85, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Rivalität", 
                        "Rohe Gewalt (VF)")), 227, 101, 
                "<html><body>3 Atk</body></html>"));
       
        p.add(new Pokemon(
                35, "http://www.pokewiki.de/images/7/79/Pokémonsprite_035_XY.gif",
                "Piepi", 70, 45, 48, 60, 65, 35, 
                new ArrayList<>(Arrays.asList("Charmebolzen", "Magieschild", 
                        "Freundeshut (VF)")), 115, 101, 
                "<html><body>2 HP</body></html>"));
       
        p.add(new Pokemon(
                36, "http://www.pokewiki.de/images/a/ad/Pokémonsprite_036_XY.gif",
                "Pixi", 95, 70, 73, 95, 90, 60, 
                new ArrayList<>(Arrays.asList("Charmebolzen", "Magieschild", 
                        "Unkenntnis (VF)")), 217, 101, 
                "<html><body>3 HP</body></html>"));
       
        p.add(new Pokemon(
                37, "http://www.pokewiki.de/images/a/a2/Pokémonsprite_037_XY.gif",
                "Vulpix", 38, 41, 40, 50, 65, 65, 
                new ArrayList<>(Arrays.asList("Feuerfänger",  
                        "Dürre (VF)")), 60, 101, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                38, "http://www.pokewiki.de/images/5/5d/Pokémonsprite_038_XY.gif",
                "Vulnona", 73, 76, 75, 81, 100, 100, 
                new ArrayList<>(Arrays.asList("Feuerfänger",  
                        "Dürre (VF)")), 177, 101, 
                "<html><body>1 SpD<br>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                39, "http://www.pokewiki.de/images/3/37/Pokémonsprite_039_XY.gif",
                "Pummeluff", 115, 45, 20, 45, 25, 20, 
                new ArrayList<>(Arrays.asList("Charmebolzen", "Unbeugsamkeit",  
                        "Freundeshut (VF)")), 95, 101, 
                "<html><body>2 HP</body></html>"));
       
        p.add(new Pokemon(
                40, "http://www.pokewiki.de/images/2/27/Pokémonsprite_040_XY.gif",
                "Knuddeluff", 140, 70, 45, 85, 50, 45, 
                new ArrayList<>(Arrays.asList("Charmebolzen", "Unbeugsamkeit",  
                        "Schnüffler (VF)")), 196, 101, 
                "<html><body>3 HP</body></html>"));
       
        p.add(new Pokemon(
                41, "http://www.pokewiki.de/images/1/14/Pokémonsprite_041_XY.gif",
                "Zubat", 40, 45, 30, 30, 40, 55, 
                new ArrayList<>(Arrays.asList("Konzentrator",  
                        "Schwebedurch (VF)")), 49, 22, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                42, "http://www.pokewiki.de/images/4/4e/Pokémonsprite_042_XY.gif",
                "Golbat", 75, 80, 70, 65, 75, 90, 
                new ArrayList<>(Arrays.asList("Konzentrator",  
                        "Schwebedurch (VF)")), 159, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                43, "http://www.pokewiki.de/images/a/a2/Pokémonsprite_043_XY.gif",
                "Myrapla", 45, 50, 55, 75, 65, 30, 
                new ArrayList<>(Arrays.asList("Chlorophyll",  
                        "Angsthase (VF)")), 64, 21, 
                "<html><body>1 SpA</body></html>"));
       
        p.add(new Pokemon(
                44, "http://www.pokewiki.de/images/1/1c/Pokémonsprite_044_XY.gif",
                "Duflor", 60, 65, 70, 85, 75, 40, 
                new ArrayList<>(Arrays.asList("Chlorophyll",  
                        "Duftnote (VF)")), 138, 101, 
                "<html><body>2 SpA</body></html>"));
       
        p.add(new Pokemon(
                45, "http://www.pokewiki.de/images/8/89/Pokémonsprite_045_XY.gif",
                "Giflor", 75, 80, 85, 110, 90, 50, 
                new ArrayList<>(Arrays.asList("Chlorophyll",  
                        "Sporenwirt (VF)")), 221, 101, 
                "<html><body>3 SpA</body></html>"));
       
        p.add(new Pokemon(
                46, "http://www.pokewiki.de/images/9/97/Pokémonsprite_046_XY.gif",
                "Paras", 35, 70, 55, 45, 55, 25, 
                new ArrayList<>(Arrays.asList("Sporenwirt", "Trockenheit",  
                        "Feuchtigkeit (VF)")), 57, 24, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                47, "http://www.pokewiki.de/images/1/16/Pokémonsprite_047_XY.gif",
                "Parasek", 60, 95, 80, 60, 80, 30, 
                new ArrayList<>(Arrays.asList("Sporenwirt", "Trockenheit",  
                        "Feuchtigkeit (VF)")), 142, 101, 
                "<html><body>2 Atk<br>1 Def</body></html>"));
       
        p.add(new Pokemon(
                48, "http://www.pokewiki.de/images/3/34/Pokémonsprite_048_XY.gif",
                "Bluzuk", 60, 55, 50, 40, 55, 45, 
                new ArrayList<>(Arrays.asList("Facettenauge", "Aufwertung",  
                        "Angsthase (VF)")), 61, 31, 
                "<html><body>1 SpD</body></html>"));
       
        p.add(new Pokemon(
                49, "http://www.pokewiki.de/images/f/f8/Pokémonsprite_049_XY.gif",
                "Omot", 70, 65, 60, 90, 75, 90, 
                new ArrayList<>(Arrays.asList("Puderabwehr", "Aufwertung",  
                        "Wunderhaut (VF)")), 158, 101, 
                "<html><body>1 SpD<br>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                50, "http://www.pokewiki.de/images/1/18/Pokémonsprite_050_XY.gif",
                "Digda", 10, 55, 25, 35, 45, 95, 
                new ArrayList<>(Arrays.asList("Sandschleier", "Ausweglos",  
                        "Sandgewalt (VF)")), 53, 26, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                51, "http://www.pokewiki.de/images/4/47/Pokémonsprite_051_XY.gif",
                "Digdri", 35, 100, 50, 50, 70, 120, 
                new ArrayList<>(Arrays.asList("Sandschleier", "Ausweglos",  
                        "Sandgewalt (VF)")), 149, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                52, "http://www.pokewiki.de/images/f/f4/Pokémonsprite_052_XY.gif",
                "Mauzi", 40, 45, 35, 40, 40, 90, 
                new ArrayList<>(Arrays.asList("Mitnahme", "Techniker",  
                        "Anspannung (VF)")), 58, 28, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                53, "http://www.pokewiki.de/images/c/cf/Pokémonsprite_053_XY.gif",
                "Snobilikat", 65, 70, 60, 65, 65, 115, 
                new ArrayList<>(Arrays.asList("Flexibilität", "Techniker",  
                        "Anspannung (VF)")), 154, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                54, "http://www.pokewiki.de/images/6/65/Pokémonsprite_054_XY.gif",
                "Enton", 50, 52, 48, 65, 50, 55, 
                new ArrayList<>(Arrays.asList("Feuchtigkeit", "Wolke Sieben",  
                        "Wassertempo (VF)")), 64, 33, 
                "<html><body>1 SpA</body></html>"));
       
        p.add(new Pokemon(
                55, "http://www.pokewiki.de/images/7/77/Pokémonsprite_055_XY.gif",
                "Entoron", 80, 82, 78, 95, 80, 85, 
                new ArrayList<>(Arrays.asList("Feuchtigkeit", "Wolke Sieben",  
                        "Wassertempo (VF)")), 175, 101, 
                "<html><body>2 SpA</body></html>"));
       
        p.add(new Pokemon(
                56, "http://www.pokewiki.de/images/3/3f/Pokémonsprite_056_XY.gif",
                "Menki", 40, 80, 35, 35, 45, 70, 
                new ArrayList<>(Arrays.asList("Munterkeit", "Kurzschluss",  
                        "Siegeswille (VF)")), 61, 28, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                57, "http://www.pokewiki.de/images/7/7d/Pokémonsprite_057_XY.gif",
                "Rasaff", 65, 105, 60, 60, 70, 95, 
                new ArrayList<>(Arrays.asList("Munterkeit", "Kurzschluss",  
                        "Siegeswille (VF)")), 159, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                58, "http://www.pokewiki.de/images/c/cb/Pokémonsprite_058_XY.gif",
                "Fukano", 55, 70, 45, 70, 50, 60, 
                new ArrayList<>(Arrays.asList("Bedroher", "Feuerfänger",  
                        "Redlichkeit (VF)")), 70, 101, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                59, "http://www.pokewiki.de/images/7/74/Pokémonsprite_059_XY.gif",
                "Arkani", 90, 110, 80, 100, 80, 95, 
                new ArrayList<>(Arrays.asList("Bedroher", "Feuerfänger",  
                        "Redlichkeit (VF)")), 194, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                60, "http://www.pokewiki.de/images/b/ba/Pokémonsprite_060_XY.gif",
                "Quapsel", 40, 50, 40, 40, 40, 90, 
                new ArrayList<>(Arrays.asList("H2O-Absorber", "Feuchtigkeit",  
                        "Wassertempo (VF)")), 60, 25, 
                "<html><body>1 Ini</body></html>"));
       
        p.add(new Pokemon(
                61, "http://www.pokewiki.de/images/d/d6/Pokémonsprite_061_XY.gif",
                "Quaputzi", 65, 65, 65, 50, 50, 90, 
                new ArrayList<>(Arrays.asList("H2O-Absorber", "Feuchtigkeit",  
                        "Wassertempo (VF)")), 135, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                62, "http://www.pokewiki.de/images/0/00/Pokémonsprite_062_XY.gif",
                "Quappo", 90, 95, 95, 70, 90, 70, 
                new ArrayList<>(Arrays.asList("H2O-Absorber", "Feuchtigkeit",  
                        "Wassertempo (VF)")), 230, 101, 
                "<html><body>3 Def</body></html>"));
       
        p.add(new Pokemon(
                63, "http://www.pokewiki.de/images/4/41/Pokémonsprite_063_XY.gif",
                "Abra", 25, 20, 15, 105, 55, 90, 
                new ArrayList<>(Arrays.asList("Synchro", "Konzentrator",  
                        "Magieschild (VF)")), 62, 16, 
                "<html><body>1 SpA</body></html>"));
       
        p.add(new Pokemon(
                64, "http://www.pokewiki.de/images/4/4b/Pokémonsprite_064_XY.gif",
                "Kadabra", 40, 35, 30, 120, 70, 105, 
                new ArrayList<>(Arrays.asList("Synchro", "Konzentrator",  
                        "Magieschild (VF)")), 140, 101, 
                "<html><body>2 SpA</body></html>"));
       
        p.add(new Pokemon(
                65, "http://www.pokewiki.de/images/0/0d/Pokémonsprite_065_XY.gif",
                "Simsala", 55, 50, 45, 135, 95, 120, 
                new ArrayList<>(Arrays.asList("Synchro", "Konzentrator",  
                        "Magieschild (VF)")), 225, 101, 
                "<html><body>3 SpA</body></html>"));
       
        p.add(new Pokemon(
                66, "http://www.pokewiki.de/images/b/bc/Pokémonsprite_066_XY.gif",
                "Machollo", 70, 80, 50, 35, 35, 35, 
                new ArrayList<>(Arrays.asList("Adrenalin", "Schildlos",  
                        "Felsenfest (VF)")), 61, 28, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                67, "http://www.pokewiki.de/images/4/4c/Pokémonsprite_067_XY.gif",
                "Maschock", 80, 100, 70, 50, 60, 45, 
                new ArrayList<>(Arrays.asList("Adrenalin", "Schildlos",  
                        "Felsenfest (VF)")), 142, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                68, "http://www.pokewiki.de/images/0/09/Pokémonsprite_068_XY.gif",
                "Machomei", 90, 130, 80, 65, 65, 55, 
                new ArrayList<>(Arrays.asList("Adrenalin", "Schildlos",  
                        "Felsenfest (VF)")), 227, 101, 
                "<html><body>3 Atk</body></html>"));
       
        p.add(new Pokemon(
                69, "http://www.pokewiki.de/images/f/f8/Pokémonsprite_069_XY.gif",
                "Knofensa", 50, 75, 35, 70, 30, 40, 
                new ArrayList<>(Arrays.asList("Chlorophyll", "Völlerei (VF)"  
                        )), 60, 21, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                70, "http://www.pokewiki.de/images/e/e8/Pokémonsprite_070_XY.gif",
                "Ultrigaria", 65, 90, 50, 85, 45, 55, 
                new ArrayList<>(Arrays.asList("Chlorophyll", "Völlerei (VF)"  
                        )), 137, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                71, "http://www.pokewiki.de/images/7/71/Pokémonsprite_071_XY.gif",
                "Sarzenia", 80, 105, 65, 100, 70, 70, 
                new ArrayList<>(Arrays.asList("Chlorophyll", "Völlerei (VF)"  
                        )), 221, 101, 
                "<html><body>3 Atk</body></html>"));
       
        p.add(new Pokemon(
                72, "http://www.pokewiki.de/images/1/1b/Pokémonsprite_072_XY.gif",
                "Tentacha", 40, 40, 35, 50, 100, 70, 
                new ArrayList<>(Arrays.asList("Neutraltorso", "Kloakensoße",
                        "Regengenuss (VF)")), 67, 30, 
                "<html><body>1 SpD</body></html>"));
       
        p.add(new Pokemon(
                73, "http://www.pokewiki.de/images/3/37/Pokémonsprite_073_XY.gif",
                "Tentoxa", 80, 70, 65, 80, 120, 100, 
                new ArrayList<>(Arrays.asList("Neutraltorso", "Kloakensoße",
                        "Regengenuss (VF)")), 180, 101, 
                "<html><body>2 SpD</body></html>"));
       
        p.add(new Pokemon(
                74, "http://www.pokewiki.de/images/e/ef/Pokémonsprite_074_XY.gif",
                "Kleinstein", 40, 80, 100, 30, 30, 20, 
                new ArrayList<>(Arrays.asList("Robustheit", "Steinhaupt",
                        "Sandschleier (VF)")), 60, 25, 
                "<html><body>1 Def</body></html>"));
       
        p.add(new Pokemon(
                75, "http://www.pokewiki.de/images/2/21/Pokémonsprite_075_XY.gif",
                "Georok", 55, 95, 115, 45, 45, 35, 
                new ArrayList<>(Arrays.asList("Robustheit", "Steinhaupt",
                        "Sandschleier (VF)")), 137, 101, 
                "<html><body>2 Def</body></html>"));
              
        p.add(new Pokemon(
                76, "http://www.pokewiki.de/images/9/9f/Pokémonsprite_076_XY.gif",
                "Geowaz", 80, 120, 130, 55, 65, 45, 
                new ArrayList<>(Arrays.asList("Robustheit", "Steinhaupt",
                        "Sandschleier (VF)")), 223, 101, 
                "<html><body>3 Def</body></html>"));
             
        p.add(new Pokemon(
                77, "http://www.pokewiki.de/images/9/97/Pokémonsprite_077_XY.gif",
                "Ponita", 50, 85, 55, 65, 65, 90, 
                new ArrayList<>(Arrays.asList("Angsthase", "Feuerfänger",
                        "Flammkörper (VF)")), 82, 40, 
                "<html><body>1 Ini</body></html>"));
            
        p.add(new Pokemon(
                78, "http://www.pokewiki.de/images/8/82/Pokémonsprite_078_XY.gif",
                "Gallopa", 65, 100, 70, 80, 80, 105, 
                new ArrayList<>(Arrays.asList("Angsthase", "Feuerfänger",
                        "Flammkörper (VF)")), 175, 101, 
                "<html><body>2 Ini</body></html>"));
       
        p.add(new Pokemon(
                79, "http://pokewiki.de/images/9/9c/Pokémonsprite_079_XY.gif",
                "Flegmon", 90, 65, 65, 40, 40, 15, 
                new ArrayList<>(Arrays.asList("Dösigkeit", "Tempomacher",
                        "Belebekraft (VF)")), 63, 37, 
                "<html><body>1 HP</body></html>"));
       
        p.add(new Pokemon(
                80, "http://pokewiki.de/images/2/2d/Pokémonsprite_080_XY.gif",
                "Lahmus", 97, 75, 110, 100, 80, 30, 
                new ArrayList<>(Arrays.asList("Dösigkeit", "Tempomacher",
                        "Belebekraft (VF)")), 172, 101, 
                "<html><body>2 Def</body></html>"));
       
        p.add(new Pokemon(
                81, "http://pokewiki.de/images/5/5f/Pokémonsprite_081_XY.gif",
                "Magnetilo", 25, 35, 70, 95, 55, 45, 
                new ArrayList<>(Arrays.asList("Magnetfalle", "Robustheit",
                        "Analyse (VF)")), 65, 30, 
                "<html><body>1 SpA</body></html>"));
       
        p.add(new Pokemon(
                82, "http://pokewiki.de/images/0/02/Pokémonsprite_082_XY.gif",
                "Magneton", 50, 60, 95, 120, 70, 70, 
                new ArrayList<>(Arrays.asList("Magnetfalle", "Robustheit",
                        "Analyse (VF)")), 163, 101, 
                "<html><body>2 SpA</body></html>"));
       
        p.add(new Pokemon(
                83, "http://pokewiki.de/images/f/f1/Pokémonsprite_083_XY.gif",
                "Porenta", 52, 90, 55, 58, 62, 60, 
                new ArrayList<>(Arrays.asList("Adlerauge", "Konzentrator",
                        "Siegeswille (VF)")), 132, 101, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                84, "http://pokewiki.de/images/9/98/Pokémonsprite_084_XY.gif",
                "Dodu", 35, 85, 45, 35, 35, 75, 
                new ArrayList<>(Arrays.asList("Angsthase", "Frühwecker",
                        "Fußangel (VF)")), 62, 31, 
                "<html><body>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                85, "http://pokewiki.de/images/5/54/Pokémonsprite_085_XY.gif",
                "Dodri", 60, 110, 70, 60, 60, 110, 
                new ArrayList<>(Arrays.asList("Angsthase", "Frühwecker",
                        "Fußangel (VF)")), 165, 101, 
                "<html><body>2 Atk</body></html>"));
       
        p.add(new Pokemon(
                86, "http://pokewiki.de/images/4/40/Pokémonsprite_086_XY.gif",
                "Jurob", 65, 45, 55, 45, 70, 45, 
                new ArrayList<>(Arrays.asList("Speckschicht", "Hydration",
                        "Eishaut (VF)")), 65, 34, 
                "<html><body>1 SpD</body></html>"));
       
        p.add(new Pokemon(
                87, "http://pokewiki.de/images/3/3f/Pokémonsprite_087_XY.gif",
                "Jugong", 90, 70, 80, 70, 95, 70, 
                new ArrayList<>(Arrays.asList("Speckschicht", "Hydration",
                        "Eishaut (VF)")), 166, 101, 
                "<html><body>2 SpD</body></html>"));
       
        p.add(new Pokemon(
                88, "http://pokewiki.de/images/1/18/Pokémonsprite_088_XY.gif",
                "Sleima", 80, 80, 50, 40, 50, 25, 
                new ArrayList<>(Arrays.asList("Duftnote", "Wertehalter",
                        "Giftgriff (VF)")), 65, 38, 
                "<html><body>1 HP</body></html>"));
       
        p.add(new Pokemon(
                89, "http://pokewiki.de/images/b/bc/Pokémonsprite_089_XY.gif",
                "Sleimok", 105, 105, 75, 65, 100, 50, 
                new ArrayList<>(Arrays.asList("Duftnote", "Wertehalter",
                        "Giftgriff (VF)")), 175, 101, 
                "<html><body>1 HP<br>1 Atk</body></html>"));
       
        p.add(new Pokemon(
                90, "http://pokewiki.de/images/7/78/Pokémonsprite_090_XY.gif",
                "Muschas", 30, 65, 100, 45, 25, 40, 
                new ArrayList<>(Arrays.asList("Panzerhaut", "Wertelink",
                        "Wetterfest (VF)")), 61, 101, 
                "<html><body>1 Def</body></html>"));
       
        p.add(new Pokemon(
                91, "http://pokewiki.de/images/4/4a/Pokémonsprite_091_XY.gif",
                "Austos", 50, 95, 180, 85, 45, 70, 
                new ArrayList<>(Arrays.asList("Panzerhaut", "Wertelink",
                        "Wetterfest (VF)")), 184, 101, 
                "<html><body>2 Def</body></html>"));
        
        p.add(new Pokemon(
                92, "http://www.pokewiki.de/images/6/64/Pokémonsprite_092_XY.gif",
                "Nebulak", 30, 35, 30, 100, 35, 80, 
                new ArrayList<>(Arrays.asList("Schwebe")), 62, 25, 
                "<html><body>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                93, "http://pokewiki.de/images/d/de/Pokémonsprite_093_XY.gif",
                "Alpollo", 45, 50, 45, 115, 55, 95, 
                new ArrayList<>(Arrays.asList("Schwebe")), 142, 101, 
                "<html><body>2 SpA</body></html>"));
        
        p.add(new Pokemon(
                94, "http://pokewiki.de/images/8/88/Pokémonsprite_094_XY.gif",
                "Gengar", 60, 65, 60, 130, 75, 110, 
                new ArrayList<>(Arrays.asList("Schwebe", "Tastfluch")), 225, 101, 
                "<html><body>3 SpA</body></html>"));
        
        p.add(new Pokemon(
                95, "http://pokewiki.de/images/7/77/Pokémonsprite_095_XY.gif",
                "Onix", 35, 45, 160, 30, 45, 70, 
                new ArrayList<>(Arrays.asList("Steinhaupt", "Robustheit",
                        "Bruchrüstung (VF)")), 77, 101, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                96, "http://pokewiki.de/images/3/3e/Pokémonsprite_096_XY.gif",
                "Traumato", 60, 48, 45, 43, 90, 42, 
                new ArrayList<>(Arrays.asList("Insomnia", "Vorwarnung",
                        "Kontentrator (VF)")), 66, 26, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                97, "https://www.pokewiki.de/images/e/ec/Pokémonsprite_097_XY.gif",
                "Hypno", 85, 73, 70, 73, 115, 67, 
                new ArrayList<>(Arrays.asList("Insomnia", "Vorwarnung",
                        "Kontentrator (VF)")), 169, 101, 
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                98, "https://www.pokewiki.de/images/4/4b/Pokémonsprite_098_XY.gif",
                "Krabby", 30, 105, 90, 25, 25, 50, 
                new ArrayList<>(Arrays.asList("Scherenmacht", "Panzerhaut",
                        "Rohe Gewalt (VF)")), 65, 28, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                99, "https://www.pokewiki.de/images/7/71/Pokémonsprite_099_XY.gif",
                "Kingler", 55, 130, 115, 50, 50, 75, 
                new ArrayList<>(Arrays.asList("Scherenmacht", "Panzerhaut",
                        "Rohe Gewalt (VF)")), 166, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                100, "https://www.pokewiki.de/images/a/ac/Pokémonsprite_100_XY.gif",
                "Voltobal", 40, 30, 50, 55, 55, 100, 
                new ArrayList<>(Arrays.asList("Lärmschutz", "Statik",
                        "Finalschlag (VF)")), 66, 30, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                101, "https://www.pokewiki.de/images/8/8f/Pokémonsprite_101_XY.gif",
                "Lektrobal", 60, 50, 70, 80, 80, 150, 
                new ArrayList<>(Arrays.asList("Lärmschutz", "Statik",
                        "Finalschlag (VF)")), 172, 101, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                102, "https://www.pokewiki.de/images/2/2e/Pokémonsprite_102_XY.gif",
                "Owei", 60, 40, 80, 60, 45, 40, 
                new ArrayList<>(Arrays.asList("Chlorophyll", 
                        "Reiche Ernte (VF)")), 65, 101, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                103, "https://www.pokewiki.de/images/b/bb/Pokémonsprite_103_XY.gif",
                "Kokowei", 95, 95, 85, 125, 75, 55, 
                new ArrayList<>(Arrays.asList("Chlorophyll", 
                        "Reiche Ernte (VF)")), 186, 101, 
                "<html><body>2 SpA</body></html>"));
        
        p.add(new Pokemon(
                104, "https://www.pokewiki.de/images/b/b5/Pokémonsprite_104_XY.gif",
                "Tragosso", 50, 50, 95, 40, 50, 35, 
                new ArrayList<>(Arrays.asList("Steinhaupt", "Blitzfänger",
                        "Kampfpanzer (VF)")), 64, 28, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                105, "https://www.pokewiki.de/images/d/d7/Pokémonsprite_105_XY.gif",
                "Knogga", 60, 80, 110, 50, 80, 45, 
                new ArrayList<>(Arrays.asList("Steinhaupt", "Blitzfänger",
                        "Kampfpanzer (VF)")), 149, 101, 
                "<html><body>2 Def</body></html>"));
        
        p.add(new Pokemon(
                106, "https://www.pokewiki.de/images/9/9f/Pokémonsprite_106_XY.gif",
                "Kicklee", 50, 120, 53, 35, 110, 87, 
                new ArrayList<>(Arrays.asList("Flexibilität", "Achtlos",
                        "Entlastung (VF)")), 159, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                107, "https://www.pokewiki.de/images/e/e6/Pokémonsprite_107_XY.gif",
                "Nockchan", 50, 105, 79, 35, 110, 76, 
                new ArrayList<>(Arrays.asList("Adlerauge", "Eisenfaust",
                        "Konzentrator (VF)")), 159, 101, 
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                108, "https://www.pokewiki.de/images/0/03/Pokémonsprite_108_XY.gif",
                "Schlurp", 90, 55, 75, 60, 75, 30, 
                new ArrayList<>(Arrays.asList("Tempomacher", "Dösigkeit",
                        "Wolke Sieben (VF)")), 77, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                109, "https://www.pokewiki.de/images/1/1c/Pokémonsprite_109_XY.gif",
                "Smogon", 40, 65, 95, 60, 45, 35, 
                new ArrayList<>(Arrays.asList("Schwebe")), 68, 35, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                110, "https://www.pokewiki.de/images/3/3f/Pokémonsprite_110_XY.gif",
                "Smogmog", 65, 90, 120, 85, 70, 60, 
                new ArrayList<>(Arrays.asList("Schwebe")), 172, 101, 
                "<html><body>2 Def</body></html>"));
        
        p.add(new Pokemon(
                111, "https://www.pokewiki.de/images/4/42/Pokémonsprite_111_XY.gif",
                "Rihorn", 80, 85, 95, 30, 30, 25, 
                new ArrayList<>(Arrays.asList("Blitzfänger", "Steinhaupt", "Achtlos (VF)")), 69, 42, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                112, "https://www.pokewiki.de/images/2/22/Pokémonsprite_112_XY.gif",
                "Rizeros", 105, 130, 120, 45, 45, 40, 
                new ArrayList<>(Arrays.asList("Blitzfänger", "Steinhaupt", "Achtlos (VF)")), 170, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                113, "https://www.pokewiki.de/images/7/73/Pokémonsprite_113_XY.gif",
                "Chaneira", 250, 5, 5, 35, 105, 50, 
                new ArrayList<>(Arrays.asList("Innere Kraft", "Edelmut", "Heilherz (VF)")), 395, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                114, "https://www.pokewiki.de/images/5/5a/Pokémonsprite_114_XY.gif",
                "Tangela", 65, 55, 115, 100, 40, 60, 
                new ArrayList<>(Arrays.asList("Chlorophyll", "Floraschild", "Belebekraft (VF)")), 87, 101, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                115, "https://www.pokewiki.de/images/7/7f/Pokémonsprite_115_XY.gif",
                "Kangama", 105, 95, 80, 40, 80, 90, 
                new ArrayList<>(Arrays.asList("Frühwecker", "Rauflust", "Konzentrator (VF)")), 172, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                116, "https://www.pokewiki.de/images/d/d8/Pokémonsprite_116_XY.gif",
                "Seeper", 30, 40, 70, 70, 25, 60, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Superschütze", "Feuchtigkeit (VF)")), 59, 32, 
                "<html><body>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                117, "https://www.pokewiki.de/images/e/e8/Pokémonsprite_117_XY.gif",
                "Seemon", 55, 65, 95, 95, 45, 85, 
                new ArrayList<>(Arrays.asList("Giftdorn", "Superschütze", "Feuchtigkeit (VF)")), 154, 101, 
                "<html><body>1 Def<br>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                118, "https://www.pokewiki.de/images/2/20/Pokémonsprite_118_XY.gif",
                "Goldini", 45, 67, 60, 35, 50, 63, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Aquahülle", "Blitzfänger (VF)")), 64, 33, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                119, "https://www.pokewiki.de/images/3/39/Pokémonsprite_119_XY.gif",
                "Golking", 80, 92, 65, 65, 80, 68, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Aquahülle", "Blitzfänger (VF)")), 158, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                120, "https://www.pokewiki.de/images/7/71/Pokémonsprite_120_XY.gif",
                "Sterndu", 30, 45, 55, 70, 55, 85, 
                new ArrayList<>(Arrays.asList("Erleuchtung", "Innere Kraft", "Analyse (VF)")), 68, 101, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                121, "https://www.pokewiki.de/images/c/cb/Pokémonsprite_121_XY.gif",
                "Starmie", 60, 75, 85, 100, 85, 115, 
                new ArrayList<>(Arrays.asList("Erleuchtung", "Innere Kraft", "Analyse (VF)")), 182, 101, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                122, "https://www.pokewiki.de/images/4/41/Pokémonsprite_122_XY.gif",
                "Pantimos", 40, 45, 65, 100, 120, 90, 
                new ArrayList<>(Arrays.asList("Lärmschutz", "Filter", "Techniker (VF)")), 161, 101, 
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                123, "https://www.pokewiki.de/images/1/19/Pokémonsprite_123_XY.gif",
                "Sichlor", 70, 110, 80, 55, 80, 105, 
                new ArrayList<>(Arrays.asList("Hexaplaga", "Techniker", "Felsenfest (VF)")), 100, 101, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                124, "https://www.pokewiki.de/images/7/7a/Pokémonsprite_124_XY.gif",
                "Rossana", 65, 50, 35, 115, 95, 95, 
                new ArrayList<>(Arrays.asList("Dösigkeit", "Vorwarnung", "Trockenheit (VF)")), 159, 101, 
                "<html><body>2 SpA</body></html>"));
        
        p.add(new Pokemon(
                125, "https://www.pokewiki.de/images/e/e0/Pokémonsprite_125_XY.gif",
                "Elektek", 65, 83, 57, 95, 85, 105, 
                new ArrayList<>(Arrays.asList("Statik", "Munterkeit (VF)")), 172, 101, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                126, "https://www.pokewiki.de/images/d/d0/Pokémonsprite_126_XY.gif",
                "Magmar", 65, 95, 57, 100, 85, 93, 
                new ArrayList<>(Arrays.asList("Flammkörper", "Munterkeit (VF)")), 173, 101, 
                "<html><body>2 SpA</body></html>"));
        
        p.add(new Pokemon(
                127, "https://www.pokewiki.de/images/3/3d/Pokémonsprite_127_XY.gif",
                "Pinsir", 65, 125, 100, 55, 70, 85, 
                new ArrayList<>(Arrays.asList("Scherenmacht", "Überbrückung", "Hochmut (VF)")), 175, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                128, "https://www.pokewiki.de/images/2/21/Pokémonsprite_128_XY.gif",
                "Tauros", 75, 100, 95, 40, 70, 110, 
                new ArrayList<>(Arrays.asList("Bedroher", "Kurzschluss", "Rohe Gewalt (VF)")), 172, 101, 
                "<html><body>1 Atk<br>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                129, "https://www.pokewiki.de/images/e/e6/Pokémonsprite_129_XY.gif",
                "Karpador", 20, 10, 55, 15, 20, 80, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Hasenfuß (VF)")), 40, 20, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                130, "https://www.pokewiki.de/images/8/8f/Pokémonsprite_130_XY.gif",
                "Garados", 95, 125, 79, 60, 100, 81, 
                new ArrayList<>(Arrays.asList("Bedroher", "Hochmut (VF)")), 189, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                131, "https://www.pokewiki.de/images/3/39/Pokémonsprite_131_XY.gif",
                "Lapras", 130, 85, 80, 85, 95, 60, 
                new ArrayList<>(Arrays.asList("H2O-Absorber", "Panzerhaut", "Hydration (VF)")), 187, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                132, "https://www.pokewiki.de/images/a/a3/Pokémonsprite_132_XY.gif",
                "Ditto", 48, 48, 48, 48, 48, 48, 
                new ArrayList<>(Arrays.asList("Flexibilität", "Doppelgänger (VF)")), 101, 101, 
                "<html><body>1 HP</body></html>"));
        
        p.add(new Pokemon(
                133, "https://www.pokewiki.de/images/e/ee/Pokémonsprite_133_XY.gif",
                "Evoli", 55, 55, 50, 45, 65, 55, 
                new ArrayList<>(Arrays.asList("Angsthase", "Anpassung", "Vorahnung (VF)")), 65, 101, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                134, "https://www.pokewiki.de/images/2/25/Pokémonsprite_134_XY.gif",
                "Aquana", 130, 65, 60, 110, 95, 65, 
                new ArrayList<>(Arrays.asList("H2O-Absorber", "Hydration (VF)")), 184, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                135, "https://www.pokewiki.de/images/a/a3/Pokémonsprite_135_XY.gif",
                "Blitza", 65, 65, 60, 110, 95, 130, 
                new ArrayList<>(Arrays.asList("Voltabsorber", "Rasanz (VF)")), 184, 101, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                136, "https://www.pokewiki.de/images/c/c8/Pokémonsprite_136_XY.gif",
                "Flamara", 65, 130, 60, 95, 110, 65, 
                new ArrayList<>(Arrays.asList("Feuerfänger", "Adrenalin (VF)")), 184, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                137, "https://www.pokewiki.de/images/b/b2/Pokémonsprite_137_XY.gif",
                "Porygon", 65, 60, 70, 85, 75, 40, 
                new ArrayList<>(Arrays.asList("Fährte", "Download", "Analyse (VF)")), 79, 101, 
                "<html><body>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                138, "https://www.pokewiki.de/images/7/7c/Pokémonsprite_138_XY.gif",
                "Amonitas", 35, 40, 100, 90, 55, 35, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Panzerhaut", "Bruchrüstung (VF)")), 71, 40, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                139, "https://www.pokewiki.de/images/6/69/Pokémonsprite_139_XY.gif",
                "Amoroso", 70, 60, 125, 115, 70, 55, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Panzerhaut", "Bruchrüstung (VF)")), 173, 101, 
                "<html><body>2 Def</body></html>"));
        
        p.add(new Pokemon(
                140, "https://www.pokewiki.de/images/2/26/Pokémonsprite_140_XY.gif",
                "Kabuto", 30, 80, 90, 55, 45, 55, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Kampfpanzer", "Bruchrüstung (VF)")), 71, 40, 
                "<html><body>1 Def</body></html>"));
        
        p.add(new Pokemon(
                141, "https://www.pokewiki.de/images/6/65/Pokémonsprite_141_XY.gif",
                "Kabutops", 60, 115, 105, 65, 70, 80, 
                new ArrayList<>(Arrays.asList("Wassertempo", "Kampfpanzer", "Bruchrüstung (VF)")), 173, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                142, "https://www.pokewiki.de/images/c/ca/Pokémonsprite_142_XY.gif",
                "Aerodactyl", 80, 105, 65, 60, 75, 130, 
                new ArrayList<>(Arrays.asList("Steinhaupt", "Erzwinger", "Anspannung (VF)")), 180, 101, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                143, "https://www.pokewiki.de/images/6/6a/Pokémonsprite_143_XY.gif",
                "Relaxo", 160, 110, 65, 65, 110, 30, 
                new ArrayList<>(Arrays.asList("Immunität", "Speckschicht", "Völlerei (VF)")), 189, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                144, "https://www.pokewiki.de/images/8/8e/Pokémonsprite_144_XY.gif",
                "Arktos", 90, 85, 100, 95, 125, 85, 
                new ArrayList<>(Arrays.asList("Erzwinger", "Schneemantel (VF)")), 261, 101, 
                "<html><body>3 SpD</body></html>"));
        
        p.add(new Pokemon(
                145, "https://www.pokewiki.de/images/6/61/Pokémonsprite_145_XY.gif",
                "Zapdos", 90, 90, 85, 125, 90, 100, 
                new ArrayList<>(Arrays.asList("Erzwinger", "Statik (VF)", "Blitzfänger (VF)")), 261, 101, 
                "<html><body>3 SpA</body></html>"));
        
        p.add(new Pokemon(
                146, "https://www.pokewiki.de/images/4/41/Pokémonsprite_146_XY.gif",
                "Lavados", 65, 130, 60, 95, 110, 65, 
                new ArrayList<>(Arrays.asList("Erzwinger", "Flammkörper (VF)")), 261, 101, 
                "<html><body>3 SpA</body></html>"));
        
        p.add(new Pokemon(
                147, "https://www.pokewiki.de/images/c/cc/Pokémonsprite_147_XY.gif",
                "Dratini", 41, 64, 45, 50, 50, 50, 
                new ArrayList<>(Arrays.asList("Expidermis", "Notschutz (VF)")), 60, 30, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                148, "https://www.pokewiki.de/images/4/42/Pokémonsprite_148_XY.gif",
                "Dragonir", 61, 84, 65, 70, 70, 70, 
                new ArrayList<>(Arrays.asList("Expidermis", "Notschutz (VF)")), 147, 55, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                149, "https://www.pokewiki.de/images/6/6d/Pokémonsprite_149_XY.gif",
                "Dragoran", 91, 134, 95, 100, 100, 80, 
                new ArrayList<>(Arrays.asList("Kontentrator", "Multischuppe (VF)")), 270, 101, 
                "<html><body>3 Atk</body></html>"));
        
        p.add(new Pokemon(
                150, "https://www.pokewiki.de/images/c/c2/Pokémonsprite_150_XY.gif",
                "Mewtu", 106, 110, 90, 154, 90, 130, 
                new ArrayList<>(Arrays.asList("Feuerfänger", "Adrenalin (VF)")), 306, 101, 
                "<html><body>3 SpA</body></html>"));
        
        p.add(new Pokemon(
                151, "https://www.pokewiki.de/images/9/9c/Pokémonsprite_151_XY.gif",
                "Mew", 100, 100, 100, 100, 100, 100, 
                new ArrayList<>(Arrays.asList("Synchro")), 270, 101, 
                "<html><body>3 HP</body></html>"));
        
        p.add(new Pokemon(
                152, "https://www.pokewiki.de/images/7/73/Pokémonsprite_152_XY.gif",
                "Endivie", 45, 49, 65, 49, 65, 45, 
                new ArrayList<>(Arrays.asList("Notdünger", "Floraschild (VF)")), 64, 16, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                153, "https://www.pokewiki.de/images/f/fc/Pokémonsprite_153_XY.gif",
                "Lorblatt", 60, 62, 80, 63, 80, 60, 
                new ArrayList<>(Arrays.asList("Notdünger", "Floraschild (VF)")), 142, 32, 
                "<html><body>1 Def<br>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                154, "https://www.pokewiki.de/images/c/c2/Pokémonsprite_154_XY.gif",
                "Meganie", 80, 82, 100, 83, 100, 80, 
                new ArrayList<>(Arrays.asList("Notdünger", "Floraschild (VF)")), 236, 101, 
                "<html><body>1 Def<br>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                155, "https://www.pokewiki.de/images/4/43/Pokémonsprite_155_XY.gif",
                "Feurigel", 39, 52, 43, 60, 50, 65, 
                new ArrayList<>(Arrays.asList("Großbrand", "Feuerfänger (VF)")), 62, 14, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                156, "https://www.pokewiki.de/images/3/33/Pokémonsprite_156_XY.gif",
                "Igelavar", 58, 64, 58, 80, 65, 80, 
                new ArrayList<>(Arrays.asList("Großbrand", "Feuerfänger (VF)")), 142, 36, 
                "<html><body>1 SpA<br>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                157, "https://www.pokewiki.de/images/a/a0/Pokémonsprite_157_XY.gif",
                "Tornupto", 78, 84, 78, 109, 85, 100, 
                new ArrayList<>(Arrays.asList("Großbrand", "Feuerfänger (VF)")), 240, 101, 
                "<html><body>3 SpA</body></html>"));
        
        p.add(new Pokemon(
                158, "https://www.pokewiki.de/images/c/c0/Pokémonsprite_158_XY.gif",
                "Karnimani", 50, 65, 64, 44, 48, 43, 
                new ArrayList<>(Arrays.asList("Sturzbach", "Rohe Gewalt (VF)")), 63, 18, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                159, "https://www.pokewiki.de/images/5/59/Pokémonsprite_159_XY.gif",
                "Tyracroc", 65, 80, 80, 59, 63, 58, 
                new ArrayList<>(Arrays.asList("Sturzbach", "Rohe Gewalt (VF)")), 142, 30, 
                "<html><body>1 Atk<br>1 Def</body></html>"));
        
        p.add(new Pokemon(
                160, "https://www.pokewiki.de/images/4/41/Pokémonsprite_160_XY.gif",
                "Impergator", 85, 105, 100, 79, 83, 78, 
                new ArrayList<>(Arrays.asList("Sturzbach", "Rohe Gewalt (VF)")), 239, 101, 
                "<html><body>2 Atk<br>1 Def</body></html>"));
        
        p.add(new Pokemon(
                161, "https://www.pokewiki.de/images/a/a4/Pokémonsprite_161_XY.gif",
                "Wiesor", 35, 46, 34, 35, 45, 20, 
                new ArrayList<>(Arrays.asList("Angsthase", "Adlerauge", "Schnüffler (VF)")), 43, 15, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                162, "https://www.pokewiki.de/images/d/d9/Pokémonsprite_162_XY.gif",
                "Wiesenior", 85, 76, 64, 45, 55, 90, 
                new ArrayList<>(Arrays.asList("Angsthase", "Adlerauge", "Schnüffler (VF)")), 145, 101, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                163, "https://pokewiki.de/images/0/00/Pok%C3%A9monsprite_163_XY.gif",
                "Hoothoot", 60, 30, 30, 36, 56, 50, 
                new ArrayList<>(Arrays.asList("Insomnia", "Adlerauge", "Aufwertung (VF)")), 52, 20, 
                "<html><body>1 KP</body></html>"));
        
        p.add(new Pokemon(
                164, "https://pokewiki.de/images/3/37/Pok%C3%A9monsprite_164_XY.gif",
                "Noctuh", 100, 50, 50, 86, 96, 70, 
                new ArrayList<>(Arrays.asList("Insomnia", "Adlerauge", "Aufwertung (VF)")), 158, 101, 
                "<html><body>2 KP</body></html>"));
        
        p.add(new Pokemon(
                165, "https://pokewiki.de/images/0/02/Pok%C3%A9monsprite_165_XY.gif",
                "Ledyba", 40, 20, 30, 40, 80, 55, 
                new ArrayList<>(Arrays.asList("Hexaplaga", "Frühwecker", "Hasenfuß (VF)")), 53, 18, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                166, "https://pokewiki.de/images/0/06/Pok%C3%A9monsprite_166_XY.gif",
                "Ledian", 55, 35, 50, 55, 110, 85, 
                new ArrayList<>(Arrays.asList("Hexaplaga", "Frühwecker", "Eisenfaust (VF)")), 137, 101, 
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                167, "https://pokewiki.de/images/4/49/Pok%C3%A9monsprite_167_XY.gif",
                "Webarak", 40, 60, 40, 40, 40, 30, 
                new ArrayList<>(Arrays.asList("Insomnia", "Hexaplaga", "Superschütze (VF)")), 50, 22, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                168, "https://pokewiki.de/images/f/f1/Pok%C3%A9monsprite_168_XY.gif",
                "Ariados", 70, 90, 70, 60, 70, 40, 
                new ArrayList<>(Arrays.asList("Insomnia", "Hexaplaga", "Superschütze (VF)")), 140, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                169, "https://pokewiki.de/images/7/78/Pok%C3%A9monsprite_169_XY.gif",
                "Iksbat", 85, 90, 80, 70, 80, 130, 
                new ArrayList<>(Arrays.asList("Konzentrator", "Schwebedurch (VF)")), 241, 101, 
                "<html><body>3 Ini</body></html>"));
        
        p.add(new Pokemon(
                170, "https://pokewiki.de/images/c/c0/Pok%C3%A9monsprite_170_XY.gif",
                "Lampi", 75, 38, 38, 56, 56, 67, 
                new ArrayList<>(Arrays.asList("Voltabsorber", "Erleuchtung", "H2O-Absorber (VF)")), 66, 27, 
                "<html><body>1 HP</body></html>"));
        
        p.add(new Pokemon(
                171, "https://pokewiki.de/images/7/71/Pok%C3%A9monsprite_171_XY.gif",
                "Lanturn", 125, 58, 38, 76, 76, 67, 
                new ArrayList<>(Arrays.asList("Voltabsorber", "Erleuchtung", "H2O-Absorber (VF)")), 161, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                172, "https://pokewiki.de/images/f/f9/Pok%C3%A9monsprite_172_XY.gif",
                "Pichu", 20, 40, 15, 35, 35, 60, 
                new ArrayList<>(Arrays.asList("Statik", "Blitzfänger (VF)")), 41, 101, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                173, "https://pokewiki.de/images/e/e0/Pok%C3%A9monsprite_173_XY.gif",
                "Pii", 50, 25, 28, 45, 55, 15, 
                new ArrayList<>(Arrays.asList("Charmebolzen", "Magieschild", "Freundeshut (VF)")), 44, 101, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                174, "https://pokewiki.de/images/7/7a/Pok%C3%A9monsprite_174_XY.gif",
                "Fluffeluff", 90, 30, 15, 40, 20, 15, 
                new ArrayList<>(Arrays.asList("Charmebolzen", "Unbeugsamkeit", "Freundeshut (VF)")), 42, 101, 
                "<html><body>1 HP</body></html>"));
        
        p.add(new Pokemon(
                175, "https://pokewiki.de/images/7/71/Pok%C3%A9monsprite_175_XY.gif",
                "Togepi", 35, 20, 65, 40, 65, 20, 
                new ArrayList<>(Arrays.asList("Übereifer", "Edelmut", "Glückspilz (VF)")), 49, 101, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                176, "https://pokewiki.de/images/7/71/Pok%C3%A9monsprite_175_XY.gif",
                "Togepi", 35, 20, 65, 40, 65, 20, 
                new ArrayList<>(Arrays.asList("Übereifer", "Edelmut", "Glückspilz (VF)")), 49, 101, 
                "<html><body>1 SpD</body></html>"));
        
        
        
        /**
        **/
        
        
        
        
        
        
        p.add(new Pokemon(
                194, "https://www.pokewiki.de/images/c/c4/Pokémonsprite_194_XY.gif",
                "Felino", 45, 45, 45, 25, 25, 15, 
                new ArrayList<>(Arrays.asList("Feuchtigkeit", 
                        "H2O-Absorber", "Unkenntnis (VF)")), 42, 20,
                "<html><body>1 HP</body></html>"));
        
        p.add(new Pokemon(
                195, "http://www.pokewiki.de/images/1/12/Pokémonsprite_195_XY.gif",
                "Morlord", 95, 85, 85, 65, 65, 35, 
                new ArrayList<>(Arrays.asList("Feuchtigkeit", 
                        "H2O-Absorber", "Unkenntnis (VF)")), 151, 101,
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                196, "https://www.pokewiki.de/images/b/b0/Pokémonsprite_196_XY.gif",
                "Psiana", 65, 65, 60, 130, 95, 110, 
                new ArrayList<>(Arrays.asList("Synchro", "Magiespiegel (VF)")), 
                184, 101, 
                "<html><body>2 SpA</body></html>"));
        
        p.add(new Pokemon(
                197, "http://www.pokewiki.de/images/8/8a/Pokémonsprite_197_XY.gif",
                "Nachtara", 95, 65, 110, 60, 130, 65, 
                new ArrayList<>(Arrays.asList("Synchro", "Konzentrator (VF)")), 
                184, 101, 
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                270, "https://www.pokewiki.de/images/b/bf/Pokémonsprite_270_XY.gif",
                "Loturzel", 40, 30, 30, 40, 50, 30, 
                new ArrayList<>(Arrays.asList("Wassertempo", 
                        "Regengenuss", "Tempomacher (VF)")), 44, 20,
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                271, "https://www.pokewiki.de/images/9/9e/Pokémonsprite_271_XY.gif",
                "Lombrero", 50, 50, 50, 60, 70, 50, 
                new ArrayList<>(Arrays.asList("Wassertempo", 
                        "Regengenuss", "Tempomacher (VF)")), 119, 101,
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                272, "https://www.pokewiki.de/images/7/70/Pokémonsprite_272_XY.gif",
                "Kappalores", 80, 70, 70, 90, 100, 70, 
                new ArrayList<>(Arrays.asList("Wassertempo", 
                        "Regengenuss", "Tempomacher (VF)")), 216, 101,
                "<html><body>3 SpD</body></html>"));
        
        p.add(new Pokemon(
                280, "https://www.pokewiki.de/images/0/0b/Pokémonsprite_280_XY.gif",
                "Trasla", 28, 25, 25, 45, 35, 40, 
                new ArrayList<>(Arrays.asList("Synchro", 
                        "Fährte", "Telepathie (VF)")), 40, 20,
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                281, "https://www.pokewiki.de/images/e/e3/Pokémonsprite_281_XY.gif",
                "Kirlia", 38, 35, 35, 65, 55, 50, 
                new ArrayList<>(Arrays.asList("Synchro", 
                        "Fährte", "Telepathie (VF)")), 97, 30,
                "<html><body>2 SpD</body></html>"));
        
        p.add(new Pokemon(
                282, "https://www.pokewiki.de/images/3/39/Pokémonsprite_282_XY.gif",
                "Guardevoir", 68, 65, 65, 125, 115, 80, 
                new ArrayList<>(Arrays.asList("Synchro", 
                        "Fährte", "Telepathie (VF)")), 223, 101,
                "<html><body>3 SpD</body></html>"));
        
        
        
        p.add(new Pokemon(
                304, "https://www.pokewiki.de/images/7/7e/Pokémonsprite_304_XY.gif",
                "Stollunior", 50, 70, 100, 40, 40, 30, 
                new ArrayList<>(Arrays.asList("Robustheit", 
                        "Steinhaupt", "Schwermetall (VF)")), 66, 101,
                "<html><body>1 Def</body></html>"));
        
        
        
        p.add(new Pokemon(
                352, "https://www.pokewiki.de/images/2/2c/Pokémonsprite_352_XY.gif",
                "Kecleon", 60, 90, 70, 60, 120, 40, 
                new ArrayList<>(Arrays.asList("Farbwechsel",  
                        "Wandlungskunst (VF)")), 154, 101, 
                "<html><body>1 SpD</body></html>"));
        
        p.add(new Pokemon(
                359, "http://www.pokewiki.de/images/0/07/Pokémonsprite_359_XY.gif",
                "Absol", 65, 130, 60, 75, 60, 75, 
                new ArrayList<>(Arrays.asList("Erzwinger", "Glückspilz", 
                        "Redlichkeit (VF)")), 163, 101, 
                "<html><body>2 Atk</body></html>"));
        
        p.add(new Pokemon(
                396, "https://www.pokewiki.de/images/f/f1/Pokémonsprite_396_XY.gif",
                "Staralili", 40, 55, 30, 30, 30, 60, 
                new ArrayList<>(Arrays.asList("Adlerauge", 
                        "Achtlos (VF)")), 49, 14, 
                "<html><body>1 Ini</body></html>"));
        
        p.add(new Pokemon(
                397, "http://www.pokewiki.de/images/d/db/Pokémonsprite_397_XY.gif",
                "Staravia", 55, 75, 50, 40, 40, 80, 
                new ArrayList<>(Arrays.asList("Bedroher", 
                        "Achtlos (VF)")), 119, 34, 
                "<html><body>2 Ini</body></html>"));
        
        p.add(new Pokemon(
                397, "https://www.pokewiki.de/images/7/73/Pokémonsprite_398_XY.gif",
                "Staraptor", 85, 120, 70, 50, 60, 100, 
                new ArrayList<>(Arrays.asList("Bedroher", 
                        "Achtlos (VF)")), 218, 101, 
                "<html><body>3 Atk</body></html>"));
        
        p.add(new Pokemon(
                447, "https://www.pokewiki.de/images/7/7b/Pokémonsprite_447_XY.gif",
                "Riolu", 40, 70, 40, 35, 40, 60, 
                new ArrayList<>(Arrays.asList("Felsenfest", "Konzentrator", "Strolch (VF)")), 57, 101, 
                "<html><body>1 Atk</body></html>"));
        
        p.add(new Pokemon(
                448, "https://www.pokewiki.de/images/d/d9/Pokémonsprite_448_XY.gif",
                "Lucario", 70, 110, 70, 115, 70, 90, 
                new ArrayList<>(Arrays.asList("Felsenfest", "Konzentrator", "Redlichkeit (VF)")), 184, 101, 
                "<html><body>1 Atk<br>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                475, "https://www.pokewiki.de/images/2/23/Pokémonsprite_475_XY.gif",
                "Galagladi", 68, 125, 65, 65, 115, 80, 
                new ArrayList<>(Arrays.asList("Felsenfest", "Redlichkeit (VF)")), 223, 101, 
                "<html><body>3 Atk</body></html>"));
        
        p.add(new Pokemon(
                531, "https://www.pokewiki.de/images/1/1a/Pokémonsprite_531_XY.gif",
                "Ohrdoch", 103, 60, 86, 60, 86, 50, 
                new ArrayList<>(Arrays.asList("Heilherz", "Belebekraft", "Tollpatsch (VF)")), 390, 101, 
                "<html><body>2 HP</body></html>"));
        
        p.add(new Pokemon(
                570, "https://www.pokewiki.de/images/d/da/Pokémonsprite_570_XY.gif",
                "Zorua", 40, 65, 40, 80, 40, 65, 
                new ArrayList<>(Arrays.asList("Trugbild")), 66, 30, 
                "<html><body>1 SpA</body></html>"));
        
        p.add(new Pokemon(
                571, "http://www.pokewiki.de/images/0/0a/Pokémonsprite_571_XY.gif",
                "Zoroark", 60, 105, 60, 120, 60, 105, 
                new ArrayList<>(Arrays.asList("Trugbild")), 179, 30, 
                "<html><body>2 SpA</body></html>"));
        
        p.add(new Pokemon(
                595, "https://www.pokewiki.de/images/5/51/Pokémonsprite_595_XY.gif",
                "Wattzapf", 50, 47, 50, 57, 50, 65, 
                new ArrayList<>(Arrays.asList("Facettenauge", "Anspannung", "Hexaplaga (VF)")), 64, 36, 
                "<html><body>1 Ini</body></html>"));
                    
        p.add(new Pokemon(
                596, "https://www.pokewiki.de/images/1/14/Pokémonsprite_596_XY.gif",
                "Voltula", 50, 47, 50, 57, 50, 65, 
                new ArrayList<>(Arrays.asList("Facettenauge", "Anspannung", "Hexaplaga (VF)")), 165, 101, 
                "<html><body>2 Ini</body></html>"));
                          
        p.add(new Pokemon(
                624, "https://www.pokewiki.de/images/a/a6/Pokémonsprite_624_XY.gif",
                "Gladiantri", 45, 85, 70, 40, 40, 60, 
                new ArrayList<>(Arrays.asList("Siegeswille", "Konzentrator", "Erzwinger (VF)")), 68, 52, 
                "<html><body>1 Atk</body></html>"));
                      
        p.add(new Pokemon(
                633, "http://www.pokewiki.de/images/8/80/Pokémonsprite_633_XY.gif",
                "Kapuno", 52, 65, 50, 45, 50, 38, 
                new ArrayList<>(Arrays.asList("Übereifer")), 60, 50, 
                "<html><body>1 Atk</body></html>"));
        
        
        
        
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

    public String getDex(int index){
        return p.get(index).getDex();
    }
    
    void setList(JComboBox<String> pkmCB) {
        javax.swing.DefaultComboBoxModel<String> mod = 
                new javax.swing.DefaultComboBoxModel<String>();
        for (Pokemon i : p){
            mod.addElement(i.getDexNr()+": "+i.getName());
        }
        pkmCB.setModel(mod);
    }
    
    void setAbilities(JComboBox<String> abilities, int index){
        javax.swing.DefaultComboBoxModel<String> mod = 
                new javax.swing.DefaultComboBoxModel<String>();
        for (String a : p.get(index).getAbilities()){
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
    
    public void calculateStats(int[] EVs, int[] IVs, int level, int index, JLabel[] statAnz, JLabel ev){
        
        Pokemon selected = p.get(index);
        
        double e;
        
        if(level >= p.get(index).getLvlEntw()){
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
            ev.setText("+ "+(int) Math.floor(p.get(index).getBaseXP()*level*e/7)+" Exp.");
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
    
    public String getEV(int index){
        return p.get(index).getEVs();
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
    
    public Pokemon getP(int index){
        return p.get(index);
    }
    
    
    public Pokemon getPokemonbyDexNumber(int dex){
        for (Pokemon poke : p){
            if (poke.getDexNr() == dex)
                return poke;
        }
        
        return null;
    }
    
    
    
    public int[] getStats(){
        return stats;
    }
}
