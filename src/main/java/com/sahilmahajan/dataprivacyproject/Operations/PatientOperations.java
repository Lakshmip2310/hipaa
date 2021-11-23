package com.sahilmahajan.dataprivacyproject.Operations;

import com.sahilmahajan.dataprivacyproject.Repo.PatientDetails;
import com.sahilmahajan.dataprivacyproject.Utils.NewPatientDetails;
import com.sahilmahajan.dataprivacyproject.Utils.SHA;

public class   PatientOperations {

    //For Internal Use
    public void NewUser(NewPatientDetails newPatientDetails) {

        PatientDetails patientDetails = new PatientDetails();

        //Generating MRN for patient
        int MRN = patientDetails.NewUserMRN();

        //Inserting Patient Details in DB
        System.out.println(patientDetails.InsertPatientDetails(MRN, newPatientDetails));


    }

    //For External Use
    public void PatientDetailsForExternalUse(int MRN, NewPatientDetails newPatientDetails) {

        SHA sha = new SHA();

        String SecureMRN = sha.Token(Integer.toString(MRN));
        newPatientDetails.setFullName("XXXXXX");

        String Age = "";
        if (newPatientDetails.getAge() < 18) {
            Age = "0-17";
        }
        else if (newPatientDetails.getAge() < 25) {
            Age = "18-24";
        }
        else if (newPatientDetails.getAge() < 35) {
            Age = "25-34";
        }
        else if (newPatientDetails.getAge() < 50) {
            Age = "35-49";
        }
        else if (newPatientDetails.getAge() >= 50) {
            Age = "50+";
        }

        PatientDetails patientDetails = new PatientDetails();
        patientDetails.InsertExternalUsePatientDetails(SecureMRN, newPatientDetails.getFullName(), Age, newPatientDetails.getPinCode());

    }

}
