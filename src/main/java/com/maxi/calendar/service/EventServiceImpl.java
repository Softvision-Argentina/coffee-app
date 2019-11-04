package com.maxi.calendar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.EventRepository;
import com.maxi.calendar.repository.UserRepository;
import com.maxi.calendar.utils.Status;

@Service
public class EventServiceImpl implements IEventService {
	
	@Autowired
	EventRepository eventRepository;
	@Autowired
	UserRepository  userRepository;

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Event getEvent(int id) {
		return eventRepository.findById(id);
	}

	@Override
	public Event createEvent(Event newEvent) {
		return eventRepository.save(newEvent);
	}

	@Override
	public void editEvent(Event uEvent, Event oldEvent) {		
		
		Date uDay = uEvent.getDay();
		Date uBeginTime = uEvent.getBeginTime();
		Date uEndTime = uEvent.getEndTime();
		Status  uStatus = uEvent.getStatus();
		
		if (oldEvent != null) {
					
			if(!uDay.equals(oldEvent.getDay())) {
				oldEvent.setDay(uDay);
			}
			if(!uBeginTime.equals(oldEvent.getBeginTime())) {
				oldEvent.setBeginTime(uBeginTime);
			}
			if(!uEndTime.equals(oldEvent.getEndTime())) {
				oldEvent.setEndTime(uEndTime);
			}
			if(uStatus!=oldEvent.getStatus()) {
				oldEvent.setStatus(uStatus);
			}
		}
		eventRepository.save(uEvent);
	}

	@Override
	public void deleteEvent(int id) {
		
		eventRepository.deleteById(id);
	}

	@Override
	public Status setStatus(Event event) {
		eventRepository.save(event);
		
		return event.getStatus();
		
	}
	
	@Override
	public void insertUserAndEvent(Event event) {
		eventRepository.save(event);
	}

	@Override
	public void deleteUserAndEvent(Event event) {
		eventRepository.delete(event);

	}


}
