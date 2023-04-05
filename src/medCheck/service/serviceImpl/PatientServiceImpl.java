package medCheck.service.serviceImpl;

import medCheck.dao.impl.PatientServiceImplDao;
import medCheck.database.Database;
import medCheck.model.Hospital;
import medCheck.model.Patient;
import medCheck.service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService {
   // public Database database;
    Database database=new Database();


    PatientServiceImplDao patientServiceImplDao = new PatientServiceImplDao();

 /*   public PatientServiceImpl(Database database) {
        this.database = database;
    }*/

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        database.setHospitals(new ArrayList<>());
        return patientServiceImplDao.addPatientToHospital(id,patient);
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {

        return patientServiceImplDao.addPatientsToHospital(id,patients);
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {

        return patientServiceImplDao.updatePatientById(id,patientsNewInfo);
    }

    @Override
    public void removePatientById(Long id) {
        patientServiceImplDao.removePatientById(id);
    }

    @Override
    public Patient getPatientById(Long id) {

        return patientServiceImplDao.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {

        return patientServiceImplDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {

        return patientServiceImplDao.sortPatientsByAge(ascOrDesc);
    }
}
