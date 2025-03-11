package com.example.jakartaee;

public class Client {
    private String name;
    private String city;
    private int code;

    public Client(String name, String city, int code) {
        this.name = name;
        this.city = city;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCode() {
        return code;
    }
}
