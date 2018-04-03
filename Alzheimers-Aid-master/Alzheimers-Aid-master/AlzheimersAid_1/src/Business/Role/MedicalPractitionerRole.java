/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CareGiverOrganization;
import Business.Organization.NeurologistOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Organization.MedicalPractitionerOrganization;

import javax.swing.JPanel;
import userinterface.medicalPractitioner.MedicalPractitionerWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class MedicalPractitionerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
      return new MedicalPractitionerWorkAreaJPanel(userProcessContainer, account, (MedicalPractitionerOrganization)organization, enterprise, business);
    }

    @Override
    public String toString() {
        return "MedicalPractitioner Role";
    } 
    
    
}
