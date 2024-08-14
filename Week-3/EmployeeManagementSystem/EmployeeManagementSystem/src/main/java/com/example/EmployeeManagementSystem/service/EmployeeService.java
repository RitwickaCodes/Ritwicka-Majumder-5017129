package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getEmployeesByDepartmentName(String departmentName) {
        return employeeRepository.findEmployeesByDepartmentName(departmentName);
    }

    public List<Employee> getEmployeesByEmailDomain(String domain) {
        return employeeRepository.findEmployeesByEmailDomain(domain);
    }

    // Get paginated list of employees with sorting
    public Page<Employee> getPaginatedEmployees(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    // Get paginated list of employees by department with sorting
    public Page<Employee> getEmployeesByDepartmentName(String departmentName, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findByDepartmentName(departmentName, pageable);
    }

    // Interface-based projection
    public List<EmployeeNameEmailProjection> getEmployeeNamesAndEmailsByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }

    // Class-based projection
    public List<EmployeeDTO> getEmployeeDTOsByDepartment(String departmentName) {
        return employeeRepository.findEmployeeDTOsByDepartmentName(departmentName);
    }

    @Transactional
    public void saveEmployeesInBatch(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));

            // Flush and clear the EntityManager periodically to manage memory
            if (i % 20 == 0) { // Adjust the batch size as needed
                entityManager.flush();
                entityManager.clear();
            }
        }

        entityManager.flush();
        entityManager.clear();
    }
}
