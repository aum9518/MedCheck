package medCheck.dao.impl;

import medCheck.dao.DepartmentServiceDao;
import medCheck.dao.DoctorServiceDao;
import medCheck.dao.HospitalServiceDao;
import medCheck.database.Database;
import medCheck.model.Department;
import medCheck.model.Doctor;
import medCheck.model.Hospital;
import medCheck.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DoctorServiceImplDao implements DoctorServiceDao {
    Database database = new Database();
    List<Hospital>hospitals;
    Map<Long,Doctor>doctors;


    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {

        Hospital hospital = database.getHospitals().stream()
                .filter(h -> h.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (hospital == null) {
            return "Hospital not found!";
        }
        doctor.setId(doctor.getId());
        hospital.getDoctors().add(doctor);
        doctors.put(doctor.getId(), doctor);
        return "Doctor added to hospital successfully.";
    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctors.get(id);
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {
        if (!doctors.containsKey(id)) {
            return "Doctor not found!";
        }
        doctor.setId(id);
        doctors.put(id, doctor);
        return "Doctor updated successfully.";
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctors.remove(id);
        database.getHospitals().stream()
                .flatMap(h -> h.getDepartments().stream())
                .forEach(d -> d.getDoctors().removeIf(doc -> doc.getId().equals(id)));

    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        Department department = database.getHospitals().stream()
                .flatMap(h -> h.getDepartments().stream())
                .filter(d -> d.getId().equals(departmentId))
                .findFirst()
                .orElse(null);
        if (department == null) {
            return "Department not found!";
        }
        List<Doctor> doctorsToAdd = doctorsId.stream()
                .map(doctorId -> doctors.get(doctorId))
                .toList();
        department.getDoctors().addAll(doctorsToAdd);
        return "Doctors assigned to department successfully.";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return database.getHospitals().stream()
                .filter(h -> h.getId().equals(id))
                .flatMap(h -> h.getDoctors().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {

        return database.getHospitals().stream()
                .flatMap(h -> h.getDepartments().stream())
                .filter(d -> d.getId().equals(id))
                .flatMap(d -> d.getDoctors().stream())
                .collect(Collectors.toList());
    }
}
