package com.people.realestate.dtos;

import com.people.realestate.model.Comment;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link Comment} entity
 */
@Data
public class CommentDto implements Serializable {
    private final Long id;
    private final String header;
    private final String comments;
    private final Integer star;
    private final Integer safetyScore;
    private final Boolean isRecommended;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String createdBy;
    private final String modifiedBy;
    private final Boolean isActive;
    private final Boolean isDeleted;
}