package com.example.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.EmployeeManagementSystem.entity.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find departments by name
    Department findByName(String name);

    // Find departments whose name ends with a specific suffix
    List<Department> findByNameEndingWith(String suffix);

    // Custom query to find departments by partial name using JPQL
    @Query("SELECT d FROM Department d WHERE d.name LIKE CONCAT('%', :name, '%')")
    List<Department> findDepartmentsByNameContaining(@Param("name") String name);

    // Custom query to find all departments using native SQL
    @Query(value = "SELECT * FROM departments", nativeQuery = true)
    List<Department> findAllDepartmentsNative();
}