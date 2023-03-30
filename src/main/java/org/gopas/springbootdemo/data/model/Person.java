package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO = z DB, IDENTITY = autoincrement, SEQUENCE = interní sequence v APP, TABLE= deprecated
    @Column(name = "id_person")
    private Long id;

    private int age;

    private LocalDate birthday;
    @Column(name="email")
    private String email;

    @Column(name="first_name")
    private String firstName;

    private String nickname;

    private String pwd;

    private String surname;

    @ManyToOne
    @JoinColumn(name="id_address")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idRole")
    private Set<PersonHasRole> personHasRoleSet;

    public Person() {
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address adress) {
        this.address = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    public Set<PersonHasRole> getPersonHasRoleSet() {
        return Collections.unmodifiableSet(personHasRoleSet);
    }

    public void setPersonHasRoleSet(Set<PersonHasRole> personHasRoleSet) {
        this.personHasRoleSet = personHasRoleSet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
