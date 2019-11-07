package com.todolist.service;

import com.todolist.dto.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventService implements IServiceUserEvent {


    @Override
    public List<Event> eventsAll() {
        return null;
    }
}
