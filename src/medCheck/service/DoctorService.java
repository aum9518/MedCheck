package medCheck.service;

import medCheck.model.Doctor;

import java.util.List;

public interface DoctorService {
    void addDoctorToHospital(String hospitalId, Doctor doctor);
    Doctor findDoctorById(String id);
    void updateDoctor(String id, Doctor doctor);
    void deleteDoctorById(String id);
    void assignDoctorToDepartment(String doctorId, String departmentId);
    List<Doctor> getAllDoctorsByHospitalId(String hospitalId);
    List<Doctor> getAllDoctorsByDepartmentId(String departmentId);
}
