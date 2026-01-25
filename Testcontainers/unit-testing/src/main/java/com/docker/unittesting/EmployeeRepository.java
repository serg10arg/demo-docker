package com.docker.unittesting;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // Hereda metodos basicos como save(), findById() etc..
}
