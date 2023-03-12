package com.people.realestate.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@SuperBuilder
public abstract class Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(name = "createdDate")
    protected LocalDateTime createdDate;

    @Column(name = "modifiedDate")
    protected LocalDateTime modifiedDate;

    @Column(name = "createdBy")
    protected String createdBy;

    @Column(name = "modifiedBy")
    protected String modifiedBy;

    @Column(name = "isActive")
    protected Boolean isActive;

    @Column(name = "isDeleted")
    protected Boolean isDeleted;

    @PrePersist
    public void setValues() {
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
        this.isActive = true;
        this.isDeleted = false;
    }
    public Base() {
    }

}
