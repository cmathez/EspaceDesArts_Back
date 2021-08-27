package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entity.EspaceExposition;

@Repository
public interface EspaceExpositionRepository extends JpaRepository<EspaceExposition, Long> {

}
