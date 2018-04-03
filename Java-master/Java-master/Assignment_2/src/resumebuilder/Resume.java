/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resumebuilder;

/**
 *
 * @author varsha
 */
public class Resume {
   private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String state;
    private String addressLine1;
    private String addressLine2;
    private int zipCode;
    private String affiliation;
    private String careerObjective;
    private String skills;
    private String achievements;
    private String projects;
    private String participations;
    private String experience;
    private String certifictions;
    private String path;
    private String gender;
    private double cgpa;
    private String university;
    private String degreeName;
    private int year;
        
    private String degreeName2;
    private String uniName2;
    private int year2;
    private double cgp2;
    //private Education degree1;
    //private Education degree2;
    private String Nationality;
    private String type;
    private String email;
    private Long contact;

    public String getDegreeName2() {
        return degreeName2;
    }

    public void setDegreeName2(String degreeName2) {
        this.degreeName2 = degreeName2;
    }

    public String getUniName2() {
        return uniName2;
    }

    public void setUniName2(String uniName2) {
        this.uniName2 = uniName2;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public double getCgp2() {
        return cgp2;
    }

    public void setCgp2(double cgp2) {
        this.cgp2 = cgp2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }
    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /*public Resume()
    {
        degree1= new Education();
        degree2=new Education();
        
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city+",";
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state+",";
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressLine1() {
        return addressLine1+",";
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2+",";
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getParticipations() {
        return participations;
    }

    public void setParticipations(String participations) {
        this.participations = participations;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCertifictions() {
        return certifictions;
    }

    public void setCertifictions(String certifictions) {
        this.certifictions = certifictions;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

 /*   public Education getDegree1() {
        return degree1;
    }

    public void setDegree1(Education degree1) {
        this.degree1 = degree1;
    }

    public Education getDegree2() {
        return degree2;
    }

    public void setDegree2(Education degree2) {
        this.degree2 = degree2;
    }
*/
     public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
   public String toString()
   {
       return this.firstName;
   }
}
