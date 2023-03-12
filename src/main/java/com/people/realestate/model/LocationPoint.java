package com.people.realestate.model;


import com.people.realestate.enums.LocationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LocationPoint extends Base {

    @Column(name = "name")
    private String name;

    @Column(name = "upperId")
    private Long upperId;

    @Column(name = "locationType")
    @Enumerated(EnumType.ORDINAL)
    private LocationType locationType;

    @OneToMany(mappedBy = "locationPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
