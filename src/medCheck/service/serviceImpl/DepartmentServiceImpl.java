package medCheck.service.serviceImpl;

import medCheck.database.Database;
import medCheck.model.Department;
import medCheck.model.Hospital;
import medCheck.service.DepartmentService;

import java.util.List;
import java.util.Objects;

public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        for (Hospital h : database.getHospitals()) {
            if (h.getId() == id) {
                h.getDepartments().add(department);
                return "Department added successfully.";
            }
        }
        return "Hospital with id " + id + " does not exist.";
    }


    Database database = new Database();

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h : database.getHospitals()
        ) {
            if (Objects.equals(h.getId(), id)) {
                System.out.println(h.getDepartments());
            } else return null;
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital ha : database.getHospitals()) {
            for (Department department : ha.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    return department;
                }
            }
        }
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        for (Hospital h : database.getHospitals()) {
            for (Department department : h.getDepartments()) {
                if (Objects.equals(department.getId(), id)) {
                    h.getDepartments().remove(department);
                    return;
                }
            }
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department) {
        for (Hospital h : database.getHospitals()) {
            for (Department dep : h.getDepartments()) {
                if (Objects.equals(dep.getId(), id)) {
                    dep.setDepartmentName(department.getDepartmentName());
                    dep.setDoctors(department.getDoctors());
                    return "Department updated successfully.";
                }
            }
        }
        return "Department with id " + id + " does not exist.";
    }
}