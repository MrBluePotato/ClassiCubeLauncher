package net.classicube.launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PromptScreen extends javax.swing.JDialog {

    public static String show(final Frame parent, final String title, final String message, final String placeholder) {
        PromptScreen screen = new PromptScreen(parent, title, message, placeholder);
        screen.setVisible(true);
        return screen.input;
    }
    private String input;

    private PromptScreen(final Frame parent, final String title, final String message, final String placeholder) {
        // set title, add border
        super(parent, title, true);
        // set background
        final ImagePanel bgPanel = new ImagePanel(null, true);
        bgPanel.setGradient(true);
        bgPanel.setImage(Resources.getClassiCubeBackground());
        bgPanel.setGradientColor(new Color(124, 104, 141));
        bgPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
        setContentPane(bgPanel);

        initComponents();

        this.tInput.setText(placeholder);
        this.tInput.selectAll();

        // print the message
        if (message.startsWith("<html>")) {
            this.lMessage.setText(message);
        } else {
            this.lMessage.setText("<html><b>" + message);
        }

        // focus & highlight [OK]
        getRootPane().setDefaultButton(bOK);

        // Show GridBagLayout who's boss.
        this.imgErrorIcon.setImage(Resources.getInfoIcon());
        this.imgErrorIcon.setMinimumSize(new Dimension(64, 64));
        this.imgErrorIcon.setPreferredSize(new Dimension(64, 64));
        this.imgErrorIcon.setSize(new Dimension(64, 64));

        // Set windows size, pack, and center
        //this.setPreferredSize(new Dimension(400, 150));
        pack();
        setLocationRelativeTo(null);

        tInput.getDocument().addDocumentListener(new TextChangeListener());
    }

    class TextChangeListener implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            onTextChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            onTextChange();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            onTextChange();
        }
    }

    void onTextChange() {
        this.bOK.setEnabled(!tInput.getText().isEmpty());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        imgErrorIcon = new net.classicube.launcher.ImagePanel();
        lMessage = new javax.swing.JLabel();
        bOK = new net.classicube.launcher.JNiceLookingButton();
        bNo = new net.classicube.launcher.JNiceLookingButton();
        tInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        imgErrorIcon.setMaximumSize(new java.awt.Dimension(64, 64));
        imgErrorIcon.setMinimumSize(new java.awt.Dimension(64, 64));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        getContentPane().add(imgErrorIcon, gridBagConstraints);

        lMessage.setForeground(new java.awt.Color(255, 255, 255));
        lMessage.setText("Someone set up us the bomb!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(lMessage, gridBagConstraints);

        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(bOK, gridBagConstraints);

        bNo.setText("Cancel");
        bNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(bNo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        getContentPane().add(tInput, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNoActionPerformed
        dispose();
    }//GEN-LAST:event_bNoActionPerformed

    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        this.input = this.tInput.getText();
        dispose();
    }//GEN-LAST:event_bOKActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.classicube.launcher.JNiceLookingButton bNo;
    private net.classicube.launcher.JNiceLookingButton bOK;
    private net.classicube.launcher.ImagePanel imgErrorIcon;
    private javax.swing.JLabel lMessage;
    private javax.swing.JTextField tInput;
    // End of variables declaration//GEN-END:variables
}