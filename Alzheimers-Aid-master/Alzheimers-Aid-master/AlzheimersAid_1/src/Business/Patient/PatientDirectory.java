/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Neurologist.Neurologist;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class PatientDirectory {
    private ArrayList<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList<Patient>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    
    public Patient addPatient()
    {
        Patient p = new Patient();
        patientList.add(p);
        return p;
    }
    public boolean checkIfPatientIsUnique (Organization org, String  name)
    {
        boolean isUniqueNeurologist = true;
        for(Patient p : org.getPatientDirectory().getPatientList())
        {
            if(p.getName().equalsIgnoreCase(name))
            {
                isUniqueNeurologist = false;
            }
        }
        
    
     return isUniqueNeurologist;
}
}
