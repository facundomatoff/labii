package org.utn.labii.oop.test;

import org.junit.Before;
import org.junit.Test;
import org.utn.labii.oop.Author;
import org.utn.labii.oop.Book;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by nico on 9/16/16.
 */
public class BookTest {

    private Book book1;
    private Book book2;
    private final String TO_STRING_EXP_OUT =
            "Book[name=Cronica de una muerte anunciada, authors={Author[name=Gabriel Garcia Marquez, email=gabo@libros.co, gender=MALE]}, price=33.3, qty=0]";
    private final String GET_AUTHOR_NAMES_EXP_OUT = "Gabriel Garcia Marquez, Julio Cortazar, Ernesto Sábato";

    @Before
    public void setUp() throws Exception {
        Author[] authors1, authors2;
        authors1 = new Author[]{
                new Author("Gabriel Garcia Marquez", "gabo@libros.co", 'm'),
        };

        authors2 = new Author[]{
                new Author("Gabriel Garcia Marquez", "gabo@libros.co", 'm'),
                new Author("Julio Cortazar", "julio@libros.ar", 'm'),
                new Author("Ernesto Sábato", "Enrnesto@libros.ar", 'm')
        };

        book1 = new Book("Cronica de una muerte anunciada", authors1, 33.3);
        book2 = new Book("Cien Años De Soledad", authors2, 53.6, 5);

    }

    @Test
    public void getName() throws Exception {
        assertThat(book2.getName(), equalTo("Cien Años De Soledad"));
    }

    @Test
    public void getAuthors() throws Exception {
        Author[] a = {new Author("Gabriel Garcia Marquez", "gabo@libros.co", 'm')};
        assertThat(book1.getAuthors(), equalTo(a));
    }

    @Test
    public void getPrice() throws Exception {
        assertThat(
                book2.getPrice(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(53.6)
                )
        );
    }

    @Test
    public void setPrice() throws Exception {
        book1.setPrice(44.5);
        assertThat(
                book1.getPrice(),
                allOf(
                        notNullValue(),
                        instanceOf(Double.class),
                        equalTo(44.5)
                )
        );
    }

    @Test
    public void getQty() throws Exception {

        assertThat(
                book1.getQty(),
                allOf(
                        notNullValue(),
                        instanceOf(Integer.class),
                        equalTo(0)
                )
        );
    }

    @Test
    public void setQty() throws Exception {
        book1.setQty(4);

        assertThat(
                book1.getQty(),
                allOf(
                        notNullValue(),
                        instanceOf(Integer.class),
                        equalTo(4)
                )
        );
    }

    @Test
    public void toString_() throws Exception {
        assertThat(
                book1.toString(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo(TO_STRING_EXP_OUT)
                        )
                )
        );
    }

    @Test
    public void getAuthorsNames() throws Exception {
        assertThat(
                book2.getAuthorsNames(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo(GET_AUTHOR_NAMES_EXP_OUT)
                        )
                )
        );
    }

}