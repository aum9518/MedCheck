package medCheck.dao.impl;

import medCheck.dao.HospitalServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.*;
import java.util.stream.Collectors;

public class HospitalServiceImplDao implements HospitalServiceDao {
    @Override
    public String addHospital(Hospital hospital) {
        Database.database.getHospitals().add(hospital);
        return "has joined!!!";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        boolean isTrue = true;
        for (Hospital d : Database.database.getHospitals()) {
            if (Objects.equals(d.getId(), id)) {
                isTrue = true;
                return d;
            } else {
                isTrue = false;
            }
        }
            try {
                if (!isTrue) {
                    throw new MyException("Hospital with id: " + id + " not found!");
                }
    }catch (MyException e) {
            System.out.println(e.getMessage());
        }
            return null;
        }

    @Override
    public List<Hospital> getAllHospital() {
        return Database.database.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        boolean isTrue = true;
        for (Hospital d : Database.database.getHospitals()) {
            for (Patient p : d.getPatients()) {
                if (Objects.equals(d.getId(), id)) {
                    isTrue = true;
                    return d.getPatients();
                } else {
                    isTrue = false;
                }
            }
            try {
                if (!isTrue) {
                    throw new MyException("Hospital with id: " + id + " not found!");
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        boolean isTrue = true;
        synchronized (Database.database.getHospitals()) {
            Iterator<Hospital> iterator = Database.database.getHospitals().iterator();
            while (iterator.hasNext()) {
                Hospital h = iterator.next();
                if (h.getId() == id) {
                    isTrue = true;
                    iterator.remove();
                    return "successfully fired!!!";
                } else {
                    isTrue = false;
                }
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Hospital with id: " + id + " not found!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            Map<String,Hospital> map = new HashMap<>();
            for (Hospital h : Database.database.getHospitals()) {
                if (h.getAddress().equalsIgnoreCase(address)) {
                    map.put(h.getAddress(),h);
                    return map;
                } else {
                    throw new MyException("Hospital with address: " + address + " not found!");
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
