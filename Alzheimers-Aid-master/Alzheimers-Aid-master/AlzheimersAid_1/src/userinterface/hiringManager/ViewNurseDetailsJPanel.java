/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.hiringManager;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Nurse.Nurse;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ChiefNurseToVolunteer;
import Business.city.City;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author varsha
 */
public class ViewNurseDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewNurseDetailsJPanel
     */
    private JPanel userProcessContainer;
    private Nurse nurse;
    private UserAccount account;
    private EcoSystem business;
    public ViewNurseDetailsJPanel(JPanel userProcessContainer, Nurse nurse, UserAccount account, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.nurse = nurse;
        this.account = account;
        this.business = business;
        populateDetails();
    }

    public void populateDetails()
    {
        nurseNameJTextField.setText(nurse.getNurseName());
        expJTextField.setText(String.valueOf(nurse.getNoOfYearsExp()));
        pastWorkExpJTextField.setText(nurse.getPastExp());
        qualificationJTextArea.setText(nurse.getEduQuaifications());
        contactJTextField.setText(nurse.getContact());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nurseNameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        qualificationJTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        contactJTextField = new javax.swing.JTextField();
        shortlistJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        expJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pastWorkExpJTextField = new javax.swing.JTextArea();

        jLabel4.setText("jLabel4");

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("Details:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 107, 30));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel2.setText("Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 163, 26));

        nurseNameJTextField.setEnabled(false);
        add(nurseNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 66, 166, 26));

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel3.setText("No.of Years of Experience:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 190, 31));

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel5.setText("Educational Qualifications:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, 26));

        qualificationJTextArea.setColumns(20);
        qualificationJTextArea.setRows(5);
        qualificationJTextArea.setEnabled(false);
        jScrollPane2.setViewportView(qualificationJTextArea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 291, -1, -1));

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setText("Contact: ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 163, 34));

        contactJTextField.setEnabled(false);
        add(contactJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 417, 166, 34));

        shortlistJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        shortlistJButton.setText("Shortlist");
        shortlistJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortlistJButtonActionPerformed(evt);
            }
        });
        add(shortlistJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 469, 162, 39));

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 95, 31));

        expJTextField.setEnabled(false);
        add(expJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 110, 166, 31));

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel7.setText("Past Work Experience:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 162, 33));

        pastWorkExpJTextField.setColumns(20);
        pastWorkExpJTextField.setRows(5);
        pastWorkExpJTextField.setEnabled(false);
        jScrollPane1.setViewportView(pastWorkExpJTextField);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 159, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void shortlistJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortlistJButtonActionPerformed
        // TODO add your handling code here:
        //send messasge to assoiation person 
        String message= "Nurse to be recruited.";
        ChiefNurseToVolunteer request = new ChiefNurseToVolunteer();
        request.setMessage(message);
        request.setSender(account);
        request.setStatus("Sent");
        Organization o = null;
        for(State state : business.getStateList())
        {
            for(City city : state.getCityList())
            {
                for(Enterprise e : city.getEnterprizeDirectory().getEnterprizeList())
                {
                    for(Organization org : e.getOrganizationDirectory().getOrganizationList())
                    {
                        if (org instanceof VolunteerOrganization) {
                                o = org;
                                break;
                            
                        }
                    }
                        
                }
            }
        }
        if (o!=null){
            o.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
    }//GEN-LAST:event_shortlistJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField contactJTextField;
    private javax.swing.JTextField expJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nurseNameJTextField;
    private javax.swing.JTextArea pastWorkExpJTextField;
    private javax.swing.JTextArea qualificationJTextArea;
    private javax.swing.JButton shortlistJButton;
    // End of variables declaration//GEN-END:variables
}
