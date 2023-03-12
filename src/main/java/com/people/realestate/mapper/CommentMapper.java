package com.people.realestate.mapper;

import com.people.realestate.model.Comment;
import com.people.realestate.dtos.CommentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface CommentMapper {
    Comment commentDtoToComment(CommentDto commentDto);

    CommentDto commentToCommentDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment updateCommentFromCommentDto(CommentDto commentDto, @MappingTarget Comment comment);
}
