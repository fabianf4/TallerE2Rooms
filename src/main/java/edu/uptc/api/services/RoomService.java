package edu.uptc.api.services;

import edu.uptc.api.entities.Room;
import edu.uptc.api.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }
    public List<Room> getRooms(){
        return roomRepository.findAll();
    }
    public Room save(Room room){
        return roomRepository.save(room);
    }

    public Room findById(int id){
        Optional<Room> room = roomRepository.findById(id);
        return room.isPresent() ? room.get() : null;
    }

    public Room update(Room room){
        if(findById(room.getId()) != null){
            return roomRepository.save(room);
        }else{
            return null;
        }
    }

    public Room delete(int id){
        Room room = findById(id);
        if(room != null){
            roomRepository.delete(room);
            return room;
        }else{
            return null;
        }
    }

}
