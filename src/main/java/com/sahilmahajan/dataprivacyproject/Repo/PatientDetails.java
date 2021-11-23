package com.sahilmahajan.dataprivacyproject.Repo;

import com.mongodb.MongoClientException;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sahilmahajan.dataprivacyproject.Connections.MongoDB;
import com.sahilmahajan.dataprivacyproject.Utils.NewPatientDetails;
import org.bson.Document;
import org.bson.types.ObjectId;

public class PatientDetails {

    private String Database = "Data-Privacy-Project";
    private String Collection = "InternalUserDetails";

    MongoDB mongoDB = new MongoDB();

    //Getting new MRN
    public int NewUserMRN() {

        int MRN = 0;

        try {
            MongoDB.Connect(Database, Collection);

            Document GetMRN = mongoDB.getcollection().find(Filters.eq("_id", new ObjectId("6188b0eb946bd2e9886bb374"))).first();

            MRN = GetMRN.getInteger("Count");

            mongoDB.getcollection().updateOne(Filters.eq("_id", new ObjectId("6188b0eb946bd2e9886bb374")),
                    Updates.set("Count", GetMRN.getInteger("Count") + 1));

            return MRN;
        } catch (MongoClientException mongoClientException) {
            return -1;
        }
    }

    //Internal Use
    public boolean InsertPatientDetails(int MRN, NewPatientDetails newPatientDetails) {
        try {
            MongoDB.Connect(Database, Collection);

            Document NewPatientDetails = new Document("MRN", MRN)
                    .append("Name", newPatientDetails.getFullName())
                    .append("DOB", newPatientDetails.getDOB())
                    .append("Age", newPatientDetails.getAge())
                    .append("MaritalStatus", newPatientDetails.getMaritalStatus())
                    .append("Occupation", newPatientDetails.getOccupation())
                    .append("PinCode", newPatientDetails.getPinCode())
                    .append("PhoneNumber", newPatientDetails.getPhoneNumber())
                    .append("EmailID", newPatientDetails.getEmailID())
                    .append("EmergencyContact_Name", newPatientDetails.getEmergencyContact_FullName())
                    .append("EmergencyContact_Relation", newPatientDetails.getEmergencyContact_Relation())
                    .append("EmergencyContact_PhoneNumber", newPatientDetails.getEmergencyContact_PhoneNumber())
                    .append("ConsultantDoctor_Name", newPatientDetails.getConsultantDoctor_Name());

            mongoDB.getcollection().insertOne(NewPatientDetails);

            return true;
        } catch (MongoClientException mongoClientException) {
            return false;
        }
    }

    //External Use
    public boolean InsertExternalUsePatientDetails(String MRN, String Name, String Age, int PinCode) {
        try {
            MongoDB.Connect(Database, "ExternalUserData");

            Document PatientData = new Document("MRN", MRN)
                    .append("Name", Name)
                    .append("Age", Age)
                    .append("PinCode", PinCode);

            mongoDB.getcollection().insertOne(PatientData);

            return true;
        } catch (MongoClientException mongoClientException) {
            return false;
        }
    }
}
