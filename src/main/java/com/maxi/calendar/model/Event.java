package com.maxi.calendar.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.maxi.calendar.utils.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="event")
@AllArgsConstructor @Getter @Setter @Builder
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private LocalDate day;
	
	@Column(name="begin_time")
	private LocalTime beginTime;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="name")
	private String nameEvent;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="event_user", 
	joinColumns=@JoinColumn(name="event_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
	final private List<User> users = new ArrayList<>();

}
