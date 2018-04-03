/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.neurologistRole;

import Business.Date.Time;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.MedicalPractitionerOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientFamilyOrganization;
import Business.Patient.Patient;
import Business.PatientFamily.PatientFamily;
import Business.State.State;
import Business.UserAccount.UserAccount;
import Business.VitalSign.VitalSigns;
import Business.WorkQueue.CaregiverToMedicalPractitioner;
import Business.WorkQueue.NeurologistToPatientFamily;
import Business.city.City;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
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
 * @author varsha
 */
public class MonitorVitalSignJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MonitorVitalSignJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private EcoSystem business;
    private JProgressBar progressBar;
    private Patient p;
    public MonitorVitalSignJPanel(JPanel userProcessContainer, UserAccount account,EcoSystem business,Patient p) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.account = account;
        this.p = p;
        patientName.setText(p.getName());
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        BPJPanel.setLayout(new java.awt.BorderLayout());
        //monitorBPJPanel.setPreferredSize(new Dimension(400,400));
        BPJPanel.add(chartPanel, BorderLayout.CENTER);
        BPJPanel.validate();
        final CategoryDataset dataset1 = createDatasetTemp();
        final JFreeChart chart1 = createChart1(dataset1);
        final ChartPanel chartPanel1 = new ChartPanel(chart1);
        tempJPanel.setLayout(new java.awt.BorderLayout());
        tempJPanel.add(chartPanel1, BorderLayout.CENTER);
        tempJPanel.validate();
        final CategoryDataset dataset2 = createDatasetTempPulse();
        final JFreeChart chart2 = createChart2(dataset2);
        final ChartPanel chartPanel2 = new ChartPanel(chart2);
        pulseJPanel.setLayout(new java.awt.BorderLayout());
        pulseJPanel.add(chartPanel2, BorderLayout.CENTER);
        pulseJPanel.validate();
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
                       for(Patient p : o.getPatientDirectory().getPatientList())
                       {
                           if(p.getNeurologist().getName().equalsIgnoreCase(account.getEmployee().getName()))
                           {
                              // Patient p = pf.getPatient();
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
    
        final ArrayList<Integer> temp = new ArrayList<Integer>();
        final Map<Long, String> map = new HashMap<Long, String>();
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        Calendar c = Calendar.getInstance();
        int year = 0;
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
                       for(Patient p : o.getPatientDirectory().getPatientList())
                       {
                           if(p.getNeurologist().getName().equalsIgnoreCase(account.getEmployee().getName()))
                           {
                               //Patient p = pf.getPatient();
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
                       for(Patient p : o.getPatientDirectory().getPatientList())
                       {
                           if(p.getNeurologist().getName().equalsIgnoreCase(account.getEmployee().getName()))
                           {
                              // Patient p = pf.getPatient();
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
    private JFreeChart createChart2(final CategoryDataset dataset2) {
    final JFreeChart chart2 = ChartFactory.createLineChart(
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BPJPanel = new javax.swing.JPanel();
        pulseJPanel = new javax.swing.JPanel();
        tempJPanel = new javax.swing.JPanel();
        callAmbulanceJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        patientName = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BPJPanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout BPJPanelLayout = new javax.swing.GroupLayout(BPJPanel);
        BPJPanel.setLayout(BPJPanelLayout);
        BPJPanelLayout.setHorizontalGroup(
            BPJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        BPJPanelLayout.setVerticalGroup(
            BPJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        add(BPJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 340, 210));

        pulseJPanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pulseJPanelLayout = new javax.swing.GroupLayout(pulseJPanel);
        pulseJPanel.setLayout(pulseJPanelLayout);
        pulseJPanelLayout.setHorizontalGroup(
            pulseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        pulseJPanelLayout.setVerticalGroup(
            pulseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        add(pulseJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 500, -1));

        tempJPanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout tempJPanelLayout = new javax.swing.GroupLayout(tempJPanel);
        tempJPanel.setLayout(tempJPanelLayout);
        tempJPanelLayout.setHorizontalGroup(
            tempJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        tempJPanelLayout.setVerticalGroup(
            tempJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        add(tempJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 320, 210));

        callAmbulanceJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        callAmbulanceJButton.setText("Call Ambulance");
        callAmbulanceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callAmbulanceJButtonActionPerformed(evt);
            }
        });
        add(callAmbulanceJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 130, 32));

        backJButton.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 40));

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 14)); // NOI18N
        jLabel1.setText("Vital Sign Record of");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 180, 30));
        add(patientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void callAmbulanceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callAmbulanceJButtonActionPerformed
        // TODO add your handling code here:
       
        String message = "There is some issue in the vital sign readings. Ambulance will be at the destination soon";
        NeurologistToPatientFamily request = new NeurologistToPatientFamily();
        request.setMessage(message);
        request.setSender(account);
        request.setStatus("Sent");

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
    
        

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
         ProgressBarDemo.createAndShowGUI();
         
         
         sendEmail();
    }//GEN-LAST:event_callAmbulanceJButtonActionPerformed

    public void sendEmail()
    {
            String to="nirali69@gmail.com";//change accordingly

//Get the session object
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
        	"javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");
 
  Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication("nirali69@gmail.com","bLESSed_by_u");//change accordingly
   }
  });
 
//compose message
  try {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress("nirali69@gmail.com"));//change accordingly
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   message.setSubject("Hello");
   message.setText("Testing.......");
   
   //send message
   Transport.send(message);

   //System.out.println("message sent successfully");
   JOptionPane.showMessageDialog(null,"Email sent to the Patients family","Information", JOptionPane.INFORMATION_MESSAGE );
 
  } catch (MessagingException e) {throw new RuntimeException(e);}
 
    }
    
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BPJPanel;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton callAmbulanceJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel patientName;
    private javax.swing.JPanel pulseJPanel;
    private javax.swing.JPanel tempJPanel;
    // End of variables declaration//GEN-END:variables
}
class ProgressBarDemo extends JPanel
                             implements  
                                        PropertyChangeListener {

    private JProgressBar progressBar;
    private JButton startButton;
    private JTextArea taskOutput;
    private Task task;

    /*@Override
    public void actionPerformed(ActionEvent e) {
        
    }*/

    class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            //startButton.setEnabled(true);
            setCursor(null); //turn off the wait cursor
            //taskOutput.append("Done!\n");
        }
    }

    public ProgressBarDemo() {
        super(new BorderLayout());

        //Create the demo's UI.
        //startButton = new JButton("Start");
        //startButton.setActionCommand("start");
        //startButton.addActionListener(this);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        //taskOutput = new JTextArea(5, 20);
        //taskOutput.setMargin(new Insets(5,5,5,5));
        //taskOutput.setEditable(false);

        JPanel panel = new JPanel();
       // panel.add(startButton);
        panel.add(progressBar);

        add(panel, BorderLayout.PAGE_START);
        //add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        
        //setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    /**
     * Invoked when the user presses the start button.
     */
    /*public void actionPerformed(ActionEvent evt) {
       // startButton.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }*/

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
            if(progress == 0)
            {
                JOptionPane.showMessageDialog(null,"Ambulance is on its way!");
            }
            if(progress == 50)
            {
                JOptionPane.showMessageDialog(null,"Ambulance has reached the midway!");
            }
            if(progress == 100)
            {
                JOptionPane.showMessageDialog(null,"Ambulance has reached the destination!");
            }
           // taskOutput.append(String.format(
             //       "Completed %d%% of task.\n", task.getProgress()));
        } 
    }


    /**
     * Create the GUI and show it. As with all GUI code, this must run
     * on the event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ProgressBarDemo");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ProgressBarDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}