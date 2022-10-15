package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.EventType;

import java.util.List;

public interface EventTypeService {

    List<EventType> getEventTypes();
    EventType getEventTypeById(Long id) throws NotFoundException;
    void saveEventType(EventType eventType);
    void deleteEventType(Long id) throws NotFoundException;
}