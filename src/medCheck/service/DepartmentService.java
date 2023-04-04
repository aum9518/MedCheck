package medCheck.service;

import medCheck.model.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartmentToHospital(String hospitalId, Department department);
    List<Department> getAllDepartmentsByHospital(String hospitalId);
    Department findDepartmentByName(String name);
    void deleteDepartmentById(String id);
    void updateDepartmentById(String id, Department department);

}
