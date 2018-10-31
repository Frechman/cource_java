package ru.frechman.model;

import java.util.Date;

public class User {

    private Long id;

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    private String name;
    private String login;
    private String email;
    private Date createDate;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User [" +
                "id: " + id +
                ", name: " + name +
                ", login: " + login +
                ", email: " + email +
                ", createDate: " + createDate +
                ']';
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}