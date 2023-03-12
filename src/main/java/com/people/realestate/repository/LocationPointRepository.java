package com.people.realestate.repository;

import com.people.realestate.model.LocationPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationPointRepository extends JpaRepository<LocationPoint, Long> {
}
