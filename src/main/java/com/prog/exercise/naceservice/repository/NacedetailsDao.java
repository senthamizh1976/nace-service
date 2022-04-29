package com.prog.exercise.naceservice.repository;

import com.prog.exercise.naceservice.model.NaceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacedetailsDao extends JpaRepository<NaceDetails, Long> {
    NaceDetails findByOrderId(Long orderId);
}
