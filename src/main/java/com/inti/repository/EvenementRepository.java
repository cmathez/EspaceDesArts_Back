package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entity.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
