package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contact")
    private Long id_contact;
    @Column(name="contact", length = 45)
    private String contact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_contact_type")
    private ContactType contactType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_person")
    private Person person;

    public Contact() {
    }

    public Long getId_contact() {
        return id_contact;
    }

    public void setId_contact(Long id_contact) {
        this.id_contact = id_contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id_contact=" + id_contact +
                ", contact='" + contact + '\'' +
                '}';
    }
}
