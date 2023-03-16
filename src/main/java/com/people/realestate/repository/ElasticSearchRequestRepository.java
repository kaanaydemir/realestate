package com.people.realestate.repository;

import com.people.realestate.dtos.elasticsearch.ElasticSearchRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticSearchRequestRepository extends ElasticsearchRepository<ElasticSearchRequest, String>{

}
