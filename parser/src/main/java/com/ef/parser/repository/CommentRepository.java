package com.ef.parser.repository;


import org.springframework.data.repository.CrudRepository;

import com.ef.parser.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
	
	
}
