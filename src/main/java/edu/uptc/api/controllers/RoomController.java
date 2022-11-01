package edu.uptc.api.controllers;

import edu.uptc.api.entities.Room;
import edu.uptc.api.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://www.baeldung.com/spring-cors

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }
    @GetMapping
    public List<Room> getRooms(){
        return roomService.getRooms();
    }

    @PostMapping
    public Room save(@RequestBody Room room){
        return roomService.save(room);
    }

    @GetMapping("/{id}")
    public Room findById(@PathVariable Integer id){
        return roomService.findById(id);
    }

    @PutMapping
    public Room update(@RequestBody Room room){
        return roomService.update(room);
    }

    @DeleteMapping("/{id}")
    public Room delete(@PathVariable int id){
        return roomService.delete(id);
    }
}
