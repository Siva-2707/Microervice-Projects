package com.siva.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.siva.employee.model.Employee.Employee;
import com.siva.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeWithCode(int empCode) {
        return employeeRepository.findById(empCode)
                .orElseThrow(() -> new RuntimeException("No employee found with code: " + empCode));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public void filterByDepartment(String department, List<Employee> filteredEmployees) {
        filteredEmployees.addAll(
                employeeRepository.findEmployeeByDepartment(department));
    }

    public void filterByAge(int age, List<Employee> filteredEmployees) {
        filteredEmployees.addAll(
                employeeRepository.findEmployeeByAge(age));
    }

    public void filterByCurrentExperience(int years, List<Employee> filteredEmployees) {
        filteredEmployees.addAll(
                employeeRepository.findEmployeeByCurrentExperience(years));
    }

    //Update employee

    // public List<Employee> findByName(String name) {
    //     String names[] = name.split(" ");
    //     return employeeRepository.findByName(names);
    // }
}
