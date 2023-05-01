package com.example.demoapplication.model;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier(value = "com.example.demoapplication.processing.BaristaCoffe")
public class Staff {
    private String name;
    private String post;
    private Double salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double  salary) {
        this.salary = salary;
    }

    public Staff() {

    }

    public Staff(String name, String post, Double salary) {
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}';
    }
}