/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientFamily;


import Business.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class PatientFamilyDirectory {
    private ArrayList<PatientFamily> patientFamilyList;

    public PatientFamilyDirectory() {
        patientFamilyList = new ArrayList<PatientFamily>();
    }
    

    public ArrayList<PatientFamily> getPatientFamilyList() {
        return patientFamilyList;
    }

    public void setPatientFamilyList(ArrayList<PatientFamily> patientFamilyList) {
        this.patientFamilyList = patientFamilyList;
    }
    public PatientFamily addPatientFamiy()
    {
        PatientFamily p = new PatientFamily();
        patientFamilyList.add(p);
        return p;
               
    }
}
