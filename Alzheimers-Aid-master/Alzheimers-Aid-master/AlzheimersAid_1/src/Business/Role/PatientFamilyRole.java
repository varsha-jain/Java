/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.PatientFamily;
import Business.Organization.PatientFamilyOrganization;
import static Business.Role.Role.RoleType.PatientFamily;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.patientFamilyRole.PatientFamilyWorkAreaJPanel;

/**
 *
 * @author Nirali Merchant
 */
public class PatientFamilyRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PatientFamilyWorkAreaJPanel(userProcessContainer, account, (PatientFamilyOrganization)organization, enterprise, business);
    }
    @Override
    public String toString() {
        return "PatientFamily Role";
    }
    
    
}
