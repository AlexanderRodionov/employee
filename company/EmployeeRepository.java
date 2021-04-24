package com.company;

import com.company.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Найти всех сотрудников с заданной фамилией
     */
    public List<Employee> getByLastName(String lastName) {
        List<Employee> myList = new LinkedList<>();
        for(Employee e : employees) {
            if(e.getLastName().equals(lastName)) {
                myList.add(e);
            }
        }
        return myList;

    }

    /**
     * Найти всех сотрудников старше заданного возраста
     */
    public List<Employee> getOlderThan(int age) {
        List<Employee> myList = new LinkedList<>();
        for (int i = 0; i < employees.size(); i++) {
            int myAge = (Period.between(employees.get(i).getBirthday(), LocalDate.now())).getYears();
            if(myAge > age) {
                myList.add(employees.get(i));
            }
        }
        return myList;
    }

    /**
     * Найти всех сотрудников заданного пола.
     * Вместо Object используйте ваш класс для пола
     */
    public List<Employee> getByGender(String gender) {
        List<Employee> myList = new LinkedList<>();
        for(Employee e : employees) {
            if(e.getSex() == Employee.Sex.valueOf(gender)) {
                myList.add(e);
            }
        }
        return myList;
    }

    /**
     * Найти всех сотрудников с указанными должностями
     */
    public List<Employee> getByStates(String... states) {
        List<Employee> myList = new LinkedList<>();
        for(Employee e : employees) {
            for (int i = 0; i < states.length; i++) {
                if(e.getPost().contains(states[i])) {
                    myList.add(e);
                }
            }
        }
        return myList;
    }

    /**
     * Найти всех сотрудников с зарплатой меньше заднной в рублях
     */
    public List<Employee> getBySalaryLessThan(int salaryInRubbles) {
        List<Employee> myList = new LinkedList<>();
        for(Employee e : employees) {
            if(e.getSalary().compareTo(BigDecimal.valueOf(salaryInRubbles)) < 0) {
                myList.add(e);
            }
        }
        return myList;
    }

    /**
     * Найти всех сотрудников, обладающих заданным навыком
     */
    public List<Employee> getBySkill(String skill) {
        List<Employee> myList = new LinkedList<>();
        for(Employee e : employees) {
            if(e.getSkills().contains(skill)) myList.add(e);
        }
        return myList;
    }

    /**
     * Найти всех сотрудников, работающих в компании больше заданного числа лет
     */
    public List<Employee> getWorkMoreThan(int years) {
        List<Employee> myList = new LinkedList<>();
        for(int i = 0; i < employees.size(); i++) {
            int myYears = (Period.between(employees.get(i).getDateOfStart(), LocalDate.now())).getYears();
            if(myYears > years) {
                myList.add(employees.get(i));
            }
        }
        return myList;
    }

    /**
     * Найти всех сотрудников, у которых День рождения в указанную дату
     */
    public List<Employee> getBirthDayMates(LocalDate date) {
        List<Employee> myList = new LinkedList<>();
        for(Employee e : employees) {
            if(e.getBirthday().isEqual(date)) {
                myList.add(e);
            }
        }
        return myList;
    }

    /**
     * Получить сколько всего сотрудников работает в компании
     */
    public int amount() {
        return employees.size();
    }

    /**
     * Получить сколько всего денег тратит компания на зарплаты в год.
     * Вместо Object используйте подходящий тип данных
     */
    public BigDecimal totalSalary() {
        BigDecimal total = valueOf(0);
        for(Employee e : employees) {
            total = total.add(e.getSalary());
        }
        return total;
    }

    /**
     * Получить отображение идентификатора работника на сущность работника для удобства дальнейшего поиска по id
     */
    public Map<Integer, Employee> mapIdToEmployee() {
        Map mapA = new HashMap();
        for(Employee e : employees) {
            mapA.put(e.getId(), e);
        }
        return mapA;
    }
}