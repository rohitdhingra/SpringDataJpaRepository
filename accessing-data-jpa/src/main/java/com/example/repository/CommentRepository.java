package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.PostComment;

public interface CommentRepository extends  JpaRepository<PostComment,Long>{

}
