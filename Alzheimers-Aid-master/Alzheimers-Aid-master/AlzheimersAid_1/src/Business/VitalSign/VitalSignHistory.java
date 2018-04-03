/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.VitalSign;

import static Business.Organization.Organization.Type.Patient;
import Business.Role.PatientRole;
import static Business.Role.Role.RoleType.Patient;
import java.util.ArrayList;
import Business.VitalSign.VitalSigns;

/**
 *
 * @author Nirali Merchant
 */
public class VitalSignHistory {
    
    private ArrayList <VitalSigns> vitalSignHistory;
    
    public VitalSignHistory()
    {
        vitalSignHistory = new ArrayList<VitalSigns>();
       
    }

    

    public ArrayList<VitalSigns> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSigns> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    public VitalSigns addVitalSigns() {
     
        VitalSigns vitalSigns  = new VitalSigns();
        vitalSignHistory.add(vitalSigns);
        return vitalSigns;
        
    }
    
    public void removeVitalSigns(VitalSigns vitalSigns)
    {
        vitalSignHistory.remove(vitalSigns);
    }
    
    
}
