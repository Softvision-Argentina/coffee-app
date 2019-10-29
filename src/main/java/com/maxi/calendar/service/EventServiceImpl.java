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
	public void editEvent(String nameEvent) {
		Event event = eventRepository.findByName(nameEvent);
		eventRepository.save(event);

	}

	@Override
	public void deleteEvent(String nameEvent) {
		Event event = eventRepository.findByName(nameEvent);
		eventRepository.delete(event);
	}

	@Override
	public Event cancelEvent(String nameEvent) {
		Event event = eventRepository.findByName(nameEvent);
		event.setStatus(3);
		return eventRepository.save(event);
	}
	
	@Override
	public int setStatus(String nameEvent, int newStatus) {
		Event event = eventRepository.findByName(nameEvent);
		event.setStatus(newStatus);
		eventRepository.save(event);
		
		return event.getStatus();
		
	}

	@Override
	public void addUserAtEvent(User user, String nameEvent) {
		Event event = eventRepository.findByName(nameEvent);
		User newUser = userRepository.findByName(user.getName());
		
		event.getUsers().add(newUser);		

	}

	@Override
	public void deleteUserAtEvent(User user, String nameEvent) {
		Event event = eventRepository.findByName(nameEvent);
		event.getUsers().remove(user);

	}

}
