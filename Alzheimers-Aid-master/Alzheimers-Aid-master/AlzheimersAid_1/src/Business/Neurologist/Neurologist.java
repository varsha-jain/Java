/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Neurologist;

import Business.TimeSlot.TimeSlotList;
import Business.WorkingDays.WorkingDays;
import Business.WorkingDays.WorkingDaysList;
import Business.city.City;

/**
 *
 * @author varsha
 */
public class Neurologist {
    private String name;
    private String degree;
    private int age;
    private int yearsExp;
    private City city;
    private TimeSlotList timeslotList;
    private WorkingDaysList workingDaysList;
    
    public Neurologist() {
        city = new City();
        timeslotList = new TimeSlotList();
        workingDaysList = new WorkingDaysList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearsExp() {
        return yearsExp;
    }

    public void setYearsExp(int yearsExp) {
        this.yearsExp = yearsExp;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public TimeSlotList getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(TimeSlotList timeslotList) {
        this.timeslotList = timeslotList;
    }

    public WorkingDaysList getWorkingDaysList() {
        return workingDaysList;
    }

    public void setWorkingDaysList(WorkingDaysList workingDaysList) {
        this.workingDaysList = workingDaysList;
    }

    
    
}
