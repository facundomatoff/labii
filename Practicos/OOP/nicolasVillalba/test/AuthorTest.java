package org.utn.labii.oop.test;

import org.junit.Before;
import org.junit.Test;
import org.utn.labii.oop.Author;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by nico on 9/16/16.
 */
public class AuthorTest {

    private Author author1;

    @Before
    public void setUp() throws Exception {
        author1 = new Author("Gabriel Garcia Marquez", "gabo@libros.co", 'm');
    }

    @Test
    public void getName() throws Exception {
        assertThat(author1.getName(), is(not(equalTo("jdkdskdjsdkjddklsdsl"))));
        assertThat(author1.getName(), is(not(equalTo("Grabriel Garcia Marquez"))));
    }

    @Test
    public void getEmail() throws Exception {
        assertThat(
                author1.getEmail(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo("gabo@libros.co")
                        )
                )
        );
    }

    @Test
    public void setEmail() throws Exception {
        author1.setEmail("gabriel_garcia_marquez@libros.co");
        assertThat(
                author1.getEmail(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo("gabriel_garcia_marquez@libros.co")
                        )
                )
        );
    }

    @Test
    public void getGender() throws Exception {
        author1.setEmail("gabriel_garcia_marquez@libros.co");
        assertThat(
                author1.getGender(),
                is(
                        allOf(
                                notNullValue(),
                                equalTo("MALE")
                        )
                )
        );
    }

    @Test
    public void toString_() throws Exception {
        assertThat(author1.toString(), is(equalTo("Author[name=Gabriel Garcia Marquez, email=gabo@libros.co, gender=MALE]")));
    }

}