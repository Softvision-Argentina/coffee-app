package com.maxi.calendar.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;

@Service
public interface IEventService {
	
	public List<Event> getAllEvents();
	
	public Event getEvent(String nameEvent);
	
	public Event createEvent(Date date, Date time, String nameEvent);
	
	public void editEvent(Event event);
	
	public void deleteEvent(Event event);
	
	public int setStatus(Event event);	
	
	public void addUserAtEvent(User user, String nameEvent);
	
	public void deleteUserAtEvent(User user, Event event);
	
	
}
