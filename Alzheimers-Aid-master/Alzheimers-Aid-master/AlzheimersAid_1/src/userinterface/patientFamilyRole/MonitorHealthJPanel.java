    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.patientFamilyRole;

import Business.Date.Time;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Neurologist.Neurologist;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.PatientFamily.PatientFamily;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.VitalSign.VitalSigns;
import Business.city.City;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.JPanel;
//import org.eclipse.swt.graphics.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author varsha
 */
public class MonitorHealthJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MonitorHealthJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount account;
    public MonitorHealthJPanel(JPanel userProcessContainer, EcoSystem business, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.account = account;
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        monitorBPJPanel.setLayout(new java.awt.BorderLayout());
        monitorBPJPanel.setPreferredSize(new Dimension(400,400));
        monitorBPJPanel.add(chartPanel, BorderLayout.CENTER);
        monitorBPJPanel.validate();
        final CategoryDataset dataset1 = createDatasetTemp();
        final JFreeChart chart1 = createChart1(dataset1);
        final ChartPanel chartPanel1 = new ChartPanel(chart1);
        monitorTempJPanel.setPreferredSize(new Dimension(400,400));
        monitorTempJPanel.setLayout(new java.awt.BorderLayout());
        monitorTempJPanel.add(chartPanel1, BorderLayout.CENTER);
        monitorTempJPanel.validate();
        final CategoryDataset dataset2 = createDatasetTempPulse();
        final JFreeChart chart2 = createChart2(dataset2);
        final ChartPanel chartPanel2 = new ChartPanel(chart2);
        monitorPulseJPanel.setPreferredSize(new Dimension(400,400));
        monitorPulseJPanel.setLayout(new java.awt.BorderLayout());
        monitorPulseJPanel.add(chartPanel2, BorderLayout.CENTER);
        monitorPulseJPanel.validate();
        
    }
    private CategoryDataset createDataset() {
        //final double[][] data = new double[][] {{4.0, 3.0, -2.0, 3.0, 6.0}};
        final ArrayList<Integer> bp = new ArrayList<Integer>();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(State state : business.getStateList())
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
                                   int tempBP = vs.getBloodPressure();
                                   Time d = vs.getTime();
                                   bp.add(tempBP);
                                   dataset.addValue(vs.getBloodPressure(),"",vs.getTimeRecord());
                               }
                           }
                       }
                   }
               }
           }
        }
        return dataset;
    }
    
    private CategoryDataset createDatasetTemp() {
    
       // final ArrayList<Integer> temp = new ArrayList<Integer>();
       // final Map<Long, String> map = new HashMap<Long, String>();
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        Calendar c = Calendar.getInstance();
        //int year = 0;
        Date d = null;
        int i = 2;
        String t ;
        for(State state : business.getStateList())
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
                                   String tempAL = String.valueOf( vs.getTemperature());
                                   t = vs.getTimeRecord();
                                   dataset1.addValue(vs.getTemperature()," ",t);
                               }
                           }
                       }
                   }
               }
           }
        }
       /* for(Map.Entry<Long,String> entry : map.entrySet())
        {
            dataset1.addValue(entry.getKey(),"",entry.getValue());
        }*/
           
        return dataset1;
    }
    
   private CategoryDataset createDatasetTempPulse() {
    
       // final ArrayList<Integer> temp = new ArrayList<Integer>();
       // final Map<Long, String> map = new HashMap<Long, String>();
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        Calendar c = Calendar.getInstance();
        //int year = 0;
        Date d = null;
        int i = 2;
        String t ;
        for(State state : business.getStateList())
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
                                   int pulse = vs.getPulse();
                                   t = vs.getTimeRecord();
                                   dataset2.addValue(pulse," ",t);
                               }
                           }
                       }
                   }
               }
           }
        }
       /* for(Map.Entry<Long,String> entry : map.entrySet())
        {
            dataset1.addValue(entry.getKey(),"",entry.getValue());
        }*/
           
        return dataset2;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitorBPJPanel = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        monitorTempJPanel = new javax.swing.JPanel();
        monitorPulseJPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        monitorBPJPanel.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout monitorBPJPanelLayout = new javax.swing.GroupLayout(monitorBPJPanel);
        monitorBPJPanel.setLayout(monitorBPJPanelLayout);
        monitorBPJPanelLayout.setHorizontalGroup(
            monitorBPJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        monitorBPJPanelLayout.setVerticalGroup(
            monitorBPJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        add(monitorBPJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 440, -1));

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 18, 88, 43));

        monitorTempJPanel.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout monitorTempJPanelLayout = new javax.swing.GroupLayout(monitorTempJPanel);
        monitorTempJPanel.setLayout(monitorTempJPanelLayout);
        monitorTempJPanelLayout.setHorizontalGroup(
            monitorTempJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        monitorTempJPanelLayout.setVerticalGroup(
            monitorTempJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );

        add(monitorTempJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 360, -1));

        monitorPulseJPanel.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout monitorPulseJPanelLayout = new javax.swing.GroupLayout(monitorPulseJPanel);
        monitorPulseJPanel.setLayout(monitorPulseJPanelLayout);
        monitorPulseJPanelLayout.setHorizontalGroup(
            monitorPulseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        monitorPulseJPanelLayout.setVerticalGroup(
            monitorPulseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        add(monitorPulseJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 579, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart(
            "Blood Pressure",       // chart title
            "Time",               // domain axis label
            "BP",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // the plot orientation
            false,                    // include legend
            true,
            false
        );
    
        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");

        final ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLowerMargin(0.15);
        rangeAxis.setUpperMargin(0.15);

        return chart;

    
    }//GEN-LAST:event_backJButtonActionPerformed

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
   private JFreeChart createChart2(final CategoryDataset dataset2) {
    final JFreeChart chart2 = ChartFactory.createBarChart(
            "Pulse",       // chart title
            "Time",               // domain axis label
            "Temperature",                  // range axis label
            dataset2,                  // data
            PlotOrientation.VERTICAL, // the plot orientation
            false,                    // include legend
            true,
            false
        );final CategoryPlot plot = chart2.getCategoryPlot();
        plot.setNoDataMessage("NO DATA!");

        final ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLowerMargin(0.15);
        rangeAxis.setUpperMargin(0.15);

        return chart2;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JPanel monitorBPJPanel;
    private javax.swing.JPanel monitorPulseJPanel;
    private javax.swing.JPanel monitorTempJPanel;
    // End of variables declaration//GEN-END:variables
}
