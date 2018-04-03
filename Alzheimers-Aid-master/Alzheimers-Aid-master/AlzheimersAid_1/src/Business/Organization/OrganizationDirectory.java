/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Neurologist.getValue())){
            organization = new NeurologistOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.Nurse.getValue())){
            organization = new NurseOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.Caregiver.getValue())){
            organization = new CareGiverOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.HiringManager.getValue())){
            organization = new ChiefNursePractitionerOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.MedicalPractitioner.getValue())){
            organization = new MedicalPractitionerOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.PatientFamily.getValue())){
            organization = new PatientFamilyOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.Researcher.getValue())){
            organization = new ResearcherOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        }
      
        return organization;
    }
    
    
    public boolean checkIfOrganizationIsUnique (Type type, Enterprise enterprise)
    {
        boolean isUniqueOrganization = true;
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList() )
            
        {
            if(type.getValue().equalsIgnoreCase(organization.getName()))
            isUniqueOrganization = false;
        /*    if(employee.getName().equalsIgnoreCase(name))
            {
               // if(enterprise.getName().equalsIgnoreCase(name))
               // {
                    isUniqueEmployee = false;
                    break;
                    
                }
                else
                {
                    isUniqueEmployee = true;
                }
            }*/
        
        }
    
     return isUniqueOrganization;
}
    
    
    
    
    
    
}