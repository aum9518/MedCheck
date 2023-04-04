package medCheck.dao;

import medCheck.model.Department;

public interface DepartmentServiceDao {
    String addDepartmentToHospital(Long id, Department department);

}
