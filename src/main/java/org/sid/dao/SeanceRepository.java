package org.sid.dao;


import org.sid.entite.Seance;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
public interface SeanceRepository extends JpaRepository<Seance, Long> {

	
	
		
}
