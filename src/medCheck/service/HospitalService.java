package medCheck.service;

import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.List;

public interface HospitalService {
    void addHospital(Hospital hospital);
    Hospital findHospitalById(String id);
    List<Hospital> getAllHospitals();
    List<Patient> getAllPatientFromHospital(String hospitalId);
    void deleteHospitalById(String id);
    List<Hospital> getAllHospitalByAddress(String address);

}

