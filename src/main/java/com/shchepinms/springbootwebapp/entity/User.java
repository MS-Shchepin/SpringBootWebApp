package com.shchepinms.springbootwebapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private int age;
    @JoinColumn(name = "car_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;

    public User() {
    }

    public User(String name, String lastname, int age, Car car) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.car = car;
    }

    public User(long id, String name, String lastname, int age, Car car) {
        this(name, lastname, age, car);
        this.id = id;
    }

    public long getId() {
        return id;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", car=").append(car);
        sb.append('}');
        return sb.toString();
    }
}
