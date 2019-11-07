/**package com.todolist.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table (name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable (
            name = "Users_Events",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "event_id")}
    )
    private List<Event> event;

    public User() {
    }

    public User(long id, String firstName, String lastName, String email, List<Event> event) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.event = event;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return email;
    }

    public void setPassword(String password) {
        this.email = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
} **/
