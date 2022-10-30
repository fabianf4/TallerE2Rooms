package edu.uptc.api.repositories;

import edu.uptc.api.entities.Act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRepository extends JpaRepository<Act, Integer> {

}
