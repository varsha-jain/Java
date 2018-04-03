/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Caregiver;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class CaregiverList {
    private ArrayList<Caregiver> caregiverList;

    public CaregiverList() {
        caregiverList = new ArrayList<Caregiver>();
    }

    public ArrayList<Caregiver> getCaregiverList() {
        return caregiverList;
    }

    public void setCaregiverList(ArrayList<Caregiver> caregiverList) {
        this.caregiverList = caregiverList;
    }
    
    public Caregiver addCaregiver()
    {
        Caregiver cg = new Caregiver();
        caregiverList.add(cg);
        return cg;
    }
}
