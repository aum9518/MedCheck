package medCheck.service;

import medCheck.model.Patient;

import java.util.List;
import java.util.Map;

public interface PatientService {
    String addPatientToHospital(Long id, Patient patient);
    String addPatientsToHospital(Long id,List<Patient> patients);
    String updatePatientById(Long id, Patient patientsNewInfo);
    void removePatientById(Long id);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge();
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
