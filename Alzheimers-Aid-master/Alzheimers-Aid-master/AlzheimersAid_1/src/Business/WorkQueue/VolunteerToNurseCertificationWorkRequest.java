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
public class VolunteerToNurseCertificationWorkRequest extends WorkRequest {
    
    private String certificationCompleted;

    public String getTestResult() {
        return certificationCompleted;
    }

    public void setTestResult(String certificationStatus) {
        this.certificationCompleted = certificationStatus;
    }
    
}
