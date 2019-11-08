package com.todolist.models.repository;

import com.todolist.dto.Event;

import java.util.List;

public interface IEventDao {

    public List<Event> getAllEvents();

    public void saveNewEvent(Event event);

    public Event findEvent(Long id);

    public void deleteEvent(Long id);

}
