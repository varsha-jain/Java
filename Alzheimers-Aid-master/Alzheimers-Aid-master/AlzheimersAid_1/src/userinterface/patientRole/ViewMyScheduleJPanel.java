/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.patientRole;

import Business.Caregiver.Caregiver;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientFamilyOrganization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.PatientFamily.PatientFamily;
import Business.Role.PatientRole;
import Business.Role.Role;
import Business.Schedule.Task;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AddTasksForPatient;
import Business.WorkQueue.InformFamilyAboutTask;
import Business.WorkQueue.WorkRequest;
import Business.city.City;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author varsha
 */
public class ViewMyScheduleJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewMyScheduleJPanel
     */
    private JPanel userProcessContainer;
    
    private UserAccount account;
    private EcoSystem business;
    private PatientOrganization patientOrganization;
    public ViewMyScheduleJPanel(JPanel userProcessContainer, Organization organization, UserAccount account, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        
        this.account = account;
        this.business = business;
        this.patientOrganization = (PatientOrganization) organization;
        
       /* for (Patient p : organization.getPatientDirectory().getPatientList()) {
                             //  if (p.getName().equalsIgnoreCase(account.getEmployee().getName())) {
                             System.out.println("****"+p.getName());
                           //  caregiverNameJLabel.setText(p.getCareGiver().getCareGiverName());
                               }*/
                          
        
        //checkIfCorrectUser();
        displayCareGiverName();
       populateTable();
        
    }
    public void populateTable()
    {
        //patient receiving message from caregiver
        DefaultTableModel model = (DefaultTableModel) tasksJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : patientOrganization.getWorkQueue().getWorkRequestList()) {
            for (State state : business.getStateList()) {
               for (City city : state.getCityList()) {
                    for (Enterprise e : city.getEnterprizeDirectory().getEnterprizeList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            // for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                            for (Patient p : o.getPatientDirectory().getPatientList()) {
                                if (p.getCareGiver().getCareGiverName().equalsIgnoreCase(request.getSender().getEmployee().getName()) && p.getName().equalsIgnoreCase(account.getEmployee().getName())) {
                                    Object[] row = new Object[3];
                                    row[0] = request;
                                    row[1] = request.getSender().getEmployee().getName();
                                    // row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                                    row[2] = request.getStatus();

                                    model.addRow(row);
                                    break;
                                //}
                            }

                        }
                      }

                    }
                }
            }
        }
        
        
       
    }
   public void displayCareGiverName()
   {
       for (State state : business.getStateList()) {
           for (City city : state.getCityList()) {
               for (Enterprise e : city.getEnterprizeDirectory().getEnterprizeList()) {
                   for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                      // for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                           for (Patient p : o.getPatientDirectory().getPatientList()) {
                               if (p.getName().equalsIgnoreCase(account.getEmployee().getName())) {
                                   caregiverNameJLabel.setText(p.getCareGiver().getCareGiverName());
                               }
                           }

                       //}
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
        tasksJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        caregiverNameJLabel = new javax.swing.JLabel();
        completeJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("My Tasks for today!!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 67, -1, 39));

        tasksJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task Name", "sender", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tasksJTable);
        if (tasksJTable.getColumnModel().getColumnCount() > 0) {
            tasksJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 175, 576, 179));

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, 96, 38));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel2.setText("Your Caregiver is:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 120, 160, 27));
        add(caregiverNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 330, 27));

        completeJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        completeJButton.setText("Complete");
        completeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeJButtonActionPerformed(evt);
            }
        });
        add(completeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 389, 132, 39));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void completeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = tasksJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        AddTasksForPatient request = (AddTasksForPatient)tasksJTable.getValueAt(selectedRow, 0);
        request.setTestResult("Completed");
        String messageForFamily = request.toString();
        request.setStatus("Completed");
        populateTable();
        
        
          InformFamilyAboutTask request4 = new InformFamilyAboutTask();
          request4.setMessage(messageForFamily);
          request4.setSender(account);
          request4.setStatus("Sent");
         
        Organization org = null;
        for (State state : business.getStateList()) {
            for (City city : state.getCityList()) {
                for (Enterprise enterprise : city.getEnterprizeDirectory().getEnterprizeList()) {
                     
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof PatientFamilyOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }
            }
        
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request4);
            account.getWorkQueue().getWorkRequestList().add(request4);
        }
        JOptionPane.showMessageDialog(null, "You have successfully completed this task!");
    }//GEN-LAST:event_completeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel caregiverNameJLabel;
    private javax.swing.JButton completeJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tasksJTable;
    // End of variables declaration//GEN-END:variables
}
