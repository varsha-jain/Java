/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Caregiver.Caregiver;
import Business.Neurologist.Neurologist;
import static Business.Organization.Organization.Type.Caregiver;
import Business.Schedule.TaskList;
import Business.VitalSign.VitalSignHistory;
import Business.city.City;
import java.util.Date;

/**
 *
 * @author varsha
 */
public class Patient {
    private VitalSignHistory vsh;   
    private TaskList taskList;
    private String gender;
    private String sourceLocation;
    private int age;
    private String name;
    private Caregiver careGiver;
    private String  city;
    private Neurologist neurologist;
    private String ethnicity;
    private String memoryProblem;
    boolean balanceProblem;
    boolean majorStroke;
    boolean sadCurrentMood;
    boolean everydayActivityProblem ;
    private String birthMonth;
   // private int birthDate;
  //  private int birthYear;
    private String birthDate;
    private String birthYear;
    private int sageTestScore;
    private boolean earlyAlzhimers;
    private boolean moderateAlzhimers;
      private boolean highAlzhiemers;
    private String riskofFallScore;
    private String riskFallPriority;
    private String state;
    private String addressline1;
    private int pincode;

    private Date dateRegistered;

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
    

    private String mood;

    public Patient() {
        vsh = new VitalSignHistory();
        taskList = new TaskList();
        careGiver = new Caregiver();
       // city = new City();
        neurologist = new Neurologist();
    }

    public Caregiver getCareGiver() {
        return careGiver;
    }

    public void setCareGiver(Caregiver careGiver) {
        this.careGiver = careGiver;
    }

    public VitalSignHistory getVsh() {
        return vsh;
    }

    public void setVsh(VitalSignHistory vsh) {
        this.vsh = vsh;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getMemoryProblem() {
        return memoryProblem;
    }

    public void setMemoryProblem(String memoryProblem) {
        this.memoryProblem = memoryProblem;
    }

    public boolean isBalanceProblem() {
        return balanceProblem;
    }

    public void setBalanceProblem(boolean balanceProblem) {
        this.balanceProblem = balanceProblem;
    }

    public boolean isMajorStroke() {
        return majorStroke;
    }

    public void setMajorStroke(boolean majorStroke) {
        this.majorStroke = majorStroke;
    }

    public boolean isSadCurrentMood() {
        return sadCurrentMood;
    }

    public void setSadCurrentMood(boolean sadCurrentMood) {
        this.sadCurrentMood = sadCurrentMood;
    }

    public boolean isEverydayActivityProblem() {
        return everydayActivityProblem;
    }

    public void setEverydayActivityProblem(boolean everydayActivityProblem) {
        this.everydayActivityProblem = everydayActivityProblem;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    

    public int getSageTestScore() {
        return sageTestScore;
    }

    public void setSageTestScore(int sageTestScore) {
        this.sageTestScore = sageTestScore;
    }

    public boolean isEarlyAlzhimers() {
        return earlyAlzhimers;
    }

    public void setEarlyAlzhimers(boolean earlyAlzhimers) {
        this.earlyAlzhimers = earlyAlzhimers;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    

    public Neurologist getNeurologist() {
        return neurologist;
    }

    public void setNeurologist(Neurologist neurologist) {
        this.neurologist = neurologist;
    }

    public String getRiskofFallScore() {
        return riskofFallScore;
    }

    public void setRiskofFallScore(String riskofFallScore) {
        this.riskofFallScore = riskofFallScore;
    }


    

    public String getRiskFallPriority() {
        return riskFallPriority;
    }

    public void setRiskFallPriority(String riskFallPriority) {
        this.riskFallPriority = riskFallPriority;
    }

    public boolean isModerateAlzhimers() {
        return moderateAlzhimers;
    }

    public void setModerateAlzhimers(boolean moderateAlzhimers) {
        this.moderateAlzhimers = moderateAlzhimers;
    }

    public boolean isHighAlzhiemers() {
        return highAlzhiemers;
    }

    public void setHighAlzhiemers(boolean highAlzhiemers) {
        this.highAlzhiemers = highAlzhiemers;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
    
    
    
    
    
    
    
    
    public String toString()
    {
        return name;
    }
    
    
    
    
    
    
    
    
    
    

}
