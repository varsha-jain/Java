/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.State.State;
import java.util.ArrayList;
        
/**
 *
 * @author Nirali Merchant
 */
public class EcoSystem extends Organization
{

    private static EcoSystem business;
    private ArrayList<State> stateList ;
    
    
    private EcoSystem()
    {
       super(null);
       stateList = new ArrayList<State>();
    }

    public ArrayList<State> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<State> stateList) {
        this.stateList = stateList;
    }
    
    public static EcoSystem getInstance()
    {
        if(business == null)
        {
            business = new EcoSystem();
        }
        return business;
    }
    
    
    public State createAndAddState()
    {
        State state = new State();
        stateList.add(state);
        return state;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList  = new ArrayList();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    
    
   /* public boolean checkIfUserNameIsUnique(String userName)
    {
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
        {
            return false;
        }
        for(Network network : networkList)
        {
            
        }
        return true;
    }*/
}
