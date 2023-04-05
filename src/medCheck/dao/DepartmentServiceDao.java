package medCheck.dao;

import medCheck.exception.MyException;
import medCheck.model.Department;

import java.util.List;

public interface DepartmentServiceDao {
    String addDepartmentToHospital(Long id, Department department) throws MyException;
    List<Department> getAllDepartmentByHospital(Long id) throws MyException;
    Department findDepartmentByName(String name) throws MyException;
    void deleteDepartmentById(Long id) throws MyException;
    String updateDepartmentById(Long id, Department department) throws MyException;
}
