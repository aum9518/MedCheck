package medCheck.dao.impl;

import medCheck.dao.DepartmentServiceDao;
import medCheck.dao.DoctorServiceDao;
import medCheck.dao.HospitalServiceDao;
import medCheck.database.Database;
import medCheck.enums.Gender;
import medCheck.exception.MyException;
import medCheck.model.Department;
import medCheck.model.Doctor;
import medCheck.model.Hospital;
import medCheck.service.DepartmentService;

import javax.print.Doc;
import java.util.*;
import java.util.stream.Collectors;


public class DoctorServiceImplDao implements DoctorServiceDao {


  private Database database = new Database();

    public DoctorServiceImplDao(Database database) {
        this.database = database;
    }

    Department department1 = new Department(1L, "Physical medicine", new ArrayList<>(List.of(new Doctor(1L, "Amir", "Mirlanov", Gender.FEMALE, 1))));
    List<Department> depart = new ArrayList<>(List.of(department1));
    Hospital hospital1 = new Hospital(2L, "Republican Hospital No. 2", "Bishkek, st. Kyiv, 110", depart, new ArrayList<>(), new ArrayList<>());
    List<Hospital> hospitals = new ArrayList<>(List.of(hospital1));
    Database database = new Database(hospitals);


    @Override
    public String addDoctorToHospital(Long id, Doctor doctor) {
        try {
            for (Hospital h : database.getHospitals()) {
                if (Objects.equals(h.getId(), id)) {
                    h.getDoctors().add(doctor);
                    return "Doctor added to hospital successfully." + doctor;
                } else {
                    throw new MyException("ID not found!");
                }
            }
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
        return "Hospital not found!";
    }

    @Override
    public Doctor findDoctorById(Long id) {

        for (Hospital h : database.getHospitals()) {
            for (Doctor d : h.getDoctors()) {
                if (d.getId().equals(id)) {
                    return d;

        try {
            for (Hospital h : database.getHospitals()) {
                for (Doctor d : h.getDoctors()) {
                    if (d.getId().equals(id)) {
                        return d;
                    } else {
                        throw new MyException("ID not found! ");
                    }

                }
            }
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
        return null;
    }

    @Override
    public String updateDoctor(Long id, Doctor doctor) {

        for (Hospital h : database.getHospitals()) {
            for (Doctor d : h.getDoctors()) {
                if (d.getId() == id) {
                    d.setFirstName(doctor.getFirstName());

//                    h.getDoctors().remove(d);
//                    h.getDoctors().add(doctor);
                    return "Doctor updated successfully." + doctor;

        try {
            for (Hospital h : database.getHospitals()) {
                for (Doctor d : h.getDoctors()) {
                    if (h.getId().equals(id)) {
                        d.setFirstName(d.getFirstName());
                        d.setLastName(d.getLastName());
                        d.setGender(d.getGender());
                        d.setExperienceYear(d.getExperienceYear());
                        return "Doctor updated successfully." + doctor;
                    } else {
                        throw new MyException("ID not found!");
                    }

                }
            }
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
        return "Doctor not found!";
    }

    @Override
    public void deleteDoctorById(Long id) {
        try {
            boolean isTrue = true;
            for (Hospital h : database.getHospitals()) {
                for (Doctor d : h.getDoctors()) {
                    if (d.getId().equals(id)){
                        isTrue = true;
                        h.getDoctors().remove(d);
                        System.out.println("Doctor removed successfully");
                        break;
                    } else {
                        isTrue = false;
                    }
                }
            }
            if (!isTrue) {
                throw new MyException("Doctor not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {

        for (Hospital h : database.getHospitals()) {
            for (Department d : h.getDepartments()) {
                for (Doctor o : h.getDoctors()) {
                    if (d.getId() == departmentId) {

                        doctorsId.add(o.getId());
                        return "Doctor id added successfully" + doctorsId;

        try {
            for (Hospital h : database.getHospitals()) {
                for (Department d : h.getDepartments()) {
                    for (Doctor o : h.getDoctors()) {
                        if (d.getId().equals(departmentId)) {
                            doctorsId.add(o.getId());
                            return "Doctor id added successfully" + doctorsId;
                        } else {
                            throw new MyException("Doctor not found!");
                        }

                    }
                }
            }
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
        return "Invalid partition ID";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        try {
            boolean isTrue = true;

            for (Hospital h : database.getHospitals()) {
                if (Objects.equals(h.getId(), id)) {
                    isTrue = true;
                    return h.getDoctors();
                } else {
                    isTrue = false;
                }
            }

            if (!isTrue) {
                throw new MyException("Hospital with id " + id + " does not exist.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        try {
            for (Hospital h : database.getHospitals()) {
                for (Department d : h.getDepartments()) {
                    if (Objects.equals(d.getId(), id)) {
                        return d.getDoctors();
                    } else {
                        throw new MyException("ID not found!");
                    }
                }
            }
        } catch (MyException m) {
            System.out.println(m.getMessage());
        }
        return null;
    }
}
