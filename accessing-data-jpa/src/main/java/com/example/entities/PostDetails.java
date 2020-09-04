package com.example.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class PostDetails {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	public PostDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDetails(String createdBy) {
		super();
		createdOn = new Date();
		this.createdBy = createdBy;
	}
	
	
	
	
}
