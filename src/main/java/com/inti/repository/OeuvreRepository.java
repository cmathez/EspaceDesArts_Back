package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entity.Avis;
import com.inti.entity.Oeuvre;

@Repository
public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM message WHERE id_oeuvre=?1", nativeQuery = true)
	public void deleteAvis(Long idOeuvre);
	
	@Query(value="SELECT * FROM oeuvre WHERE id_espace_exposition=?1", nativeQuery = true)
	public List<Oeuvre> findByIdEspaceExposition(Long idEspaceExposition);
}
