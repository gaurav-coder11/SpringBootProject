package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
}
