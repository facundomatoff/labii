package org.utn.labii.oop;

/**
 * Created by nico on 9/13/16.
 */
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){
        return String.format("%s %s", getFirstName(), getLastName());
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary(){
        return this.salary * 12;
    }

    public int raiseSalary(int percent){
        int p = (int)(getSalary()*((float)percent/100.0f));
        int newSalary = getSalary() + p;
        setSalary(newSalary);
        return  newSalary;
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, name=%s, salary=%d]", getID(), getName(), getSalary());
    }
}
