package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Club;
import cccc.club_management.models.Event;
import cccc.club_management.service.ClubService;
import cccc.club_management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public List<Event> getEvents(){
        return eventService.getEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return eventService.getEventById(id);
    }

    @PostMapping("/")
    public void saveEvent(@RequestBody Event event){
        eventService.saveEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventService.deleteEvent(id);
    }
}
