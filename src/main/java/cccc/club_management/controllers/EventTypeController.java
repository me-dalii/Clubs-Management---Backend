package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Event;
import cccc.club_management.models.EventType;
import cccc.club_management.service.EventService;
import cccc.club_management.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event_type")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    @GetMapping("/")
    public List<EventType> getEventTypes(){
        return eventTypeService.getEventTypes();
    }

    @GetMapping("/{id}")
    public EventType getEventTypeById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return eventTypeService.getEventTypeById(id);
    }

    @PostMapping("/")
    public void saveEventType(@RequestBody EventType eventType){
        eventTypeService.saveEventType(eventType);
    }

    @DeleteMapping("/{id}")
    public void deleteEventType(@PathVariable(name = "id") Long id) throws NotFoundException {
        eventTypeService.deleteEventType(id);
    }
}
