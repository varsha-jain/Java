/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.Date.Time;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.PatientFamily.PatientFamily;
import Business.State.State;
import Business.VitalSign.VitalSigns;
import Business.city.City;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author Nirali Merchant
 */
public class ViewReportsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewReports
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    ViewReportsJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        final CategoryDataset dataset1 = createDatasetTemp();
        final JFreeChart chart1 = createChart1(dataset1);
        final ChartPanel chartPanel1 = new ChartPanel(chart1);
        reportsJPanel.setLayout(new java.awt.BorderLayout());
        reportsJPanel.add(chartPanel1, BorderLayout.CENTER);
        reportsJPanel.validate();
    }
    
    
   private CategoryDataset createDatasetTemp() {
        //final double[][] data = new double[][] {{4.0, 3.0, -2.0, 3.0, 6.0}};
      //  final Map<Integer,String> temp= new HashMap<Integer,String>();
       // DefaultCategoryDataset datasetTemp = new DefaultCategoryDataset();
        
    /*    String category1 = "02/10/2005"; 
String category2 = "05/10/2005"; 
String category3 = "07/10/2005"; 
String category4 = "10/10/2005"; 
long time1 = convert("02:37:36"); 
long time2 = convert("11:22:45"); 
long time3 = convert("07:36:39"); 
long time4 = convert("03:00:41"); 
 

datasetTemp.addValue(time1, "First", category1); 
datasetTemp.addValue(time2, "First", category2); 
datasetTemp.addValue(time3, "First", category3); 
datasetTemp.addValue(time4, "First", category4); */

    
    
    
   
      /* for(State state : business.getStateList())
        {
           for(City city : state.getCityList())
           {
               for(Enterprise e : city.getEnterprizeDirectory().getEnterprizeList())
               {
                   for(Organization o : e.getOrganizationDirectory().getOrganizationList())
                   {
                       for(PatientFamily pf : o.getPatientFamilyDirectory().getPatientFamilyList())
                       {
                           if(pf.getMemberName().equalsIgnoreCase(account.getEmployee().getName()))
                           {
                               Patient p = pf.getPatient();
                               for(VitalSigns vs : p.getVsh().getVitalSignHistory())
                               {
                                   String tempBP = String.valueOf(vs.getTemperature());
                                   Date d = vs.getTime().getTime_taken();
                                   c.setTime(d);
                                   int year = c.get(Calendar.YEAR);
                                   temp.put(year,tempBP);
                                   
                                 //  datasetTemp.addValue(temp,"", String.valueOf( d));
                                 for (Map.Entry<Integer,String> entry : temp.entrySet())
                                    {
                                        System.out.println(entry.getKey() + "/" + entry.getValue());
                                        datasetTemp.addValue(entry.getKey(),"Blood pressure ",entry.getValue());
                                    }
                               }
                           }
                       }
                   }
               }
           }
        }*/
       // return datasetTemp;
        /*return DatasetUtilities.createCategoryDataset(
            "Blood Pressure",
            "Date",
            bp
        );*/
       // final ArrayList<Integer> temp = new ArrayList<Integer>();
        final Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        Calendar c = Calendar.getInstance();
        int year = 0;
        Date registeredDate = null;
        int count = 0;
        int initialCount = 1;
        int i = 2;
        String t ;
        for(State state : system.getStateList())
        {
           for(City city : state.getCityList())
           {
               for(Enterprise e : city.getEnterprizeDirectory().getEnterprizeList())
               {
                   for(Organization o : e.getOrganizationDirectory().getOrganizationList())
                   {
                       for(PatientFamily pf : o.getPatientFamilyDirectory().getPatientFamilyList())
                       {
                           
                               Patient p = pf.getPatient();
                               
                               if (p.isEarlyAlzhimers())
                               {
                                   registeredDate =   p.getDateRegistered();
                                   c.setTime(registeredDate);
                                   year = c.get(Calendar.YEAR);
                                   
                                   for(Map.Entry<Integer,Integer> entry : map.entrySet())
                                   {
                                       if(entry.getKey() == year)
                                       {
                                           count = entry.getValue();
                                           count = count+ 1;
                                           map.put(entry.getKey(), count);
                                       }
                                   
                                  /* if(map.containsKey(year))
                                   {
                                       map.get(o)
                                       count = count + 1;
                                       map.put(year, count);
                                   }*/
                                   else
                                   {
                                       map.put(year,initialCount);
                                   }
                               }
                               }
                               
                       }
                   }
               }
           }
        }                                   
       for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            dataset1.addValue(entry.getKey(),"",entry.getValue());
        }
           
        return dataset1;
    }
    
   
    private JFreeChart createChart1(final CategoryDataset dataset1) {
    final JFreeChart chart1 = ChartFactory.createBarChart(
            "Temperature",       // chart title
            "Time",               // domain axis label
            "Temperature",                  // range axis label
            dataset1,                  // data
            PlotOrientation.VERTICAL, // the plot orientation
            false,                    // include legend
            true,
            false
        );final CategoryPlot plot = chart1.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");

        final ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLowerMargin(0.15);
        rangeAxis.setUpperMargin(0.15);

        return chart1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportsJPanel = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout reportsJPanelLayout = new javax.swing.GroupLayout(reportsJPanel);
        reportsJPanel.setLayout(reportsJPanelLayout);
        reportsJPanelLayout.setHorizontalGroup(
            reportsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );
        reportsJPanelLayout.setVerticalGroup(
            reportsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        add(reportsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 133, -1, -1));

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, 109, 38));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JPanel reportsJPanel;
    // End of variables declaration//GEN-END:variables
}
