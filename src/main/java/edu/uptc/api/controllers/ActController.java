package edu.uptc.api.controllers;

import edu.uptc.api.entities.Act;
import edu.uptc.api.entities.Meet;
import edu.uptc.api.services.ActService;
import edu.uptc.api.services.MeetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/act")
public class ActController {
    private ActService actService;
    private MeetService meetService;
    public ActController(ActService actService, MeetService meetService){
        this.actService = actService;
        this.meetService = meetService;
    }

    @GetMapping("/{id}")
    public Act getAct(@PathVariable Integer id){
        return actService.findById(id);
    }

    @GetMapping
    public List<Act> getAct(){
        return actService.getActs();
    }

    @PostMapping
    public Act save(@RequestBody Act act){
        return actService.save(act);
    }

    @PutMapping
    public Act update(@RequestBody Act act){
        return actService.update(act);
    }

    @DeleteMapping("/{id}")
    public Act delete(@PathVariable Integer id){
        return actService.delete(id);
    }

    @GetMapping("/meet/{id}")
    public List<Act> getActsByMeet(@PathVariable int id){
        Meet meet = meetService.findById(id);
        if (meet != null){
            return actService.getActsByMeet(meet);
        }else{
            return null;
        }
    }
}
