/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.neurologistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NeurologistToNurseFallWorkRequest;
import Business.WorkQueue.VolunteerToNurseCertificationWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.city.City;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author varsha
 */
public class ViewPatientListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientListJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private EcoSystem business;
    private Enterprise enterprise;
    private ArrayList<Patient> riskFallPatientList;
    public ViewPatientListJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, Enterprise enterprise) {
        initComponents();
        riskFallPatientList = new ArrayList<Patient>();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.enterprise = enterprise;
        populatePatientList();
        
        
    }
    
    
    
    public void populatePatientList()
    {
         DefaultTableModel model = (DefaultTableModel)patientJTable.getModel();
        
        model.setRowCount(0);
        for (State state : business.getStateList()) {
               for (City city : state.getCityList()) {
                    for (Enterprise e : city.getEnterprizeDirectory().getEnterprizeList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            // for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                            for (Patient p : o.getPatientDirectory().getPatientList()) {
      
                                if(p.getNeurologist().getName().equalsIgnoreCase(userAccount.getEmployee().getName()))
                                {
                                    Object[] row = new Object[2];
                                    row[0] = p;
                                   
                                    row[1] = p.getRiskofFallScore()== null ? "Not Calculated" : p.getRiskofFallScore();
                                    if(p.getRiskofFallScore() == null)
                                    {
                                        riskFallPatientList.add(p);
                                        
                                    }
                                    if(p.isSadCurrentMood())
                                    { 
                                        p.setRiskFallPriority("High");
                                    
                                    }
                                    else
                                    {
                                         p.setRiskFallPriority("low");
                                    }
                                        
                                        
                                    
                                   // if(p.getRiskofFallScore() == null)
                                   // {
                                    model.addRow(row);
                                }   // }
                            }
                        }
                    }
               }
        }
        
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
        patientJTable = new javax.swing.JTable();
        requestRiskOfFallingScore = new javax.swing.JButton();
        monitorVitalSignsJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("Patient List:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 132, 30));

        patientJTable.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        patientJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Risk of Falling"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientJTable);
        if (patientJTable.getColumnModel().getColumnCount() > 0) {
            patientJTable.getColumnModel().getColumn(0).setResizable(false);
            patientJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 390, 130));

        requestRiskOfFallingScore.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        requestRiskOfFallingScore.setText("Request Risk of Falling Score");
        requestRiskOfFallingScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestRiskOfFallingScoreActionPerformed(evt);
            }
        });
        add(requestRiskOfFallingScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 217, 40));

        monitorVitalSignsJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        monitorVitalSignsJButton.setText("Monitor Vital Signs");
        monitorVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorVitalSignsJButtonActionPerformed(evt);
            }
        });
        add(monitorVitalSignsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 220, 40));

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 91, 29));
    }// </editor-fold>//GEN-END:initComponents

    private void requestRiskOfFallingScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestRiskOfFallingScoreActionPerformed
        // TODO add your handling code here:
        NeurologistToNurseFallWorkRequest request = new NeurologistToNurseFallWorkRequest();
        request.setMessage("Calculate Risk of Falling Score");
        request.setSender(userAccount);
        //request.setReceiver(nuseUserAccount);
        request.setStatus("Sent");
        request.setPatientList(riskFallPatientList);

        Organization org = null;
        //UserAccount userAcct = null;
       // for (State state : system.getStateList()) {
       // for (City city : state.getCityList()) {
      //  for (Enterprise enterprise : city.getEnterprizeDirectory().getEnterprizeList()) {
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof NurseOrganization){
                
                       
                        org = organization;
                        break;    
                    }
                }
                         
            
        
        
        if (org!=null){
           org.getWorkQueue().getWorkRequestList().add(request);
            //userAcct.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null,"Request successfully submitted", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
         
         
        //code to send message via email
    }//GEN-LAST:event_requestRiskOfFallingScoreActionPerformed

    private void monitorVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
        int i = patientJTable.getSelectedRow();
        if(i < 0)
        {
            JOptionPane.showMessageDialog(null,"Please select a row!!");
            return;
        }
        Patient p = (Patient)patientJTable.getValueAt(i, 0);
        MonitorVitalSignJPanel mvsjp = new MonitorVitalSignJPanel(userProcessContainer, userAccount, business, p);
        userProcessContainer.add("MonitorVitalSignJPanel",mvsjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_monitorVitalSignsJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton monitorVitalSignsJButton;
    private javax.swing.JTable patientJTable;
    private javax.swing.JButton requestRiskOfFallingScore;
    // End of variables declaration//GEN-END:variables
}
