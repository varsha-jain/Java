/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Date;


import java.util.Date;

/**
 *
 * @author varsha
 */
public class Time {
    private Date time_taken;

    public Time() {
        time_taken = new Date();
    }

    public Date getTime_taken() {
        return time_taken;
    }

    public void setTime_taken(Date time_taken) {
        this.time_taken = time_taken;
    }

    @Override
    public String toString() {
        return String.valueOf(time_taken);
    }

    
    
}
