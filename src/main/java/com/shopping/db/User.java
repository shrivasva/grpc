package com.shopping.db;

public class User {
    private int id;
    private String username;
    private String name;
    private String gender;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (!username.equals(user.username)) return false;
        if (!name.equals(user.name)) return false;
        return gender.equals(user.gender);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age;
        return result;
    }


}
