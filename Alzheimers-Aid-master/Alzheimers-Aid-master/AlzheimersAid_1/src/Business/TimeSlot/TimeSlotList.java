/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TimeSlot;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class TimeSlotList {
    private ArrayList<TimeSlot> timeSlotList;

    public TimeSlotList() {
        timeSlotList = new ArrayList<TimeSlot>();
    }

    
    public ArrayList<TimeSlot> getTimeSlotList() {
        return timeSlotList;
    }

    public void setTimeSlotList(ArrayList<TimeSlot> timeSlotList) {
        this.timeSlotList = timeSlotList;
    }
    public TimeSlot addTimeSlot()
    {
        TimeSlot timeSlot = new TimeSlot();
        timeSlotList.add(timeSlot);
        return timeSlot;
    }
}
