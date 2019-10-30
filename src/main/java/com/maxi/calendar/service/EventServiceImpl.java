package com.maxi.calendar.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.EventRepository;
import com.maxi.calendar.repository.UserRepository;

@Service
public class EventServiceImpl implements IEventService {
	
	EventRepository eventRepository;
	UserRepository  userRepository;

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event getEvent(String nameEvent) {
		return eventRepository.findByName(nameEvent);
	}

	@Override
	public Event createEvent(Date date, Date time, String nameEvent) {
		Event newEvent = new Event (date, time, nameEvent);
		return eventRepository.save(newEvent);
	}

	@Override
	public void editEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public void deleteEvent(Event event) {
		
		eventRepository.delete(event);
	}

	@Override
	public int setStatus(Event event) {
		eventRepository.save(event);
		
		return event.getStatus();
		
	}
	
	@Override
	public void insertUserAndEvent(int userId, int eventId) {
		eventRepository.addUserToEvent(userId, eventId);

	}

	@Override
	public void deleteUserAndEvent(int userId, int eventId) {
		eventRepository.removeUserFromEvent(userId, eventId);

	}


}
