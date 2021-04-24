package com.company;

import com.company.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = List.of(

                new Employee(LocalDate.of(1999, 5, 2),
                        "Alex",
                        "Rodionov",
                        "Andreevich",
                        "MALE",
                        LocalDate.of(2021, 5, 1),
                        "intern",
                        BigDecimal.valueOf(100),
                        Set.of("Java", "C++")),

                new Employee(LocalDate.of(2002, 11, 1),
                        "Ivan",
                        "Ivanov",
                        "Ivanovich",
                        "UNDEFINED",
                        LocalDate.of(2021, 5, 14),
                        "junior",
                        BigDecimal.valueOf(200),
                        Set.of("Java", "JS", "C#", "DataBase")),

                new Employee(LocalDate.of(1993, 11, 1),
                        "Ivan",
                        "Ivanov",
                        "Petrovich",
                        "MALE",
                        LocalDate.of(2020, 8, 1),
                        "expert",
                        BigDecimal.valueOf(300),
                        Set.of("DataBase"))
        );

        EmployeeRepository employeeRepository = new EmployeeRepository(employees);

//        System.out.println(employeeRepository.getByStates("intern", "junior"));
//        System.out.println(employeeRepository.getBySkill("DataBase"));
//        System.out.println(employeeRepository.mapIdToEmployee().get(1));
//        System.out.println(employeeRepository.getBySalaryLessThan(201));
//
        for(Employee e : employees) {
            System.out.println(e.getCard());
        }


    }
}
