package org.utn.labii.oop;

/**
 * Created by nico on 9/16/16.
 */
public class Author {
    private String name;
    private String email;
    private Gender gender;
    private enum Gender{MALE, FEMALE}

    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = (gender == 'm')? Gender.MALE : Gender.FEMALE;
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

    public String getGender() {
        return gender.toString();
    }

    @Override
    public String toString() {
        return String.format("Author[name=%s, email=%s, gender=%s]", name, email, gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return equals(author);
    }

    private boolean equals(Author author){
        if (!name.equals(author.name)) return false;
        if (!email.equals(author.email)) return false;
        return gender == author.gender;

    }
}
