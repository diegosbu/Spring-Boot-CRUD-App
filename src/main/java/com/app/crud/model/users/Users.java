package com.app.crud.model.users;

//  Model of users data fields

public class Users {
    private int id;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRoles() {
        return "USER";
    }

    public String toString() {
        return "Email: " + this.email + "Password: " + this.password;
    }
}
