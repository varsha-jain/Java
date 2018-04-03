/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkingDays;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class WorkingDaysList {
    private ArrayList<WorkingDays> workingDaysList;

    public WorkingDaysList() {
        workingDaysList = new ArrayList<WorkingDays>();
    }

    public ArrayList<WorkingDays> getWorkingDaysList() {
        return workingDaysList;
    }

    public void setWorkingDaysList(ArrayList<WorkingDays> workingDaysList) {
        this.workingDaysList = workingDaysList;
    }
    public WorkingDays addWorkingDays()
    {
        WorkingDays wd = new WorkingDays();
        workingDaysList.add(wd);
        return wd;
    }
    
}
