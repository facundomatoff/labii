package org.utn.labii.oop.test;


import org.junit.Before;
import org.junit.Test;
import org.utn.labii.oop.Employee;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by nico on 9/13/16.
 */
public class EmployeeTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;

    @Before
    public void setUp(){
        employee1 = new Employee(3, "Nicolas", "Villalba", 1288);
        employee2 = new Employee(4, "Gabriel", "Toscana", 1588);
        employee3 = new Employee(5, "James", "Bond", 2388);
        employee4 = new Employee(6, "Julia", "Robberts", 100);
    }

    @Test
    public void getID() throws Exception {
        assertThat(employee1.getID(), is(3));
        assertThat(employee2.getID(), is(not(3)));
        assertThat(employee3.getID(), is(5));
    }

    @Test
    public void getFirstName() throws Exception {
        assertThat(employee1.getFirstName(), is("Nicolas"));
        assertThat(employee2.getFirstName(), is(not("Pedro")));
        assertThat(employee3.getFirstName(), is("James"));
    }

    @Test
    public void getLastName() throws Exception {
        assertThat(employee1.getLastName(), is("Villalba"));
        assertThat(employee2.getLastName(), is("Toscana"));
        assertThat(employee3.getLastName(), is("Bond"));
    }

    @Test
    public void getName() throws Exception {
        assertThat(employee1.getName(), is("Nicolas Villalba"));
        assertThat(employee2.getName(), is("Gabriel Toscana"));
        assertThat(employee3.getName(), is("James Bond"));
    }

    @Test
    public void getSalary() throws Exception {
        assertThat(employee1.getSalary(), is(1288));
        assertThat(employee2.getSalary(), is(1588));
        assertThat(employee3.getSalary(), is(2388));
    }

    @Test
    public void setSalary() throws Exception {
        employee4.setSalary(4546);
        assertThat(employee4.getSalary(), is(4546));
    }

    @Test
    public void getAnnualSalary() throws Exception {
        assertThat(employee1.getAnnualSalary(), is(1288 * 12));
        assertThat(employee2.getAnnualSalary(), is(1588 * 12));
        assertThat(employee3.getAnnualSalary(), is(2388 * 12));
    }

    @Test
    public void raiseSalary() throws Exception {
        employee4.raiseSalary(10);
        assertThat(employee4.getSalary(), is(110));
        employee4.raiseSalary(50);
        assertThat(employee4.getSalary(), is(165));
    }

    @Test
    public void toString_() throws Exception {
        assertThat(
                employee1.toString(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo("Employee[id=3, name=Nicolas Villalba, salary=1288]")
                        )
                )
        );
    }

}