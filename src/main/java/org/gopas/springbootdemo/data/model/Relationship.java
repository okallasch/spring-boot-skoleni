package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="relationship")
public class Relationship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_relationship")
    private Long id;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person1")
    private Person personOne;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_person2")
    private Person personSecond;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_relationship_type")
    private RelationshipType relationshipType;

    public Relationship() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public void setPersonOne(Person personOne) {
        this.personOne = personOne;
    }

    public Person getPersonSecond() {
        return personSecond;
    }

    public void setPersonSecond(Person personSecond) {
        this.personSecond = personSecond;
    }

    public RelationshipType getRelationType() {
        return relationshipType;
    }

    public void setRelationType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
