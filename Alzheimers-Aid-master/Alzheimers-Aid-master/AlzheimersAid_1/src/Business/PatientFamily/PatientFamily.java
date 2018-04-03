/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientFamily;

import Business.Patient.Patient;

/**
 *
 * @author varsha
 */
public class PatientFamily {
    private Patient patient;
    private String memberName;
    private String relaionship;
    private int Contact;
    public PatientFamily() {
        patient = new Patient();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getRelaionship() {
        return relaionship;
    }

    public void setRelaionship(String relaionship) {
        this.relaionship = relaionship;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int Contact) {
        this.Contact = Contact;
    }
    
    
    
}
