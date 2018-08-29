package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.twitter.entity.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {

}

