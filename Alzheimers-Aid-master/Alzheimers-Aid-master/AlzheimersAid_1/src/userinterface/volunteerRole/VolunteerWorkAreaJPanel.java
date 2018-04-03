/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.volunteerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Nurse.Nurse;
import Business.Nurse.NurseList;
import Business.Organization.CareGiverOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.Nurse;
import Business.Organization.VolunteerOrganization;
import Business.Patient.Patient;
import Business.Role.Role;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ChiefNurseToVolunteer;
import Business.WorkQueue.VolunteerMedicalPracWorkRequest;
import Business.WorkQueue.VolunteerToNurseCertificationWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.city.City;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.hiringManager.RecruitNursesJPanel;

/**
 *
 * @author Nirali Merchant
 */
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VolunteerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private VolunteerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private NurseList nurseList;
    
    public VolunteerWorkAreaJPanel(JPanel userProcessContainer,UserAccount account,VolunteerOrganization organization,Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        nurseList = new NurseList();
        volunteerNameJLabel.setText(account.getEmployee().getName());
        populateRequestTable();
        populateActivePatients();
    }
    
    
     public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        //String username = userAccount.getUsername();
        model.setRowCount(0);
         Object[] row = new Object[5];
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
         //   Object[] row = new Object[4];
         
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getSender();
            row[3] = request.getStatus();
            
            if(request instanceof VolunteerMedicalPracWorkRequest) 
            {
                String result = ((VolunteerMedicalPracWorkRequest) request).getTestResult();
                row[4] = result;
                
            }
            if (request instanceof VolunteerToNurseCertificationWorkRequest)
            {
                String result = ((VolunteerToNurseCertificationWorkRequest) request).getTestResult();
                row[4] = result;
            }
            //if (request.getReceiver().getRole().toString().equalsIgnoreCase("Nurse Role"))
          //          {
           //             String result = ((VolunteerToNurseCertificationWorkRequest) request).getTestResult();
             //           row[4] = result;
      //      row[4] = result == null ? "Waiting" : result;
      model.addRow(row);
       }
     //       String result = ((ResearchAnalysisWorkRequest) request).getTestResult();
      //      row[4] = result == null ? "Waiting" : result;
            
            
         
       
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList())
        {
            row = new Object[5];
            row[0] = request;
            //row[1] = request.getReceiver();
            row[1] = "test";
            row[2] = request.getSender();
            row[3] = request.getStatus();
            String result = ((ChiefNurseToVolunteer) request).getTestResult();
            row[4] = result == null ? "In Process" : result;
             model.addRow(row);
        }
     }
     


     public void populateActivePatients()
     {
         activePatientsJComboBox.removeAllItems();
        for (State state : business.getStateList()) {
               for (City city : state.getCityList()) {
                    for (Enterprise e : city.getEnterprizeDirectory().getEnterprizeList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            // for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                            for (Patient p : o.getPatientDirectory().getPatientList()) {
                              if(p.isHighAlzhiemers())
                               {
                                    activePatientsJComboBox.addItem(p.getName());
                               }
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

        registerActivePatientsJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        volunteerNameJLabel = new javax.swing.JLabel();
        performSurveyJButton = new javax.swing.JButton();
        activePatientsJComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestNurseCertificationJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        newNurseJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerActivePatientsJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        registerActivePatientsJButton.setText("Register Active Patients");
        registerActivePatientsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActivePatientsJButtonActionPerformed(evt);
            }
        });
        add(registerActivePatientsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 255, 206, 32));

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("Welcome");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 11, 77, 28));

        volunteerNameJLabel.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        add(volunteerNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 11, 397, 28));

        performSurveyJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        performSurveyJButton.setText("Perform Survey");
        performSurveyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performSurveyJButtonActionPerformed(evt);
            }
        });
        add(performSurveyJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 363, 206, 43));

        activePatientsJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        activePatientsJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activePatientsJComboBoxActionPerformed(evt);
            }
        });
        add(activePatientsJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 255, 256, 32));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Receiver", "Sender", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 67, 443, 125));

        requestNurseCertificationJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        requestNurseCertificationJButton.setText("Send Request for Nurse Certification");
        requestNurseCertificationJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestNurseCertificationJButtonActionPerformed(evt);
            }
        });
        add(requestNurseCertificationJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 305, -1, 40));

        jButton2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jButton2.setText("Send Nurse Info");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 306, 209, 38));

        newNurseJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        newNurseJButton.setText("Register New Nurses");
        newNurseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNurseJButtonActionPerformed(evt);
            }
        });
        add(newNurseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 363, 253, 43));

        jButton1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 90, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void registerActivePatientsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActivePatientsJButtonActionPerformed
        // TODO add your handling code here:
      String patientName = (String)activePatientsJComboBox.getSelectedItem();
        RegisterActivePatientsJPanel rapjp = new RegisterActivePatientsJPanel(userProcessContainer, patientName, organization);
        userProcessContainer.add("RegisterActivePatientsJPanel",rapjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_registerActivePatientsJButtonActionPerformed

    private void performSurveyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performSurveyJButtonActionPerformed
        // TODO add your handling code here:
        PerformSurveyJPanel psjp = new PerformSurveyJPanel(userProcessContainer, userAccount, enterprise,  organization);
        userProcessContainer.add("PerformSurveyJPanel",psjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_performSurveyJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList<Nurse> tempNurseList = new ArrayList<Nurse>();
        int selectedRow = workRequestJTable.getSelectedRow();
        if(selectedRow < 0)
            return;
        ChiefNurseToVolunteer cntv = (ChiefNurseToVolunteer)workRequestJTable.getValueAt(selectedRow, 0);
        String text = cntv.getMessage();
        String[] text1 = text.split(" ");
        String newString = text1[0];
         for(State state : business.getStateList())
        {
            for(City city : state.getCityList())
            {
                for(Enterprise e : city.getEnterprizeDirectory().getEnterprizeList())
                {
                    for(Organization org : e.getOrganizationDirectory().getOrganizationList())
                    {
                        for(Nurse nurse : org.getNurseList().getNurseList()){
                           
                            if(newString.equalsIgnoreCase("Experienced"))
                            {
                                String[] years = text.split(" ");
                                int yearsExp = Integer.parseInt(years[1]);
                                System.out.println(yearsExp);
                                if(nurse.getNoOfYearsExp()>= yearsExp)
                                {
                                    tempNurseList.add(nurse);
                                }
                                    
                                cntv.setNurseList(tempNurseList);
                            }
                            if(text.equalsIgnoreCase("Immediate Availability"))
                            {
                                if(nurse.isAvailability()==true)
                                {
                                    tempNurseList.add(nurse);
                                }
                                 cntv.setNurseList(tempNurseList);
                            }
                            if(text.equalsIgnoreCase("All Nurses"))
                            {
                                tempNurseList.add(nurse);
                                cntv.setNurseList(tempNurseList);
                            }
                        }
                    }
                        
                }
            }
        }
        cntv.setTestResult("List forwarded");
        cntv.setStatus("Done");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void newNurseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newNurseJButtonActionPerformed
        // TODO add your handling code here:
       RegisterNewNurseJPanel rnjp = new RegisterNewNurseJPanel(userProcessContainer, nurseList, enterprise, business);
        userProcessContainer.add("RegisterNewNurseJPanel",rnjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
       
    }//GEN-LAST:event_newNurseJButtonActionPerformed

    private void requestNurseCertificationJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestNurseCertificationJButtonActionPerformed
        // TODO add your handling code here:
        RequestNurseCertificationJPanel rncjp = new RequestNurseCertificationJPanel(userProcessContainer, userAccount, enterprise, business);
        userProcessContainer.add("RequestNurseCertificationJPanel",rncjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer); 
       
    }//GEN-LAST:event_requestNurseCertificationJButtonActionPerformed

    private void activePatientsJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activePatientsJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activePatientsJComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        populateRequestTable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> activePatientsJComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newNurseJButton;
    private javax.swing.JButton performSurveyJButton;
    private javax.swing.JButton registerActivePatientsJButton;
    private javax.swing.JButton requestNurseCertificationJButton;
    private javax.swing.JLabel volunteerNameJLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}


