package edu.uptc.api.services;

import edu.uptc.api.entities.Act;
import edu.uptc.api.entities.Meet;
import edu.uptc.api.repositories.ActRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActService {
    private ActRepository actRepository;
    private MeetService meetService;

    public ActService(ActRepository actRepository, MeetService meetService) {
        this.actRepository = actRepository;
        this.meetService = meetService;
    }

    public Act save(Act act) {
        Meet meet = meetService.findById(act.getMeet().getId());
        if (meet != null) {
            act.setMeet(meet);
            return actRepository.save(act);
        } else {
            return null;
        }
    }

    public Act findById(int id) {
        Optional<Act> act = actRepository.findById(id);
        return act.isPresent() ? act.get() : null;

    }

    public List<Act> getActs() {
        return actRepository.findAll();
    }

    public Act update(Act act) {
        if (findById(act.getId()) != null) {
            return actRepository.save(act);
        } else {
            return null;
        }
    }

    public Act delete(Act act) {
        if (findById(act.getId()) != null) {
            actRepository.delete(act);
            return act;
        } else {
            return null;
        }
    }
}
