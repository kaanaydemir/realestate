package com.people.realestate.dtos.restdtos.comment.create;

import com.people.realestate.dtos.base.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
public class CreateCommentRequest extends BaseRequest {

    @NotBlank
    private final String commentHeader;

    @NotBlank
    private final String comments;

    @PositiveOrZero
    private final Integer star;

    @PositiveOrZero
    private final Integer safetyScore;

    @NotNull
    private final Boolean isRecommended;

    @NotNull
    private final Long locationPoint;
}
