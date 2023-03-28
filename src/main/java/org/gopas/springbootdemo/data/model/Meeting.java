package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_meeting")
    private Long id;
    @Column(name="duration")
    private Long duration;
    @Column(name="note",  length = 1000)
    private String note;
    @Column(name="place", length = 200)
    private String place;
    @Column(name="start_time")
    private LocalDateTime startTime;




}
