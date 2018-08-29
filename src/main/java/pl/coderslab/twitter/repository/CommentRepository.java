package pl.coderslab.twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.twitter.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
