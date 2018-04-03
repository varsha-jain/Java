/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CareGiverOrganization;
import Business.Organization.ChiefNursePractitionerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import userinterface.hiringManager.ChiefNursePractitionerWorkAreaJPanel;

/**
 *
 * @author varsha
 */
public class ChiefNursePractitionerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
      //add p anel
      return new ChiefNursePractitionerWorkAreaJPanel(userProcessContainer, account, (ChiefNursePractitionerOrganization)organization, enterprise, business);
    }
    @Override
    public String toString() {
       // return "ChiefNursePractitionerRole";
       return "HiringManagerRole";
    }
    
}
