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

	@Transactional
	public PostComment invokeCriteriaQueryMethod(long l) {
		
		return em.createQuery("select pc  from PostComment pc join fetch pc.post where pc.id=:id",PostComment.class)
				.setParameter("id", l)
				.getSingleResult();
	}
	
}
