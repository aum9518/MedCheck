
import medCheck.dao.impl.DoctorServiceImplDao;

import medCheck.dao.impl.DepartmentServiceImplDao;

import medCheck.dao.impl.HospitalServiceImplDao;
import medCheck.database.Database;
import medCheck.enums.Gender;
import medCheck.exception.MyException;
import medCheck.model.Department;
import medCheck.model.Doctor;
import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import medCheck.enums.Gender;
import medCheck.model.Doctor;
import medCheck.service.DepartmentService;
import medCheck.service.serviceImpl.DepartmentServiceImpl;
import medCheck.service.serviceImpl.DoctorServiceImpl;
import medCheck.service.serviceImpl.HospitalServiceImpl;
import medCheck.service.serviceImpl.PatientServiceImpl;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1L, "Bektur", "Duyshenbek uulu", Gender.MALE, 3);
        Doctor doctor2 = new Doctor(2L, "Aizat", "Duisheeva", Gender.FEMALE, 1);
        Doctor doctor3 = new Doctor(3L, "Erkinbek", "Koshaliev", Gender.MALE, 5);
        Doctor doctor4 = new Doctor(4L, "Ernazar", "Asanbekov", Gender.MALE, 2);
        List<Doctor> doctors = new ArrayList<>(List.of(doctor1, doctor2));
        List<Doctor> doctors1 = new ArrayList<>(List.of(doctor3, doctor4));

        Department department = new Department(1L, "Surgical department", doctors);
        Department department1 = new Department(2L, " Physical medicine", doctors);
        Department department2 = new Department(3L, "Pharmacy department", doctors1);
        Department department3 = new Department(4L, "Operation theater complex (OT)", doctors1);
        List<Department> departments = new ArrayList<>(List.of(department, department1));
        List<Department> departments1 = new ArrayList<>(List.of(department2, department3));

        Patient patient = new Patient(1L, "Manas", "Abdugani uulu", 20, Gender.MALE);
        Patient patient1 = new Patient(2L, "Aigerim", "Bektenova", 18, Gender.FEMALE);
        Patient patient2 = new Patient(3L, "Baytik", "Taalaiibekov", 23, Gender.MALE);
        Patient patient3 = new Patient(4L, "Kanymgul", "Abdutairovna", 20, Gender.FEMALE);
        List<Patient> patients = new ArrayList<>(List.of(patient, patient1));
        List<Patient> patients1 = new ArrayList<>(List.of(patient2, patient3));

        Hospital hospital = new Hospital(1L, "City Clinical Hospital No. 1", "Bishkek, st. Fuchika, 15", departments, doctors, patients);

        PatientServiceImpl servicePatient = new PatientServiceImpl(Database.database);
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(Database.database);
        HospitalServiceImpl hospitalService = new HospitalServiceImpl(Database.database);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(Database.database);

        System.out.println(hospitalService.addHospital(hospital)); //TO ADD HOSPITAL.
        System.out.println("FIND HOSPITAL BY ID : " + hospitalService.findHospitalById(1L)); //FIND HOSPITAL BY ID.
        System.out.println("GET ALL HOSPITAL : " + hospitalService.getAllHospital()); //GET ALL HOSPITAL.
        System.out.println("GET ALL PATIENT FROM HOSPITAL : " + hospitalService.getAllPatientFromHospital(1L)); //GET ALL PATIENT FROM HOSPITAL.
        System.out.println("GET ALL HOSPITAL BY ADDRESS : " + hospitalService.getAllHospitalByAddress("Bishkek, st. Fuchika, 15")); //GET ALL HOSPITAL BY ADDRESS.
        // System.out.println("DELETE HOSPITAL BY ID : " + hospitalService.deleteHospitalById(1L)); //DELETE HOSPITAL BY ID

        System.out.println("=====================DOCTOR======================");

        System.out.println("ADD DOCTOR TO HOSPITAL: " + doctorService.addDoctorToHospital(1L, doctor1));
        System.out.println("FIND DOCTOR BY ID: " + doctorService.findDoctorById(1L));
        System.out.println("UPDATE DOCTOR: " + doctorService.updateDoctor(3L, doctor1));
        System.out.println("DELETE DOCTOR BY ID: ");
        doctorService.deleteDoctorById(1L);
        List<Long> list = new ArrayList<>();
        System.out.println("ASSIGN DOCTOR TO DEPARTMENT: " + doctorService.assignDoctorToDepartment(4L, list));
        System.out.println("GET ALL DOCTORS BY HOSPITAL ID: " + doctorService.getAllDoctorsByHospitalId(2L));
        System.out.println("GET ALL DOCTORS BY DEPARTMENT ID: " + doctorService.getAllDoctorsByDepartmentId(1L));
        doctorService.deleteDoctorById(3L);
        System.out.println("==================================================");

        System.out.println("Add patient to Hospital: " + servicePatient.addPatientToHospital(1L, patient2));
        System.out.println("Add list of patient: " + servicePatient.addPatientsToHospital(1L, patients1));
        System.out.println("Get patient by id: " + servicePatient.getPatientById(3L));
        System.out.println("Get patient by age: " + servicePatient.getPatientByAge());
        System.out.println("Update patient by id: " + servicePatient.updatePatientById(3L, patient1));
        System.out.println("Sort patient by age(Ascending/Descending): " + servicePatient.sortPatientsByAge("Descending"));
        servicePatient.removePatientById(4L);

        System.out.println("ADD DEPARTMENT TO HOSPITAL : " + departmentService.addDepartmentToHospital(1L, department2));
        System.out.println("GET ALL DEPARTMENT BY HOSPITAL : " + departmentService.getAllDepartmentByHospital(1L));
        System.out.println("FIND DEPARTMENT BY NAME : " + departmentService.findDepartmentByName("Pharmacy department"));
        System.out.println("UPDATE DEPARTMENT BY ID : " + departmentService.updateDepartmentById(2L, department1));
        departmentService.deleteDepartmentById(2L);

    }
}
