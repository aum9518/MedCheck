package medCheck.service.serviceImpl;

import medCheck.dao.impl.DepartmentServiceImplDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Department;
import medCheck.model.Hospital;
import medCheck.service.DepartmentService;

import java.util.List;
import java.util.Objects;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentServiceImplDao departmentServiceImplDao = new DepartmentServiceImplDao();

    @Override
    public String addDepartmentToHospital(Long id, Department department) throws MyException {
       return departmentServiceImplDao.addDepartmentToHospital(id,department);
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) throws MyException {
        return departmentServiceImplDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) throws MyException {
        return departmentServiceImplDao.findDepartmentByName(name);
    }

    @Override
    public void deleteDepartmentById(Long id) throws MyException {
    departmentServiceImplDao.deleteDepartmentById(id);
    }

    @Override
    public String updateDepartmentById(Long id, Department department) throws MyException {
        return departmentServiceImplDao.updateDepartmentById(id, department);
    }
}