package medCheck.dao.impl;

import medCheck.dao.PatientServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.*;
import java.util.stream.Collectors;


public class PatientServiceImplDao implements PatientServiceDao {
    Hospital hospital = new Hospital(1L, "City Clinical Hospital No. 1", "Bishkek, st. Fuchika, 15", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    List<Hospital>hospitals= new ArrayList<>(Arrays.asList(hospital));

    Database database = new Database(hospitals);

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        boolean isTrue = true;
        for (Hospital d:database.getHospitals()) {
            if (d.getId()==id){
                isTrue = true;
                d.getPatients().add(patient);
                return "Patient successfully added patient: "+patient;
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Not found hospital");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        boolean isTrue = true;
        for (Hospital h: database.getHospitals()) {
            if (h.getId()==id){
                isTrue = true;
                h.setPatients(patients);
                return "List of patient: "+h.getPatients();
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Not found hospital!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        boolean isTrue = true;
        for (Hospital h: database.getHospitals()) {
            for (Patient p:h.getPatients()) {
                if (p.getId()==id){
                    isTrue = true;
                    h.getPatients().remove(p);
                    h.getPatients().add(patientsNewInfo);
                    return "Successfully updated patient: "+ patientsNewInfo;
                }else {
                    isTrue = false;
                }
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Not found patient with id: "+id);
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void removePatientById(Long id) {
        boolean isTrue = true;
        for (Hospital h: database.getHospitals()) {
            for (Patient p:h.getPatients()) {
                if (p.getId()==id){
                    isTrue = true;
                    h.getPatients().remove(p);
                    System.out.println("Successfully removed patient with id: "+id);
                }else {
                    isTrue = false;
                }
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Not found patient with id: "+id);
            }
        } catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Patient getPatientById(Long id) {

       /* for (Hospital h:database.getHospitals()) {
            for (Patient p:h.getPatients()) {
                if (p.getId()==id){
                    return p;
                }
            }
        }*/

        Optional<Patient>patient = database.getHospitals().stream()
                .flatMap(h->h.getPatients().stream())
                .filter(x->x.getId()==id)
                .findFirst();
        return patient.orElse(null);

    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        /*Map<Integer,Patient>patientMap = new HashMap<>();
            List<Hospital>hospitals = database.getHospitals().stream().toList();
           List<List<Patient>>patients= hospitals.stream().map(Hospital::getPatients).toList();

        for (List<Patient> p:patients) {
            for (Patient a:p) {
                patientMap.put(a.getAge(),a);
            }
        }
        return patientMap;*/
        Map<Integer,Patient>patientMap = new HashMap<>();
        List<Patient>patients = database.getHospitals().stream().flatMap(p->p.getPatients().stream()).toList();
        for (Patient a:patients) {
            patientMap.put(a.getAge(),a);
        }
        return patientMap;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        System.out.println("1.Ascending\n2.Descending");
        switch (ascOrDesc){
            case "Ascending" ->{
                List<Hospital>hospitals = database.getHospitals().stream().toList();
                List<List<Patient>>patients= hospitals.stream().map(Hospital::getPatients).toList();
                for (List<Patient> p:patients) {
                   List<Patient>list1= p.stream().sorted(Comparator.comparing(Patient::getAge)).toList();
                   return list1;
                }
            }
            case "Descending" ->{
                List<Hospital>hospitals1 = database.getHospitals().stream().toList();
                List<List<Patient>>patients1= hospitals1.stream().map(Hospital::getPatients).toList();
                for (List<Patient> p:patients1) {
                    List<Patient>list2= p.stream().sorted(Comparator.comparing(Patient::getAge).reversed()).toList();
                    return list2;
                }
            }
        }
        return null;
    }
}
