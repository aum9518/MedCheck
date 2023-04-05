package medCheck.service.serviceImpl;

import medCheck.dao.impl.HospitalServiceImplDao;
import medCheck.model.Hospital;
import medCheck.model.Patient;
import medCheck.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    HospitalServiceImplDao hospitalServiceImplDao = new HospitalServiceImplDao();
    @Override
    public String addHospital(Hospital hospital) {
        hospitalServiceImplDao.addHospital(hospital);
        return null;
    }

    @Override
    public Hospital findHospitalById(Long id) {
        hospitalServiceImplDao.findHospitalById(id);
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        hospitalServiceImplDao.getAllHospital();
        return null;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        hospitalServiceImplDao.getAllPatientFromHospital(id);
        return null;
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalServiceImplDao.deleteHospitalById(id);
        return null;
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        hospitalServiceImplDao.getAllHospitalByAddress(address);
        return null;
    }
}
