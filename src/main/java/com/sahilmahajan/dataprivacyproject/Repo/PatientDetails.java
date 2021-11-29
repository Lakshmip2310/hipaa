package com.sahilmahajan.dataprivacyproject.Repo;

import com.mongodb.MongoClientException;
import com.sahilmahajan.dataprivacyproject.Connections.MongoDB;
import com.sahilmahajan.dataprivacyproject.Utils.InPatientDetails;
import org.bson.Document;

public class PatientDetails {

    private String Database = "Data-Privacy-Project";
    private String Collection = "PatientDetails";

    MongoDB mongoDB = new MongoDB();

    public boolean InsertPatientDetails(InPatientDetails inPatientDetails) {
        try {
            MongoDB.Connect(Database, Collection);

            Document NewPatientDetails = new Document("id", inPatientDetails.getId())
                    .append("NHS_Number", inPatientDetails.getNhs_number())
                    .append("First_Name", inPatientDetails.getFirst_name())
                    .append("Last_Name", inPatientDetails.getLast_name())
                    .append("Email", inPatientDetails.getEmail())
                    .append("Gender", inPatientDetails.getGender())
                    .append("Phone", inPatientDetails.getPhone())
                    .append("Street", inPatientDetails.getStreet())
                    .append("City", inPatientDetails.getCity())
                    .append("State", inPatientDetails.getState())
                    .append("Country", inPatientDetails.getCountry())
                    .append("Diag_Code", inPatientDetails.getDiag_code())
                    .append("Desc_Short", inPatientDetails.getDesc_short())
                    .append("Proc_Code", inPatientDetails.getProc_code())
                    .append("Proc_Short", inPatientDetails.getProc_short())
                    .append("Drug_Brand", inPatientDetails.getDrug_brand())
                    .append("Drug_Generic", inPatientDetails.getDrug_generic())
                    .append("Drug_Company", inPatientDetails.getDrug_company());

            mongoDB.getcollection().insertOne(NewPatientDetails);

            return true;
        } catch (MongoClientException mongoClientException) {
            return false;
        }
    }

}
