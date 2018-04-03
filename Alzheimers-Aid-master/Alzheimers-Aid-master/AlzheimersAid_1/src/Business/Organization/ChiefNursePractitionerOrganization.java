/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ChiefNursePractitionerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class ChiefNursePractitionerOrganization extends Organization{
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ChiefNursePractitionerRole());
        return roles;
    }
    public ChiefNursePractitionerOrganization()
    {
        super(Organization.Type.HiringManager.getValue());
    }
}
