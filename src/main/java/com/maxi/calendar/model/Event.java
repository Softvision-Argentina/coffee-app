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
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	
	private int id;
	private Date day;
	private Date beginTime;
	private Date endTime;
	private int status;
	private String nameEvent;
	private List<User> users = new ArrayList<>();
	
	public Event() {
		
	}
	
	//full optional constructor
	public Event(Date day, Date beginTime, Date endTime, int status, List<User> users) {
		this.day=day;
		this.beginTime=beginTime;
		this.endTime=endTime;
		this.status=status;
		this.users=users;
	}
	
	//"default" constructor for controller
	public Event(Date day, Date beginTime, Date endTime, String nameEvent) {
		this.day=day;
		this.beginTime=beginTime;
		this.endTime=endTime;
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
	
	public Date getDay() {
		return day;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	@Column(name="begin_time")
	public Date getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	@Column(name="end_time")
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="event_user", 
	joinColumns=@JoinColumn(name="event_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
