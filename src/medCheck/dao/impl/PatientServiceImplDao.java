package medCheck.dao.impl;

import com.sun.tools.javac.Main;
import medCheck.dao.PatientServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.*;
import java.util.stream.Collectors;


public class PatientServiceImplDao implements PatientServiceDao {
    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        boolean isTrue = true;
        for (Hospital d : Database.database.getHospitals()) {
            if (d.getId() == id) {
                isTrue = true;
                d.getPatients().add(patient);
                return "Patient successfully added patient: " + patient;
            } else {
                isTrue = false;
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Not found hospital");
            }
        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        boolean isTrue = true;
        for (Hospital h : Database.database.getHospitals()) {
            if (h.getId() == id) {
                isTrue = true;
                h.setPatients(patients);
                return "List of patient: " + h.getPatients();
            } else {
                isTrue = false;
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Not found hospital!");
            }
        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        boolean isTrue = true;
        for (Hospital h : Database.database.getHospitals()) {
            for (Patient p : h.getPatients()) {
                if (p.getId() == id) {
                    isTrue = true;
                    p.setFirstName(patientsNewInfo.getFirstName());
                    p.setLastName(patientsNewInfo.getLastName());
                    p.setGender(patientsNewInfo.getGender());
                    p.setAge(patientsNewInfo.getAge());
                    return "Successfully updated patient: " + p;
                } else {
                    isTrue = false;
                }
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Not found patient with id: " + id);
            }
        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void removePatientById(Long id) {
        try {
            boolean isTrue = true;
            for (Hospital h : Database.database.getHospitals()) {
                for (Patient p : h.getPatients()) {
                    if (p.getId() == id) {
                        isTrue = true;
                        h.getPatients().remove(p);
                        System.out.println("Successfully removed patient with id: " + id);
                        break;
                    } else {
                        isTrue = false;
                    }
                }
            }

            if (!isTrue) {
                throw new MyException("Not found patient with id: " + id);
            }
        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Patient getPatientById(Long id) {
        try {
            List<Patient> list = Database.database.getHospitals().stream()
                    .flatMap(h -> h.getPatients().stream())
                    .filter(x -> x.getId() == id)
                    .toList();
            if (list.isEmpty()) {
                throw new MyException("Not found patient with Id: " + id);
            }
            return list.get(0);

        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        try {
            Map<Integer, Patient> patientMap = new HashMap<>();
            List<Patient> patients = Database.database.getHospitals().stream().flatMap(p -> p.getPatients().stream()).toList();
            for (Patient a : patients) {
                patientMap.put(a.getAge(), a);
            }
            if (patientMap.isEmpty()) {
                throw new MyException("Not found!!!");
            }
            return patientMap;
        } catch (MyException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        System.out.println("1.Ascending\n2.Descending");
        switch (ascOrDesc) {
            case "Ascending" -> {
                List<Hospital> hospitals = Database.database.getHospitals().stream().toList();
                List<List<Patient>> patients = hospitals.stream().map(Hospital::getPatients).toList();
                for (List<Patient> p : patients) {
                    List<Patient> list1 = p.stream().sorted(Comparator.comparing(Patient::getAge)).toList();
                    return list1;
                }
            }
            case "Descending" -> {
                List<Hospital> hospitals1 = Database.database.getHospitals().stream().toList();
                List<List<Patient>> patients1 = hospitals1.stream().map(Hospital::getPatients).toList();
                for (List<Patient> p : patients1) {
                    List<Patient> list2 = p.stream().sorted(Comparator.comparing(Patient::getAge).reversed()).toList();
                    return list2;
                }
            }
        }
        return null;
    }
}
