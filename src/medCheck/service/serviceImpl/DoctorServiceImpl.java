package medCheck.service.serviceImpl;

import medCheck.dao.impl.DoctorServiceImplDao;
import medCheck.model.Doctor;
import medCheck.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DoctorServiceImplDao doctorServiceImplDao = new DoctorServiceImplDao();
    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {

        return doctorServiceImplDao.addDoctorToHospital(id,doctor);
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorServiceImplDao.findDoctorById(id);
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        return doctorServiceImplDao.updateDoctor(id,doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorServiceImplDao.deleteDoctorById(id);

    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorServiceImplDao.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorServiceImplDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorServiceImplDao.getAllDoctorsByDepartmentId(id);
    }
}
