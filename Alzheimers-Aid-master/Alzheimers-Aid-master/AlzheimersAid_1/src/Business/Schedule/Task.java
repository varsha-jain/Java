/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Schedule;

import Business.Date.Time;
import Business.Medicine.Medicine;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author varsha
 */
public class Task {
    private Time scheduledDateTime;
    private String taskName;
    private Medicine medicine;

    public Task() {
    scheduledDateTime = new Time();
    medicine = new Medicine();
    }

    public Time getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Time scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
}
