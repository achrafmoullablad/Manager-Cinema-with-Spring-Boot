package org.sid.dao;




import org.sid.entite.Cinema;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	
	public Page<Cinema> findByNameContains(String mc, Pageable pageable);
	
	@Query("select c from Cinema c where c.ville.id = :idv")
	public Page<Cinema> cinemaparviles(@Param ("idv")Long id, Pageable pageable);
}

