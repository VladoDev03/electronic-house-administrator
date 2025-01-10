package org.example;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.Employee.CreateEmployeeDto;
import org.example.dto.Employee.EmployeeDto;
import org.example.dto.Employee.UpdateEmployeeDto;
import org.example.service.contracts.EmployeeService;
import org.example.service.implementations.EmployeeServiceImpl;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtil.getSessionFactory().openSession();
    }
}
