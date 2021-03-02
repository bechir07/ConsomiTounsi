package tn.esprit.spring.entities;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity @Data
public class Comment {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String contentComment;
    private Date dateComment;
    @ManyToOne
    User users;
    @ManyToOne
    Subject subject;
    
    public Comment() {
    }

}