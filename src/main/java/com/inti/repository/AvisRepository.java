package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entity.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long>{
	@Query(value = "SELECT * FROM message WHERE type = 'AVIS' AND id_oeuvre=?1", nativeQuery = true)
	public List<Avis> findByIdOeuvre(Long idOeuvre);
}
