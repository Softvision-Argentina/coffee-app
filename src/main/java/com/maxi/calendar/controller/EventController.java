package com.maxi.calendar.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.EventRepository;
import com.maxi.calendar.service.IEventService;
import com.maxi.calendar.service.IUserService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	IEventService 		eventService;
	@Autowired
	IUserService		userService;
	
	Event event = new Event();
	User user = new User();
	List<User> users = new ArrayList<User>();
	
	String printError = "ERROR AL PROCESAR SOLICITUD";
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		
		List<Event> events = eventService.getAllEvents();
		if(events.isEmpty()) {
			return new ResponseEntity<>("NO HAY EVENTOS", HttpStatus.OK);
		}
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public ResponseEntity<?> getEvent(@PathVariable String name) {
		
		event = eventService.getEvent(name);
		
		if (event == null) {
			return new ResponseEntity<>(printError, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(event, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/new/{date}/{time}/{nameEvent}", method=RequestMethod.POST)
	public ResponseEntity<?> addEvent(@PathVariable Date date, @PathVariable Date time, @PathVariable String nameEvent) {
		
		event = eventService.createEvent(date, time, nameEvent);
		
		return new ResponseEntity<>(event, HttpStatus.OK);
	}
	
	@RequestMapping(value="/mod/{name}/{date}/{time}/{status}", method=RequestMethod.PUT)
	public ResponseEntity<?> editEvent(@PathVariable String name, @PathVariable Date date, @PathVariable Date time, @PathVariable int status) {
		
		event = eventService.getEvent(name);
		
		if (event != null) {
			
			if(!date.equals(event.getDate())) {
				event.setDate(date);
			}
			if(!time.equals(event.getTime())) {
				event.setTime(time);
			}
			if(status!=event.getStatus()) {
				event.setStatus(status);
			}
			
			eventService.editEvent(event);
			return new ResponseEntity<>(event, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(printError, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/d/{name}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteEvent(@PathVariable String name) {
		
		event = eventService.getEvent(name);		
		if(event != null) {
			eventService.deleteEvent(event);
			return new ResponseEntity<>("DELETED", HttpStatus.OK);
		}
		return new ResponseEntity<>(printError, HttpStatus.OK);
		
	}

	@RequestMapping(value="/modstatus/{name}/{status}", method=RequestMethod.PUT)
	public ResponseEntity<?> setEventStatus(@PathVariable String name, @PathVariable int status) { //both for cancel and status change
		
		event = eventService.getEvent(name);
		
		if(event != null) {
			event.setStatus(status);
			eventService.setStatus(event);
			return new ResponseEntity<>(event, HttpStatus.OK);
		}	
		return new ResponseEntity<>(printError, HttpStatus.OK);
	}
	
	@RequestMapping(value="/adduser/{nameUser}/{nameEvent}", method=RequestMethod.POST)
	public ResponseEntity<?>  addUserAtEvent(@PathVariable String nameUser, @PathVariable String nameEvent) {
		
		event = eventService.getEvent(nameEvent);
		user = userService.getUser(nameUser);
		
		if ((event!=null) || (event!=null)) {		
			return new ResponseEntity<>(printError, HttpStatus.OK);
		}		
		eventService.insertUserAndEvent(user.getId(), event.getId());		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteuser/{nameUser}/{nameEvent}", method=RequestMethod.DELETE)
	public ResponseEntity<?>  deleteUserAtEvent(@PathVariable String nameUser, @PathVariable String nameEvent) {
		
		event = eventService.getEvent(nameEvent);
		user = userService.getUser(nameUser);		
		if ((event!=null) || (event!=null)) {
			return new ResponseEntity<>(printError, HttpStatus.OK);
		}
		eventService.deleteUserAndEvent(user.getId(), event.getId());
		return new ResponseEntity<>("DELETED", HttpStatus.OK);

	}


}
