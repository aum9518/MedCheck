package medCheck.dao.impl;

import medCheck.dao.HospitalServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Hospital;
import medCheck.model.Patient;

import java.util.*;
import java.util.stream.Collectors;

public class HospitalServiceImplDao implements HospitalServiceDao {
    Database database = new Database(new ArrayList<>());

    @Override
    public String addHospital(Hospital hospital) {
        database.getHospitals().add(hospital);
        return null;
    }

    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital> list = database.getHospitals().stream().filter(x -> x.getId() == id).collect(Collectors.toList());
        return list.get(0);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return database.getHospitals();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Hospital> hospitals = database.getHospitals().stream().filter(x -> x.getId() == id).toList();
        return hospitals.get(0).getPatients();
    }

    @Override
    public String deleteHospitalById(Long id) {
        synchronized (database.getHospitals()) {
            Iterator<Hospital> iterator = database.getHospitals().iterator();
            while (iterator.hasNext()) {
                Hospital h = iterator.next();
                if (h.getId() == id) {
                    iterator.remove();
                    return "successfully fired!!!";
                }
            }
        }
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        try {
            Map<String,Hospital> map = new HashMap<>();
            for (Hospital h : database.getHospitals()) {
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
