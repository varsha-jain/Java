/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Nurse;

import Business.Neurologist.Neurologist;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class NurseList {
    private ArrayList<Nurse> nurseList;

    public NurseList() {
        nurseList = new ArrayList<Nurse>();
    }

    public ArrayList<Nurse> getNurseList() {
        return nurseList;
    }

    public void setNurseList(ArrayList<Nurse> nurseList) {
        this.nurseList = nurseList;
    }
    public Nurse addNurse()
    {
        Nurse nurse = new Nurse();
        nurseList.add(nurse);
        return nurse;
    }
    public boolean checkIfNurseIsUnique (Organization org, String  name)
    {
        boolean isUniqueNeurologist = true;
        for(Nurse nurse : org.getNurseList().getNurseList())
        {
            if(nurse.getNurseName().equalsIgnoreCase(name))
            {
                isUniqueNeurologist = false;
            }
        }
        
    
     return isUniqueNeurologist;
}
}
