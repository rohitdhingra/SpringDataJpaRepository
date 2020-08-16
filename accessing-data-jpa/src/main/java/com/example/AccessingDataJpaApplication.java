package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entities.Customer;
import com.example.entities.Post;
import com.example.entities.PostComment;
import com.example.repository.CommentRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.PostRepository;
import com.example.services.CustomerService;
import com.example.services.PostService;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
//	@PersistenceContext
//	private EntityManagerFactory emf;
	
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository)
	{
		return (args) ->{
//			EntityManager em = emf.createEntityManager();
//			Session session = null;
//			session = em.unwrap(Session.class);
//			EntityTransaction tx = em.getTransaction();
//			tx.begin();
//			em.persist(new Post("Reyansh going to school"));
//			tx.commit();
		
			
			postService.save(new Post("New Home"));
			
			postRepository.save(new Post("Reyansh Gdoing to scheools"));
//			Optional<Post> findById = postRepository.findById(1L);
			Post post = null;
//			if(findById.isPresent())
//{
//	post = findById.get();
//}
			post = postRepository.getOne(1L);
			commentRepository.save(new PostComment("Great Home!!"
					,post));
			
			PostComment comment = commentRepository.findById(1L).get();
			System.out.println(comment.getPost().getTitle());
			System.out.println(comment.getReview());
			
			comment= postService.invokeCriteriaQueryMethod(1L);
			System.out.println(comment.getPost().getTitle());
			System.out.println(comment.getReview());
			customerService.insert(new Customer("Jack","Bauer"));
//			postService.save(new PostComment("New Home"));
//			repository.save(new Customer("Jack","Bauer"));
			repository.save(new Customer("Rahul","Dhingra"));
			repository.save(new Customer("Rohit","Dhingra"));
			repository.save(new Customer("Anchal","Dhingra"));
			repository.save(new Customer("Gargi","Dhingra"));
			
			log.info("Customer found with findAll method");
			for(Customer customer: repository.findAll())
			{
				log.info(customer.toString());
			}
			log.info("Customer found with findById method");
			Customer cust = repository.findById(1);
			log.info(cust.toString());
			
			log.info("Customer found with LastName method");
			repository.findByLastName("Dhingra").forEach(obj -> log.info(obj.toString()));
//			log.info(cust.toString());
			Thread.currentThread().join();
		};
		
		
	}

}
