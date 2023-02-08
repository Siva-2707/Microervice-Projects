package com.siva.employee.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    //Filter

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
                employeeRepository.findEmployeeByCurrentCompanyExperience(years));
    }

    public Set<Employee> filterEmployees(Map<String, String> request) {
        Set<Employee> filteredEmployees = new HashSet<>();
        List<Employee> filter = new ArrayList<>();
        if (request.containsKey("department"))
            filterByDepartment(request.get("department"), filter);
        if (request.containsKey("age"))
            filterByAge(Integer.parseInt(request.get("age")), filter);
        if (request.containsKey("currentExperience"))
            filterByCurrentExperience(Integer.parseInt(request.get("currentExperience")), filter);
        filteredEmployees.addAll(filter);
        return filteredEmployees;
    }

}
