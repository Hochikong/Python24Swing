/*
 * Copyright 2020 Hochikong
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.hochikong.ktmeta.swingui.codegen;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import javax.swing.DefaultListModel;
import java.awt.Image;

/**
 *
 * @author ckhoi
 */
public class impMetaAdvanceSearch extends javax.swing.JFrame {

    /**
     * Creates new form MetaAdvanceSearch
     */
    public impMetaAdvanceSearch() {
        this.rulesModel.addElement(java.util.ResourceBundle.getBundle("i18n/Frames/MetaAdvanceSearch_trans").getString("NO RULES"));
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public impMetaAdvanceSearch(String[] MetaLibs, String[] MetaAttrs, String[] SearchCond, String[] RuleConn, Image icon) {
        this.rulesModel.addElement(java.util.ResourceBundle.getBundle("i18n/Frames/MetaAdvanceSearch_trans").getString("NO RULES"));
        this.metaLibs = MetaLibs;
        this.metaAttributes = MetaAttrs;
        this.searchConditions = SearchCond;
        this.ruleConnectors = RuleConn;
        initComponents();
        this.setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupOnWhere = new javax.swing.ButtonGroup();
        LabelTarget = new javax.swing.JLabel();
        ComboBoxTargetMetaLib = new javax.swing.JComboBox<>();
        CheckBoxSearchOnDB = new javax.swing.JCheckBox();
        CheckBoxCreateNewTab = new javax.swing.JCheckBox();
        CheckBoxSearchOnES = new javax.swing.JCheckBox();
        PanelRulesEditor = new javax.swing.JPanel();
        LabelAttribute = new javax.swing.JLabel();
        ComboBoxAttribute = new javax.swing.JComboBox<>();
        BTNAddRule = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BTNRemoveRule = new javax.swing.JButton();
        BTNResetRules = new javax.swing.JButton();
        ComboBoxMatchConditions = new javax.swing.JComboBox<>();
        TextFieldSearchInput = new javax.swing.JTextField();
        LabelThen = new javax.swing.JLabel();
        ComboBoxRulesConnector = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListRulesDisplay = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("i18n/Frames/MetaAdvanceSearch_trans"); // NOI18N
        setTitle(bundle.getString("ADVANCE SEARCH")); // NOI18N

        LabelTarget.setText(bundle.getString("TARGET METADATA LIBRARY : ")); // NOI18N

        ComboBoxTargetMetaLib.setModel(new javax.swing.DefaultComboBoxModel<>(this.metaLibs));
        ComboBoxTargetMetaLib.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxTargetMetaLibItemStateChanged(evt);
            }
        });

        buttonGroupOnWhere.add(CheckBoxSearchOnDB);
        CheckBoxSearchOnDB.setText(bundle.getString("ON DATABASE")); // NOI18N

        CheckBoxCreateNewTab.setText(bundle.getString("CREATE NEW TAB")); // NOI18N

        buttonGroupOnWhere.add(CheckBoxSearchOnES);
        CheckBoxSearchOnES.setText(bundle.getString("ON ELASTICSEARCH")); // NOI18N

        PanelRulesEditor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rules Editor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei UI", 0, 14), new java.awt.Color(74, 136, 199))); // NOI18N

        LabelAttribute.setText(bundle.getString("ATTRIBUTE : ")); // NOI18N

        ComboBoxAttribute.setModel(new javax.swing.DefaultComboBoxModel<>(this.metaAttributes));

        BTNAddRule.setText(bundle.getString("ADD")); // NOI18N
        BTNAddRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAddRuleActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("ADD RULES TO MAKE SEARCHING MORE PRECISELY ")); // NOI18N

        BTNRemoveRule.setText(bundle.getString("REMOVE")); // NOI18N
        BTNRemoveRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRemoveRuleActionPerformed(evt);
            }
        });

        BTNResetRules.setText(bundle.getString("RESET")); // NOI18N
        BTNResetRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNResetRulesActionPerformed(evt);
            }
        });

        ComboBoxMatchConditions.setModel(new javax.swing.DefaultComboBoxModel<>(this.searchConditions));

        LabelThen.setText(bundle.getString("THEN : ")); // NOI18N

        ComboBoxRulesConnector.setModel(new javax.swing.DefaultComboBoxModel<>(this.ruleConnectors));

        javax.swing.GroupLayout PanelRulesEditorLayout = new javax.swing.GroupLayout(PanelRulesEditor);
        PanelRulesEditor.setLayout(PanelRulesEditorLayout);
        PanelRulesEditorLayout.setHorizontalGroup(
            PanelRulesEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRulesEditorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelRulesEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRulesEditorLayout.createSequentialGroup()
                        .addComponent(LabelAttribute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxMatchConditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextFieldSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(LabelThen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxRulesConnector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(PanelRulesEditorLayout.createSequentialGroup()
                        .addGroup(PanelRulesEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRulesEditorLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRulesEditorLayout.createSequentialGroup()
                                .addComponent(BTNResetRules)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BTNAddRule)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNRemoveRule)
                        .addGap(18, 18, 18))))
        );
        PanelRulesEditorLayout.setVerticalGroup(
            PanelRulesEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRulesEditorLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelRulesEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAttribute)
                    .addComponent(ComboBoxAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxMatchConditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelThen)
                    .addComponent(ComboBoxRulesConnector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(PanelRulesEditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNAddRule)
                    .addComponent(BTNRemoveRule)
                    .addComponent(BTNResetRules))
                .addContainerGap())
        );

        ListRulesDisplay.setModel(this.rulesModel);
        jScrollPane1.setViewportView(ListRulesDisplay);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CheckBoxSearchOnES)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTarget)
                            .addComponent(CheckBoxSearchOnDB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckBoxCreateNewTab)
                            .addComponent(ComboBoxTargetMetaLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PanelRulesEditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTarget)
                    .addComponent(ComboBoxTargetMetaLib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBoxSearchOnDB)
                    .addComponent(CheckBoxCreateNewTab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBoxSearchOnES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRulesEditor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<Auto-Generate>
    private void ComboBoxTargetMetaLibItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxTargetMetaLibItemStateChanged
        impComboBoxTargetMetaLibItemStateChanged(evt);
    }//GEN-LAST:event_ComboBoxTargetMetaLibItemStateChanged

    private void BTNResetRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNResetRulesActionPerformed
        impBTNResetRulesActionPerformed(evt);
    }//GEN-LAST:event_BTNResetRulesActionPerformed

    private void BTNAddRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAddRuleActionPerformed
        impBTNAddRuleActionPerformed(evt);
    }//GEN-LAST:event_BTNAddRuleActionPerformed

    private void BTNRemoveRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRemoveRuleActionPerformed
        impBTNRemoveRuleActionPerformed(evt);
    }//GEN-LAST:event_BTNRemoveRuleActionPerformed
    //</Auto-Generate>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatSolarizedLightIJTheme.install();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new impMetaAdvanceSearch().setVisible(true);
            }
        });
    }
    
    //<My-Custom>
    protected DefaultListModel<String> rulesModel = new DefaultListModel();
    
    protected String[] metaLibs = new String[] {"Lib 1", "Lib 2"};
    protected String[] metaAttributes = new String[] { "Attr 1", "Attr 2", "Attr 3", "Attr 4" };
    protected String[] searchConditions = new String[] {"LIKE", "Equals"};
    protected String[] ruleConnectors = new String[] {"And", "Or"};
    //</My-Custom>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton BTNAddRule;
    private javax.swing.JButton BTNRemoveRule;
    protected javax.swing.JButton BTNResetRules;
    protected javax.swing.JCheckBox CheckBoxCreateNewTab;
    protected javax.swing.JCheckBox CheckBoxSearchOnDB;
    protected javax.swing.JCheckBox CheckBoxSearchOnES;
    protected javax.swing.JComboBox<String> ComboBoxAttribute;
    protected javax.swing.JComboBox<String> ComboBoxMatchConditions;
    protected javax.swing.JComboBox<String> ComboBoxRulesConnector;
    protected javax.swing.JComboBox<String> ComboBoxTargetMetaLib;
    private javax.swing.JLabel LabelAttribute;
    private javax.swing.JLabel LabelTarget;
    private javax.swing.JLabel LabelThen;
    protected javax.swing.JList<String> ListRulesDisplay;
    protected javax.swing.JPanel PanelRulesEditor;
    protected javax.swing.JTextField TextFieldSearchInput;
    protected javax.swing.ButtonGroup buttonGroupOnWhere;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    //<Auto-Generate-Result>
    protected void impComboBoxTargetMetaLibItemStateChanged(java.awt.event.ItemEvent evt){}
    protected void impBTNResetRulesActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impBTNAddRuleActionPerformed(java.awt.event.ActionEvent evt){}
    protected void impBTNRemoveRuleActionPerformed(java.awt.event.ActionEvent evt){}
    //</Auto-Generate-Result>
}
