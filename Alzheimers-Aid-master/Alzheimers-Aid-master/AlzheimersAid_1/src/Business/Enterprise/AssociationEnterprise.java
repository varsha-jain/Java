/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Patient.PatientDirectory;
import Business.PatientFamily.PatientFamilyDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Nirali Merchant
 */
public class AssociationEnterprise extends Enterprise {

   
 @Override
    public ArrayList<Role> getSupportedRole() {
      return null;
    }

    public AssociationEnterprise(String name) {
        super(name, EnterprizeType.Association);
         
    }

    

    
}
