package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Comment;

public interface ICommentService {

	String addComment(Comment comment);

	List<Comment> getComments();


	Comment updateComment(Comment c);



	void deleteByCommentId(long id);

	void affecterSubjectAComment(long ids, long id);

	void affecterUserAComment(long idu, long id);

}
