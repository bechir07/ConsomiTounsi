package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Comment;

public interface ICommentService {

	String addComment(Comment comment);

	List<Comment> getComments();

	void deleteByCommentId(int id);

	Comment updateComment(Comment c);

	void affecterSubjectAComment(int ids, int id);

	void affecterUserAComment(int idu, int id);

}
