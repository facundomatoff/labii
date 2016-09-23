package org.utn.labii.oop.test;


import org.junit.Before;
import org.junit.Test;
import org.utn.labii.oop.Account;

import java.util.InputMismatchException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by nico on 9/19/16.
 */
public class AccountTest {

    private Account account1;
    private Account account2;
    private Account account3;

    @Before
    public void setUp() throws Exception {
        account1 = new Account("322","Andre Vellar");
        account2 = new Account("352","March Metz", 4555);
        account3 = new Account("318","Guido Liss");
    }

    @Test
    public void getID() throws Exception {
        assertThat(
                account1.getID(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo("322")
                        )
                )
        );
    }

    @Test
    public void getName() throws Exception {
        assertThat(
                account2.getName(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(String.class),
                                equalTo("March Metz")
                        )
                )
        );
    }

    @Test
    public void getBalance() throws Exception {
        assertThat(
                account1.getBalance(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Integer.class),
                                equalTo(0)
                        )
                )
        );

        assertThat(
                account2.getBalance(),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Integer.class),
                                equalTo(4555)
                        )
                )
        );

    }

    @Test
    public void credit() throws Exception {
        assertThat(
                account1.credit(4545),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Integer.class),
                                equalTo(4545)
                        )
                )
        );

        assertThat(
                account2.credit(1),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Integer.class),
                                equalTo(4556)
                        )
                )
        );
    }

    @Test(expected=InputMismatchException.class)
    public void debit() throws Exception {
        assertThat(
                account1.debit(4545),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Integer.class),
                                equalTo(4545)
                        )
                )
        );

        assertThat(
                account2.debit(1),
                is(
                        allOf(
                                notNullValue(),
                                instanceOf(Integer.class),
                                equalTo(4554)
                        )
                )
        );
    }

    @Test
    public void transferTo() throws Exception {
        assertThat(
                account2.transferTo(account1, 555),
                allOf(
                        notNullValue(),
                        instanceOf(Integer.class),
                        equalTo(4000)
                )
        );

        assertThat(
                account1.transferTo(account1, 555),
                allOf(
                        notNullValue(),
                        instanceOf(Integer.class),
                        equalTo(4000)
                )
        );
    }

    @Test
    public void toString_() throws Exception {
        assertThat(
                account1.toString(),
                allOf(
                        notNullValue(),
                        instanceOf(String.class),
                        equalTo("Account[id=322, name=Andre Vellar, balance=0]")
                )
        );
    }

}