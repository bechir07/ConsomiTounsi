package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comment;
@Repository
public interface CommentRepository   extends JpaRepository<Comment, Long> {
	
	/*@Query(value="SELECT * FROM comment WHERE content_comment LIKE '@N%'", nativeQuery = true)
	public List<?> getbillByEtat(@Param("payment_type") String payment_type);*/
}
