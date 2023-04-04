package medCheck.dao;

import medCheck.model.Department;

import java.util.List;

public interface DepartmentServiceDao {
    String addDepartmentToHospital(Long id, Department department);
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
    void deleteDepartmentById(Long id);
    String updateDepartmentById(Long id, Department department);
}
