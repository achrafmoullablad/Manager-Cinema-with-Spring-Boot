package org.sid.dao;





import org.sid.entite.ProjectionFilm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm, Long> {


	public Page<ProjectionFilm> findByprixContains(String mc, PageRequest of);
	
	@Query("select p from ProjectionFilm p where p.film.id = :idf")
	public Page<ProjectionFilm> Projectionparfilm(@Param ("idf")Long id, Pageable pageable);



	
	



}