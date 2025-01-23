package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@MappedSuperclass
public class Person extends BaseEntity {
    @NotBlank(message = "First name cannot be blank!")
    @Column(name="first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank!")
    @Column(name="last_name")
    private String lastName;

    @Positive
    private int age;

    public Person() {

    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(long id, String firstName, String lastName, int age) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
