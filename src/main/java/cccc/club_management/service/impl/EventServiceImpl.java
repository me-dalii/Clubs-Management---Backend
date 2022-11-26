package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Event;
import cccc.club_management.repositories.EventRepository;
import cccc.club_management.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getEvents() {
        return this.eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) throws NotFoundException {
        if(this.eventRepository.findById(id).isPresent()) {
            return this.eventRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveEvent(Event event) {
        this.eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) throws NotFoundException {
        if(this.eventRepository.existsById(id)) {
            this.eventRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public List<Event> getEventsByClubId(Long id) {
        return this.eventRepository.findAllByClubId(id);
    }

    @Override
    public Event updateEventStatus(Long eventId, boolean status) throws NotFoundException {
        Event event = this.getEventById(eventId);
        event.setStatus(status);
        return this.eventRepository.save(event);
    }

    @Override
    public List<Event> getRejectedEvents() {
        return this.eventRepository.findAllByStatusFalse();
    }

    @Override
    public List<Event> getApprovedEvents() {
        return this.eventRepository.findAllByStatusTrue();
    }

    @Override
    public List<Event> getRequestedEvents() {
        return this.eventRepository.findAllByStatusNull();
    }
}
