package edu.uptc.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "meets")
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(nullable = false, length = 255)
    private String affair;

    private LocalDateTime dateMeet;

    @OneToOne
    private Act act;

    @ManyToOne
    private Room room;

    public Meet() {
    }

    public Meet(int id, String affair, LocalDateTime dateMeet, Act act, Room room) {
        this.id = id;
        this.affair = affair;
        this.dateMeet = dateMeet;
        this.act = act;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public LocalDateTime getDateMeet() {
        return dateMeet;
    }

    public void setDateMeet(LocalDateTime dateMeet) {
        this.dateMeet = dateMeet;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
