package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.dto.EmployeeDTO;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Find employees by department name
    // List<Employee> findByDepartmentName(String departmentName);

    // Find employees whose name contains a specific substring
    List<Employee> findByNameContaining(String name);

    // Find employees with email starting with a specific prefix
    List<Employee> findByEmailStartingWith(String prefix);

    // Custom query to find employees by department name using JPQL
    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName);

    // Custom query to find employees by email domain using native SQL
    @Query(value = "SELECT * FROM employees WHERE email LIKE CONCAT('%', :domain)", nativeQuery = true)
    List<Employee> findEmployeesByEmailDomain(@Param("domain") String domain);

    // Find all employees with pagination and sorting
    Page<Employee> findAll(Pageable pageable);

    // Example: Find employees by department name with pagination and sorting
    Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

    // Fetch name and email using the projection
    List<EmployeeNameEmailProjection> findByDepartmentName(String departmentName);

    // Custom query with projection
    @Query("SELECT e.name AS name, e.email AS email FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeNameEmailProjection> findCustomByDepartmentName(String departmentName);

    // Use class-based projection
    @Query("SELECT new com.example.Exercise8_EmployeeManagementSystem.dto.EmployeeDTO(e.name, e.email) " +
            "FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeDTO> findEmployeeDTOsByDepartmentName(String departmentName);
}
