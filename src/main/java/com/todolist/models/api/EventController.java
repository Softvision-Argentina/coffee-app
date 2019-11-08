package com.todolist.models.api;

import com.todolist.dto.Event;
import com.todolist.models.repository.IEventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
//@SessionAttributes("event")
public class EventController {

    @Autowired
    @Qualifier(value = "EventDaoImpl")
    private IEventDao eventDao;

    @GetMapping(value = "/events")
    public String getEvents(Model model) {
        model.addAttribute("titulo", "Get all events");
        model.addAttribute("events", eventDao.getAllEvents());
        return "events";
    }

    //To show the form to add new events
    @GetMapping(value = "/form")
    public String addEvent(Map<String, Object> model) {
        Event event = new Event();
        model.put("event", event);
        model.put("titulo", "Add new task or Event");
        return "form";
    }

    //In this case we take the object inserted from the form described above and save it with the method addNewEvent
    // and return the view that implements all list of events, to add the new one
    @PostMapping(value = "/form")
    public String addNewEvent(@Valid Event event, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("titulo", "Add new task or Event");
            return "form";
        }
        eventDao.saveNewEvent(event);
        return "redirect:events";
    }

    @PatchMapping(value = "/events/{id}")
    public String editEvent(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        Event event = null;

        if(id > 0) {
            event = eventDao.findEvent(id);
        } else {
            return "redirect:/events";
        }
        model.put("event", event);
        model.put("title", "Edit Event");
        return "form";
    }

    @DeleteMapping (value = "/events/{id}")
    public String deleteEvent(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            eventDao.deleteEvent(id);
        }
        return "redirect:/events";
    }

}