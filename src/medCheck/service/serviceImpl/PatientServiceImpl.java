package medCheck.service.serviceImpl;

import medCheck.model.Patient;
import medCheck.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    @Override
    public void addPatientToHospital(String hospitalId, Patient patient) {

    }

    @Override
    public void addPatientsToHospital(String hospitalId, List<Patient> patients) {

    }

    @Override
    public void updatePatientById(String id, Patient patient) {

    }

    @Override
    public void removePatientById(String id) {

    }

    @Override
    public Patient getPatientById(String id) {
        return null;
    }

    @Override
    public List<Patient> getPatientByAge(int age) {
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge() {
        return null;
    }
}
