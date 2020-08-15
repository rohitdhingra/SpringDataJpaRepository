package com.example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class PostService {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Long save(Post post)
	{
		em.persist(post);
		return post.getId();
	}
	
	@Transactional
	public Long save(PostComment post)
	{
		em.persist(post);
		return post.getId();
	}
	
}
