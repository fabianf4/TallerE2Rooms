package edu.uptc.api.repositories;
import edu.uptc.api.entities.Meet;
import edu.uptc.api.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface MeetRepository extends JpaRepository<Meet, Integer> {
    List<Meet> findByRoom(Room room);
}
