/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.State.State;
import Business.city.City;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role, EcoSystem system){
    // if(!username.equalsIgnoreCase("sysadmin"))
      boolean uniqueUserName = true;
      /* if(!username.equalsIgnoreCase("sysadmin"))
       {
         uniqueUserName = checkIfUsernameIsUnique(username, system);
       }*/
       // if (uniqueUserName!=false)
        //{
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        //userAccount.setEnterpriseType(username);
        userAccountList.add(userAccount);
        return userAccount;
       // }
       /* else
        {
            JOptionPane.showMessageDialog(null, "Username already exists", "Warning", JOptionPane.WARNING_MESSAGE);            
            return null;
        }*/
     
    }
    
    public boolean checkIfUsernameIsUnique(String username, Organization organization){
       
        boolean isUniqueUserName = true;
        
        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
        {
            if(ua.getUsername().equalsIgnoreCase(username))
            {
                isUniqueUserName = false;
                        break;
            }
        }
        
        return isUniqueUserName;
        
    }
        
        
        
      /*  for (UserAccount ua : userAccountList){
            String usernameTemp = ua.getUsername();
            if (ua.getUsername().equalsIgnoreCase(username))
                return false;
        }
        
        return true;
        boolean uniqueUserName = true;
          for (State state : system.getStateList())
          {
              for (City city : state.getCityList())
              {
                  for(Enterprise enterprise : city.getEnterprizeDirectory().getEnterprizeList())
                  {
                      for( UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList())
                      {
                         if (ua.getUsername().equalsIgnoreCase(username))
                         
                         {
                             uniqueUserName = false;
                             break;
                         }
                         else
                         {
                             uniqueUserName = true;
                         }
                          
                         
                         
                     }

                      if(enterprise.getUserAccountDirectory().getUserAccountList().size() == 0)
                      {
                          uniqueUserName = true;
                      }
                      //if(!uniqueUserName)

                    if(uniqueUserName==false)

                          break;
                  }
                  if(uniqueUserName==false)
                      break;
             }
              if(uniqueUserName==false)
                  break;
         }
          
          return uniqueUserName;
    */
    
}  

    
          
