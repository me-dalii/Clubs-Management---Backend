package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.EventType;
import cccc.club_management.repositories.EventRepository;
import cccc.club_management.repositories.EventTypeRepository;
import cccc.club_management.service.EventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public List<EventType> getEventTypes() {
        return this.eventTypeRepository.findAll();
    }

    @Override
    public EventType getEventTypeById(Long id) throws NotFoundException {
        if(this.eventTypeRepository.findById(id).isPresent()) {
            return this.eventTypeRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveEventType(EventType eventType) {
        this.eventTypeRepository.save(eventType);
    }

    @Override
    public void deleteEventType(Long id) throws NotFoundException {
        if(this.eventTypeRepository.existsById(id)) {
            this.eventTypeRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }
}
