package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class PersonHasRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_person_has_role")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_person")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_role")
    private Role idRole;

    @Column(name="date_created")
    private LocalDateTime dateCreated;

    @Column(name="date_deleted")
    private LocalDateTime dateDeleted;

    public PersonHasRole() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(LocalDateTime dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    @Override
    public String toString() {
        return "PersonHasRole{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateDeleted=" + dateDeleted +
                '}';
    }
}
