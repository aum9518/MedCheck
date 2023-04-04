package medCheck.service.serviceImpl;

import medCheck.model.Doctor;
import medCheck.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    @Override
    public void addDoctorToHospital(String hospitalId, Doctor doctor) {

    }

    @Override
    public Doctor findDoctorById(String id) {
        return null;
    }

    @Override
    public void updateDoctor(String id, Doctor doctor) {

    }

    @Override
    public void deleteDoctorById(String id) {

    }

    @Override
    public void assignDoctorToDepartment(String doctorId, String departmentId) {

    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(String hospitalId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(String departmentId) {
        return null;
    }
}
