package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entity.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long>{

}
