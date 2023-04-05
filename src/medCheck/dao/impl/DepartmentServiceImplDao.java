package medCheck.dao.impl;
import medCheck.dao.DepartmentServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Department;
import medCheck.model.Hospital;
import java.util.List;
import java.util.Objects;
    public class DepartmentServiceImplDao implements DepartmentServiceDao {@Override
    public String addDepartmentToHospital(Long id, Department department) throws MyException {
        for (Hospital h : database.getHospitals()) {
            if (h.getId() == id) {
                h.getDepartments().add(department);
                return "Department added successfully.";
            }
        }
        throw new MyException("Hospital with id " + id + " does not exist.");
    }



        Database database = new Database();

        @Override
        public List<Department> getAllDepartmentByHospital(Long id) throws MyException {
            for (Hospital h : database.getHospitals()) {
                if (Objects.equals(h.getId(), id)) {
                    return h.getDepartments();
                }
            }
            throw new MyException("Hospital with id " + id + " does not exist.");
        }

        @Override
        public Department findDepartmentByName(String name) throws MyException {
            for (Hospital ha : database.getHospitals()) {
                for (Department department : ha.getDepartments()) {
                    if (department.getDepartmentName().equals(name)) {
                        return department;
                    }
                }
            }
            throw new MyException("Department with name '" + name + "' not found.");
        }

        @Override
        public void deleteDepartmentById(Long id) throws MyException {
            for (Hospital h : database.getHospitals()) {
                for (Department department : h.getDepartments()) {
                    if (Objects.equals(department.getId(), id)) {
                        try {
                            h.getDepartments().remove(department);
                            System.out.println("Department removed successfully.");
                        } catch (NullPointerException e) {
                            throw new MyException("Error deleting department: " + e.getMessage());
                        }
                    }
                }
            }
        }

        @Override
        public String updateDepartmentById(Long id, Department department) throws MyException {
            for (Hospital h : database.getHospitals()) {
                for (Department dep : h.getDepartments()) {
                    if (Objects.equals(dep.getId(), id)) {
                        dep.setDepartmentName(department.getDepartmentName());
                        dep.setDoctors(department.getDoctors());
                        return "Department updated successfully.";
                    }
                }
            }
            throw new MyException("Department with id " + id + " does not exist.");
        }
    }
