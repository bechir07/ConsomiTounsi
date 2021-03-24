package tn.esprit.spring.entities;
import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity 
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String content_comment;
    @Temporal(TemporalType.DATE)
    private Date dateComment;
    @ManyToOne
    User users;
    @ManyToOne
    Subject subject;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Comment() {
    }

	public Comment(int id, String content_comment, Date dateComment, User users, Subject subject) {
		super();
		this.id = id;
		this.content_comment = content_comment;
		this.dateComment = dateComment;
		this.users = users;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content_comment=" + content_comment + ", dateComment=" + dateComment + ", users="
				+ users + ", subject=" + subject + "]";
	}

	public String getContent_comment() {
		return content_comment;
	}

	public void setContent_comment(String content_comment) {
		this.content_comment = content_comment;
	}

}