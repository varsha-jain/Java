/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resumebuildergui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import resumebuilder.Resume;
import resumebuilder.ResumeCollection;

/**
 *
 * @author varsha
 */
public class ViewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewJPanel
     */
   
    private ResumeCollection resume;
    //private Education degree1;
   // private Education degree2;
    public ViewJPanel(ResumeCollection resume) {
        initComponents();
         this.resume=resume;
    // this.degree1=degree1;
    // this.degree2=degree2;
         populate();
         setNoBorder();
         
    }
    public void setNoBorder()
    {
        jScrollPane4.setBorder(null);
         JCareerObjectiveField.setBorder(null);
         jScrollPane5.setBorder(null);
         experienceTextField.setBorder(null);
         projTextField.setBorder(null);
         jScrollPane6.setBorder(null);
         skillsTextArea.setBorder(null);
         jScrollPane11.setBorder(null);
         awardsTextField.setBorder(null);
         jScrollPane8.setBorder(null);
         certificationTextField.setBorder(null);
         jScrollPane9.setBorder(null);
         jScrollPane10.setBorder(null);
         partiipateTextField.setBorder(null);
    }
    public void populate(){
        DefaultTableModel dtm= (DefaultTableModel)tblContent.getModel();
            dtm.setRowCount(0); 
            for(Resume resi : resume.getResume())
            {
                Object obj[] = new Object[2]; //generte rows dynmically
                obj[0]= resi;
                obj[1]= resi.getLastName();
                dtm.addRow(obj);
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblContent = new javax.swing.JTable();
        viewResumeButton = new javax.swing.JButton();
        deleteResumeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emailID = new javax.swing.JLabel();
        contactTextField = new javax.swing.JLabel();
        addressJLine1 = new javax.swing.JLabel();
        addressJLine2 = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        zipCode = new javax.swing.JLabel();
        salLabel = new javax.swing.JLabel();
        nationalityLabel = new javax.swing.JLabel();
        JImage1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JCareerObjectiveField = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        experienceTextField = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        affiliationTextField = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        studentTypeLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        degree2CgpaLabel = new javax.swing.JLabel();
        degree1NameLabel = new javax.swing.JLabel();
        degree2NameLabel = new javax.swing.JLabel();
        univNameLabel = new javax.swing.JLabel();
        degree2UnivNameLabel = new javax.swing.JLabel();
        year1 = new javax.swing.JLabel();
        year2 = new javax.swing.JLabel();
        cgpaLabel = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        projTextField = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        awardsTextField = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        certificationTextField = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        partiipateTextField = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        skillsTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("RESUME");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblContent);

        jScrollPane2.setViewportView(jScrollPane3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 48, 417, 119));

        viewResumeButton.setText("View Resume");
        viewResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResumeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(viewResumeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 185, 129, 35));

        deleteResumeButton.setText("Delete Resume");
        deleteResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteResumeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteResumeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 185, 115, 35));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("RESUME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 130, 20));

        firstNameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 70, 30));

        lastNameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPanel1.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 80, 30));
        jPanel1.add(emailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 120, 30));
        jPanel1.add(contactTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 100, 30));
        jPanel1.add(addressJLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, 23));
        jPanel1.add(addressJLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 90, 26));
        jPanel1.add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 70, 30));
        jPanel1.add(stateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 40, 30));
        jPanel1.add(countryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 80, 30));
        jPanel1.add(zipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 293, 80, 30));

        salLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(salLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 30, 30));
        jPanel1.add(nationalityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 75, 30));
        jPanel1.add(JImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 180, 170));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 520, 10));

        jLabel11.setText("Career Objective");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 100, 30));

        JCareerObjectiveField.setEditable(false);
        JCareerObjectiveField.setColumns(20);
        JCareerObjectiveField.setRows(5);
        JCareerObjectiveField.setBorder(null);
        jScrollPane4.setViewportView(JCareerObjectiveField);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 330, 130));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 980, 560, 10));

        jLabel22.setText("Experience");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 80, 23));

        experienceTextField.setEditable(false);
        experienceTextField.setColumns(20);
        experienceTextField.setRows(5);
        experienceTextField.setBorder(null);
        jScrollPane5.setViewportView(experienceTextField);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 320, 120));

        jLabel32.setText("Affiliation");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 770, 120, 25));

        affiliationTextField.setEditable(false);
        affiliationTextField.setBackground(new java.awt.Color(255, 255, 255));
        affiliationTextField.setBorder(null);
        jPanel1.add(affiliationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 810, 260, 28));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 870, 660, 19));

        jLabel31.setText("Type of Student:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 930, 97, 22));

        jLabel12.setText("Academics");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 890, 93, 22));
        jPanel1.add(studentTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 930, 94, 25));

        jLabel13.setText("Education");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, -1, 23));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 392, 520, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 640, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1180, 600, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1020, 600, 10));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1060, 600, 10));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1120, 600, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 1022, 20, 0));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1030, -1, -1));

        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 1020, 20, 160));

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 1020, 40, 160));

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1020, 20, 160));

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1020, 10, 160));

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 1020, 20, 160));

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 1020, 20, 160));

        jLabel5.setText("CGPA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1030, 60, 20));

        jLabel8.setText("Degree 1");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1080, 70, 30));

        jLabel14.setText("Degree 2");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1130, 70, 30));

        jLabel15.setText("Degree Name");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 1030, 90, 20));

        jLabel16.setText("University Name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1030, 130, 20));

        jLabel17.setText("Year of passing");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1030, 130, 20));
        jPanel1.add(degree2CgpaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1130, 70, 30));
        jPanel1.add(degree1NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1080, 70, 30));
        jPanel1.add(degree2NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 1130, 70, 30));
        jPanel1.add(univNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1080, 70, 30));
        jPanel1.add(degree2UnivNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1130, 70, 30));
        jPanel1.add(year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1080, 70, 30));
        jPanel1.add(year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1140, 70, 30));
        jPanel1.add(cgpaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 1080, 70, 30));

        jLabel27.setText("Projects");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1210, 98, 30));

        projTextField.setEditable(false);
        projTextField.setColumns(20);
        projTextField.setRows(5);
        projTextField.setBorder(null);
        jScrollPane6.setViewportView(projTextField);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1250, 310, 125));

        jLabel28.setText("Skills");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1400, 88, 28));

        jLabel33.setText("Awards and Honors");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1580, 110, 31));

        awardsTextField.setEditable(false);
        awardsTextField.setColumns(20);
        awardsTextField.setRows(5);
        awardsTextField.setBorder(null);
        jScrollPane8.setViewportView(awardsTextField);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1620, 310, 140));

        jLabel34.setText("Certifications");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1780, 122, 28));

        certificationTextField.setEditable(false);
        certificationTextField.setColumns(20);
        certificationTextField.setRows(5);
        certificationTextField.setBorder(null);
        jScrollPane9.setViewportView(certificationTextField);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1830, 310, 140));

        jLabel35.setText("Participations");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 2010, 105, 27));

        partiipateTextField.setEditable(false);
        partiipateTextField.setColumns(20);
        partiipateTextField.setRows(5);
        partiipateTextField.setBorder(null);
        jScrollPane10.setViewportView(partiipateTextField);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 2060, 310, 140));

        skillsTextArea.setEditable(false);
        skillsTextArea.setColumns(20);
        skillsTextArea.setRows(5);
        skillsTextArea.setBorder(null);
        jScrollPane11.setViewportView(skillsTextArea);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 1430, 310, 130));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel3.setText("email ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 324, 50, 40));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel4.setText("Contact No:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 70, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jLabel6.setText("view details here--");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2303, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResumeButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow=tblContent.getSelectedRow();
        if(selectedRow>=0)
        {
        Resume res= (Resume)tblContent.getValueAt(selectedRow,0);//get resume object from table
        String firstName= res.getFirstName();
        firstNameLabel.setText(firstName);        
        String lastName= res.getLastName();
        lastNameLabel.setText(lastName);        
        String addressLine1= res.getAddressLine1();
        addressJLine1.setText(addressLine1);
        
        String addressLine2= res.getAddressLine2();
        addressJLine2.setText(addressLine2);
        String city= res.getCity();
        cityLabel.setText(city);
        String state= res.getState();
        stateLabel.setText(state);
        String country= res.getCountry();
        countryLabel.setText(country);
        //String zipCode= res.getZipCode();
        zipCode.setText(String.valueOf(res.getZipCode()));
        String affiliation= res.getAffiliation();
        affiliationTextField.setText(affiliation);        
        String careerObjective= res.getCareerObjective();
        JCareerObjectiveField.setText(careerObjective);
        
        String degreeName=res.getDegreeName();        
        degree1NameLabel.setText(degreeName);             
        univNameLabel.setText(res.getUniversity());
        year1.setText(String.valueOf(res.getYear()));
       //Double cgpa=Doube.parseDouble()
        cgpaLabel.setText(String.valueOf(res.getCgpa()));
        
        String degree2=res.getDegreeName2();        
        degree2NameLabel.setText(degree2);              
        degree2UnivNameLabel.setText(res.getUniName2());
        //if(!String.valueOf(res.getDegree2().getYear()).trim().isEmpty())
       // {
        year2.setText(String.valueOf(res.getYear2()));
       // }
       // if(!String.valueOf(res.getDegree2().getCgpa()).trim().isEmpty())
       // {
        degree2CgpaLabel.setText(String.valueOf(res.getCgp2()));
       // }
        String gen= res.getGender();
        if(gen.equalsIgnoreCase("Male"))
        {
            salLabel.setText("Mr.");
        }
        if(gen.equalsIgnoreCase("Female"))
        {
            salLabel.setText("Ms.");
        }
        
        String nationality= res.getNationality();
        nationalityLabel.setText(nationality);
        
        String Type= res.getType();
        studentTypeLabel.setText(Type);
        
        
        
        String skill=res.getSkills();
        skillsTextArea.setText(skill);
        
        String awards= res.getAchievements();
        awardsTextField.setText(awards);
        String projects= res.getProjects();
        projTextField.setText(projects);
        String participation= res.getProjects();
        partiipateTextField.setText(participation);
        String email= res.getEmail();
        emailID.setText(email);
        contactTextField.setText(String.valueOf(res.getContact()));
        String experience= res.getExperience();
        experienceTextField.setText(experience);
        String certification= res.getCertifictions();
        certificationTextField.setText(certification);
         String newpath=res.getPath();
        //System.out.println("new path"+newpath);        
      // JImage1.setIcon(new ImageIcon(new ImageIcon(newpath).getImage()));
         ImageIcon icon= new ImageIcon(newpath);
            Image img=icon.getImage().getScaledInstance(160,150,Image.SCALE_SMOOTH);
            
            ImageIcon finalicon=new ImageIcon(img);
            JImage1.setIcon(finalicon);    
        }
        else
            JOptionPane.showMessageDialog(null,"Please select any row!");
    }//GEN-LAST:event_viewResumeButtonActionPerformed

    private void deleteResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteResumeButtonActionPerformed
        // TODO add your handling code here:
         int selectedRow=tblContent.getSelectedRow();
       int i= JOptionPane.showConfirmDialog(null,"Do you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
       if(i==0)
        {
       if(selectedRow>=0)
        {
            Resume rs= (Resume)tblContent.getValueAt(selectedRow,1);
            resume.removeResume(rs);
            JOptionPane.showMessageDialog(null,"Resume has been deleted");
             
                   populate();
            if(rs.getFirstName().equalsIgnoreCase(firstNameLabel.getText()))
            {
                clear();
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Please select any row!");
    }
       
    }//GEN-LAST:event_deleteResumeButtonActionPerformed
public void clear()
       {
           firstNameLabel.setText(" ");
           salLabel.setText(" ");
           lastNameLabel.setText(" ");
           addressJLine1.setText("");
           addressJLine2.setText("");
           cityLabel.setText("");
           stateLabel.setText("");
           countryLabel.setText("");
           emailID.setText("");
           contactTextField.setText("");
           nationalityLabel.setText("");
           JCareerObjectiveField.setText("");
           experienceTextField.setText("");
           affiliationTextField.setText("");
           degree1NameLabel.setText("");
           univNameLabel.setText("");
           year1.setText("");
           cgpaLabel.setText("");
           degree2NameLabel.setText("");
           degree2UnivNameLabel.setText("");
           year2.setText("");
           degree2CgpaLabel.setText("");
           projTextField.setText("");
           skillsTextArea.setText("");
           awardsTextField.setText("");
           certificationTextField.setText("");
           partiipateTextField.setText("");
           zipCode.setText("");
           JImage1.setIcon(null);
       }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JCareerObjectiveField;
    private javax.swing.JLabel JImage1;
    private javax.swing.JLabel addressJLine1;
    private javax.swing.JLabel addressJLine2;
    private javax.swing.JTextField affiliationTextField;
    private javax.swing.JTextArea awardsTextField;
    private javax.swing.JTextArea certificationTextField;
    private javax.swing.JLabel cgpaLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel contactTextField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JLabel degree1NameLabel;
    private javax.swing.JLabel degree2CgpaLabel;
    private javax.swing.JLabel degree2NameLabel;
    private javax.swing.JLabel degree2UnivNameLabel;
    private javax.swing.JButton deleteResumeButton;
    private javax.swing.JLabel emailID;
    private javax.swing.JTextArea experienceTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel nationalityLabel;
    private javax.swing.JTextArea partiipateTextField;
    private javax.swing.JTextArea projTextField;
    private javax.swing.JLabel salLabel;
    private javax.swing.JTextArea skillsTextArea;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel studentTypeLabel;
    private javax.swing.JTable tblContent;
    private javax.swing.JLabel univNameLabel;
    private javax.swing.JButton viewResumeButton;
    private javax.swing.JLabel year1;
    private javax.swing.JLabel year2;
    private javax.swing.JLabel zipCode;
    // End of variables declaration//GEN-END:variables
}
