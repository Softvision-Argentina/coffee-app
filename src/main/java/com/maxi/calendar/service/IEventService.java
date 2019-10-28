package com.maxi.calendar.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;

@Service
public interface IEventService {
	
	public Event getAllEvents();
	
	public Event getEvent(String nameEvent);
	
	public Event createEvent(Date date, Date time, String nameEvent);
	
	public void editEvent(String nameEvent);
	
	public void deleteEvent(String nameEvent);
	
	public Event cancelEvent(String nameEvent);
	
	public void addUserAtEvent(User user, String nameEvent);
	
	public void deleteUserAtEvent(User user, String nameEvent);
	
	public void editUserAtEvent(User user, String nameEvent);
	
	public String setStatus(String nameEvent);	
	
}
