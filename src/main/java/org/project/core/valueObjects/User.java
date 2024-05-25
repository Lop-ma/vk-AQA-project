package org.project.core.valueObjects;

public class User {
    private final String login;
    private final String password;
    private final String name;
    private final String surname;

    public User(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.name = "";
        this.surname = "";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
