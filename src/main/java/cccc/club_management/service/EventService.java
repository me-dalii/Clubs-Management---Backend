package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Event;

import java.util.List;

public interface EventService {

    List<Event> getEvents();
    Event getEventById(Long id) throws NotFoundException;
    void saveEvent(Event event);
    void deleteEvent(Long id) throws NotFoundException;
}