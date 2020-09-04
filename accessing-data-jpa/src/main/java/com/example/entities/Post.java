package com.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Post {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@OneToOne(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
	private PostDetails postDetails;
	
	public void setPostDetails(PostDetails details)
	{
		if(details == null)
		{
			if(this.postDetails!=null)
			{
				this.postDetails.setPost(null);
			}
		}
		else
		{
			this.postDetails.setPost(this);
		}
		this.postDetails = details;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post( String title) {
		super();	
		this.title = title;
	}
	
	
	
	
}
