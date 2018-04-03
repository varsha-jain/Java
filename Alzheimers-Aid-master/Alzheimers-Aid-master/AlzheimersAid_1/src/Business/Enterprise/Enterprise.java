/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Patient.PatientDirectory;
import Business.PatientFamily.PatientFamilyDirectory;
import Business.State.State;
import Business.city.City;

/**
 *
 * @author varsha
 */
public abstract class Enterprise extends Organization {
    private  EnterprizeType enterprizeType;
    private OrganizationDirectory organizationDirectory;
    
    
    public enum EnterprizeType
    {
        Hospital("Hospital"),
        Association("Association"),
        SafetyCenter("Safety Center");
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        private EnterprizeType(String value)
        {
            this.value = value;
        }
        @Override
        public String toString() {
            return value;
        }
        
    }

    public EnterprizeType getEnterprizeType() {
        return enterprizeType;
    }

    public void setEnterprizeType(EnterprizeType enterprizeType) {
        this.enterprizeType = enterprizeType;
    }
    
    public Enterprise(String name, EnterprizeType enterprizeType)
    {
        super(name);
        this.enterprizeType = enterprizeType;
        organizationDirectory = new OrganizationDirectory();
      
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
    
    
    
}
