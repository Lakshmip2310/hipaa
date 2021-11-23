package com.sahilmahajan.dataprivacyproject.Utils;

public class NewPatientDetails {

    private String FullName;
    private String DOB;
    private int Age;
    private String MaritalStatus;
    private String Occupation;
    private int PinCode;
    private long PhoneNumber;
    private String EmailID;
    private String EmergencyContact_FullName;
    private String EmergencyContact_Relation;
    private long EmergencyContact_PhoneNumber;
    private String ConsultantDoctor_Name;

    public String getEmailID() {
        return EmailID;
    }

    public void setEmailID(String emailID) {
        EmailID = emailID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public int getPinCode() {
        return PinCode;
    }

    public void setPinCode(int pinCode) {
        PinCode = pinCode;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmergencyContact_FullName() {
        return EmergencyContact_FullName;
    }

    public void setEmergencyContact_FullName(String emergencyContact_FullName) {
        EmergencyContact_FullName = emergencyContact_FullName;
    }

    public String getEmergencyContact_Relation() {
        return EmergencyContact_Relation;
    }

    public void setEmergencyContact_Relation(String emergencyContact_Relation) {
        EmergencyContact_Relation = emergencyContact_Relation;
    }

    public long getEmergencyContact_PhoneNumber() {
        return EmergencyContact_PhoneNumber;
    }

    public void setEmergencyContact_PhoneNumber(long emergencyContact_PhoneNumber) {
        EmergencyContact_PhoneNumber = emergencyContact_PhoneNumber;
    }

    public String getConsultantDoctor_Name() {
        return ConsultantDoctor_Name;
    }

    public void setConsultantDoctor_Name(String consultantDoctor_Name) {
        ConsultantDoctor_Name = consultantDoctor_Name;
    }
}
