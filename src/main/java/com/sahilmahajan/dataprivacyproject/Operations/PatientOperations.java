package com.sahilmahajan.dataprivacyproject.Operations;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.sahilmahajan.dataprivacyproject.Repo.PatientDetails;
import com.sahilmahajan.dataprivacyproject.Utils.InPatientDetails;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class   PatientOperations {


    public static void main(String[] args) {

        InPatientDetails inPatientDetails = new InPatientDetails();
        Faker fake = new Faker();
        PatientDetails patientDetails = new PatientDetails();

        String FileName = "C:\\Users\\sahil\\Downloads\\MOCK_DATA.csv";

        try (CSVReader Reader = new CSVReader(new FileReader(FileName))) {
            List<String[]> Result = Reader.readAll();
            System.out.println(Arrays.toString(Result.get(0)));


            for (int i = 1; i < Result.size(); i++) {
                for (int k = 0; k < Result.get(i).length; k++) {


                    if (k == 0) {
                        inPatientDetails.setId(Result.get(i)[k]);
                    }
                    else if (k == 1) {
                        String nhs_token = UUID.randomUUID().toString();
                        inPatientDetails.setNhs_number(nhs_token);
                    }
                    else if (k == 2) {
                        inPatientDetails.setFirst_name("XXXXX");
                    }
                    else if (k == 3) {
                        inPatientDetails.setLast_name("XXXXX");
                    }
                    else if (k == 4) {
                        inPatientDetails.setEmail("XXXXX");
                    }
                    else if (k == 5) {
                        inPatientDetails.setGender(Result.get(i)[k]);
                    }
                    else if (k == 6) {
                        inPatientDetails.setPhone(fake.phoneNumber().phoneNumber());
                    }
                    else if (k == 7) {
                        inPatientDetails.setStreet("XXXXX");
                    }
                    else if (k == 8) {
                        inPatientDetails.setCity(Result.get(i)[k]);
                    }
                    else if (k == 9) {
                        inPatientDetails.setState(Result.get(i)[k]);
                    }
                    else if (k == 10) {
                        inPatientDetails.setCountry(Result.get(i)[k]);
                    }
                    else if (k == 11) {
                        inPatientDetails.setDiag_code(UUID.randomUUID().toString());
                    }
                    else if (k == 12) {
                        inPatientDetails.setDesc_short(Result.get(i)[k]);
                    }
                    else if (k == 13) {
                        inPatientDetails.setProc_code(UUID.randomUUID().toString());
                    }
                    else if (k == 14) {
                        inPatientDetails.setProc_short(Result.get(i)[k]);
                    }
                    else if (k == 15) {
                        inPatientDetails.setDrug_brand(Result.get(i)[k]);
                    }
                    else if (k == 16) {
                        inPatientDetails.setDrug_generic(Result.get(i)[k]);
                    }
                    else if (k == 17) {
                        inPatientDetails.setDrug_company(Result.get(i)[k]);
                    }
                }
                patientDetails.InsertPatientDetails(inPatientDetails);

            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}
