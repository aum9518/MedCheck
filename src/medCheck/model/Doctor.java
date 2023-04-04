package medCheck.model;

import medCheck.enums.Gender;

public class Doctor {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int experienceYear;

    public Doctor(Long id, String firstName, String lastName, Gender gender, int experienceYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
    }
}
