package com.maxi.calendar.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Event {
	
	private int id;
	private Date date;
	private Date time;
	private int status;
	private String nameEvent;
	private User users;
	
	//full optional constructor
	public Event(Date date, Date time, int status, User users) {
		this.date=date;
		this.time=time;
		this.status=status;
		this.users=users;
	}
	
	//"default" constructor for controller
	public Event( Date date, Date time) {
		this.date = date;
		this.time = time;
	}

	//getters & setters
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
	
	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	
	public User getUsers() {
		return users;
	}
	
	public void setUsers(User users) {
		this.users = users;
	}
	

}
