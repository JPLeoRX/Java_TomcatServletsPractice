package database_example;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private String country;
    private int id;

    public User(String name, String email, String country, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "User: Name=" + this.name + ", Email=" + this.email + ", Country=" + this.country + ", Id=" + this.id;
    }
}
