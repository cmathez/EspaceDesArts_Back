package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entity.ReservationEspace;

@Repository
public interface ReservationEspaceRepository extends JpaRepository<ReservationEspace, Long> {

}
