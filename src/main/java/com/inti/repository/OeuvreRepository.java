package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.entity.Oeuvre;

public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {

}
