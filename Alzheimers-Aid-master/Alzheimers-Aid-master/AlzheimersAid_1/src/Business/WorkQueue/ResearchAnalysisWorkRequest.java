/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class ResearchAnalysisWorkRequest extends WorkRequest{
    
    private String analysisResult;
    private String criteria;

    public String getTestResult() {
        return analysisResult;
    }

    public void setTestResult(String testResult) {
        this.analysisResult = testResult;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
    
}

        
    

