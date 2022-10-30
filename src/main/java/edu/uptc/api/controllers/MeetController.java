package edu.uptc.api.controllers;

import edu.uptc.api.entities.Meet;
import edu.uptc.api.services.MeetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/meet")
public class MeetController {
    private MeetService meetService;

    public MeetController(MeetService meetService){
        this.meetService = meetService;
    }

    @GetMapping
    public List<Meet> getMeets(){
        return meetService.getMeets();
    }

    @PostMapping
    public Meet save(@RequestBody Meet meet){
        return meetService.save(meet);
    }

    @GetMapping("/{id}")
    public Meet findById(@PathVariable Integer id){
        return meetService.findById(id);
    }

    @PutMapping
    public Meet update(@RequestBody Meet meet){
        return meetService.update(meet);
    }

    @DeleteMapping
    public Meet delete(@RequestBody Meet meet){
        return meetService.delete(meet);
    }
}
