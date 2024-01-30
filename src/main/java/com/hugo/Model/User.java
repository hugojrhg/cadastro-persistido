package com.hugo.Model;

import java.util.Objects;

public class User {

    private Long id;
    private String fullName;
    private int age;
    private String job;

    public User() {
    }

    public User(Long id, String fullName, int age, String job) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public java.lang.String getJob() {
        return job;
    }

    public void setJob(java.lang.String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return
                id +
                "," + fullName +
                "," + age +
                "," + job
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
