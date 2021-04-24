package com.company.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Employee {

    private Fio fio = new Fio();
    private final int id;
    private static int globalId;
    private LocalDate birthday;
    private Sex sex;

    public enum Sex {
        MALE,
        FEMALE,
        UNDEFINED
    }

    private LocalDate dateOfStart;
    private String post;
    private BigDecimal salary;
    private Set<String> skills = new HashSet<>();
    private boolean isFired;

    public void setSkills(Set<String> skills) {
        for (String s: skills) {
            if (!Pattern.matches(".*[a-zA-Z]+.*", s)) {
                throw new IllegalArgumentException("\n\n" + s + " can not be a skill!\n\n");
            }
        }
        this.skills.addAll(skills);
    }

    public void removeSkills(Set<String> skills) {
        this.skills.removeAll(skills);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String first) {
        fio.setFirstName(first);
    }

    public void setLastName(String last) {
        fio.setLastName(last);
    }

    public void setFatherName(String father) {
        fio.setFatherName(father);
    }

    public String getFirstName() {
        return fio.getFirstName();
    }

    public String getLastName() {
        return fio.getLastName();
    }

    public String getFatherName() {
        return fio.getFatherName();
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public void setDayOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }

    public void setPost(String post) {
        if (!Pattern.matches(".*[a-zA-Z]+.*", post)) {
            throw new IllegalArgumentException("\n\n" + post + " can not be a post!\n\n");
        }
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setSalary(BigDecimal salary) {
        if (salary.compareTo(new BigDecimal("0.00")) < 0) {
            throw new IllegalArgumentException("\n\n" + salary + " can not be a salary!\n\n");
        }
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setFired() throws Exception {
        if (isFired == true) {
            throw new Exception("\n\n" + "this employee is already fired!\n\n");
        }
        isFired = true;
    }

    public boolean getIsFired() {
        return isFired;
    }

    public String getCard() {
        return ("\nID: " + getId() +
                "\nFIO: " + getFirstName() + " " + getLastName() + " " + getFatherName() +
                "\nBirthday: " + getBirthday() +
                "\nSex: " + getSex() +
                "\nPost: " + getPost() +
                "\nSkills: " + getSkills() +
                "\nSalary: " + getSalary() +
                "\nDate of start: " + getDateOfStart());
    }

    public Employee(LocalDate birthday,
                    String firstName,
                    String lastName,
                    String fatherName,
                    String sex,
                    LocalDate dateOfStart,
                    String post,
                    BigDecimal salary,
                    Set<String> skills) {

        id = globalId;
        globalId++;
        setBirthday(birthday);

        fio.setFirstName(firstName);
        fio.setLastName(lastName);
        fio.setFatherName(fatherName);
        setSex(Sex.valueOf(sex));
        setDayOfStart(dateOfStart);
        setPost(post);
        setSalary(salary);
        setSkills(skills);
        isFired = false;
    }

}