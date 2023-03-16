package com.people.realestate.services.comment;

import com.people.realestate.dtos.CommentDto;
import com.people.realestate.dtos.base.ResponseHeader;
import com.people.realestate.dtos.restdtos.comment.create.CreateCommentRequest;
import com.people.realestate.dtos.restdtos.comment.findById.FindCommentByIdResponse;
import com.people.realestate.mapper.CommentMapper;
import com.people.realestate.model.Comment;
import com.people.realestate.model.LocationPoint;
import com.people.realestate.model.User;
import com.people.realestate.services.location.LocationPointService;
import com.people.realestate.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentControllerService {
    private final CommentService commentService;
    private final UserService userService;
    private final CommentMapper commentMapper;

    private final LocationPointService locationPointService;

    public CommentControllerService(CommentService commentService, UserService userService, CommentMapper commentMapper,
                                    LocationPointService locationPointService) {
        this.commentService = commentService;
        this.userService = userService;
        this.commentMapper = commentMapper;
        this.locationPointService = locationPointService;
    }

    public Long createComment(CreateCommentRequest request) {

        User user = userService.findByUsername(request.getHeader().getUsername());

        LocationPoint locationPoint = locationPointService.getLocationPoint(request.getLocationPoint());

        Comment comment = Comment.builder()
                .comments(request.getComments())
                .user(user)
                .isRecommended(request.getIsRecommended())
                .safetyScore(request.getSafetyScore())
                .locationPoint(locationPoint)
                .header(request.getCommentHeader())
                .star(request.getStar())
                .createdBy(user.getUsername())
                .build();
        return commentService.create(comment).getId();
    }

    public FindCommentByIdResponse findById(Long id) {
        Comment comment = commentService.findById(id);
        return FindCommentByIdResponse.builder()
                .id(comment.getId())
                .comment(comment.getComments())
                .createdBy(comment.getUser().getUsername())
                .isActive(comment.getIsActive())
                .isRecommended(comment.getIsRecommended())
                .safetyScore(comment.getSafetyScore())
                .star(comment.getStar())
                .modifiedDate(comment.getModifiedDate())
                .modifiedBy(comment.getModifiedBy())
                .commentHeader(comment.getHeader())
                .header(new ResponseHeader())
                .build();
    }

    public List<CommentDto> findAll() {
        List<Comment> comments = commentService.getAll();
        return commentMapper.convertEntitesToDtos(comments);
    }
}
