/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.researcherRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ResearchAnalysisWorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author raunak
 */
public class ProcessWorkRequest extends javax.swing.JPanel {

    JPanel userProcessContainer;
    ResearchAnalysisWorkRequest request;
    Enterprise enterprise;
    
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public ProcessWorkRequest(JPanel userProcessContainer, ResearchAnalysisWorkRequest request, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.enterprise = enterprise;
       
        
       // createDemoPanel();
        //graphJPanel.add(cp1,BorderLayout.CENTER);
        createJFreeChart();
        
    }
    
    public void createJFreeChart()
    {
       JFreeChart chart = createChart(createDataset( ) );  
       ChartPanel cp = new ChartPanel( chart );
       jPanel1.removeAll();
       jPanel1.add(cp,BorderLayout.CENTER);
       jPanel1.validate();
    }
    
   /* public void createJFreeChart()
    {
        JFreeChart chart = createChart(createDataset( ) );  
        
     //   return new ChartPanel( chart ); 
    }
    */
   // public static JPanel createDemoPanel( )
    public  void createDemoPanel( )
   {
       
      JFreeChart chart = createChart(createDataset( ) );  
       ChartPanel cp = new ChartPanel( chart );
       
      
   }
    private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Mood Analysis",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
    
    public PieDataset createDataset( ) 
   {
       int agitatedCount = 0;
       int annoyedCount = 0;
       int bewilderedCount = 0;
       int boredCount = 0;
       int calmCount  = 0;
   
       DefaultPieDataset dataset = new DefaultPieDataset( );
       for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
       {
       for(Patient p : org.getPatientDirectory().getPatientList())
       {
           String criteria = request.getCriteria();
           if (criteria.equalsIgnoreCase("Mood"))
           {
               
                if (p.getMood().equalsIgnoreCase("Agitated"))
                        {
                            ++agitatedCount ;
                        }
      
                if (p.getMood().equalsIgnoreCase("Annoyed"))
                        {
                            ++annoyedCount ;
                        }
                
                 if (p.getMood().equalsIgnoreCase("Bewildered"))
                        {
                            ++bewilderedCount ;
                        }
      
                if (p.getMood().equalsIgnoreCase("Bored"))
                        {
                            ++boredCount ;
                        }
                
                if (p.getMood().equalsIgnoreCase("Calm"))
                        {
                            ++calmCount ;
                        }
                
           }
       }
       }
                dataset.setValue( "Agitated" , new Double( agitatedCount ) );  
                dataset.setValue( "Bewildered" , new Double( bewilderedCount ) );   
                dataset.setValue( "Annoyed" , new Double( boredCount ) );    
                dataset.setValue( "Bored" , new Double( calmCount ) );  
                    dataset.setValue( "Calm" , new Double( calmCount ) );  
                return dataset;         
           }
               
       
       
       
       
       
  
    
    
    
   /* private static PieDataset createDataset( ) 
   {  
       DefaultPieDataset dataset = new DefaultPieDataset( );
      
      
      
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );  
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );   
      dataset.setValue( "MotoG" , new Double( 80 ) );    
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      return dataset;         
   }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 101, 33));

        jPanel1.setBackground(new java.awt.Color(204, 51, 255));
        jPanel1.setForeground(new java.awt.Color(153, 0, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 611, 297));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ResearcherWorkAreaJPanel dwjp = (ResearcherWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
