package com.maxi.calendar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="event")
@AllArgsConstructor @Getter @Setter
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private Date day;
	
	@Column(name="begin_time")
	private Date beginTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	private int status;
	
	@Column(name="name")
	private String nameEvent;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="event_user", 
	joinColumns=@JoinColumn(name="event_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
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

}
