package medCheck.dao.impl;

import medCheck.dao.PatientServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.List;
import java.util.Map;


public class PatientServiceImplDao implements PatientServiceDao {
    private Database database;
    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        boolean isTrue = true;
        for (Hospital d:database.getHospitals()) {
            if (d.getId()==id){
                isTrue = true;
                d.getPatients().add(patient);
            }else {
                isTrue = false;
            }
        }
        try{
            if (isTrue){
                return "Patient successfully added patient: "+patient;
            }else {
                throw new MyException("Not found hospital");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return null;
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return null;
    }

    @Override
    public void removePatientById(Long id) {

    }

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return null;
    }
}
