package com.siva.employee.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.siva.employee.model.Employee.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    // @Query(value = "select * from employee where FIRST_NAME  IN (?1) OR LAST_NAME  IN (?1)", nativeQuery = true)
    // public List<Employee> findByName(String[] names);

    public List<Employee> findEmployeeByDepartment(String department);

    public List<Employee> findEmployeeByAge(int age);

    public List<Employee> findEmployeeByCurrentExperience(int years);

}
