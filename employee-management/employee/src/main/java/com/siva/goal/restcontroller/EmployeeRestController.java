package com.siva.goal.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.goal.model.Employee.Employee;
import com.siva.goal.service.EmployeeService;

@RestController()
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/employee/{empCode}")
    public Employee getEmployee(@PathVariable int empCode) {
        return employeeService.getEmployeeWithCode(empCode);
    }

    @PostMapping(path = "employee/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    // @GetMapping(path = "employee/find")
    // public List<Employee> findEmployeeWithName(@RequestParam(name = "name") String name) {
    //     return employeeService.findByName(name);
    // }

}
