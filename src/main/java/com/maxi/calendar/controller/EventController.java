package com.maxi.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.EventUserBody;
import com.maxi.calendar.model.User;
import com.maxi.calendar.service.EventServiceImpl;
import com.maxi.calendar.service.IEventService;
import com.maxi.calendar.service.IUserService;
import com.maxi.calendar.service.UserServiceImpl;

@RestController
@RequestMapping("/events")
public class EventController {
	
	//@Autowired
	IEventService 		eventService;
	//@Autowired
	IUserService		userService;
	
	EventController (EventServiceImpl eventService, UserServiceImpl userService){
		this.eventService=eventService;
		this.userService=userService;
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		
		List<Event> events = eventService.getAllEvents();
		if(events.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEvent(@PathVariable int id) {
		
		Event event = eventService.getEvent(id);
		
		if (event == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(event, HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEvent(@RequestBody Event newEvent) {
		
		Event event = eventService.createEvent(newEvent);
		
		return new ResponseEntity<>(event, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editEvent(@RequestBody Event uEvent, @PathVariable int id) {
		
		Event oldEvent = eventService.getEvent(id);

		if(oldEvent!=null) {
			eventService.editEvent(uEvent, oldEvent);
			return new ResponseEntity<>(oldEvent, HttpStatus.OK);
		}
				
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEvent(@PathVariable int id) {
		
		Event event = eventService.getEvent(id);		
		if(event != null) {
			eventService.deleteEvent(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@PutMapping("/status/{id}")
	public ResponseEntity<?> setEventStatus(@RequestBody Event sEvent, int id) { //both for cancel and status change
		
		Event event = eventService.getEvent(id);
		
		if(event != null) {
			event.setStatus(sEvent.getStatus());
			eventService.setStatus(event);
			return new ResponseEntity<>(event, HttpStatus.OK);
		}	
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping("/addUser")
//	public ResponseEntity<?> addUserAtEvent(@RequestBody User aUser, @RequestBody Event aEvent) {
//		
//		Event event = eventService.getEvent(aEvent.getId());
//		User user = userService.getUser(aUser.getId());
//		
//		if ((event==null) || (event==null)) {		
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		
//		event.getUsers().add(user);
//		user.getEvents().add(event);
//		eventService.insertUserAndEvent(event);		
//		return new ResponseEntity<>("OK", HttpStatus.OK);
//	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUserAtEvent(@RequestBody Event userEvent) {
		
		//Event event = rawBody.getEvent();
		List<User> user = userEvent.getUsers();
		
		Event event = eventService.getEvent(userEvent.getId());
		
		User usuario = userService.getUser(user.get(0).getId());
		//user = userService.getUser(user.get(0).getId());
		
		if ((event==null) || (user==null)) {		
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		event.getUsers().add(usuario);
		eventService.insertUserAndEvent(event);		
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
	
	@DeleteMapping("/{idUser}/{idEvent}")
	public ResponseEntity<?>  deleteUserAtEvent(@PathVariable int idUser, @PathVariable int idEvent) {
		
		Event event = eventService.getEvent(idEvent);
		User user = userService.getUser(idUser);	
		
		if ((event==null) || (user==null)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		event.getUsers().remove(user);
		user.getEvents().remove(event);
		eventService.deleteUserAndEvent(event);
		return new ResponseEntity<>("DELETED", HttpStatus.OK);

	}


}
