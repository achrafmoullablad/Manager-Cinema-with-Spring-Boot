package org.sid.dao;



import org.sid.entite.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface SalleRepository  extends JpaRepository<Salle, Long>{
	public Page<Salle> findByNameContains(String mc, Pageable pageable);
	
	
	@Query("select s from Salle s where s.cinema.id = :ids")
	public Page<Salle> Salleparcinema(@Param ("ids")Long id, Pageable pageable);
	
	
	

	
	}