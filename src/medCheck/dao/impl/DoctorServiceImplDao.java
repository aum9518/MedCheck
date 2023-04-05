package medCheck.dao.impl;

import medCheck.dao.DoctorServiceDao;
import medCheck.dao.HospitalServiceDao;
import medCheck.database.Database;
import medCheck.model.Doctor;
import medCheck.model.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DoctorServiceImplDao implements DoctorServiceDao {

    List<Database>databases;
    Map<Long,Doctor>doctors;

    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        HospitalServiceDao hospitalDao = new HospitalServiceImplDao();
        Hospital hospital = hospitalDao.findHospitalById(id);
        if (hospital != null) {
            hospital.getDoctors().add(doctor);
            doctors.put(doctor.getId(), doctor);
            return "Doctor added to hospital successfully";
        } else {
            return "Hospital not found";
        }
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctors.remove(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {

       return null;
    }
}
