package com.maxi.calendar.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.maxi.calendar.model.Event;
import com.maxi.calendar.model.User;
import com.maxi.calendar.repository.EventRepository;
import com.maxi.calendar.service.IEventService;
import com.maxi.calendar.service.IUserService;

@Controller
public class EventController {
	
	IEventService eventService;
	IUserService  userService;
	
	Event event = new Event();
	User user = new User();
	List<User> users = new ArrayList<User>();
	
	String printError;
	
	public List<Event> getAll(){
		
		return eventService.getAllEvents();
	}
	
	public Event getEvent(String name) {
		
		event = eventService.getEvent(name);
		
		if (event != null) {
			return event;
		}
		
		return printError="No existe evento";
		
	}
	
	public Event addEvent(Date date, Date time, String nameEvent) {
		
		return eventService.createEvent(date, time, nameEvent);
		
	}
	
	public void editEvent(String name, Date date, Date time, int status) {
		
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
		}
		
		printError="No existe evento";
		
	}
	
	public void deleteEvent(String name) {
		
		event = eventService.getEvent(name);
		
		if(event != null) {
			eventService.deleteEvent(event);
		}
		
	}

	public String setEventStatus(String name, int status) { //both for cancel and status change
		
		event = eventService.getEvent(name);
		
		if(event != null) {
			event.setStatus(status);
			eventService.setStatus(event);
			return "Status changed";
		}
		
		return printError="No existe evento";
	}

	public String  addUserAtEvent(String nameUser, String nameEvent) {
		
		event = eventService.getEvent(nameEvent);
		user = userService.getUser(nameUser);
		
		if ((event.equals(null)) || (user.equals(null))) {
			
			return printError="Nor event or user exists";
		}
		
		event.setUsers(users.add(user));
	}
	
	public String  deleteUserAtEvent(String nameUser, String nameEvent) {
		
		event = eventService.getEvent(nameEvent);
		user = userService.getUser(nameUser);
		
		if ((event.equals(null)) || (user.equals(null))) {
			
			return printError="Nor event or user exists";
		}
		
		for(User userF : event.getUsers()) {
			if (userF.getName().equals(user.getName())){
				
				eventService.deleteUserAtEvent(userF, event);
				
				return "User removed from event";
			}
		}
	}


}
