package com.maxi.calendar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.maxi.calendar.utils.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@AllArgsConstructor @Getter @Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private Roles role;
	
	@ManyToMany(mappedBy="users")
	private List<Event> events = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(String name, Roles role) {
		this.name=name;
		this.role=role;
	}

}
