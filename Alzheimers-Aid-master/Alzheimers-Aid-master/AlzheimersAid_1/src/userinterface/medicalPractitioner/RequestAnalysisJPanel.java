/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.medicalPractitioner;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ResearchAnalysisWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import Business.Organization.ResearcherOrganization;
import javax.swing.JOptionPane;
/**
 *
 * @author Nirali Merchant
 */
public class RequestAnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestAnalysisJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;

    RequestAnalysisJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
       // valueLabel.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitRequestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        criteriaComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitRequestJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        submitRequestJButton.setText("Submit");
        submitRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitRequestJButtonActionPerformed(evt);
            }
        });
        add(submitRequestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 215, 120, 39));

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("Criteria :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 153, 98, 32));

        backJButton1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton1.setText("<< Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 22, -1, 32));

        criteriaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mood", " " }));
        add(criteriaComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 153, 130, 32));
    }// </editor-fold>//GEN-END:initComponents

    private void submitRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitRequestJButtonActionPerformed

      //  String message = messageJTextField.getText();
      String criteria = (String)criteriaComboBox.getSelectedItem();
      

        ResearchAnalysisWorkRequest request = new ResearchAnalysisWorkRequest();
        request.setMessage(criteria + " research");
        request.setSender(userAccount);
        request.setCriteria(criteria);
        
        
        request.setStatus("Sent");

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ResearcherOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null,"Request successfully submitted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_submitRequestJButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JComboBox<String> criteriaComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton submitRequestJButton;
    // End of variables declaration//GEN-END:variables
}
