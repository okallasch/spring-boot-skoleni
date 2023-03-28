package org.gopas.springbootdemo.data.model;

import javax.persistence.*;

@Entity
public class ContactType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contact_type")
    private Long id;
    @Column(name="title", length = 45)
    private String title;

    public ContactType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
