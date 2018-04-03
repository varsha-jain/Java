/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CareGiverRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class CareGiverOrganization extends Organization {

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList(); 
       roles.add(new CareGiverRole());
        return roles;
    }

    public CareGiverOrganization() {
      super(Organization.Type.Caregiver.getValue());
    }
    
    
    
}
