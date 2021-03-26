package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Service.CommentServiceImpl;
import tn.esprit.spring.entities.Comment;

@RestController
public class CommentRestController {
	@Autowired
	CommentServiceImpl commentService;
	
	
	@PostMapping("/addComment")
	@ResponseBody
	public String addComment(@RequestBody Comment comment) {
		
		return commentService.addComment(comment);
		
	}
	

	@GetMapping("/getAllComments")
	public List<Comment> getAllComments() {

		return commentService.getComments();
	}
	
	
		@PutMapping("/affecterSubjecttoComment/{ids}/{id}")
		public void affecterSubjecttoComment(@PathVariable("ids") long ids, @PathVariable("id") long id) {
			commentService.affecterSubjectAComment(ids, id);

		}
		@PutMapping("/affecterUsertoComment/{idu}/{id}")
		public void affecterUsertoComment(@PathVariable("idu") long idu, @PathVariable("id") long id) {
			commentService.affecterUserAComment(idu, id);

		}

	 @PutMapping(value = "/updateComment") 
		public Comment updateComment(@RequestBody Comment comment)  {
			return commentService.updateComment(comment);
		}
	


@DeleteMapping(value = "/deletecommentById/{id}")
public void deleteById(@PathVariable("id")long id) {
	commentService.deleteByCommentId(id);
	
	
}

}
