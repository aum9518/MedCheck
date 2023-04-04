package medCheck.model;

import medCheck.enums.Gender;

public class Patient {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public Patient() {
    }

    public Patient(long id, String firstName, String lastName, int age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return " " +
                "\nid=" + id +
                "\n firstName='" + firstName + '\'' +
                "\n lastName='" + lastName + '\'' +
                "\n age=" + age +
                "\n gender=" + gender +
                ' ';
    }
}
