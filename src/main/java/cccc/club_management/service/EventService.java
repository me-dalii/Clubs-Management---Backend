package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Event;

import java.util.List;

public interface EventService {

    List<Event> getEvents();
    Event getEventById(Long id) throws NotFoundException;
    void saveEvent(Event event);
    void deleteEvent(Long id) throws NotFoundException;
    List<Event> getEventsByClubId(Long id);

    Event updateEventStatus(Long eventId, boolean status) throws NotFoundException;

    List<Event> getRejectedEvents();
    List<Event> getApprovedEvents();
    List<Event> getRequestedEvents();

    Long getTotalEvents();
    Long getTotalApprovedEvents();
}