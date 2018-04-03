/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Nurse;

/**
 *
 * @author varsha
 */
public class Nurse {
    private String nurseName;
    private int noOfYearsExp;
    private String pastExp;
    private String eduQuaifications;
    private String contact;
    private boolean availability;

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public int getNoOfYearsExp() {
        return noOfYearsExp;
    }

    public void setNoOfYearsExp(int noOfYearsExp) {
        this.noOfYearsExp = noOfYearsExp;
    }

    public String getPastExp() {
        return pastExp;
    }

    public void setPastExp(String pastExp) {
        this.pastExp = pastExp;
    }

    public String getEduQuaifications() {
        return eduQuaifications;
    }

    public void setEduQuaifications(String eduQuaifications) {
        this.eduQuaifications = eduQuaifications;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return  nurseName;
    }

    
    
    
}
