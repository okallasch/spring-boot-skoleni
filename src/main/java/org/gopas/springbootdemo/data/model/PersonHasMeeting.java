package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PersonHasMeeting implements Serializable {

    @Id
    @Column(name="id_person")
    private Long idPerson;

    @Id
    @Column(name="id_meeting")
    private Long idMeeting;

    public PersonHasMeeting() {

    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(Long idMeeting) {
        this.idMeeting = idMeeting;
    }

    @Override
    public String toString() {
        return "PersonHasMeeting{" +
                "idPerson=" + idPerson +
                ", idMeeting=" + idMeeting +
                '}';
    }
}
