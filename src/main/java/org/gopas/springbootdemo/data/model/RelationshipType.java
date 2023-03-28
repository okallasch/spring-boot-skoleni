package org.gopas.springbootdemo.data.model;

import javax.persistence.*;

@Entity
@Table(name="relationship_type")
public class RelationshipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_relationship_type")
    private Long id;

    @Column(name="title", length = 255)
    private String title;

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
        return "RelationType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
