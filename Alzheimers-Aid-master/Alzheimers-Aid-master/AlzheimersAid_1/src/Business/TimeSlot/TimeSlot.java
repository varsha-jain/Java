/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TimeSlot;

import Business.Date.Time;

/**
 *
 * @author varsha
 */
public class TimeSlot {
    private String  time;    
    private boolean iSlotAvailable;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isiSlotAvailable() {
        return iSlotAvailable;
    }

    public void setiSlotAvailable(boolean iSlotAvailable) {
        this.iSlotAvailable = iSlotAvailable;
    }
    
    
    
    
    
}
