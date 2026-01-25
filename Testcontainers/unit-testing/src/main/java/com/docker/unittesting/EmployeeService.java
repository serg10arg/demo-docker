package com.docker.unittesting;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Este es el metodo que vamos a probar.
    // Recibe un empleado y le pide al repositorio que lo guarde.
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
