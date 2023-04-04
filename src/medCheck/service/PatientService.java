package medCheck.service;

import medCheck.model.Patient;

import java.util.List;

public interface PatientService {
    void addPatientToHospital(String hospitalId, Patient patient);
    void addPatientsToHospital(String hospitalId, List<Patient> patients);
    void updatePatientById(String id, Patient patient);
    void removePatientById(String id);
    Patient getPatientById(String id);
    List<Patient> getPatientByAge(int age);
    List<Patient> sortPatientsByAge();
}
