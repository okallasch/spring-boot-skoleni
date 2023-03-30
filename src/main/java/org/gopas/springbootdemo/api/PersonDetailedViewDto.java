package org.gopas.springbootdemo.api;

import java.time.LocalDate;

public class PersonDetailedViewDto {

    private Long id;
    private int age;
    private LocalDate birthday;
    private String email;
    private String firstName;
    private String nickname;
    private String surname;
    private PersonAddressDto address;

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

    public PersonAddressDto getAddress() {
        return address;
    }

    public void setAddress(PersonAddressDto address) {
        this.address = address;
    }
}
