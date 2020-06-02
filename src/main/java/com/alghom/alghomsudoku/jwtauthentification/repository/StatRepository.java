package com.alghom.alghomsudoku.jwtauthentification.repository;

import com.alghom.alghomsudoku.jwtauthentification.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatRepository extends JpaRepository<Statistics, Long> {
    Optional<Statistics> findByUserId(Long id);
}
