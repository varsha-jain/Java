/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.State.State;
import Business.city.City;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterprizeList;

    public EnterpriseDirectory() {
        enterprizeList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterprizeList() {
        return enterprizeList;
    }

    public void setEnterprizeList(ArrayList<Enterprise> enterprizeList) {
        this.enterprizeList = enterprizeList;
    }
    
    public Enterprise createAndAddEnterprize(String name, Enterprise.EnterprizeType type)
    {
        Enterprise enterprize = null;
        if(type == Enterprise.EnterprizeType.Hospital)
        {
            enterprize = new HospitalEnterprise(name);
            enterprizeList.add(enterprize);
            
        }
        if(type == Enterprise.EnterprizeType.Association)
        {
            enterprize = new AssociationEnterprise(name) ;
            enterprizeList.add(enterprize);
            
        }
        if(type == Enterprise.EnterprizeType.SafetyCenter)
        {
            enterprize = new SafetyCenter(name);
            enterprizeList.add(enterprize);
            
        }
        return enterprize;
    }
    
    public boolean checkIfEnterpriseIsUnique (State state, City city, Enterprise.EnterprizeType type, String name)
    {
        boolean isUniqueEnterprise = true;
        
        for (Enterprise enterprise : city.getEnterprizeDirectory().getEnterprizeList())
            
        {
            if(enterprise.getEnterprizeType().equals(type))
            {
               // if(enterprise.getName().equalsIgnoreCase(name))
               // {
                    isUniqueEnterprise = false;
                    break;
                    
                }
                else
                {
                    isUniqueEnterprise = true;
                }
            }
         return isUniqueEnterprise;
        }
        
       
    }
    
    
    

