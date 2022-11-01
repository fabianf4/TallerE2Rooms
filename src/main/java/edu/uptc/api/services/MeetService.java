package edu.uptc.api.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.uptc.api.entities.Meet;
import edu.uptc.api.entities.Room;
import edu.uptc.api.repositories.MeetRepository;
import edu.uptc.api.repositories.RoomRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MeetService {
    private MeetRepository meetRepository;
    private RoomService roomService;

    public MeetService(MeetRepository meetRepository, RoomService roomService){
        this.meetRepository = meetRepository;
        this.roomService = roomService;
    }

    public Meet save(Meet meet) {
        Room room = roomService.findById(meet.getRoom().getId());
        if (room != null) {
            meet.setRoom(room);
            return meetRepository.save(meet);
        } else {
            return null;
        }
    }
    public Meet findById(int id){
        Optional<Meet> meet = meetRepository.findById(id);
        return meet.isPresent() ? meet.get() : null;
    }
    public Meet update(Meet meet){
        if(findById(meet.getId()) != null){
            return meetRepository.save(meet);
        }else{
            return null;
        }
    }
    public Meet delete(Meet meet){
        if(findById(meet.getId()) != null){
            meetRepository.delete(meet);
            return meet;
        }else{
            return null;
        }
    }

    public List<Meet> getMeets(){
        return meetRepository.findAll();
    }
}
