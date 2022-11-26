package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Event;
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

    @GetMapping("/club/{id}")
    public List<Event> getEventsByClubId(@PathVariable(name = "id") Long id){
        return eventService.getEventsByClubId(id);
    }

    @PutMapping("/status/{eventId}")
    public Event updateEventStatus(@PathVariable(name = "eventId") Long eventId, @RequestBody boolean status) throws NotFoundException {
        return eventService.updateEventStatus(eventId, status);
    }

    @GetMapping("/requested")
    public List<Event> getRequestedEvents(){
        return eventService.getRequestedEvents();
    }

    @GetMapping("/approved")
    public List<Event> getApprovedEvents(){
        return eventService.getApprovedEvents();
    }

    @GetMapping("/rejected")
    public List<Event> getRejectedEvents(){
        return eventService.getRejectedEvents();
    }

    @GetMapping("/count")
    public Long getTotalEvents(){
        return eventService.getTotalEvents();
    }

    @GetMapping("/count/approved")
    public Long getTotalApprovedEvents(){
        return eventService.getTotalApprovedEvents();
    }
}
