package tn.esprit.spring.entities;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class Subject {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String subjectName;
    private String description;
    private Date dateSubject;
    private float evaluate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
    private Set<Comment> comments;

    public Subject() {
    }
}