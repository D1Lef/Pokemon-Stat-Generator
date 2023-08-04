/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Felix
 */
public class PartyLevelManager extends javax.swing.JFrame {

    
    ArrayList<PartyMember> members;
    Model m;
    JLabel[] anz;
    
    /**
     * Creates new form PartyLevelManager
     */
    public PartyLevelManager() {
        
        m = new Model();
        members = new ArrayList<>();
        
        int [] igelavar = {14,27,30,24,15,29};
        double [] igelavarNAT = {0.9,1,1.1,1,1};
        members.add(new PartyMember(m.getPokemonbyDexNumber(156), "Daniel: Igelavar", igelavar,igelavarNAT));
        
        int [] zorua = {22,1,31,29,3,18};
        double [] zoruaNAT = {1,1,1,0.9,1.1};
        members.add(new PartyMember(m.getPokemonbyDexNumber(570), "Saskia: Zorua", zorua,zoruaNAT));
        
        int [] trasla = {9,26,7,28,24,20};
        double [] traslaNAT = {1,1,1,1,1};
        members.add(new PartyMember(m.getPokemonbyDexNumber(281), "Teo: Kirlia", trasla, traslaNAT));
        
        int[] stollunior = {22,22,2,8,25,9};
        double [] stolluniorNAT = {1,1.1,1,1,0.9};
        members.add(new PartyMember(m.getPokemonbyDexNumber(304), "Tristan: Stollunior", stollunior, stolluniorNAT));
        
        int[] evoli = {23,20,23,30,11,14};
        double [] evoliNAT = {1,0.9,1,1,1.1};
        members.add(new PartyMember(m.getPokemonbyDexNumber(133), "NPC: Evoli", evoli, evoliNAT));
        
        
        initComponents();
        
        for (PartyMember p : members){
            memberList.addItem(p.nickname);
        }
        
        JLabel[] zwi = {hpStat,atkStat,defStat,spaStat,spdStat,iniStat};
        anz = zwi;
        
        for (JLabel a : anz){
            a.setText("");
        }
        m.loadPokemon(members.get(memberList.getSelectedIndex()));
        m.getImage(gif);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberList = new javax.swing.JComboBox<>();
        hp = new javax.swing.JLabel();
        atk = new javax.swing.JLabel();
        def = new javax.swing.JLabel();
        spa = new javax.swing.JLabel();
        spd = new javax.swing.JLabel();
        ini = new javax.swing.JLabel();
        evs = new javax.swing.JLabel();
        lv = new javax.swing.JLabel();
        hpStat = new javax.swing.JLabel();
        atkStat = new javax.swing.JLabel();
        defStat = new javax.swing.JLabel();
        spaStat = new javax.swing.JLabel();
        spdStat = new javax.swing.JLabel();
        iniStat = new javax.swing.JLabel();
        stat = new javax.swing.JLabel();
        GenerateBTN = new javax.swing.JButton();
        gif = new javax.swing.JLabel();
        levelSpinner = new javax.swing.JSpinner();
        iniEV = new javax.swing.JSpinner();
        spdEV = new javax.swing.JSpinner();
        spaEV = new javax.swing.JSpinner();
        defEV = new javax.swing.JSpinner();
        atkEV = new javax.swing.JSpinner();
        hpEV = new javax.swing.JSpinner();

        setTitle("Party Manager");
        setResizable(false);

        memberList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chengedSelectedPokemon(evt);
            }
        });

        hp.setText("HP");

        atk.setText("Atk:");

        def.setText("Def:");

        spa.setText("SpAtk:");

        spd.setText("SpDef:");

        ini.setText("Speed:");

        evs.setText("EVs");

        lv.setText("Level:");

        hpStat.setText("Stat HP");

        atkStat.setText("Stat Atk");

        defStat.setText("Stat Def");

        spaStat.setText("Stat SpA");

        spdStat.setText("Stat SpD");

        iniStat.setText("Stat Speed");

        stat.setText("Stat");

        GenerateBTN.setText("Generate");
        GenerateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBTNPressed(evt);
            }
        });

        gif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gif.setBorder(javax.swing.BorderFactory.createTitledBorder("Icon"));
        gif.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        levelSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        iniEV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        spdEV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        spaEV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        defEV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        atkEV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));
        atkEV.setToolTipText("");

        hpEV.setModel(new javax.swing.SpinnerNumberModel(0, 0, 255, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hp)
                                    .addComponent(atk)
                                    .addComponent(def)
                                    .addComponent(lv))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atkEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(defEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hpEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(evs)
                                    .addComponent(levelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ini)
                                    .addComponent(spd)
                                    .addComponent(spa))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spaEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spdEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iniEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iniStat)
                            .addComponent(stat)
                            .addComponent(hpStat)
                            .addComponent(atkStat)
                            .addComponent(defStat)
                            .addComponent(spaStat)
                            .addComponent(spdStat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(GenerateBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(memberList, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gif, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gif, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(memberList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(levelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(evs)
                            .addComponent(stat))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hp)
                    .addComponent(hpEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hpStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atk)
                    .addComponent(atkStat)
                    .addComponent(atkEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(def)
                    .addComponent(defStat)
                    .addComponent(defEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spa)
                    .addComponent(spaStat)
                    .addComponent(spaEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spd)
                    .addComponent(spdStat)
                    .addComponent(spdEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ini)
                    .addComponent(GenerateBTN)
                    .addComponent(iniStat)
                    .addComponent(iniEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        hpStat.getAccessibleContext().setAccessibleName("hpStat");
        atkStat.getAccessibleContext().setAccessibleName("atkStat");
        defStat.getAccessibleContext().setAccessibleName("defStat");
        spaStat.getAccessibleContext().setAccessibleName("spaStat");
        spdStat.getAccessibleContext().setAccessibleName("spdStat");
        iniStat.getAccessibleContext().setAccessibleName("iniStat");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateBTNPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBTNPressed
        PartyMember pm = members.get(memberList.getSelectedIndex());
        int[] EVs = {(int) (hpEV.getValue()), (int) (atkEV.getValue()),
            (int) (defEV.getValue()), (int) (spaEV.getValue()),
            (int) (spdEV.getValue()), (int) (int) (iniEV.getValue())};
        
        m.calculateStats(pm, EVs, pm.IVs, (int) levelSpinner.getValue(), anz, pm.natMUL);
    }//GEN-LAST:event_GenerateBTNPressed

    private void chengedSelectedPokemon(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chengedSelectedPokemon
        m.loadPokemon(members.get(memberList.getSelectedIndex()));
        m.getImage(gif);
    }//GEN-LAST:event_chengedSelectedPokemon

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerateBTN;
    private javax.swing.JLabel atk;
    private javax.swing.JSpinner atkEV;
    private javax.swing.JLabel atkStat;
    private javax.swing.JLabel def;
    private javax.swing.JSpinner defEV;
    private javax.swing.JLabel defStat;
    private javax.swing.JLabel evs;
    private javax.swing.JLabel gif;
    private javax.swing.JLabel hp;
    private javax.swing.JSpinner hpEV;
    private javax.swing.JLabel hpStat;
    private javax.swing.JLabel ini;
    private javax.swing.JSpinner iniEV;
    private javax.swing.JLabel iniStat;
    private javax.swing.JSpinner levelSpinner;
    private javax.swing.JLabel lv;
    private javax.swing.JComboBox<String> memberList;
    private javax.swing.JLabel spa;
    private javax.swing.JSpinner spaEV;
    private javax.swing.JLabel spaStat;
    private javax.swing.JLabel spd;
    private javax.swing.JSpinner spdEV;
    private javax.swing.JLabel spdStat;
    private javax.swing.JLabel stat;
    // End of variables declaration//GEN-END:variables
}
