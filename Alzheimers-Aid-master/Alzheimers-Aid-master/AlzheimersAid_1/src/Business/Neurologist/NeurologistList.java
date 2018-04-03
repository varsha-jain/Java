/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Neurologist;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class NeurologistList {
    private ArrayList<Neurologist> neurologistList;

    
    public NeurologistList() {
        neurologistList = new ArrayList<Neurologist>();
        
    }

    public ArrayList<Neurologist> getNeurologistList() {
        return neurologistList;
    }

    public void setNeurologistList(ArrayList<Neurologist> neurologistList) {
        this.neurologistList = neurologistList;
    }
    public Neurologist addNeurologist()
    {
        Neurologist nu = new Neurologist();
        neurologistList.add(nu);
        return nu;
    }
    public boolean checkIfNeurologistIsUnique (Organization org, String  name)
    {
        boolean isUniqueNeurologist = true;
        for(Neurologist neuro : org.getNeuroList().neurologistList)
        {
            if(neuro.getName().equalsIgnoreCase(name))
            {
                isUniqueNeurologist = false;
            }
        }
        
    
     return isUniqueNeurologist;
}
}
