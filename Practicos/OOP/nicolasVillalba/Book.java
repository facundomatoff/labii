package org.utn.labii.oop;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by nico on 9/16/16.
 */
public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price){
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return String.format("Book[name=%s, authors={%s}, price=%.1f, qty=%d]", name, getListOfAuthors(this.authors), price, qty);
    }

    private String getListOfAuthors(Author[] authors){
        return Arrays.stream(authors).map(Author::toString).collect(Collectors.joining(", "));
    }

    private String getListOfAuthors2(Author[] authors){
        StringJoiner sj = new StringJoiner("");
        for(Author author : authors){
            sj.add(author.toString());
        }
        return sj.toString();
    }

    public String getAuthorsNames(){
        return Arrays.stream(authors).map(Author::getName).collect(Collectors.joining(", "));
    }
}
