package org.gopas.springbootdemo.api;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PersonUpdateDto {

    @NotNull
    private Long id;
    private int age;
    private LocalDate birthday;
    private String email;
    private String firstName;
    private String nickname;
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "PersonUpdateDto{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
