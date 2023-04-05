package medCheck.service.serviceImpl;

import medCheck.database.Database;
import medCheck.model.Department;
import medCheck.model.Hospital;
import medCheck.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    public String addDepartmentToHospital(Long id, Department department) {
        return "Department added to hospital with id " + id;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h : database.getHospitals()
        ) {
            if (h.getId() == id) {
                System.out.println(h.getDepartments());
            } else return null;
        }
        return null;
    }

    Database database = new Database();

    @Override
    public Department findDepartmentByName(String name) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {

    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        return null;
    }
}
