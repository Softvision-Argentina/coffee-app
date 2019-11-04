package com.maxi.calendar.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;
import com.maxi.calendar.service.IEventService;
import com.maxi.calendar.service.IUserService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	IEventService 		eventService;
	@Autowired
	IUserService		userService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		
		List<Event> events = eventService.getAllEvents();
		if(events.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getEvent(@PathVariable int id) {
		
		Event event = eventService.getEvent(id);
		
		if (event == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(event, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent) {
		
		Event event = eventService.createEvent(newEvent);
		
		return new ResponseEntity<>(event, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> editEvent(@RequestBody Event uEvent, @PathVariable int id) {
		
		Date uDay = uEvent.getDay();
		Date uBeginTime = uEvent.getBeginTime();
		Date uEndTime = uEvent.getEndTime();
		int  uName = uEvent.getStatus();
		
		Event event = eventService.getEvent(id);
		
		if (event != null) {
			
			if(!uDay.equals(event.getDay())) {
				event.setDay(uDay);
			}
			if(!uBeginTime.equals(event.getBeginTime())) {
				event.setBeginTime(uBeginTime);
			}
			if(!uEndTime.equals(event.getEndTime())) {
				event.setEndTime(uEndTime);
			}
			if(uName!=event.getStatus()) {
				event.setStatus(uName);
			}
			
			eventService.editEvent(event);
			return new ResponseEntity<>(event, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteEvent(@PathVariable int id) {
		
		Event event = eventService.getEvent(id);		
		if(event != null) {
			eventService.deleteEvent(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@RequestMapping(value="/status/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> setEventStatus(@RequestBody Event sEvent, int id) { //both for cancel and status change
		
		Event event = eventService.getEvent(id);
		
		if(event != null) {
			event.setStatus(sEvent.getStatus());
			eventService.setStatus(event);
			return new ResponseEntity<>(event, HttpStatus.OK);
		}	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/{idUser}/{idEvent}", method=RequestMethod.POST)
	public ResponseEntity<?>  addUserAtEvent(@PathVariable int idUser, @PathVariable int idEvent) {
		
		Event event = eventService.getEvent(idEvent);
		User user = userService.getUser(idUser);
		
		if ((event==null) || (event==null)) {		
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		event.getUsers().add(user);
		user.getEvents().add(event);
		eventService.insertUserAndEvent(event);		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value="/{idUser}/{idEvent}", method=RequestMethod.DELETE)
	public ResponseEntity<?>  deleteUserAtEvent(@PathVariable int idUser, @PathVariable int idEvent) {
		
		Event event = eventService.getEvent(idEvent);
		User user = userService.getUser(idUser);	
		
		if ((event==null) || (event==null)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		event.getUsers().remove(user);
		user.getEvents().remove(event);
		eventService.deleteUserAndEvent(event);
		return new ResponseEntity<>("DELETED", HttpStatus.OK);

	}


}
