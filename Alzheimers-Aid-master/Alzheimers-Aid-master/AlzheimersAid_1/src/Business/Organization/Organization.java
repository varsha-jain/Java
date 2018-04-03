/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Caregiver.CaregiverList;
import Business.Employee.EmployeeDirectory;
import Business.Neurologist.NeurologistList;
import Business.Nurse.NurseList;
import Business.Patient.PatientDirectory;
import Business.PatientFamily.PatientFamilyDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int count =1;
    private PatientFamilyDirectory patientFamilyDirectory;
    private PatientDirectory patientDirectory;
    private CaregiverList cgList;
    private NurseList nurseList;
    private NeurologistList neuroList;
    public enum Type{
        Admin("Admin Organization"), 
        Caregiver("Caregiver Organization"), 
        //ChiefNursePractitioner("ChiefNursePrctitioner Organization"),
        HiringManager("HiringManager organization"),
        MedicalPractitioner("MedicalPractitioner Organization"),
        Neurologist ("Neurologist Organization"),
        Nurse("Nurse Organization"),
        PatientFamily("PatientFamily Organization"),
        Patient("Patient Organization "),
        Researcher("Researcher Organization"),
        Volunteer("Volunteer Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = count++;
         patientFamilyDirectory = new PatientFamilyDirectory();
        patientDirectory = new PatientDirectory();
        cgList = new CaregiverList();
        nurseList = new NurseList();
        neuroList = new NeurologistList();
        //++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public PatientFamilyDirectory getPatientFamilyDirectory() {
        return patientFamilyDirectory;
    }

    public void setPatientFamilyDirectory(PatientFamilyDirectory patientFamilyDirectory) {
        this.patientFamilyDirectory = patientFamilyDirectory;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }

    public CaregiverList getCgList() {
        return cgList;
    }

    public void setCgList(CaregiverList cgList) {
        this.cgList = cgList;
    }

    public NurseList getNurseList() {
        return nurseList;
    }

    public void setNurseList(NurseList nurseList) {
        this.nurseList = nurseList;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Organization.count = count;
    }

    public NeurologistList getNeuroList() {
        return neuroList;
    }

    public void setNeuroList(NeurologistList neuroList) {
        this.neuroList = neuroList;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
