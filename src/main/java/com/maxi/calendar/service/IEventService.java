package com.maxi.calendar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.utils.Status;

@Service
public interface IEventService {
	
	public List<Event> getAllEvents();
	
	public Event getEvent(int id);
	
	public Event createEvent(Event newEvent);
	
	public void editEvent(Event uEvent, Event oldEvent);
	
	public void deleteEvent(int id);
	
	public Status setStatus(Event event);	
	
	public void insertUserAndEvent(Event event);
	
	public void deleteUserAndEvent(Event event);
	
}
