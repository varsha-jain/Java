/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import javax.swing.JPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.Organization.Organization;
import Business.State.State;
import Business.city.City;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nirali Merchant
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system;
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;   
        populateTree();
    }
    
    public void populateTree()
    {
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        ArrayList<State> stateList = system.getStateList();
        ArrayList<City> cityList;
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        State state;
        City city;
        Enterprise  enterprise;
        Organization organization;
        
      //  DefaultMutableTreeNode networks  = new DefaultMutableTreeNode("Network");
        //DefaultMutableTreeNode states  = new DefaultMutableTreeNode("Alzheimer's Association USA");
        //DefaultMutableTreeNode cities  = new DefaultMutableTreeNode("City");
        DefaultMutableTreeNode states   = (DefaultMutableTreeNode)model.getRoot();
        states.setUserObject("Alzhiemer's Association of USA");
        //root.removeAllChildren();
       // root.insert(states, 0);
       states.removeAllChildren();
       
        //DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode stateNode;
        DefaultMutableTreeNode cityNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for(int i = 0; i<stateList.size(); i++)
        {
            //network =stateList.get(i);
            state = stateList.get(i);
            //networkNode = new DefaultMutableTreeNode(network.getName());
            stateNode = new DefaultMutableTreeNode(state.getName());
            //networks.insert(networkNode, i);
            states.insert(stateNode, i);
            cityList = state.getCityList();
           // enterpriseList = city.getEnterprizeDirectory().getEnterprizeList();
            
            for (int j= 0 ; j<cityList.size();j++)
            {
                city  = cityList.get(j);
                cityNode = new DefaultMutableTreeNode(city.getName());
                stateNode.insert(cityNode, j);
                
                enterpriseList = city.getEnterprizeDirectory().getEnterprizeList();

                
            
                for(int k = 0; k <enterpriseList.size(); k++)
                {
                  enterprise = enterpriseList.get(k);
                  enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                  cityNode.insert(enterpriseNode, k);
                   //      networkNode.insert(networkNode, j);
              
              
                  organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                    for(int l = 0; l<organizationList.size(); l++)
                    {
                     organization =organizationList.get(l);
                        organizationNode = new DefaultMutableTreeNode(organization.getName());
                      enterpriseNode.insert(organizationNode, l);
                    }
              }
        }
        }
        
           model.reload();
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        manageNetworkJButton = new javax.swing.JButton();
        manageEnterpriseJButton = new javax.swing.JButton();
        manageEnterpriseAdmin = new javax.swing.JButton();
        viewReportsJButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTree.setBackground(new java.awt.Color(204, 255, 255));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );

        jSplitPane.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageNetworkJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        manageNetworkJButton.setText("Manage State and City");
        manageNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageNetworkJButtonActionPerformed(evt);
            }
        });
        jPanel2.add(manageNetworkJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 101, 191, 49));

        manageEnterpriseJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        manageEnterpriseJButton.setText("Manage Enterprise");
        manageEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseJButtonActionPerformed(evt);
            }
        });
        jPanel2.add(manageEnterpriseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 168, 191, 47));

        manageEnterpriseAdmin.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        manageEnterpriseAdmin.setText("Manage Enterprise Admin");
        manageEnterpriseAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseAdminActionPerformed(evt);
            }
        });
        jPanel2.add(manageEnterpriseAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 233, 191, 47));

        viewReportsJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        viewReportsJButton.setText("View Reports");
        viewReportsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReportsJButtonActionPerformed(evt);
            }
        });
        jPanel2.add(viewReportsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 291, 191, 50));

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageNetworkJButtonActionPerformed
        // TODO add your handling code here:
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, system);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout  = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageNetworkJButtonActionPerformed

    private void manageEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseJButtonActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageEnterpriseJPanel", manageEnterpriseJPanel);
        CardLayout layout  = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseJButtonActionPerformed

    private void manageEnterpriseAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseAdminActionPerformed
       ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, system);
        userProcessContainer.add("ManageEnterprseAdminJPanel", manageEnterpriseAdminJPanel);
        CardLayout layout  = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEnterpriseAdminActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        // TODO add your handling code here:
    //    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)jTree.getLastSelectedPathComponent();
      /*  if(selectedNode != null)
        {
            selectedNodeJLabel.setText(selectedNode.toString());
            
        }*/
    }//GEN-LAST:event_jTreeValueChanged

    private void viewReportsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReportsJButtonActionPerformed
        ViewReportsJPanel viewReports = new ViewReportsJPanel(userProcessContainer, system);
        userProcessContainer.add("ViewReportsJPanel", viewReports);
        CardLayout layout  = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewReportsJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JButton manageEnterpriseAdmin;
    private javax.swing.JButton manageEnterpriseJButton;
    private javax.swing.JButton manageNetworkJButton;
    private javax.swing.JButton viewReportsJButton;
    // End of variables declaration//GEN-END:variables
}