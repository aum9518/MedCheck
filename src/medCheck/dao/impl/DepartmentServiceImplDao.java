package medCheck.dao.impl;

import medCheck.dao.DepartmentServiceDao;
import medCheck.database.Database;
import medCheck.exception.MyException;
import medCheck.model.Department;
import medCheck.model.Hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DepartmentServiceImplDao implements DepartmentServiceDao {
    @Override
    public String addDepartmentToHospital(Long id, Department department) {
        boolean isTrue = true;
        for (Hospital h : Database.database.getHospitals()) {
            if (Objects.equals(h.getId(), id)) {
                isTrue = true;
                h.getDepartments().add(department);
                return "Department added successfully.";
            } else {
                isTrue = false;
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Hospital with id " + id + " does not exist.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        boolean isTrue = true;
        for (Hospital h : Database.database.getHospitals()) {
            if (Objects.equals(h.getId(), id)) {
                isTrue = true;
                return h.getDepartments();
            } else {
                isTrue = false;
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Hospital with id " + id + " does not exist.");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital ha : Database.database.getHospitals()) {
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
        boolean isTrue = true;
        for (Hospital h : Database.database.getHospitals()) {
            for (Department d : h.getDepartments()) {
                if (d.getId() == id) {
                    isTrue = true;
                    h.getDepartments().remove(d);
                    System.out.println("Successfully removed department with id: " + id);
                    break;
                } else {
                    isTrue = false;
                }
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Not found department with id: " + id);
            }
        } catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String updateDepartmentById(Long id, Department department)  {
        boolean isTrue = true;
        for (Hospital h : Database.database.getHospitals()) {
            for (Department d : h.getDepartments()) {
                if (Objects.equals(d.getId(), id)) {
                    isTrue = true;
                    d.setDepartmentName(department.getDepartmentName());
                    d.setDoctors(department.getDoctors());
                   return "Successfully updated department: " + d;
                } else {
                    isTrue = false;
                }
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Not found department with id: " + id);
            }
        } catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
