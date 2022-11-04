package edu.uptc.api.controllers;

import edu.uptc.api.entities.Meet;
import edu.uptc.api.entities.Room;
import edu.uptc.api.services.MeetService;
import edu.uptc.api.services.RoomService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/meet")
public class MeetController {
    private MeetService meetService;
    private RoomService roomService;

    public MeetController(MeetService meetService,RoomService roomService){
        this.meetService = meetService;
        this.roomService = roomService;
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

    @DeleteMapping("/{id}")
    public Meet delete(@PathVariable Integer id){
        return meetService.delete(id);
    }

    @GetMapping("/room/{id}")
    public List<Meet> getRoomsByMeet(@PathVariable int id){
        Room room =roomService.findById(id);
        if(room != null){
            return meetService.getMeetsByRoom(room);
        }else{
            return null;
        }
    }
}