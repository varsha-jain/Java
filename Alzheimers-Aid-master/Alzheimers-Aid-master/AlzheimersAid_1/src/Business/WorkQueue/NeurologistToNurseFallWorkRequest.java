/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Nurse.Nurse;
import static Business.Organization.Organization.Type.Patient;
import Business.Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author Nirali Merchant
 */
public class NeurologistToNurseFallWorkRequest extends WorkRequest{
    private float riskScore;
     private ArrayList<Patient> patientList;

    public NeurologistToNurseFallWorkRequest()
    {
        patientList = new ArrayList<Patient>();
    }

    public float getTestResult() {
        return riskScore;
    }

    public void setTestResult(String certificationStatus) {
        this.riskScore = riskScore;
    }

    public float getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(float riskScore) {
        this.riskScore = riskScore;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    
    
    
}
