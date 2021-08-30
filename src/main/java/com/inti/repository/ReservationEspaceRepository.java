package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entity.Oeuvre;
import com.inti.entity.ReservationEspace;

@Repository
public interface ReservationEspaceRepository extends JpaRepository<ReservationEspace, Long> {
	@Query(value="SELECT * FROM reservation_espace WHERE accepte=1", nativeQuery = true)
	public List<ReservationEspace> findByAccepte();
}
