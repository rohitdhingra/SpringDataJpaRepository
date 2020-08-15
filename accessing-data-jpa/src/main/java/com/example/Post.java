package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Post {

	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post( String title) {
		super();
	
		this.title = title;
	}
	
	
	
	
}
