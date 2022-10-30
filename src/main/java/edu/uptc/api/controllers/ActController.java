package edu.uptc.api.controllers;

import edu.uptc.api.entities.Act;
import edu.uptc.api.services.ActService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/act")
public class ActController {
    private ActService actService;

    public ActController(ActService actService){
        this.actService = actService;
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

    @DeleteMapping
    public Act delete(@RequestBody Act act){
        return actService.delete(act);
    }
}
