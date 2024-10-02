package com.gfarm.employeeService.repository;

import ch.qos.logback.core.model.conditional.ElseModel;
import com.gfarm.employeeService.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee ,Integer> {
}
