package EjerciciosOOP;

/**
 * Created by umantram on 16/11/16.
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int AnnualSalary(){

        return this.salary *12;
    }

    public int reaiseSalary (int percent){

        return this.salary + (this.salary * percent);

    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + firstName + "" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }

}
