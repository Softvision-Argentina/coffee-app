package com.maxi.calendar.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;

@Service
public interface IEventService {
	
	public List<Event> getAllEvents();
	
	public Event getEvent(int id);
	
	public Event createEvent(Event newEvent);
	
	public void editEvent(Event event);
	
	public void deleteEvent(int id);
	
	public int setStatus(Event event);	
	
	public void insertUserAndEvent(Event event);
	
	public void deleteUserAndEvent(Event event);
	
}
