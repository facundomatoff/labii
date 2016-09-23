package org.utn.labii.oop;

import java.util.InputMismatchException;

/**
 * Created by nico on 9/18/16.
 */
public class Account {
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount){
        return this.balance = this.balance + amount;
    }

    public int debit(int amount) throws InputMismatchException{
        if(amount > balance) throw  new InputMismatchException("Amount exceeded balance");
        return this.balance = this.balance - amount;
    }

    public int transferTo(Account another, int amount)throws Exception, InputMismatchException{
        if(amount > this.balance) throw  new InputMismatchException("Amount exceeded balance");
        if(this.equals(another)) throw  new Exception("Transfer to itself not permitted");
        this.debit(amount);
        another.credit(amount);
        return this.balance;
    }

    @Override
    public String toString() {
        return String.format("Account[id=%s, name=%s, balance=%d]", id, name, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        return name.equals(account.name);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
