package ru.khusnullin.SpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Lastname should not be empty")
    @Size(min = 3, max = 30, message = "Lastname should be between 3 and 30 characters")
    @Column(name = "lastname")
    private String lastname;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Age should be less then 150")
    @Column(name = "age")
    private int age;

    public User() {}

    public User(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
