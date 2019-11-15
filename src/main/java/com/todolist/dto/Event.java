package com.todolist.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "events")
public class Event implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column
    private String status;

    @NotNull
    @Column(name = "event_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    @NotEmpty
    @Column(name = "event_title")
    private String eventTitle;

    @NotEmpty
    @Column(name= "event_description")
    private String eventDescription;

    @ManyToMany(mappedBy = "events")
    private Set<User> users = new HashSet<>();

    public Event() {
    }

    public Event(Long id, String status, Date eventDate, String eventTitle, String eventDescription) {
        this.id = id;
        this.status = status;
        this.eventDate = eventDate;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        //this.users = users;
    }

    public void addUser(User user){
        user.getEvents().add(this);
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
        user.getEvents().remove(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
       this.users = users;
    }
}
