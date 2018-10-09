/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.stat.generator;

import java.util.ArrayList;
import java.util.Arrays;
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
        members = new ArrayList<PartyMember>();
        
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
        hpEV = new javax.swing.JTextField();
        hp = new javax.swing.JLabel();
        atk = new javax.swing.JLabel();
        atkEV = new javax.swing.JTextField();
        def = new javax.swing.JLabel();
        defEV = new javax.swing.JTextField();
        spa = new javax.swing.JLabel();
        spaEV = new javax.swing.JTextField();
        spd = new javax.swing.JLabel();
        spdEV = new javax.swing.JTextField();
        ini = new javax.swing.JLabel();
        iniEV = new javax.swing.JTextField();
        evs = new javax.swing.JLabel();
        lvSlider = new javax.swing.JSlider();
        lvLabel = new javax.swing.JLabel();
        lv = new javax.swing.JLabel();
        hpStat = new javax.swing.JLabel();
        atkStat = new javax.swing.JLabel();
        defStat = new javax.swing.JLabel();
        spaStat = new javax.swing.JLabel();
        spdStat = new javax.swing.JLabel();
        iniStat = new javax.swing.JLabel();
        stat = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hpEV.setText("0");

        hp.setText("KP");

        atk.setText("ATK");

        atkEV.setText("0");

        def.setText("DEF");

        defEV.setText("0");

        spa.setText("SP. ATK");

        spaEV.setText("0");

        spd.setText("SP. DEF");

        spdEV.setText("0");

        ini.setText("INIT");

        iniEV.setText("0");

        evs.setText("EVs");

        lvSlider.setMinimum(1);
        lvSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lvSliderStateChanged(evt);
            }
        });

        lvLabel.setText(lvSlider.getValue()+"");

        lv.setText("Level");

        stat.setText("Stat");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lvSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lvLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addComponent(def)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(defEV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(ini)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(iniEV))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(spd)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spdEV))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(spa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spaEV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atk, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(hp)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(evs)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(hpEV)
                                        .addComponent(atkEV, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(iniStat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hpStat)
                                    .addComponent(atkStat)
                                    .addComponent(defStat)
                                    .addComponent(spaStat)
                                    .addComponent(spdStat)
                                    .addComponent(stat))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(memberList, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(memberList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lv)
                    .addComponent(lvSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lvLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(evs)
                    .addComponent(stat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hpEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hp)
                    .addComponent(hpStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atkEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atk)
                    .addComponent(atkStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(defEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(def)
                    .addComponent(defStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spaEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spa)
                    .addComponent(spaStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spdEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spd)
                    .addComponent(spdStat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iniEV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ini)
                    .addComponent(iniStat)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        hpStat.getAccessibleContext().setAccessibleName("hpStat");
        atkStat.getAccessibleContext().setAccessibleName("atkStat");
        defStat.getAccessibleContext().setAccessibleName("defStat");
        spaStat.getAccessibleContext().setAccessibleName("spaStat");
        spdStat.getAccessibleContext().setAccessibleName("spdStat");
        iniStat.getAccessibleContext().setAccessibleName("iniStat");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lvSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lvSliderStateChanged
        lvLabel.setText(lvSlider.getValue()+"");
    }//GEN-LAST:event_lvSliderStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PartyMember pm = members.get(memberList.getSelectedIndex());
        int[] evs = {Integer.parseInt(hpEV.getText()),Integer.parseInt(atkEV.getText()),
            Integer.parseInt(defEV.getText()),Integer.parseInt(spaEV.getText()),
            Integer.parseInt(spdEV.getText()),Integer.parseInt(iniEV.getText())};
        
        
        m.calculateStats(pm, evs, pm.IVs, lvSlider.getValue(), pm.getDexNr(), anz, pm.natMUL);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PartyLevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartyLevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartyLevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartyLevelManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartyLevelManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atk;
    private javax.swing.JTextField atkEV;
    private javax.swing.JLabel atkStat;
    private javax.swing.JLabel def;
    private javax.swing.JTextField defEV;
    private javax.swing.JLabel defStat;
    private javax.swing.JLabel evs;
    private javax.swing.JLabel hp;
    private javax.swing.JTextField hpEV;
    private javax.swing.JLabel hpStat;
    private javax.swing.JLabel ini;
    private javax.swing.JTextField iniEV;
    private javax.swing.JLabel iniStat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lv;
    private javax.swing.JLabel lvLabel;
    private javax.swing.JSlider lvSlider;
    private javax.swing.JComboBox<String> memberList;
    private javax.swing.JLabel spa;
    private javax.swing.JTextField spaEV;
    private javax.swing.JLabel spaStat;
    private javax.swing.JLabel spd;
    private javax.swing.JTextField spdEV;
    private javax.swing.JLabel spdStat;
    private javax.swing.JLabel stat;
    // End of variables declaration//GEN-END:variables
}
