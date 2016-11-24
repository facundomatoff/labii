package EjerciciosOOP;

/**
 * Created by umantram on 16/11/16.
 */
public class Main {

    public static void main (String[] args ) throws Exception {

        /*
        Circle circulo = new Circle(2);

        System.out.println(circulo.getArea());
        System.out.println(circulo.getCircumference());

        System.out.println("circulo = " + circulo);

        */

        /*
        Employee emple = new Employee(0,"Andres", "Salinas", 200);

        System.out.println("emple = " + emple);

        System.out.println(emple.AnnualSalary());
        System.out.println(emple.reaiseSalary(2));
        */

        /*
        Author au = new Author("Andres", "umantram", 'M');
        System.out.println(au);
        */

        /*
        Account cuen = new Account("A", "Andres", 1000);
        Account cuen2 = new Account("B", "Juan");

        System.out.println(cuen.credit(50));
        System.out.println(cuen.debit(50));

        System.out.println(cuen.transferTo(cuen2, 600));

        System.out.println(cuen);

        System.out.println(cuen2);
        */

        Author[] autores = {new Author("mama","jojo",'F'), new Author("pepe", "jiji", 'M')};

        Book libro = new Book("Prog", autores, 123);

        System.out.println(libro);

        System.out.println(libro.getAuthorsNames());

    }
}
