package main.java.com.frre.tsp.oop.ejerciciosGuia;

/**
 * Ejercicio 5 - Guia de OOP.
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        authors();
    }

    static void authors() {

        Author[] authors = new Author[2];
        authors[0] = new Author("a1");
        authors[1] = new Author("a2");

        Book book = new Book("Hola Mundo!", authors);

        System.out.println(book.name);

        System.out.println("nombre " + book.authors[0].getName() + " libro: " + book.authors[0].getBooks()[0].name);
        System.out.println("nombre " + book.authors[1].getName() + " libro: " + book.authors[1].getBooks()[0].name);
    }
}

/**
 * Clase Author con una modificacion que permite registrar los libros del Author.
 */
class Author {

    private String name;
    private Book[] books = new Book[10];
    private int count = 0;

    public Author(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setBook(Book book) {

        if (this.count < 10) {
            this.books[this.count] = book;
            count++;
        }
    }

    Book[] getBooks() {
        return this.books;
    }
}

/**
 * Clase Book, permite asignar el libro creado a cada Author.
 */
class Book {

    public String name;
    public Author[] authors;

    public Book(String name, Author[] authors) {

        this.name = name;
        this.authors = authors;

        for (Author a: authors) {
            a.setBook(this);
        }

    }

}


