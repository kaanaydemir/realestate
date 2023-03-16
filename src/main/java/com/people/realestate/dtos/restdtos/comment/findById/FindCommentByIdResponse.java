package com.people.realestate.dtos.restdtos.comment.findById;

import com.people.realestate.dtos.base.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class FindCommentByIdResponse extends BaseResponse {
    private final Long id;
    private final String commentHeader;
    private final String comment;
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
