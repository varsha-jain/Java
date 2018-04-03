/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Nurse.Nurse;
import Business.Nurse.NurseList;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class ChiefNurseToVolunteer extends WorkRequest {
    private String testResult;
    private ArrayList<Nurse> nurseList;

    public ChiefNurseToVolunteer() {
        nurseList = new ArrayList<Nurse>();
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public ArrayList<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(ArrayList<Nurse> nurseList) {
        this.nurseList = nurseList;
    }

    
    
}
