package ru.job4j.comparator;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(User o) {
        return new Integer(this.age).compareTo(o.age);
    }
}
