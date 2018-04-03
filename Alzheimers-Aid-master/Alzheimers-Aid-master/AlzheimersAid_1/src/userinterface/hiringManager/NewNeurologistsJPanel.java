/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.hiringManager;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Neurologist.Neurologist;
import Business.Neurologist.NeurologistList;
import Business.Organization.ChiefNursePractitionerOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.Neurologist;
import Business.Role.Role;
import Business.State.State;
import Business.TimeSlot.TimeSlot;
import Business.TimeSlot.TimeSlotList;
import Business.UserAccount.UserAccount;
import Business.WorkingDays.WorkingDays;
import Business.city.City;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author varsha
 */
public class NewNeurologistsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewNeurologistsJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private ChiefNursePractitionerOrganization org;
    private NeurologistList neuroList;
    public NewNeurologistsJPanel(JPanel userProcessContainer, EcoSystem business, Organization org, NeurologistList neuroList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.org = (ChiefNursePractitionerOrganization)org;
        this.neuroList = neuroList;
        populateNeurologists();
    }

    public void populateNeurologists()
    {
        neurologistJComboBox.removeAllItems();
       
        for (State state : business.getStateList()) {
            for (City city : state.getCityList()) {
                for (Enterprise e : city.getEnterprizeDirectory().getEnterprizeList()) {
                    for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {

                            for (Role role : o.getSupportedRole()) {
                                if (role.toString().equals("Neurologist Role")) {
                                    neurologistJComboBox.addItem(ua.getEmployee().getName());
                                   // c++;
                                    //System.out.println("Caregiver total is:"+ c );
                                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        degreeJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        yearsExpJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cityJTextField = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        mon = new javax.swing.JCheckBox();
        tue = new javax.swing.JCheckBox();
        wed = new javax.swing.JCheckBox();
        thurs = new javax.swing.JCheckBox();
        fri = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        time1 = new javax.swing.JCheckBox();
        time2 = new javax.swing.JCheckBox();
        time3 = new javax.swing.JCheckBox();
        time4 = new javax.swing.JCheckBox();
        neurologistJComboBox = new javax.swing.JComboBox<>();
        backJButton2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("NAME:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 80, 140, 30));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel2.setText("AGE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 134, 140, 28));
        jPanel1.add(ageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 134, 174, 28));

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel3.setText("DEGREE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 180, 140, 27));
        jPanel1.add(degreeJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 180, 174, 27));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel4.setText("YEARS OF EXPERIENCE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 225, 140, 30));

        yearsExpJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsExpJTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(yearsExpJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 225, 174, 30));

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel5.setText("Record Neurologist's details");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 250, 32));

        jButton1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 190, 41));

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel6.setText("CITY:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 283, 140, 29));

        cityJTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boston", "Newton", "Brimingham", "Montgomery", "Fairbanks", "Sitka", "San Diego", "San Jose", "Boulder", "Denver", "Norwalk", "Hartford", "Wilmington", "Newark", "New York", "Kingston", "Dallas", "Austin", "Seattle", "Redmond" }));
        jPanel1.add(cityJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 283, 174, 29));

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel7.setText("WORKING DAYS:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 323, 140, 21));

        mon.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        mon.setText("MONDAY");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        jPanel1.add(mon, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 323, -1, -1));

        tue.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        tue.setText("TUESDAY");
        jPanel1.add(tue, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 323, -1, -1));

        wed.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        wed.setText("WEDNESDAY");
        jPanel1.add(wed, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 323, -1, -1));

        thurs.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        thurs.setText("THURSDAY");
        jPanel1.add(thurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 351, -1, -1));

        fri.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        fri.setText("FRIDAY");
        jPanel1.add(fri, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        sat.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        sat.setText("SATURDAY");
        jPanel1.add(sat, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 351, -1, -1));

        jLabel8.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel8.setText("TIME SLOTS:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 382, 140, 25));

        time1.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        time1.setText("9am-11am");
        jPanel1.add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 383, -1, -1));

        time2.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        time2.setText("12pm-2pm");
        jPanel1.add(time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, -1));

        time3.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        time3.setText("4pm-6pm");
        jPanel1.add(time3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        time4.setFont(new java.awt.Font("Corbel", 1, 12)); // NOI18N
        time4.setText("7pm-9pm");
        jPanel1.add(time4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, -1, -1));

        neurologistJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(neurologistJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 180, 30));

        backJButton2.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton2.setText("<< Back");
        backJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(backJButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yearsExpJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsExpJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearsExpJTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!validateFields())
        {
            create();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monActionPerformed

    private void backJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton2ActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton2ActionPerformed

    public void create(){
        String name = (String) neurologistJComboBox.getSelectedItem();
        // for (Employee e : org.getEmployeeDirectory().getEmployeeList()) {
        //  String n = e.getName();
        // if (name.equalsIgnoreCase(n)) {

        boolean isUniqueNeurologist = true;
        boolean added = true;
        
        for (State state : business.getStateList()) {
            for (City city : state.getCityList()) {
                for (Enterprise e : city.getEnterprizeDirectory().getEnterprizeList()) {
                    for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        for (UserAccount ua : o.getUserAccountDirectory().getUserAccountList()) {
                        // isUniqueNeurologist = o.getNeuroList().checkIfNeurologistIsUnique(o, name);
                      //   if(isUniqueNeurologist){
                            if (name.equalsIgnoreCase(ua.getEmployee().getName())) {
                                
                                Neurologist neurologist = org.getNeuroList().addNeurologist();
                                neurologist.setName(name);
                                neurologist.setAge(Integer.parseInt(ageJTextField.getText().trim()));
                                neurologist.setDegree(degreeJTextField.getText());
                                neurologist.setYearsExp(Integer.parseInt(yearsExpJTextField.getText().trim()));
                                //neurologist.setCity(city);
                                City c = new City();
                                for (State sta : business.getStateList()) {
                                    for (City ci : sta.getCityList()) {
                                        if (ci.getName().equalsIgnoreCase((String) cityJTextField.getSelectedItem())) {
                                            c.setName((String) cityJTextField.getSelectedItem());
                                        }
                                    }
                                }

                                neurologist.setCity(city);
                                String day;
                                WorkingDays workingDay;
                                if (mon.isSelected()) {
                                    workingDay = neurologist.getWorkingDaysList().addWorkingDays();
                                    day = mon.getText();
                                    workingDay.setWorkingDay(day);
                                }
                                if (tue.isSelected()) {
                                    workingDay = neurologist.getWorkingDaysList().addWorkingDays();
                                    day = tue.getText();
                                    workingDay.setWorkingDay(day);
                                }
                                if (wed.isSelected()) {
                                    workingDay = neurologist.getWorkingDaysList().addWorkingDays();
                                    day = wed.getText();
                                    workingDay.setWorkingDay(day);
                                }
                                if (thurs.isSelected()) {
                                    workingDay = neurologist.getWorkingDaysList().addWorkingDays();
                                    day = thurs.getText();
                                    workingDay.setWorkingDay(day);
                                }
                                if (fri.isSelected()) {
                                    workingDay = neurologist.getWorkingDaysList().addWorkingDays();
                                    day = fri.getText();
                                    workingDay.setWorkingDay(day);
                                }
                                if (sat.isSelected()) {
                                    workingDay = neurologist.getWorkingDaysList().addWorkingDays();
                                    day = sat.getText();
                                    workingDay.setWorkingDay(day);
                                }
                                String time;
                                TimeSlot t;
                                if (time1.isSelected()) {
                                    t = neurologist.getTimeslotList().addTimeSlot();
                                    time = time1.getText();
                                    t.setTime(time);
                                }
                                if (time2.isSelected()) {
                                    t = neurologist.getTimeslotList().addTimeSlot();
                                    time = time2.getText();
                                    t.setTime(time);
                                }
                                if (time3.isSelected()) {
                                    t = neurologist.getTimeslotList().addTimeSlot();
                                    time = time3.getText();
                                    t.setTime(time);
                                }
                                if (time4.isSelected()) {
                                    t = neurologist.getTimeslotList().addTimeSlot();
                                    time = time4.getText();
                                    t.setTime(time);
                                }
                           //      added = true;
                          //  break;
                         //   }
                           
                         } //else
                       //  {
                        //     added = false;
                        //     break;
                           // JOptionPane.showMessageDialog(null, "Neurologist's details already exists!", "Warning", JOptionPane.WARNING_MESSAGE);
                           // break;
                            
                         }
                        }

                    }
                }
            }
       // }

     /*   if(added == true){
            JOptionPane.showMessageDialog(null, "Neurologist Details updated!");
                            //break;
        }
        if(added == false)
           JOptionPane.showMessageDialog(null, "Neurologist's details already exists!", "Warning", JOptionPane.WARNING_MESSAGE); 
        //  }  
        */
        ageJTextField.setText(" ");
        yearsExpJTextField.setText(" ");
        degreeJTextField.setText(" ");
    }
        
    
    public boolean validateFields()
    {
        
        try
        {
           int age = Integer.parseInt(ageJTextField.getText().trim());
           int yearExp = Integer.parseInt(yearsExpJTextField.getText().trim());
           if((age<0) || (yearExp < 0) 
                   || (yearExp>age) 
                  )
           {
               ageJTextField.setText(" ");
               yearsExpJTextField.setText(" ");
               degreeJTextField.setText(" ");
           }
               //return true;
                   
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"Please enter valid data!"); 
           ageJTextField.setText(" ");
           yearsExpJTextField.setText(" ");
               degreeJTextField.setText(" ");
        }
            
         return false;   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JButton backJButton2;
    private javax.swing.JComboBox<String> cityJTextField;
    private javax.swing.JTextField degreeJTextField;
    private javax.swing.JCheckBox fri;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox mon;
    private javax.swing.JComboBox<String> neurologistJComboBox;
    private javax.swing.JCheckBox sat;
    private javax.swing.JCheckBox thurs;
    private javax.swing.JCheckBox time1;
    private javax.swing.JCheckBox time2;
    private javax.swing.JCheckBox time3;
    private javax.swing.JCheckBox time4;
    private javax.swing.JCheckBox tue;
    private javax.swing.JCheckBox wed;
    private javax.swing.JTextField yearsExpJTextField;
    // End of variables declaration//GEN-END:variables
}
