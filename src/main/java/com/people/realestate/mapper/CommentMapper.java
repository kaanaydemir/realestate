package com.people.realestate.mapper;

import com.people.realestate.model.Comment;
import com.people.realestate.dtos.CommentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface CommentMapper {
    Comment convert(CommentDto commentDto);

    CommentDto convert(Comment comment);

    List<CommentDto> convertEntitesToDtos(List<Comment> comments);

    List<Comment> convert(List<CommentDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment updateCommentFromCommentDto(CommentDto commentDto, @MappingTarget Comment comment);
}
