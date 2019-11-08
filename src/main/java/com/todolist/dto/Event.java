package com.todolist.dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
    private Date eventDate;

    @NotEmpty
    @Column(name = "event_title")
    private String eventTitle;

    @NotEmpty
    @Column(name= "event_description")
    private String eventDescription;

    //@ManyToMany(mappedBy = "events")
    //private List<User> users;

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

    //public List<User> getUsers() {
      //  return users;
    //}

    //public void setUsers(List<User> users) {
      //  this.users = users;
    //}
}
