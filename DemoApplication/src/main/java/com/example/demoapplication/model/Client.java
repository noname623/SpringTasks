package com.example.demoapplication.model;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class Client {
    Random random = new Random();
    private String name;
    private Integer num = random.nextInt(100) + 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Client() {
    }

    public Client(String name) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}