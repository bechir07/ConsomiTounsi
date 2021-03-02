package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Comment;

public interface CommentRepository   extends JpaRepository<Comment, Integer> {

}
