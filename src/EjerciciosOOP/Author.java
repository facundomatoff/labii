package EjerciciosOOP;

/**
 * Created by umantram on 16/11/16.
 */
public class Author {

    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) throws Exception {
        this.name = name;
        this.email = email;

        if (gender == 'F' || gender == 'M') {

            this.gender = gender;
        }else {
            throw new Exception("oooo");


        }

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
