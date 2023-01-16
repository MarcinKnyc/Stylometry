/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.polsl.stylometry.swingGUI;

import com.polsl.stylometry.model.Analysis;
import com.polsl.stylometry.model.AnalysisBuilder;
import com.polsl.stylometry.model.InvalidTextInputException;
import javax.swing.JOptionPane;

/**
 *
 * @author Student ETO-A 18
 */
public class MainForm extends javax.swing.JFrame {
    
    private String formatAnalysisResults(Analysis analysis){
        String output = "";
        
        for (String result : analysis.GetResults()){
            output = output + "\r\n" + result;
        }
        
        return output;
    }

    /**
     * Upon completing the form, this function is run and analyzes everything about the text.
     * It returns its findings in a Message box window.
     * */
    private void analyzeText(
        String text,
        boolean shouldAnalyzeWordFrequency,
        boolean shouldAnalyzeVocabularyDiversity,
        boolean shouldAnalyzeSentenceLength,
        boolean shouldAnalyzeParagraphLength
    ){ 
        AnalysisBuilder builder = new AnalysisBuilder(text);

        if (shouldAnalyzeWordFrequency)
            builder.AnalyzeWordFrequency();
        if (shouldAnalyzeVocabularyDiversity)
            builder.AnalyzeVocabularyDiversity();
        if (shouldAnalyzeSentenceLength)
            builder.AnalyzeSentenceLength();
        if (shouldAnalyzeParagraphLength)
            builder.AnalyzeParagraphLength();


        try {
            //create model
            Analysis analysis = builder.Build();
            //display results
            String analysisString = formatAnalysisResults(analysis);
            JOptionPane.showMessageDialog(this, analysisString);
        } catch (InvalidTextInputException exception){
            //display error
            JOptionPane.showMessageDialog(this, "An error occured: " + exception.getMessage());
        }       
    }
    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 =  new javax.swing.JTextArea("This is an example sentence. In an example paragraph. Funny word: sesquipedalian.");
        jButton1 = new javax.swing.JButton();
        checkWordFrequency = new javax.swing.JCheckBox();
        checkSentenceLength = new javax.swing.JCheckBox();
        checkParagraphLength = new javax.swing.JCheckBox();
        checkVocabularyDiversity = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Analyze your text without without needing to check for copyright!");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        checkWordFrequency.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        checkWordFrequency.setText("Check word frequency");
        checkWordFrequency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkWordFrequencyActionPerformed(evt);
            }
        });

        checkSentenceLength.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        checkSentenceLength.setText("Check sentence length");

        checkParagraphLength.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        checkParagraphLength.setText("Check paragraph length");
        checkParagraphLength.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkParagraphLengthActionPerformed(evt);
            }
        });

        checkVocabularyDiversity.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        checkVocabularyDiversity.setText("Check vocabulary diversity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1388, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(checkWordFrequency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(checkVocabularyDiversity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(checkSentenceLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(checkParagraphLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkWordFrequency, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkVocabularyDiversity, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkSentenceLength, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkParagraphLength, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        analyzeText(jTextArea1.getText(),
                checkWordFrequency.isSelected(), 
                checkVocabularyDiversity.isSelected(), 
                checkSentenceLength.isSelected(), 
                checkParagraphLength.isSelected()
        );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkWordFrequencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkWordFrequencyActionPerformed
    }//GEN-LAST:event_checkWordFrequencyActionPerformed

    private void checkParagraphLengthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkParagraphLengthActionPerformed
    }//GEN-LAST:event_checkParagraphLengthActionPerformed

    /**
     * @param args the command line arguments are usually empty.
     * This function opens the MainForm window.
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainForm mainForm = new MainForm();
//                mainForm.
                mainForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkParagraphLength;
    private javax.swing.JCheckBox checkSentenceLength;
    private javax.swing.JCheckBox checkVocabularyDiversity;
    private javax.swing.JCheckBox checkWordFrequency;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
