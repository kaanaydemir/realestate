package com.people.realestate.controller;


import com.people.realestate.dtos.CommentDto;
import com.people.realestate.dtos.restdtos.comment.create.CreateCommentRequest;
import com.people.realestate.dtos.restdtos.comment.create.CreateCommentResponse;
import com.people.realestate.dtos.restdtos.comment.findById.FindCommentByIdResponse;
import com.people.realestate.services.comment.CommentControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentControllerService commentControllerService;

    public CommentController(CommentControllerService commentControllerService) {
        this.commentControllerService = commentControllerService;
    }


    @PostMapping("/create")
    public ResponseEntity<Long> createComment(@RequestBody CreateCommentRequest request) {
        Long comment = commentControllerService.createComment(request);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FindCommentByIdResponse> findById(@PathVariable Long id) {
        FindCommentByIdResponse comment = commentControllerService.findById(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<CommentDto>> findAll() {
        List<CommentDto> comments = commentControllerService.findAll();
        return ResponseEntity.ok(comments);
    }
}
