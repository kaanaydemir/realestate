package com.people.realestate.controller;

import com.people.realestate.dtos.elasticsearch.ElasticSearchRequest;
import com.people.realestate.repository.ElasticSearchRequestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticSearchController {

    private final ElasticSearchRequestRepository myEntityRepository;

    public ElasticSearchController(ElasticSearchRequestRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }


}
