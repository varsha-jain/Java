/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Nirali Merchant
 */
public class VolunteerMedicalPracWorkRequest extends WorkRequest{
    
    private String analysisResult;

    public String getTestResult() {
        return analysisResult;
    }

    public void setTestResult(String testResult) {
        this.analysisResult = testResult;
    }
    
    

}
