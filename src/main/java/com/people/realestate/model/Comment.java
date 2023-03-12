package com.people.realestate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends Base {

    @Column(name = "header")
    private String header;

    @Column(name = "comments")
    private String comments;

    @Column(name = "star")
    private Integer star;

    @Column(name = "safetyScore")
    private Integer safetyScore;

    @Column(name = "isRecommended")
    private Boolean isRecommended;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "locationPointId")
    private LocationPoint locationPoint;
}
