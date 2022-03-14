package org.sid.dao;


import org.sid.entite.Film;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface FilmRepository extends JpaRepository<Film, Long> {

	Page<Film> findBytitreContains(String kw,  Pageable pageable);
}




	







