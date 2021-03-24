package tn.esprit.spring.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.SubjectRepository;
import tn.esprit.spring.Repository.UserRepository;

import tn.esprit.spring.entities.Comment;
@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public String addComment(Comment comment) {
		if((comment.getContent_comment().contains("xxx")) || (comment.getContent_comment().contains("yyy"))) 
		{
			return "mot interdit";
	}
	else
	{
		
			commentRepository.save(comment);
			return "Comment added successfuly";
	}
}
	
	
	
	
	

	@Override
	public List<Comment> getComments() {
		return(List<Comment>) (commentRepository.findAll());
	}
	
	
	@Override
	public void deleteByCommentId(int id) {
		
		commentRepository.deleteById(id);
	}
	@Override
	public Comment updateComment(Comment c) {
		
		return commentRepository.save(c);
	
		

	}
@Override
public void affecterSubjectAComment(int ids, int id) {
	Comment comment = commentRepository.findById(id).get();
	tn.esprit.spring.entities.Subject subject = subjectRepository.findById(ids).get();
	if (!ObjectUtils.isEmpty(comment) && !ObjectUtils.isEmpty(subject))
		comment.setSubject(subject);
	subjectRepository.save(subject);
	
	}
@Override
public void affecterUserAComment(int idu, int id) {
	Comment comment = commentRepository.findById(id).get();
	tn.esprit.spring.entities.User user = userRepository.findById((long) idu).get();
	if (!ObjectUtils.isEmpty(comment) && !ObjectUtils.isEmpty(user))
		comment.setUsers(user);
	userRepository.save(user);
	
	}

}
