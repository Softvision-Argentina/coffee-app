package com.maxi.calendar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Event {
	
	private int id;
	private Date date;
	private Date time;
	private int status;
	private String nameEvent;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="event_user", 
	joinColumns=@JoinColumn(name="event_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
	private List<User> users = new ArrayList<>();
	
	public Event() {
		
	}
	
	//full optional constructor
	public Event(Date date, Date time, int status, List<User> users) {
		this.date=date;
		this.time=time;
		this.status=status;
		this.users=users;
	}
	
	//"default" constructor for controller
	public Event( Date date, Date time, String nameEvent) {
		this.date = date;
		this.time = time;
		this.nameEvent=nameEvent;
	}

	//getters & setters	
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="name")
	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
