/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.city;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Nirali Merchant
 */
public class City {
    private String name;
    private EnterpriseDirectory enterprizeDirectory;

    public City() {
        enterprizeDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterprizeDirectory() {
        return enterprizeDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
    
}

