package edu.uptc.api.services;

import edu.uptc.api.entities.Act;
import edu.uptc.api.repositories.ActRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActService {
    private ActRepository actRepository;

    public ActService(ActRepository actRepository) {
        this.actRepository = actRepository;
    }

    public Act save(Act act) {
        return actRepository.save(act);
    }

    public Act findById(int id) {
        return actRepository.findById(id).get();
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
