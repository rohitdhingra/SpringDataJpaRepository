package com.example;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends  CrudRepository<PostComment,Long>{

}
