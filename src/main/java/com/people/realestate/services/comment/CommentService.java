package com.people.realestate.services.comment;

import com.people.realestate.exception.CommentNotFoundException;
import com.people.realestate.model.Comment;
import com.people.realestate.repository.CommentRepository;
import com.people.realestate.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService extends BaseService<Comment> {

}
