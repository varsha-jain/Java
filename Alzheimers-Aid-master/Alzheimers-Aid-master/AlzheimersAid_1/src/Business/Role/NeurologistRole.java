/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NeurologistOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.neurologistRole.NeurologistWorkAreaJPanel;

/**
 *
 * @author varsha
 */
public class NeurologistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new NeurologistWorkAreaJPanel(userProcessContainer, account, (NeurologistOrganization)organization, enterprise, business);
    }
    @Override
    public String toString() {
        return "Neurologist Role";
    }
    
}
