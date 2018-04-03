/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Enterprise.Enterprise;
import Business.State.State;
import Business.city.City;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    
    
    
     public boolean checkIfEmployeeIsUnique (Enterprise enterprise, String  name)
    {
        boolean isUniqueEmployee = true;
        
        for (Employee employee : enterprise.getEmployeeDirectory().getEmployeeList())
            
        {
            
            isUniqueEmployee = false;
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
    
     return isUniqueEmployee;
}
}