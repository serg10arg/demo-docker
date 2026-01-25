package com.docker.unittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService; // El sujeto de prueba (Real)
    private EmployeeRepository mockRepository; // El colaborador (Falso/Mock)

    @BeforeEach
    void setUp() {

        // 1. CREAR EL MOCK:
        // Mockito crea un objeto que "parece" un EmployeeRepository pero no tiene cerebro.
        // No conecta a ninguna base de datos.
        mockRepository = Mockito.mock(EmployeeRepository.class);


        // 2. INYECTAR EL MOCK:
        // Creamos el servicio real pasándole el repositorio falso.
        // Así aislamos el servicio del mundo exterior.
        employeeService = new EmployeeService(mockRepository);

    }

    @Test
    void testAddEmployee() {

        // A. PREPARAR DATOS (ARRANGE)
        Employee employee = new Employee(1L, "John Doe", "Developer");

        // B. ENTRENAR AL MOCK (El Guion):
        // Le decimos al mock: "Cuando alguien te pida guardar ESTE empleado,
        // devuelve ESTE MISMO empleado sin rechistar".
        // Esto simula una base de datos exitosa sin tocar Redis.
        Mockito.when(mockRepository.save(employee))
                .thenReturn(employee);

        // C. EJECUTAR LA ACCIÓN (ACT)
        Employee result = employeeService.addEmployee(employee);

        // D. VERIFICAR (ASSERT)
        // Comprobamos que el servicio nos devolvió lo que esperábamos.
        assertEquals(employee.name(), result.name());
    }

}