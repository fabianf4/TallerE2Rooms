package edu.uptc.api.services;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.uptc.api.entities.Meet;
import edu.uptc.api.repositories.MeetRepository;
import edu.uptc.api.repositories.RoomRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MeetService {
    private MeetRepository meetRepository;

    public MeetService(MeetRepository meetRepository){
        this.meetRepository = meetRepository;
    }

    public Meet save(Meet meet){
        
        return meetRepository.save(meet);
    }
    public Meet findById(int id){
        return meetRepository.findById(id).get();
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
